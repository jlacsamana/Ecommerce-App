package com.integratedserver;

import com.integratedserver.errors.InvalidApiRoute;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;



public class EmbeddedServer extends NanoHTTPD {
    public EmbeddedServer() throws IOException {
        super(8080);
        start(SOCKET_READ_TIMEOUT, false);
        System.out.println("Server started on port 8080");
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

    public Response handleRouting(String rootVerb, IHTTPSession session) {
        return newFixedLengthResponse("stub");
    }

    private static String GetRootVerb(String uri) throws InvalidApiRoute {
        try {
            // index

            return uri.split("/")[1];
        } catch (Error e) {
            throw new InvalidApiRoute(String.format("%s is not a valid route", uri));
        }
    }


}
