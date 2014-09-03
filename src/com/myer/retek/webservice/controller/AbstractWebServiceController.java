package com.myer.retek.webservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.myer.retek.webservice.constants.ParamConstants;
import com.myer.retek.webservice.dao.AbstractDao;
import com.myer.retek.webservice.exception.RetekServiceException;

/**
 * AbstractWebServiceController is the abstract base class for all service controller servlets should extend off.
 * controller servlets should extend off.
 * 
 * An abstract controller provides methods that should be common in all web service controllers to:
 * <ul>
 * <li>Get the action request parameter
 * <li>Handle an action parameter which is not recognized by this application.
 * <li>Get search results of a previous search (which depends on the plsql search results function to be named properly)
 * </ul>
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 *
 */
public abstract class AbstractWebServiceController extends HttpServlet {

	private static final long serialVersionUID = -635827302551497767L;
	private static Logger logger = Logger.getLogger(AbstractWebServiceController.class);
	
	/**
	 * Get the action parameter from the Url.
	 * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
	 * @return a string containing the value of the action parameter.
     * @throws IOException if an input or output error is detected when writing the response object
	 */
	public String getAction (
			HttpServletRequest request,
            HttpServletResponse response) throws IOException {
		String action = request.getParameter(ParamConstants.PARAM_ACTION);
		if (action != null){
			logger.debug("action: " + action);
			return action; 
		}	
		writeErrorResponse(request,response,ParamConstants.ACTION_NOT_SPECIFIED);
		return null;		
	}
	
    /**
     * Write a custom error message to the response object in json format. 
     * 
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @throws IOException if an input or output error is detected when writing the response object
     */
    public void writeErrorResponse (
		HttpServletRequest request,
        HttpServletResponse response,
        String error) throws IOException {
    	if (error != null && error.length() > ParamConstants.MAX_ERROR_LENGTH){
    		error = error.substring(0,ParamConstants.MAX_ERROR_LENGTH);
    	}
		response.setContentType(ParamConstants.JSON_MEDIA_TYPE);
		response.getWriter().print(ParamConstants.ERROR_PREFIX + error + ParamConstants.ERROR_SUFFIX);
		response.getWriter().flush();
    }
    
    /**
     * Get search results of a previous search based on the sessionId parameter in the request.
     * 
     * @param dao the data access object that should be used for the call to retrieve results
	 * @param request object that contains the request the client has made of the servlet
	 * @param response object that contains the response the servlet sends to the client
     * @return a list of search results
     * @throws RetekServiceException
     */
    public List getSearchResults (
    		AbstractDao dao,
    		HttpServletRequest request,
            HttpServletResponse response) throws RetekServiceException {
    	
    	String sessionId = request.getParameter(ParamConstants.PARAM_SESSION_ID);    	
    	Integer displayStart = new Integer(request.getParameter(ParamConstants.PARAM_DISPLAY_START));
    	Integer displayEnd = new Integer(request.getParameter(ParamConstants.PARAM_DISPLAY_LENGTH));    	
    	List results = dao.getSearchResults(sessionId, displayStart.intValue(), displayEnd.intValue());
    	return results;
    }
     
}
