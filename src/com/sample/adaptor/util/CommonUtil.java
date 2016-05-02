package com.sample.adaptor.util;

import java.security.SecureRandom;
import java.util.Base64;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

public class CommonUtil {
	public static String generateUUID() {
		SecureRandom random = new SecureRandom();
	    String uuid = Integer.toString(Math.abs(random.nextInt()));
    	return uuid;
    }
	
	public static boolean checkRequiredParams(JSONObject params, String[] requiredParams) {
		for (String reqParam:requiredParams) {
			if (!params.containsKey(reqParam)) {
				return false;
			}
		}
		return true;
	}
	
	public static JSONObject decode(String token) throws JSONException {
		String decodedString =  new String(Base64.getDecoder().decode(token));
		JSONObject decodedJSON = new JSONObject(decodedString);
		return decodedJSON;
	}
	
	public static String encode(JSONObject object) throws JSONException {
		return Base64.getEncoder().encodeToString(object.toString().getBytes());

	}
}
