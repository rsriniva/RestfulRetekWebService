package com.myer.retek.webservice.constants;

/**
 * This class holds constants for data access objects.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 22 Aug 2014
 */
public class DaoConstants {
	
	/*
	 * plsql procedure constants
	 * 
	 */
	public static final String PLSQL_CALL_PREFIX = "begin ";
	public static final String PLSQL_CALL_SUFFIX = " end;";
	public static final String PAGING_PROC_NAME = "p_get_search_result";
	public static final String PACKAGE_NAME_WILDCARD = "#";
	
	/*
	 * plsql package names
	 * 
	 */
	public static final String PORTAL_SEARCH_PACKAGE = "my_portal_search_pkg_rr";
	
	/*
	 * plsql procedure calls
	 * 
	 */
	public static final String CLEAR_SEARCH_RESULT_SQL = 
			PLSQL_CALL_PREFIX 
			+ PACKAGE_NAME_WILDCARD 
			+ ".p_clear_search_result(?);"
			+ PLSQL_CALL_SUFFIX;	
	
	// search results. The idea of this procedure name is that it remains the same for all packages
	// that interface with this web service
	public static final String GET_SEARCH_RESULT_SQL = 
			PLSQL_CALL_PREFIX 
			+ PACKAGE_NAME_WILDCARD 
			+ ".p_get_search_result(?, ?, ?, ?);"
			+ PLSQL_CALL_SUFFIX;		
	
	// keyword search on item
	public static final String ITEM_SEARCH_KEYWORD_SQL = 
			PLSQL_CALL_PREFIX 
			+ PORTAL_SEARCH_PACKAGE 
			+ ".p_item_search_keyword(?, ?, ?, ?, ?, ?, ?, ?);"
			+ PLSQL_CALL_SUFFIX;
	
	// item field search
	public static final String ITEM_FIELD_SEARCH_SQL = 
			PLSQL_CALL_PREFIX 
			+ PORTAL_SEARCH_PACKAGE 
			+ ".p_item_search(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
			+ PLSQL_CALL_SUFFIX;	

	// item stock on hand 
	public static final String ITEM_SOH_SQL = 
			PLSQL_CALL_PREFIX 
			+ PORTAL_SEARCH_PACKAGE 
			+ ".p_get_soh(?, ?, ?, ?);"
			+ PLSQL_CALL_SUFFIX;	

}
