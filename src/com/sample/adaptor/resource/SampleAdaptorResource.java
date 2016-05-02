package com.sample.adaptor.resource;

import java.net.HttpURLConnection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

import com.sample.adaptor.util.CommonUtil;
import com.sample.adaptor.util.Constants;
import com.sample.adaptor.util.RESTUtil;

@Path("/")
public class SampleAdaptorResource {

	final static String token = "1351507565";
	final static JSONObject devices1data = new JSONObject();
	final static JSONObject devices1details = new JSONObject();
	final static JSONObject devices1detailsMetadataStatus= new JSONObject();
	final static JSONObject devices1detailsMetadataMeasurement= new JSONObject();
	final static JSONObject devices1actions1 = new JSONObject();
	final static JSONObject devices1actions2 = new JSONObject();


	public static String _status = "on";
	public static long _measurement = 100;

	static {
		try {
			devices1data.put("deviceId", "sample1device1");
			devices1data.put("deviceShortName", "Device1");
			devices1data.put("deviceLongName", "Sample Device1");
			devices1data.put("hrefImageUrl", "https://dimension10.io:8446/img/Stellaris-Analog-wrist-watch-300px.png");
			
			devices1details.put("device_id", "sample1device1");
			devices1details.put("name", "Device1");
			devices1details.put("name_long", "Sample Device1");
			devices1details.put("primary_attribute", "status");
			devices1details.put("status", getStatus());
			devices1details.put("measurement", get_measurement());
			devices1details.put("hrefImageUrl", "https://dimension10.io:8446/img/Stellaris-Analog-wrist-watch-300px.png");
			devices1details.put("device_type", 1);

			devices1detailsMetadataStatus.put("name", "status");
			devices1detailsMetadataStatus.put("type", "java.lang.String");
			devices1detailsMetadataMeasurement.put("name", "measurement");
			devices1detailsMetadataMeasurement.put("type", "int");
			
			devices1actions1.put("device_id", "sample1device1");
			devices1actions1.put("dbId", "1");
			devices1actions1.put("name", "Set Status");
			devices1actions1.put("desc", "Set Device Status");
			devices1actions1.put("valueName", "status");
			devices1actions1.put("valueType", "String (ON, OFF)");
			
			devices1actions2.put("device_id", "sample1device1");
			devices1actions2.put("dbId", "2");
			devices1actions2.put("name", "Set Measurement");
			devices1actions2.put("desc", "Set Device Measurement");
			devices1actions2.put("valueName", "measurement");
			devices1actions2.put("valueType", "long");

		}
		catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public static long get_measurement() {
		return _measurement;
	}

	public static void set_measurement(long _measurement) {
		SampleAdaptorResource._measurement = _measurement;
	}

	public static String getStatus() {
		return _status;
	}

	public static void setStatus(String status) {
		SampleAdaptorResource._status = status;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/entrypoint")
	public Response getAdaptorInfo() {
		try {
			JSONObject result = new JSONObject();
			JSONObject adaptorInfo = new JSONObject();
			adaptorInfo.put(Constants.ADAPTOR_INFO_HREFURL, "https://dimension10.io:8446/SampleAdaptorService/authorizationcode?state");
			adaptorInfo.put("name", "SampleAdaptorService");
			adaptorInfo.put("description", "Sample Adaptor Service");
			adaptorInfo.put("hrefImageUrl", "https://dimension10.io:8446/img/power-thumb-300px.png");
			result.put(Constants.ADAPTOR_INFO_RESULT, adaptorInfo);
			
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authorizationcode")
	public Response getDeviceData(@QueryParam(Constants.OAUTH_REDIRECT_URI) String redirectURL, 
			@QueryParam(Constants.OAUTH_STATE) String state, 
			@QueryParam(Constants.OAUTH_CLIENT_ID) String clientID) {
		try {
			String authzcode = CommonUtil.generateUUID();
			UriBuilder adaptorOAuthPath = UriBuilder.fromUri(redirectURL).queryParam(Constants.OAUTH_CODE, authzcode).queryParam(Constants.OAUTH_STATE, state);
			System.out.println("adaptorOAuthPath: " + adaptorOAuthPath.build().toString());
	    	return RESTUtil.constructRedirectResponse(adaptorOAuthPath.build().toString());
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authorize/{authorizecode}")
	public Response setDeviceData(@PathParam("authorizecode") String authorizecode ) {
		try {
			JSONObject accesscodeResponseJSON = new JSONObject();
			String accessToken = SampleAdaptorResource.token; //CommonUtil.generateUUID();
			accesscodeResponseJSON.put(Constants.OAUTH_ACCESS_TOKEN, accessToken);
			accesscodeResponseJSON.put(Constants.OAUTH_EXPIRES_IN, "3000");
			accesscodeResponseJSON.put(Constants.OAUTH_TOKEN_TYPE, "Bearer");
			
			JSONObject result = new JSONObject();
			result.put(Constants.ADAPTOR_INFO_RESULT, accesscodeResponseJSON);

	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{token}/devices")
	public Response getDevicesList(@PathParam("token") String usertoken ) {
		try {
			JSONObject result = new JSONObject();
			JSONArray devicelist = new JSONArray();
			devices1data.put("primary_attribute_name", "status");
			devices1data.put("primary_attribute_value", getStatus());
			devices1data.put("primary_attribute_type", "java.lang.String");
			devicelist.add(devices1data);
			result.put(Constants.ADAPTOR_INFO_RESULT, devicelist);
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{token}/devices/{device_id}")
	public Response getDevicesDetails(@PathParam("token") String usertoken, @PathParam("device_id") String device_id ) {
		try {
			JSONObject result = new JSONObject();
			devices1details.put("status", getStatus());
			devices1details.put("measurement", get_measurement());
			result.put(Constants.ADAPTOR_INFO_RESULT, devices1details);
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{token}/devices/{device_id}/actions")
	public Response getDevicesActions(@PathParam("token") String usertoken, @PathParam("device_id") String device_id ) {
		try {
			JSONObject result = new JSONObject();
			JSONArray deviceActionList = new JSONArray();
			deviceActionList.add(devices1actions1);
			deviceActionList.add(devices1actions2);
			result.put(Constants.ADAPTOR_INFO_RESULT, deviceActionList);
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{token}/devices/{device_id}/actions/{action_id}")
	public Response putDevicesActions(@PathParam("token") String usertoken, @PathParam("device_id") String device_id, @PathParam("action_id") String action_id, JSONObject actionData ) {
		try {
			if (action_id.equals("1")) {
				String statueValue = actionData.getString("status");
				setStatus(statueValue);
			}
			if (action_id.equals("2")) {
				Long statueValue = actionData.getLong("measurement");
				set_measurement(statueValue);
			}
			JSONObject result = new JSONObject();
			result.put("result", "success");
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/devices/{db_id}")
	public Response getDevicesMetadata(@PathParam("db_id") String db_id) {
		JSONArray resultMeta = new JSONArray();
		try {
			if (db_id.equals("1")) {
				resultMeta.add(devices1detailsMetadataStatus);
				resultMeta.add(devices1detailsMetadataMeasurement);
			}
			JSONObject result = new JSONObject();
			result.put("result", resultMeta);
	    	return RESTUtil.constructJsonResponse(HttpURLConnection.HTTP_OK, result);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return RESTUtil.constructErrorResponse(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getMessage());
		}   
	}
}