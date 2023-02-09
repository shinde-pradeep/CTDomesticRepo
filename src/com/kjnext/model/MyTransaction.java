package com.kjnext.model;

import java.util.Date;

import com.kjnext.hibernate.RaDeliveryMonth;
import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaLoadPort;
import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.hibernate.RaPriceBasis;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaTracCropYear;

public class MyTransaction {

	private Date transDate;

	private String buyerId;

	private String sellerId;

	private Double price;

	private Double premPrice;

	private String priceType;

	private String priceUnit;

	private String prcieExchange;

	private String orderType;

	private Integer userId;

	private Integer noOfContainers;

	private String status;

	private Integer parentTransId;

	private Date createDate;

	private String premPriceUom;
	private String originDispName;

	private String prevStatus;
	private Integer destPortNameId;

	public Integer getDestPortNameId() {
		return destPortNameId;
	}

	public void setDestPortNameId(Integer destPortNameId) {
		this.destPortNameId = destPortNameId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getNoOfContainers() {
		return noOfContainers;
	}

	public void setNoOfContainers(Integer noOfContainers) {
		this.noOfContainers = noOfContainers;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getParentTransId() {
		return parentTransId;
	}

	public void setParentTransId(Integer parentTransId) {
		this.parentTransId = parentTransId;
	}

	public String getPrcieExchange() {
		return prcieExchange;
	}

	public void setPrcieExchange(String prcieExchange) {
		this.prcieExchange = prcieExchange;
	}

	public Double getPremPrice() {
		return premPrice;
	}

	public void setPremPrice(Double premPrice) {
		this.premPrice = premPrice;
	}

	public String getPremPriceUom() {
		return premPriceUom;
	}

	public void setPremPriceUom(String premPriceUom) {
		this.premPriceUom = premPriceUom;
	}

	public String getPrevStatus() {
		return prevStatus;
	}

	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOriginDispName() {
		return originDispName;
	}

	public void setOriginDispName(String originDispName) {
		this.originDispName = originDispName;
	}

}
