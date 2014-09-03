package com.myer.retek.webservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.myer.retek.webservice.constants.ItemConstants;
import com.myer.retek.webservice.constants.ParamConstants;
import com.myer.retek.webservice.dao.AbstractDao;
import com.myer.retek.webservice.dao.ItemDaoImpl;
import com.myer.retek.webservice.exception.RetekServiceException;
import com.myer.retek.webservice.util.JsonUtils;
import com.myer.retek.webservice.util.StringUtils;

/**
 * This controller is to handle all item related services. Service routing will
 * depend on the request parameter named action.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 22 Aug 2014
 *
 */
public class ItemWebServiceController extends AbstractWebServiceController {

	private static final long serialVersionUID = 5842701687533464062L;
	private static Logger logger = Logger.getLogger(ItemWebServiceController.class);
	
	/* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(
    		HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(
    	HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		
		JSONObject jsonObject = null;
		String action = getAction(request,response);		
		if (action == null){
			return;
		};
		
		if (action != null){
			try {
				if (action.equalsIgnoreCase(ParamConstants.PARAM_ITEM_SEARCH_RESULTS)){
					List results = getSearchResults((AbstractDao)new ItemDaoImpl(), request, response);
					jsonObject = JsonUtils.getJsonForList(results);
				}			
				else if (action.equalsIgnoreCase(ParamConstants.PARAM_ITEM_KEYWORD_SEARCH)){
					int totalRecords = doKeywordSearch(request,response);
					jsonObject = JsonUtils.getJsonForTotalRecords(totalRecords);			
				}
				else if (action.equalsIgnoreCase(ParamConstants.PARAM_ITEM_SEARCH)){
					int totalRecords = doItemSearch(request,response);
					jsonObject = JsonUtils.getJsonForTotalRecords(totalRecords);
				}					
				else if (action.equalsIgnoreCase(ParamConstants.PARAM_ITEM_PARENT_ITEM_SEARCH)){
					int totalRecords = doParentItemSearch(request,response);
					jsonObject = JsonUtils.getJsonForTotalRecords(totalRecords);			
				}	
				else if (action.equalsIgnoreCase(ParamConstants.PARAM_ITEM_STOCK_ON_HAND)){
					List results = doSohSearch(request, response);
					jsonObject = JsonUtils.getJsonForList(results);
				}else {
					writeErrorResponse(request,response,ParamConstants.ACTION_NOT_FOUND);
					return;
				}
				response.setContentType(ParamConstants.JSON_MEDIA_TYPE);
				response.getWriter().print(jsonObject);
				response.getWriter().flush();
				
			} catch (RetekServiceException e1) {
				// unexpected error
				writeErrorResponse(request,response,e1.getMessage());
				logger.error("doPost: ", e1);
			}
		}	
	}
    
    /**
     * Do an item keyword search. Both sessionId and keywords are mandatory 
     * otherwise empty results are returned.
     * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @return the total number of results matched by the search
     * @throws RetekServiceException
     * @throws IOException if an input or output error is detected when handling the request object
     */
    private int doKeywordSearch (
    		HttpServletRequest request,
            HttpServletResponse response) throws RetekServiceException, IOException  {
    	
    	String sessionId = request.getParameter(ParamConstants.PARAM_SESSION_ID);
    	String[] keyword = request.getParameterValues(ParamConstants.PARAM_KEYWORD);
    	if (keyword == null || sessionId == null){
    		return 0;
    	}
    	int totalRecords = new ItemDaoImpl().doKeywordSearch(sessionId, keyword, ItemConstants.ITEM_ACTIVE);
    	return totalRecords;
    }
    
    /**
     * Do an item search based on the parameters passed in.
     * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @return the total number of results matched by the search
     * @throws RetekServiceException
     * @throws IOException if an input or output error is detected when handling the request object
     */
    private int doItemSearch (
    		HttpServletRequest request,
            HttpServletResponse response) throws RetekServiceException, IOException {
		
    	String sessionId = request.getParameter(ParamConstants.PARAM_SESSION_ID);
    	String itemNumber = request.getParameter(ParamConstants.PARAM_ITEM);
    	String parentNumber = request.getParameter(ParamConstants.PARAM_PARENT_ITEM);
    	String classGroup = request.getParameter(ParamConstants.PARAM_CLASS_GROUP);
    	String apn = request.getParameter(ParamConstants.PARAM_APN);
    	String classNumber = request.getParameter(ParamConstants.PARAM_CLASS);
    	String subclassNumber = request.getParameter(ParamConstants.PARAM_SUBCLASS);    	
    	String itemDescription = request.getParameter(ParamConstants.PARAM_ITEM_DESCRIPTION);
    	String brandName = request.getParameter(ParamConstants.PARAM_BRAND_NAME);
    	String supplierName = request.getParameter(ParamConstants.PARAM_SUPPLER_NAME);
    	String supplierNumber = request.getParameter(ParamConstants.PARAM_SUPPLER);
    	String status = request.getParameter(ParamConstants.PARAM_ITEM_STATUS);
    	
    	if (sessionId == null){
    		return 0;
    	}
    	
    	int totalRecords = 
    		new ItemDaoImpl().doFieldSearch(sessionId, 
							    			itemNumber,
							    			parentNumber, 
							    			StringUtils.parseInt(classGroup), 
							    			apn, 
							    			StringUtils.parseInt(classNumber), 
							    			StringUtils.parseInt(subclassNumber), 
							    			itemDescription,
							    			brandName, 
							    			supplierName, 
							    			StringUtils.parseInt(supplierNumber), 
							    			status);
    	return totalRecords;
    }    
    
    /**
     * Get all child items for a parent item number.
     * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @return the total number of results matched by the search
     * @throws RetekServiceException
     * @throws IOException if an input or output error is detected when handling the request object
     */
    private int doParentItemSearch (
    		HttpServletRequest request,
            HttpServletResponse response) throws RetekServiceException, IOException  {
    	
    	String sessionId = request.getParameter(ParamConstants.PARAM_SESSION_ID);
    	String parentItem = request.getParameter(ParamConstants.PARAM_PARENT_ITEM);
    	String status = request.getParameter(ParamConstants.PARAM_ITEM_STATUS);
    	
    	if (parentItem == null || status == null){
    		return 0;
    	}
    	int totalRecords = new ItemDaoImpl().getChildren(sessionId, parentItem, status);
    	return totalRecords;
    }
    
    /**
     * Get the intra-day stock on hand figure for all passed item(s) at the locations specified.
     * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @return a list of search results
     * @throws RetekServiceException
     * @throws IOException if an input or output error is detected when handling the request object
     */
    private List doSohSearch (
    		HttpServletRequest request,
            HttpServletResponse response) throws RetekServiceException, IOException  {  
    	
    	List results = null;
    	
    	String itemNo[] = request.getParameterValues(ParamConstants.PARAM_ITEM_NO);
    	String location = request.getParameter(ParamConstants.PARAM_LOCATION);
    	String locType = request.getParameter(ParamConstants.PARAM_LOC_TYPE);
    
    	List itemList = new ArrayList(); 
    	Collections.addAll(itemList, itemNo); 
    	
    	for (Iterator i = itemList.iterator(); i.hasNext();){
    		String currentItem = (String) i.next();
    		results = new ItemDaoImpl().doSohSearch(currentItem,location,locType);	
    	}
    	return results;    	
    }  
    
}
