package com.kjnext.model;

import java.util.Date;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaGradeMaster;
import com.kjnext.hibernate.RaOriginMaster;

public class TraderOfferModel {

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String city;

	private Integer offerQty;

	private String qtyUom;

	private Integer offerPrice;

	private String offerPriceUom;

	private String comments;
	
	private String otherCity;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Integer offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getOfferPriceUom() {
		return offerPriceUom;
	}

	public void setOfferPriceUom(String offerPriceUom) {
		this.offerPriceUom = offerPriceUom;
	}

	public Integer getOfferQty() {
		return offerQty;
	}

	public void setOfferQty(Integer offerQty) {
		this.offerQty = offerQty;
	}

	public String getOtherCity() {
		return otherCity;
	}

	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQtyUom() {
		return qtyUom;
	}

	public void setQtyUom(String qtyUom) {
		this.qtyUom = qtyUom;
	}

	
}
