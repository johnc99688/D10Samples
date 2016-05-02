package com.sample.adaptor.util;

import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONObject;

public class RESTUtil {
	public static Response constructJsonResponse(int status, JSONObject data) {
    	ResponseBuilder rb = Response.status(status);
    	rb.entity(data);
    	return rb.build();
    }
	
	public static Response constructJsonArrayResponse(int status, JSONArray data) {
    	ResponseBuilder rb = Response.status(status);
    	rb.entity(data);
    	return rb.build();
    }
	
	public static Response constructStatusResponse(int status) {
    	ResponseBuilder rb = Response.status(status);
    	return rb.build();
    }
	
	public static Response constructErrorResponse(int status, String error) {
    	ResponseBuilder rb = Response.serverError();
    	rb.status(status);
    	rb.entity(error);
    	return rb.build();
    }
	
	public static Response constructRedirectResponse(String redirectURI) {
		URI location = URI.create(redirectURI);
    	return Response.seeOther(location).build();
    }
}
