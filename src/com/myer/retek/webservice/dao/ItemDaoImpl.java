package com.myer.retek.webservice.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.driver.OracleTypes;

import com.myer.retek.webservice.constants.DaoConstants;
import com.myer.retek.webservice.dao.mapper.SohMapper;
import com.myer.retek.webservice.exception.RetekServiceException;
import com.myer.retek.webservice.util.DaoUtils;
import com.myer.retek.webservice.util.StringUtils;

/**
 * This class is used to define all item specific calls to the database.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public class ItemDaoImpl extends AbstractDao implements ItemDao {
	
	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.ItemDao#doKeywordSearch(java.lang.String, java.lang.String[], java.lang.String)
	 */
	public int doKeywordSearch (
			String sessionId,
			String[] keywords, 
			String status) throws RetekServiceException {
		
		clearSidTable(sessionId);
		int totalRecords = 0;
		Connection connection = null;
		CallableStatement callStmt = null;
		try {
			connection = DaoUtils.getDataSource().getConnection();		
			try {	
				callStmt = connection.prepareCall(DaoConstants.ITEM_SEARCH_KEYWORD_SQL);
				callStmt.setString(1, sessionId); 													// p_vSid
				callStmt.setString(2, StringUtils.clean(keywords.length > 0 ? keywords[0] : null)); // p_vKeyword1 
				callStmt.setString(3, StringUtils.clean(keywords.length > 1 ? keywords[1] : null)); // p_vKeyword2
				callStmt.setString(4, StringUtils.clean(keywords.length > 2 ? keywords[2] : null)); // p_vKeyword3 
				callStmt.setString(5, StringUtils.clean(keywords.length > 3 ? keywords[3] : null)); // p_vKeyword4
				callStmt.setString(6, StringUtils.clean(keywords.length > 4 ? keywords[4] : null)); // p_vKeyword5
				callStmt.setString(7, status);														// p_vStatus
				callStmt.registerOutParameter(8, OracleTypes.INTEGER);				
				callStmt.execute();
				totalRecords = callStmt.getInt(8);
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
			throw new RetekServiceException("Could not do keyword search. ", e);
		}
		return totalRecords;
	}
	
	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.ItemDao#doFieldSearch(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String)
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
			String status) throws RetekServiceException {
		
		clearSidTable(sessionId);
		int totalRecords = 0;
		Connection connection = null;
		CallableStatement callStmt = null;
		try {
			connection = DaoUtils.getDataSource().getConnection();
			try {
				callStmt = connection.prepareCall(DaoConstants.ITEM_FIELD_SEARCH_SQL);
				callStmt.setString(1, sessionId); 	
				callStmt.setString(2, StringUtils.clean(itemNumber));
				callStmt.setString(3, StringUtils.clean(parentNumber));
				callStmt.setString(4, StringUtils.clean(classGroup));
				callStmt.setString(5, StringUtils.clean(apn));
				callStmt.setString(6, StringUtils.clean(classNumber));
				callStmt.setString(7, StringUtils.clean(subclassNumber));
				callStmt.setString(8, StringUtils.clean(itemDescription));
				callStmt.setString(9, StringUtils.clean(brandName));
				callStmt.setString(10, StringUtils.clean(supplierName));
				callStmt.setString(11, StringUtils.clean(supplierNumber));
				callStmt.setString(12, status);
				callStmt.registerOutParameter(13, OracleTypes.INTEGER);				
				callStmt.execute();
				totalRecords = callStmt.getInt(13);
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
			throw new RetekServiceException("Could not do field search. ", e);
		}
		return totalRecords;
	}
	
	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.ItemDao#getChildren(java.lang.String, java.lang.String, java.lang.String)
	 */
	public int getChildren (
			String sessionId, 
			String parentNumber, 
			String status) throws RetekServiceException {
		return doFieldSearch(sessionId, null, parentNumber, null, null, null, null, null, null, null, null, status);
	}	
	
	
	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.ItemDao#doSohSearch(java.lang.String, int, java.lang.String)
	 */
	public List doSohSearch (
			String itemNo,
			String location,
			String locType) throws RetekServiceException {
		
		int loc = new Integer(location).intValue();
		
		List data = null;
		CallableStatement callStmt = null;
		ResultSet rs = null;
		try {
			try {
				Connection connection = DaoUtils.getDataSource().getConnection();
				callStmt = connection.prepareCall(DaoConstants.ITEM_SOH_SQL);
				callStmt.setString(1, StringUtils.clean(itemNo));
				if (loc == -1){
					callStmt.setNull(2, OracleTypes.INTEGER);
				}else {
					callStmt.setInt(2, loc);
				}
				callStmt.setString(3, locType);
				callStmt.registerOutParameter(4, OracleTypes.CURSOR);
				callStmt.execute();
		
				rs = (ResultSet)callStmt.getObject(4);			
				SohMapper sohMapper = new SohMapper();
				data = sohMapper.mapRows(rs);	
			}
			finally {
				DaoUtils.closeStatementAndResultSet(callStmt, rs);
			}
		}
		catch(SQLException e) {
			throw new RetekServiceException("Could not do stock on hand search. ", e);
		}
		catch(NamingException e) {
			throw new RetekServiceException("Could not connect to the database. ", e);
		}
		return data;		
	}		

	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.AbstractDao#getSearchPackageName()
	 */
	protected String getSearchPackageName() {
		return DaoConstants.PORTAL_SEARCH_PACKAGE;
	}		

}
