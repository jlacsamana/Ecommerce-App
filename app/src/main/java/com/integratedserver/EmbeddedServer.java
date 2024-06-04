package com.integratedserver;

import com.integratedserver.controllers.InventoryRecords;
import com.integratedserver.controllers.SalesPostings;
import com.integratedserver.errors.InvalidApiRoute;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


public class EmbeddedServer extends NanoHTTPD {
    String connectionString = "mongodb+srv://jacoblacsamana0:SLwyaO3R9ZzrHeyT@ecommerce.j2b7phm.mongodb.net/?retryWrites=true&w=majority&appName=ecommerce";
    MongoClient mongoClient;
    MongoDatabase database;

    // controller instances
    InventoryRecords inventoryRecordsController;
    SalesPostings salesPostingsController;

    public EmbeddedServer() throws IOException {
        super(8080);
        start(SOCKET_READ_TIMEOUT, false);
        System.out.println("Server started on port 8080");
        // init database
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("inventory-management");
        // initialize controllers
        inventoryRecordsController = new InventoryRecords(database);
        salesPostingsController = new SalesPostings(database);
    }
    @Override
    public Response serve(IHTTPSession session) {
        try {
            String rootVerb = GetRootVerb(session.getUri());
            return this.handleRouting(rootVerb, session);
        }catch (InvalidApiRoute e) {
            return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, "text/plain", "Internal Server Error: " + e.getMessage());
        }
    }

    public Response handleRouting(String rootVerb, IHTTPSession session) throws InvalidApiRoute {
        switch (rootVerb) {
            case "inventory-records":
                return inventoryRecordsController.handleRouting(session);
            case "sales-postings":
                return salesPostingsController.handleRouting(session);
            default:
                throw new InvalidApiRoute(String.format("%s is not a valid route", session.getUri()));
        }
    }

    private static String GetRootVerb(String uri) throws InvalidApiRoute {
        try {
            // index 0 is empty
            // index 1 is "api"
            // index 2 should have top level verb

            return uri.split("/")[2];
        } catch (Error e) {
            throw new InvalidApiRoute(String.format("%s is not a valid route", uri));
        }
    }


}
