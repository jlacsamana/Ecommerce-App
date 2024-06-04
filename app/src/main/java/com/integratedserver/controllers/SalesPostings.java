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
Route: /api/sales-postings/
*/
public class SalesPostings {
    MongoCollection<Document> salesPostings;
    public SalesPostings(MongoDatabase dataBase) {
        salesPostings= dataBase.getCollection("sales-postings");
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
    Route: /api/sales-postings/
    Action: GET
    Params: Int offset, Int quantity
     */
    private NanoHTTPD.Response get(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }
    /*
    Route: /api/sales-postings/
    Action: POST
    Params: SalesRecord newSalesRecord
    */
    private NanoHTTPD.Response post(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }

    /*
    Route: /api/sales-postings/
    Action: PUT
    Params: Int id, SalesRecord salesRecordToEdit
    */
    private NanoHTTPD.Response put(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }

    /*
    Route: /api/sales-postings/
    Action: DELETE
    Params: Int id
    */
    private NanoHTTPD.Response delete(NanoHTTPD.IHTTPSession session) throws InvalidApiRoute{
        return newFixedLengthResponse("stub");
    }


}
