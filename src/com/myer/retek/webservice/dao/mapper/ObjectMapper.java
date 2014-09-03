package com.myer.retek.webservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Map a domain object from an oracle result set.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public interface ObjectMapper {
	
	/**
	 * Map a domain object from an oracle result set.
	 * 
	 * @param rs the oracle result set
	 * @return a list of domain objects
	 * @throws SQLException
	 */
	public List mapRows(ResultSet rs) throws SQLException;

}
