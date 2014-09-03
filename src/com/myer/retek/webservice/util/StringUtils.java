package com.myer.retek.webservice.util;

import com.myer.retek.webservice.constants.DaoConstants;

/**
 * String utility functions.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 27 Aug 2014
 */
public class StringUtils {
	
	/**
	 * Remove leading and trailing spaces from the input string.
	 * 
	 * @param input the input string
	 * @return a string without leading and trailing spaces 
	 */
	public static String clean(String input) {
		return (input == null ? "" : input.trim());				
	}
	
	/**
	 * Return an integer as a string
	 * 
	 * @param input the input integer
	 * @return the integer represented as a string
	 */
	public static String clean(Integer input) {
		String cleanedStr = null;
		if (input == null || input.intValue() == -1){
			return null;
		}else{
			cleanedStr = ""+input;
		}
		return cleanedStr;
	}
	
	/**
	 * Replace a package name wildcard in a plsql string.
	 * 
	 * @param replaceString the string to use as a replacement for the wild card
	 * @param input the input string
	 * @return a plsql string with the placeholder replaced 
	 */
	public static String replaceWildCard(String replaceString, String input) {
		if (replaceString == null || input == null ){
			return input;
		}
		return input.replaceAll(DaoConstants.PACKAGE_NAME_WILDCARD, replaceString);
	}

	public static Integer parseInt(String input) {
		Integer passedInt = null;
		try {
			passedInt = new Integer(input);
		} catch(NumberFormatException e){
			return null;
		}
		return passedInt;
	}	
	
	/**
	 * If the string is null return an empty string instead.
	 * 
	 * @param input the raw input string.
	 * @return a coalesced string 
	 */
	public static String coalesce(String input) {
		return input == null ? "" : input;
	}	
	
	/**
	 * Convert Y / N string to boolean. If string is null return false.
	 * 
	 * @param input the raw input string.
	 * @return a coalesced boolean 
	 */
	public static Boolean coalesceBoolean(String input) {
		if (input == null){
			return Boolean.FALSE;
		}
		return (Boolean.valueOf(input.toUpperCase().equals("Y")));
	}	
	
}
