package com.myer.retek.webservice.util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.myer.retek.webservice.constants.JsonConstants;

/**
 * Json utility functions.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 27 Aug 2014
 */
public class JsonUtils {
	
	/**
	 * Convert a list of domain object to a json object 
	 * 
	 * @param data a list of domain object to a json object
	 * @return a json object
	 */
	public static JSONObject getJsonForList(List data) {
		JSONObject obj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(data);
		obj.put(JsonConstants.AA_DATA, jsonArray);
		return obj;
    }
	
	/**
	 * A standard way to format a totalRecords int to a json object.
	 * @param a totalRecords int
	 * @return a json object
	 */
	public static JSONObject getJsonForTotalRecords(int totalRecords) {
		JSONObject obj = new JSONObject();
		obj.put(JsonConstants.I_TOTAL_RECORDS, new Integer(totalRecords));
		return obj;	
	}
}
