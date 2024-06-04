package com.integratedserver.controllers;

import static fi.iki.elonen.NanoHTTPD.newFixedLengthResponse;

import com.integratedserver.errors.InvalidApiRoute;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import fi.iki.elonen.NanoHTTPD;

/*
Route: /api/inventory-records/
*/
public class InventoryRecords {
    MongoCollection<Document> inventoryRecords;
    public InventoryRecords(MongoDatabase dataBase) {
        inventoryRecords = dataBase.getCollection("inventory-records");
    }

    public NanoHTTPD.Response handleRouting(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute {

        switch (session.getMethod()) {
            case GET:
                return get(session);
            case POST:
                return post(session);
            case PUT:
                return put(session);
            case DELETE:
                return delete(session);
            default:
                throw new InvalidApiRoute(String.format("%s is not a valid route", session.getUri()));
        }
    }

    /*
    Route: /api/inventory-records/
    Action: GET
    Params: Int offset, Int quantity
 */
    private NanoHTTPD.Response get(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }
    /*
    Route: /api/inventory-records/
    Action: POST
    Params: InventoryRecord newInventoryRecord
    */
    private NanoHTTPD.Response post(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }

    /*
    Route: /api/inventory-records/
    Action: PUT
    Params: Int id, InventoryRecord inventoryRecordToEdit
    */
    private NanoHTTPD.Response put(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }

    /*
    Route: /api/inventory-records/
    Action: DELETE
    Params: Int id
    */
    private NanoHTTPD.Response delete(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }
}
