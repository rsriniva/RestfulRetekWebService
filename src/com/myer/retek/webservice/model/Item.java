package com.myer.retek.webservice.model;

import java.math.BigDecimal;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * A domain object representing a Retek item. 
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 22 Aug 2014
 */
public class Item implements JSONAware {
		
	private String _itemNumber;
	private String _parentNumber;
	private String _itemDescription;
	private String _size;
	private String _colour;
	private String _supplyStyle;
	private Integer _classGroup;
	private String _classGroupDescription;
	private String _apn;
	private Integer _classNumber;
	private Integer _subclassNumber;
	private String _brandName;
	private String _supplierName;
	private Integer _supplierNumber;
	private String _status;
	private String _standardUOM;
	private Boolean _merchandiseInd;
	private BigDecimal _originalRetail;
	private Boolean _sellableInd;
	private Boolean _orderableInd;
	private String _orderType;
	private String _comments;
	private BigDecimal _unitCost;
	private String _originCountryId;
	private String _primaryCountryId;
	
	/**
	 * @return
	 */
	public String getAPN() {
		return _apn;
	}
	/**
	 * @param apn
	 */
	public void setAPN(String apn) {
		_apn = apn;
	}
	/**
	 * @return
	 */
	public String getBrandName() {
		return _brandName;
	}
	/**
	 * @param brandName
	 */
	public void setBrandName(String brandName) {
		_brandName = brandName;
	}
	/**
	 * @return
	 */
	public Integer getClassGroup() {
		return _classGroup;
	}
	/**
	 * @param classGroup
	 */
	public void setClassGroup(Integer classGroup) {
		_classGroup = classGroup;
	}
	/**
	 * @return
	 */
	public String getClassGroupDescription() {
		return _classGroupDescription;
	}
	/**
	 * @param classGroupDescription
	 */
	public void setClassGroupDescription(String classGroupDescription) {
		_classGroupDescription = classGroupDescription;
	}
	/**
	 * @return
	 */
	public Integer getClassNumber() {
		return _classNumber;
	}
	/**
	 * @param classNumber
	 */
	public void setClassNumber(Integer classNumber) {
		_classNumber = classNumber;
	}
	/**
	 * @return
	 */
	public String getColour() {
		return _colour;
	}
	/**
	 * @param colour
	 */
	public void setColour(String colour) {
		_colour = colour;
	}
	/**
	 * @return
	 */
	public String getItemDescription() {
		return _itemDescription;
	}
	/**
	 * @param itemDescription
	 */
	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;
	}
	/**
	 * @return
	 */
	public String getItemNumber() {
		return _itemNumber;
	}
	/**
	 * @param itemNumber
	 */
	public void setItemNumber(String itemNumber) {
		_itemNumber = itemNumber;
	}
	/**
	 * @return
	 */
	public String getParentNumber() {
		return _parentNumber;
	}
	/**
	 * @param parentNumber
	 */
	public void setParentNumber(String parentNumber) {
		_parentNumber = parentNumber;
	}
	/**
	 * @return
	 */
	public String getSize() {
		return _size;
	}
	/**
	 * @param size
	 */
	public void setSize(String size) {
		_size = size;
	}
	/**
	 * @return
	 */
	public String getStatus() {
		return _status;
	}
	/**
	 * @param status
	 */
	public void setStatus(String status) {
		_status = status;
	}
	/**
	 * @return
	 */
	public Integer getSubclassNumber() {
		return _subclassNumber;
	}
	/**
	 * @param subclassNumber
	 */
	public void setSubclassNumber(Integer subclassNumber) {
		_subclassNumber = subclassNumber;
	}
	/**
	 * @return
	 */
	public String getSupplierName() {
		return _supplierName;
	}
	/**
	 * @param supplierName
	 */
	public void setSupplierName(String supplierName) {
		_supplierName = supplierName;
	}
	/**
	 * @return
	 */
	public Integer getSupplierNumber() {
		return _supplierNumber;
	}
	/**
	 * @param supplierNumber
	 */
	public void setSupplierNumber(Integer supplierNumber) {
		_supplierNumber = supplierNumber;
	}
	/**
	 * @return
	 */
	public String getSupplyStyle() {
		return _supplyStyle;
	}
	/**
	 * @param supplyStyle
	 */
	public void setSupplyStyle(String supplyStyle) {
		_supplyStyle = supplyStyle;
	}
	/**
	 * @return
	 */
	public String getComments() {
		return _comments;
	}
	/**
	 * @param comments
	 */
	public void setComments(String comments) {
		_comments = comments;
	}
	/**
	 * @return
	 */
	public Boolean getMerchandiseInd() {
		return _merchandiseInd;
	}
	/**
	 * @param merchandiseInd
	 */
	public void setMerchandiseInd(Boolean merchandiseInd) {
		_merchandiseInd = merchandiseInd;
	}
	/**
	 * @return
	 */
	public Boolean getOrderableInd() {
		return _orderableInd;
	}
	/**
	 * @param orderableInd
	 */
	public void setOrderableInd(Boolean orderableInd) {
		_orderableInd = orderableInd;
	}
	/**
	 * @return
	 */
	public String getOrderType() {
		return _orderType;
	}
	/**
	 * @param orderType
	 */
	public void setOrderType(String orderType) {
		_orderType = orderType;
	}
	/**
	 * @return
	 */
	public BigDecimal getOriginalRetail() {
		return _originalRetail;
	}
	/**
	 * @param originalRetail
	 */
	public void setOriginalRetail(BigDecimal originalRetail) {
		_originalRetail = originalRetail;
	}
	/**
	 * @return
	 */
	public String getOriginCountryId() {
		return _originCountryId;
	}
	/**
	 * @param originCountryId
	 */
	public void setOriginCountryId(String originCountryId) {
		_originCountryId = originCountryId;
	}
	/**
	 * @return
	 */
	public String getPrimaryCountryId() {
		return _primaryCountryId;
	}
	/**
	 * @param primaryCountryId
	 */
	public void setPrimaryCountryId(String primaryCountryId) {
		_primaryCountryId = primaryCountryId;
	}
	/**
	 * @return
	 */
	public Boolean getSellableInd() {
		return _sellableInd;
	}
	/**
	 * @param sellableInd
	 */
	public void setSellableInd(Boolean sellableInd) {
		_sellableInd = sellableInd;
	}
	/**
	 * @return
	 */
	public String getStandardUOM() {
		return _standardUOM;
	}
	/**
	 * @param standardUOM
	 */
	public void setStandardUOM(String standardUOM) {
		_standardUOM = standardUOM;
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
	
	/* (non-Javadoc)
	 * @see org.json.simple.JSONAware#toJSONString()
	 */
	public String toJSONString() {
		JSONObject obj = new JSONObject();
		obj.put("itemNumber",_itemNumber);
		obj.put("parentNumber",_parentNumber);
		obj.put("itemDescription",_itemDescription);
		obj.put("size",_size);
		obj.put("colour",_colour);
		obj.put("supplyStyle",_supplyStyle);
		obj.put("classGroup",_classGroup);
		obj.put("classGroupDescription",_classGroupDescription);
		obj.put("apn",_apn);
		obj.put("classNumber",_classNumber);
		obj.put("subclassNumber",_subclassNumber);
		obj.put("brandName",_brandName);
		obj.put("supplierName",_supplierName);
		obj.put("supplierNumber",_supplierNumber);
		obj.put("status",_status);
		obj.put("standardUOM",_standardUOM);
		obj.put("merchandiseInd",_merchandiseInd);
		obj.put("originalRetail",_originalRetail);
		obj.put("sellableInd",_sellableInd);
		obj.put("orderableInd",_orderableInd);
		obj.put("orderType",_orderType);
		obj.put("comments",_comments);
		obj.put("unitCost",_unitCost);
		obj.put("originCountryId",_originCountryId);
		obj.put("primaryCountryId",_primaryCountryId);
		return obj.toString();
	}			
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer item = new StringBuffer(getClass().getSimpleName());
		item.append("[ ");
		item.append(" itemNumber: " + _itemNumber);
		item.append(" parentNumber: " + _parentNumber);
		item.append(" itemDescription: " + _itemDescription);
		item.append(" size: " + _size);
		item.append(" colour: " + _colour);
		item.append(" supplyStyle: " + _supplyStyle);
		item.append(" classGroup: " + _classGroup);
		item.append(" classGroupDescription: " + _classGroupDescription);
		item.append(" apn: " + _apn);
		item.append(" classNumber: " + _classNumber);
		item.append(" subclassNumber: " + _subclassNumber);
		item.append(" brandName: " + _brandName);
		item.append(" supplierName: " + _supplierName);
		item.append(" supplierNumber: " + _supplierNumber);
		item.append(" status: " + _status);
		item.append(" standardUOM: " + _standardUOM);
		item.append(" merchandiseInd: " + _merchandiseInd);
		item.append(" originalRetail: " + _originalRetail);
		item.append(" sellableInd: " + _sellableInd);
		item.append(" orderableInd: " + _orderableInd);
		item.append(" orderType: " + _orderType);
		item.append(" comments: " + _comments);
		item.append(" unitCost: " + _unitCost);
		item.append(" originCountryId: " + _originCountryId);
		item.append(" primaryCountryId: " + _primaryCountryId);
		item.append(" ]");
		return item.toString();
	}
}
