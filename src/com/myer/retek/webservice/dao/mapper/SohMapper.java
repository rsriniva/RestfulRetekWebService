package com.myer.retek.webservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myer.retek.webservice.model.StockOnHand;
import com.myer.retek.webservice.util.StringUtils;

/**
 * Map a stock on hand object from an oracle result set.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 26 Aug 2014
 */
public class SohMapper implements ObjectMapper {

	/* (non-Javadoc)
	 * @see com.myer.retek.webservice.dao.mapper.ObjectMapper#mapRows(java.sql.ResultSet)
	 */
	public List mapRows(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()){
			int i = 1;
			StockOnHand soh = new StockOnHand();
			soh.setLocation(new Integer(rs.getInt(i++)));
			soh.setLocationName(StringUtils.coalesce(rs.getString(i++)));
			soh.setRegion(StringUtils.coalesce(rs.getString(i++)));
			soh.setCount(new Integer(rs.getInt(i++)));
			soh.setLocationType(StringUtils.coalesce(rs.getString(i++)));
			soh.setUnitRetail(rs.getBigDecimal(i++));
			soh.setRegularUnitRetail(rs.getBigDecimal(i++));
			soh.setSellingUnitRetail(rs.getBigDecimal(i++));
			soh.setSellingUOM(StringUtils.coalesce(rs.getString(i++)));
			soh.setPromoRetail(rs.getBigDecimal(i++));
			soh.setPromoSellingRetail(rs.getBigDecimal(i++));
			soh.setPromoSellingUOM(StringUtils.coalesce(rs.getString(i++)));
			soh.setClearInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			soh.setStoreOrderMult(StringUtils.coalesce(rs.getString(i++)));
			soh.setSourceMethod(StringUtils.coalesce(rs.getString(i++)));
			soh.setSourceWarehouse(new Integer(rs.getInt(i++)));
			soh.setAverageCost(rs.getBigDecimal(i++));
			soh.setUnitCost(rs.getBigDecimal(i++));
			soh.setTsfReservedQty(rs.getBigDecimal(i++));
			soh.setTsfExpectedQty(rs.getBigDecimal(i++));
			soh.setRtvQty(rs.getBigDecimal(i++));
			soh.setNonSellableQty(rs.getBigDecimal(i++));
			soh.setFirstReceived(rs.getDate(i++));
			soh.setLastReceived(rs.getDate(i++));
			soh.setQtyReceived(rs.getBigDecimal(i++));
			soh.setFirstSold(rs.getDate(i++));
			soh.setLastSold(rs.getDate(i++));
			soh.setPrimaryCountry(StringUtils.coalesce(rs.getString(i++)));
			soh.setReturnableInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			soh.setStopSaleInd(StringUtils.coalesceBoolean(rs.getString(i++)));
			results.add(soh);
		}
		return results;
	}

}
