package com.myer.retek.webservice.dao;

import java.util.List;

import com.myer.retek.webservice.exception.RetekServiceException;

/**
 * This class is used to define all paging specific calls to the database.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public interface PagingDao {
	
	/**
	 * Get cached search results based on the sessionId parameter.
	 * 
	 * @param sessionId the sessionId to lookup in the cache table
	 * @param displayStart the start position of the resultset (used for pagination)
	 * @param displayEnd the length of the resultset (used for pagination)
	 * @return a list of results
	 * @throws RetekServiceException
	 */
	public List getSearchResults (
			String sessionId,
			int displayStart, 
			int displayEnd) throws RetekServiceException;
}
