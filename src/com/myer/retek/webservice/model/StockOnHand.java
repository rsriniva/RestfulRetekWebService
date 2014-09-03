package com.myer.retek.webservice.model;

import java.math.BigDecimal;
import java.util.Date;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * A domain object representing stock on hand. 
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 22 Aug 2014
 */
public class StockOnHand implements JSONAware {
	
	private Integer _location;
	private String _locationName;
	private String _region;
	private Integer _count;
	private String _locationType;
	private BigDecimal _unitRetail;
	private BigDecimal _regularUnitRetail;
	private BigDecimal _sellingUnitRetail;
	private String _sellingUOM;
	private BigDecimal _promoRetail;
	private BigDecimal _promoSellingRetail;
	private String _promoSellingUOM;
	private Boolean _clearInd;
	private String _storeOrderMult;
	private String _sourceMethod;
	private Integer _sourceWarehouse;
	private BigDecimal _averageCost;
	private BigDecimal _unitCost;
	private BigDecimal _tsfReservedQty;
	private BigDecimal _tsfExpectedQty;
	private BigDecimal _rtvQty;
	private BigDecimal _nonSellableQty;
	private Date _firstReceived;
	private Date _lastReceived;
	private BigDecimal _qtyReceived;
	private Date _firstSold;
	private Date _lastSold;
	private String _primaryCountry;
	private Boolean _returnableInd;
	private Boolean _stopSaleInd;
	
	/**
	 * @return
	 */
	public Integer getCount() {
		return _count;
	}
	/**
	 * @param count
	 */
	public void setCount(Integer count) {
		_count = count;
	}
	/**
	 * @return
	 */
	public Integer getLocation() {
		return _location;
	}
	/**
	 * @param location
	 */
	public void setLocation(Integer location) {
		_location = location;
	}
	/**
	 * @return
	 */
	public String getLocationName() {
		return _locationName;
	}
	/**
	 * @param locationName
	 */
	public void setLocationName(String locationName) {
		_locationName = locationName;
	}
	/**
	 * @return
	 */
	public String getLocationType() {
		return _locationType;
	}
	/**
	 * @param locationType
	 */
	public void setLocationType(String locationType) {
		_locationType = locationType;
	}
	/**
	 * @return
	 */
	public String getRegion() {
		return _region;
	}
	/**
	 * @param region
	 */
	public void setRegion(String region) {
		_region = region;
	}
	/**
	 * @return
	 */
	public BigDecimal getAverageCost() {
		return _averageCost;
	}
	/**
	 * @param averageCost
	 */
	public void setAverageCost(BigDecimal averageCost) {
		_averageCost = averageCost;
	}
	/**
	 * @return
	 */
	public Boolean getClearInd() {
		return _clearInd;
	}
	/**
	 * @param clearInd
	 */
	public void setClearInd(Boolean clearInd) {
		_clearInd = clearInd;
	}
	/**
	 * @return
	 */
	public Date getFirstReceived() {
		return _firstReceived;
	}
	/**
	 * @param firstReceived
	 */
	public void setFirstReceived(Date firstReceived) {
		_firstReceived = firstReceived;
	}
	/**
	 * @return
	 */
	public Date getFirstSold() {
		return _firstSold;
	}
	/**
	 * @param firstSold
	 */
	public void setFirstSold(Date firstSold) {
		_firstSold = firstSold;
	}
	/**
	 * @return
	 */
	public Date getLastReceived() {
		return _lastReceived;
	}
	/**
	 * @param lastReceived
	 */
	public void setLastReceived(Date lastReceived) {
		_lastReceived = lastReceived;
	}
	/**
	 * @return
	 */
	public Date getLastSold() {
		return _lastSold;
	}
	/**
	 * @param lastSold
	 */
	public void setLastSold(Date lastSold) {
		_lastSold = lastSold;
	}
	/**
	 * @return
	 */
	public BigDecimal getNonSellableQty() {
		return _nonSellableQty;
	}
	/**
	 * @param nonSellableQty
	 */
	public void setNonSellableQty(BigDecimal nonSellableQty) {
		_nonSellableQty = nonSellableQty;
	}
	/**
	 * @return
	 */
	public String getPrimaryCountry() {
		return _primaryCountry;
	}
	/**
	 * @param primaryCountry
	 */
	public void setPrimaryCountry(String primaryCountry) {
		_primaryCountry = primaryCountry;
	}
	/**
	 * @return
	 */
	public BigDecimal getPromoRetail() {
		return _promoRetail;
	}
	/**
	 * @param promoRetail
	 */
	public void setPromoRetail(BigDecimal promoRetail) {
		_promoRetail = promoRetail;
	}
	/**
	 * @return
	 */
	public BigDecimal getPromoSellingRetail() {
		return _promoSellingRetail;
	}
	/**
	 * @param promoSellingRetail
	 */
	public void setPromoSellingRetail(BigDecimal promoSellingRetail) {
		_promoSellingRetail = promoSellingRetail;
	}
	/**
	 * @return
	 */
	public String getPromoSellingUOM() {
		return _promoSellingUOM;
	}
	/**
	 * @param promoSellingUOM
	 */
	public void setPromoSellingUOM(String promoSellingUOM) {
		_promoSellingUOM = promoSellingUOM;
	}
	/**
	 * @return
	 */
	public BigDecimal getQtyReceived() {
		return _qtyReceived;
	}
	/**
	 * @param qtyReceived
	 */
	public void setQtyReceived(BigDecimal qtyReceived) {
		_qtyReceived = qtyReceived;
	}
	/**
	 * @return
	 */
	public BigDecimal getRegularUnitRetail() {
		return _regularUnitRetail;
	}
	/**
	 * @param regularUnitRetail
	 */
	public void setRegularUnitRetail(BigDecimal regularUnitRetail) {
		_regularUnitRetail = regularUnitRetail;
	}
	/**
	 * @return
	 */
	public Boolean getReturnableInd() {
		return _returnableInd;
	}
	/**
	 * @param returnableInd
	 */
	public void setReturnableInd(Boolean returnableInd) {
		_returnableInd = returnableInd;
	}
	/**
	 * @return
	 */
	public BigDecimal getRtvQty() {
		return _rtvQty;
	}
	/**
	 * @param rtvQty
	 */
	public void setRtvQty(BigDecimal rtvQty) {
		_rtvQty = rtvQty;
	}
	/**
	 * @return
	 */
	public BigDecimal getSellingUnitRetail() {
		return _sellingUnitRetail;
	}
	/**
	 * @param sellingUnitRetail
	 */
	public void setSellingUnitRetail(BigDecimal sellingUnitRetail) {
		_sellingUnitRetail = sellingUnitRetail;
	}
	/**
	 * @return
	 */
	public String getSellingUOM() {
		return _sellingUOM;
	}
	/**
	 * @param sellingUOM
	 */
	public void setSellingUOM(String sellingUOM) {
		_sellingUOM = sellingUOM;
	}
	/**
	 * @return
	 */
	public String getSourceMethod() {
		return _sourceMethod;
	}
	/**
	 * @param sourceMethod
	 */
	public void setSourceMethod(String sourceMethod) {
		_sourceMethod = sourceMethod;
	}
	/**
	 * @return
	 */
	public Integer getSourceWarehouse() {
		return _sourceWarehouse;
	}
	/**
	 * @param sourceWarehouse
	 */
	public void setSourceWarehouse(Integer sourceWarehouse) {
		_sourceWarehouse = sourceWarehouse;
	}
	/**
	 * @return
	 */
	public Boolean getStopSaleInd() {
		return _stopSaleInd;
	}
	/**
	 * @param stopSaleInd
	 */
	public void setStopSaleInd(Boolean stopSaleInd) {
		_stopSaleInd = stopSaleInd;
	}
	/**
	 * @return
	 */
	public String getStoreOrderMult() {
		return _storeOrderMult;
	}
	/**
	 * @param storeOrderMult
	 */
	public void setStoreOrderMult(String storeOrderMult) {
		_storeOrderMult = storeOrderMult;
	}
	/**
	 * @return
	 */
	public BigDecimal getTsfExpectedQty() {
		return _tsfExpectedQty;
	}
	/**
	 * @param tsfExpectedQty
	 */
	public void setTsfExpectedQty(BigDecimal tsfExpectedQty) {
		_tsfExpectedQty = tsfExpectedQty;
	}
	/**
	 * @return
	 */
	public BigDecimal getTsfReservedQty() {
		return _tsfReservedQty;
	}
	/**
	 * @param tsfReservedQty
	 */
	public void setTsfReservedQty(BigDecimal tsfReservedQty) {
		_tsfReservedQty = tsfReservedQty;
	}
	/**
	 * @return
	 */
	public BigDecimal getUnitCost() {
		return _unitCost;
	}
	/**
	 * @param unitCost
	 */
	public void setUnitCost(BigDecimal unitCost) {
		_unitCost = unitCost;
	}
	/**
	 * @return
	 */
	public BigDecimal getUnitRetail() {
		return _unitRetail;
	}
	/**
	 * @param unitRetail
	 */
	public void setUnitRetail(BigDecimal unitRetail) {
		_unitRetail = unitRetail;
	}

	/* (non-Javadoc)
	 * @see org.json.simple.JSONAware#toJSONString()
	 */
	public String toJSONString() {
		JSONObject obj = new JSONObject();
		obj.put("location", _location);
		obj.put("locationName", _locationName);
		obj.put("region", _region);
		obj.put("count", _count);
		obj.put("locationType", _locationType);
		obj.put("unitRetail", _unitRetail);
		obj.put("regularUnitRetail", _regularUnitRetail);
		obj.put("sellingUnitRetail", _sellingUnitRetail);
		obj.put("sellingUOM",  _sellingUOM);
		obj.put("promoRetail", _promoRetail);
		obj.put("promoSellingRetail", _promoSellingRetail);
		obj.put("promoSellingUOM", _promoSellingUOM);
		obj.put("clearInd", _clearInd);
		obj.put("storeOrderMult", _storeOrderMult);
		obj.put("sourceMethod", _sourceMethod);
		obj.put("sourceWarehouse", _sourceWarehouse);
		obj.put("averageCost", _averageCost);
		obj.put("unitCost", _unitCost);
		obj.put("tsfReservedQty", _tsfReservedQty);
		obj.put("tsfExpectedQty", _tsfExpectedQty);
		obj.put("rtvQty", _rtvQty);
		obj.put("nonSellableQty", _nonSellableQty);
		obj.put("firstReceived", _firstReceived);
		obj.put("lastReceived", _lastReceived);
		obj.put("qtyReceived", _qtyReceived);
		obj.put("firstSold", _firstSold);
		obj.put("lastSold", _lastSold);
		obj.put("primaryCountry", _primaryCountry);
		obj.put("returnableInd", _returnableInd);
		obj.put("stopSaleInd", _stopSaleInd);
		return obj.toString();
	}		
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer soh = new StringBuffer(getClass().getSimpleName());
		soh.append("[ ");
		soh.append(" location: " + _location);
		soh.append(" locationName: " + _locationName);
		soh.append(" region: " + _region);
		soh.append(" count: " + _count);
		soh.append(" locationType: " + _locationType);
		soh.append(" unitRetail: " + _unitRetail);
		soh.append(" regularUnitRetail: " + _regularUnitRetail);
		soh.append(" sellingUnitRetail: " + _sellingUnitRetail);
		soh.append(" sellingUOM: " +  _sellingUOM);
		soh.append(" promoRetail: " + _promoRetail);
		soh.append(" promoSellingRetail: " + _promoSellingRetail);
		soh.append(" promoSellingUOM: " + _promoSellingUOM);
		soh.append(" clearInd: " + _clearInd);
		soh.append(" storeOrderMult: " + _storeOrderMult);
		soh.append(" sourceMethod: " + _sourceMethod);
		soh.append(" sourceWarehouse: " + _sourceWarehouse);
		soh.append(" averageCost: " + _averageCost);
		soh.append(" unitCost: " + _unitCost);
		soh.append(" tsfReservedQty: " + _tsfReservedQty);
		soh.append(" tsfExpectedQty: " + _tsfExpectedQty);
		soh.append(" rtvQty: " + _rtvQty);
		soh.append(" nonSellableQty: " + _nonSellableQty);
		soh.append(" firstReceived: " + _firstReceived);
		soh.append(" lastReceived: " + _lastReceived);
		soh.append(" qtyReceived: " + _qtyReceived);
		soh.append(" firstSold: " + _firstSold);
		soh.append(" lastSold: " + _lastSold);
		soh.append(" primaryCountry: " + _primaryCountry);
		soh.append(" returnableInd: " + _returnableInd);
		soh.append(" stopSaleInd: " + _stopSaleInd);
		soh.append(" ]");
		return soh.toString();
	}	
}
