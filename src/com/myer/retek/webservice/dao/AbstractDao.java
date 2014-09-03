package com.myer.retek.webservice.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.driver.OracleTypes;

import com.myer.retek.webservice.constants.DaoConstants;
import com.myer.retek.webservice.dao.mapper.ItemMapper;
import com.myer.retek.webservice.exception.RetekServiceException;
import com.myer.retek.webservice.util.DaoUtils;
import com.myer.retek.webservice.util.StringUtils;

/**
 * This is an abstract data access object for all other data objects to extend off.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public abstract class AbstractDao {

	/**
	 * All implementing classes should implement this package which is used to tell this abstract class
	 * what plsql package to use to retrieve/clear cached search results.
	 * 
	 * @return a plsql package name
	 */
	protected abstract String getSearchPackageName();

	
	/**
	 * Clear search results in the cache table. The plsql package that will be called depends on
	 * the implementation of the {@link #getSearchPackageName() getSearchPackageName} method.
	 * 
	 * @param sessionId the sessionId that will be removed from the cahce table
	 * @throws RetekServiceException
	 */
	public void clearSidTable (String sessionId) throws RetekServiceException {
		Connection connection = null;
		CallableStatement callStmt = null;
		try {
			connection = DaoUtils.getDataSource().getConnection();
			try {
				String plSqlString = 
						StringUtils.replaceWildCard(getSearchPackageName(),DaoConstants.CLEAR_SEARCH_RESULT_SQL); 
		    	
				callStmt = connection.prepareCall(plSqlString);
				callStmt.setString(1, sessionId);     	
				callStmt.execute();	
				connection.commit();
			}
			finally {
				DaoUtils.closeStatement(callStmt);
			}
		}
		catch(SQLException e) {
			DaoUtils.doRollback(connection, e);
		}
		catch(NamingException e) {
			throw new RetekServiceException("Could not connect to the database. ", e);
		}			
	}
	
	/**
	 * Get search results based on the sessionId parameter. The plsql package that will be called depends on
	 * the implementation of the {@link #getSearchPackageName() getSearchPackageName} method.
	 *   
	 * @param sessionId the sessionId to lookup in the oracle cache table
	 * @param displayStart the start position of the resultset (used for pagination)
	 * @param displayLength the length of the resultset (used for pagination)
	 * @return a list of results
	 * @throws RetekServiceException
	 */
	public List getSearchResults (
			String sessionId,
			int displayStart, 
			int displayLength) throws RetekServiceException {
		
		List data = null;
		CallableStatement callStmt = null;
		ResultSet rs = null;
		try {
			try {
				Connection connection = DaoUtils.getDataSource().getConnection();
				String plSqlString = 
						StringUtils.replaceWildCard(getSearchPackageName(),DaoConstants.GET_SEARCH_RESULT_SQL); 
		    	
				callStmt = connection.prepareCall(plSqlString);
				callStmt.setString(1, sessionId); 
				callStmt.setInt(2, displayStart); 
				callStmt.setInt(3, displayLength); 
				callStmt.registerOutParameter(4, OracleTypes.CURSOR);	    	
				callStmt.execute();
				
				rs = (ResultSet)callStmt.getObject(4);				
				ItemMapper itemMapper = new ItemMapper();
				data = itemMapper.mapRows(rs);			
			}
			finally {
				DaoUtils.closeStatementAndResultSet(callStmt, rs);
			}
		}
		catch(SQLException e) {
			throw new RetekServiceException("Could not get search results. " , e);
		}
		catch(NamingException e) {
			throw new RetekServiceException("Could not connect to the database. ", e);
		}
		return data;		
	}
		
	
}
