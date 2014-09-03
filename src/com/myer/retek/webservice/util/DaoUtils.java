package com.myer.retek.webservice.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.myer.retek.webservice.constants.EnvConstants;
import com.myer.retek.webservice.exception.RetekServiceException;

/**
 * Data access object specific utilities.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 27 Aug 2014
 */
public class DaoUtils {

	/**
	 * Get the data source using a jndi lookup.
	 * 
	 * @return the jndi datasource
	 * @throws NamingException
	 */
	public static DataSource getDataSource() throws NamingException {	
		DataSource dataSource = null;
		String appServerEnv = System.getProperty(EnvConstants.APP_SERVER_ENV);
		if (appServerEnv.equalsIgnoreCase(EnvConstants.TOMCAT)){
			dataSource = getTomcatDataSource();
		}else if (appServerEnv.equalsIgnoreCase(EnvConstants.WAS)){
			dataSource = getWasDataSource();
		}else {
			// default to was 
			dataSource = getWasDataSource();
		}
		return dataSource;
	}
	
	/**
	 * Get the tomcat data source using a jndi lookup.
	 * 
	 * @return the jndi datasource
	 * @throws NamingException
	 */
	public static DataSource getTomcatDataSource() throws NamingException {	
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		return (DataSource) envContext.lookup("jdbc/rmsDS");
	}
	
	/**
	 * Get the was data source using a jndi lookup.
	 * 
	 * @return the jndi datasource
	 * @throws NamingException
	 */
	public static DataSource getWasDataSource() throws NamingException {	
		InitialContext context = new InitialContext();
		return (DataSource)context.lookup("jdbc/rmsDS");
	}	
	
	/**
	 * Handle an exception on a database write operation. Attempt to rollback if possible.
	 * 
	 * @param connection the database connection
	 * @param e1 the database exception
	 * @return the data source
	 * @throws RetekServiceException
	 */
	public static DataSource doRollback(Connection connection, SQLException e1) 
			throws RetekServiceException {	
		try{
			 if(connection != null){
				 connection.rollback(); 
			 } 
	      } catch(SQLException e2){
	    	  throw new RetekServiceException("Could not do rollback. ", e2);
	      }
		throw new RetekServiceException(e1.getMessage(), e1);
	}	
	
	/**
	 * Close the CallableStatement and the ResultSet
	 * 
	 * @param callStmt the CallableStatement
	 * @param rs the ResultSet
	 * @throws SQLException
	 */
	public static void closeStatementAndResultSet(CallableStatement callStmt, ResultSet rs) throws SQLException {	
		closeStatement(callStmt);
		closeResultSet(rs);
	}	
	
	/**
	 * Close the CallableStatement
	 * 
	 * @param callStmt the CallableStatement
	 * @throws SQLException
	 */
	public static void closeStatement(CallableStatement callStmt) throws SQLException {	
 		if (callStmt != null) {
 			callStmt.close();
 		}
	}		

	/**
	 * Close the ResultSet
	 * 
	 * @param rs the ResultSet
	 * @throws SQLException
	 */
	public static void closeResultSet(ResultSet rs) throws SQLException {	
 		if (rs != null) {
 			rs.close();
 		}
	}	
	
}
