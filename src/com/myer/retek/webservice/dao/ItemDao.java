package com.myer.retek.webservice.dao;

import java.util.List;

import com.myer.retek.webservice.exception.RetekServiceException;

/**
 * This class is used to define all item specific calls to the database.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public interface ItemDao extends PagingDao {
	
	/**
	 * Do an item keyword search. Only handles the first 
	 * 
	 * @param sessionId the sessionId that will be used to cache results
	 * @param keywords a string array of keywords. Only the first 5 keywords are passed, others are ignored.
	 * @param retek item status - (A) Active, (C) Discontinued or (D) Deleted
     * @return the total number of results matched by the search
	 * @throws RetekServiceException
	 */
	public int doKeywordSearch(
			String sessionId,
			String[] keywords, 
			String status) throws RetekServiceException;

	/**
	 * Returns a list of items that are children of the passed item.
	 * 
	 * @param sessionId the sessionId that will be used to retrieve search results 
	 * @param parentNumber The parent item number
	 * @param retek item status - (A) Active, (C) Discontinued or (D) Deleted
	 * @return The list of items that are siblings (ie. children of the passed parent)
	 */
	public int getChildren (
			String sessionId, 
			String parentNumber, 
			String status) throws RetekServiceException;

	/**
	 * Runs a search for items with criteria. Several fields can have values
	 * (null for those that are not specified) and are all treated as an AND condition. 
	 * 
	 * @param sessionId the sessionId that will be used to retrieve search results 
	 * @param itemNumber Item number
	 * @param classGroup Class group
	 * @param apn APN
	 * @param classNumber Class
	 * @param subclassNumber Sub class
	 * @param itemDescription Item description
	 * @param brandName Brand name
	 * @param supplierName Supplier name
	 * @param supplierNumber Supplier number
	 * @param status Active or Deleted.	Must either be Item.STATUS_ACTIVE or Item.STATUS_DELETED
     * @return the total number of results matched by the search
	 */
	public int doFieldSearch (
			String sessionId, 
			String itemNumber, 
			String parentNumber, 
			Integer classGroup, 
			String apn, 
			Integer classNumber, 
			Integer subclassNumber, 
			String itemDescription, 
			String brandName, 
			String supplierName, 
			Integer supplierNumber, 
			String status) throws RetekServiceException;
	
	/**
	 * Returns the intra-day stock on hand figure for the passed item.
	 * 
	 * @param itemNumber The item that we are interested in the stock on hand
	 * @param location The location (store number) to restrict the lookup. -1 for all stores
	 * @param locType Location type ("S"tore, "W"arehouse, or NULL/"" for all types) 
	 * @return a list of results
	 */	
	public List doSohSearch(
			String itemNo,
			String location,
			String locType) throws RetekServiceException;	
	
}
