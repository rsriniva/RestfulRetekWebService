package com.myer.retek.webservice.constants;

/**
 * This class holds constants for request parameters.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 22 Aug 2014
 */
public class ParamConstants {
	
	/*
	 * html headers
	 * 
	 */
	public static final String JSON_MEDIA_TYPE = "application/Json";
	public static final String HTML_MEDIA_TYPE = "text/html";

	/*
	 * general constants
	 * 
	 */
	public static final int MAX_ERROR_LENGTH = 100;
	public static final String ERROR_PREFIX = "{\"errorMessage\":\"";
	public static final String ACTION_NOT_SPECIFIED = "Action not specified";
	public static final String ACTION_NOT_FOUND = "Action not found";
	public static final String ERROR_SUFFIX = "\"}";
	
	/*
	 * item service actions
	 * 
	 */
	public static final String PARAM_ITEM_KEYWORD_SEARCH = "keywordSearch";
	public static final String PARAM_ITEM_SEARCH = "itemSearch";
	public static final String PARAM_ITEM_PARENT_ITEM_SEARCH = "parentItemSearch";
	public static final String PARAM_ITEM_SEARCH_RESULTS = "searchResults";
	public static final String PARAM_ITEM_STOCK_ON_HAND = "stockOnHand";
		
	/*
	 * request parameter names
	 * 
	 */
	public static final String PARAM_ACTION = "action";
	public static final String PARAM_SESSION_ID = "sessionId";	
	public static final String PARAM_DISPLAY_START = "displayStart";
	public static final String PARAM_DISPLAY_LENGTH = "displayLength";
	
	public static final String PARAM_ITEM = "item";
	public static final String PARAM_PARENT_ITEM = "parentItem";
	public static final String PARAM_CLASS_GROUP = "classGroup";
	public static final String PARAM_APN = "apn";
	public static final String PARAM_CLASS = "class";
	public static final String PARAM_SUBCLASS = "subclass";
	public static final String PARAM_ITEM_DESCRIPTION = "itemDesc";
	public static final String PARAM_BRAND_NAME = "brandName";
	public static final String PARAM_SUPPLER_NAME = "supplierName";
	public static final String PARAM_SUPPLER = "supplier";
	public static final String PARAM_ITEM_STATUS = "itemStatus";	
	
	/*
	 * item specific request parameter names
	 * 
	 */
	public static final String PARAM_KEYWORD = "keyword";
	public static final String PARAM_ITEM_NO = "itemNo";
	public static final String PARAM_LOCATION = "location";
	public static final String PARAM_LOC_TYPE = "locType";
	

}
