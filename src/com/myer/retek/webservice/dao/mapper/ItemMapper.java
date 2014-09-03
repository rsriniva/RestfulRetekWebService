package com.myer.retek.webservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myer.retek.webservice.model.Item;
import com.myer.retek.webservice.util.StringUtils;

/**
 * Map an item from an oracle result set.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public class ItemMapper implements ObjectMapper {
	
	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.mapper.ObjectMapper#mapRows(java.sql.ResultSet)
	 */
	public List mapRows(ResultSet rs) throws SQLException {
		List items = new ArrayList();
		while (rs.next()) {
			int i = 1;
			Item item = new Item();
			item.setItemNumber(StringUtils.coalesce(rs.getString(i++)));
			item.setParentNumber(StringUtils.coalesce(rs.getString(i++)));
			item.setItemDescription(StringUtils.coalesce(rs.getString(i++)));
			item.setSize(StringUtils.coalesce(rs.getString(i++)));
			item.setColour(StringUtils.coalesce(rs.getString(i++)));
			item.setSupplyStyle(StringUtils.coalesce(rs.getString(i++)));
			item.setClassGroup(new Integer(rs.getInt(i++)));
			item.setClassGroupDescription(StringUtils.coalesce(rs.getString(i++)));
			item.setAPN(StringUtils.coalesce(rs.getString(i++)));
			item.setClassNumber(new Integer(rs.getInt(i++)));
			item.setSubclassNumber(new Integer(rs.getString(i++)));
			item.setStatus(StringUtils.coalesce(rs.getString(i++)));
			item.setStandardUOM(StringUtils.coalesce(rs.getString(i++)));
			item.setMerchandiseInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			item.setOriginalRetail(rs.getBigDecimal(i++));
			item.setSellableInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			item.setOrderableInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			item.setOrderType(StringUtils.coalesce(rs.getString(i++)));
			item.setComments(StringUtils.coalesce(rs.getString(i++)));
			item.setBrandName(StringUtils.coalesce(rs.getString(i++)));
			item.setSupplierNumber(new Integer(rs.getInt(i++)));
			item.setUnitCost(rs.getBigDecimal(i++));
			item.setOriginCountryId(StringUtils.coalesce(rs.getString(i++)));
			item.setPrimaryCountryId(StringUtils.coalesce(rs.getString(i++)));
			item.setSupplierName(StringUtils.coalesce(rs.getString(i++)));
			items.add(item);
		}
		return items;
	}
	
}
