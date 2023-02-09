package com.kjnext.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * RaProducerMaster generated by MyEclipse - Hibernate Tools
 */

public class RaProducerMaster  implements java.io.Serializable {


    // Fields    

     private Integer producerId;
     private String orignizationName;
     private Date lastLoginTimestamp;
     private Integer sendRemindMail;
     private String contactName;
     private String producerStatus;
     private String email;
     private String salesContact;
     private String city;
     private String salesEmail;
     private String salesPhone;
     private String salesFax;
     private String salesUrl;
     private Date createDate;
     private Date updateDate;
     private String anonymous;
     private String state;
     private Integer userId;
     private Integer consumeQty;
     private Integer totalQty;
     private Integer prodRegionId;
     private Integer productId;
     private Set raProducerDataUploads = new HashSet(0);


    // Constructors

    /** default constructor */
    public RaProducerMaster() {
    }

	/** minimal constructor */
    public RaProducerMaster(Integer producerId, String orignizationName) {
        this.producerId = producerId;
        this.orignizationName = orignizationName;
    }
    
    /** full constructor */
    public RaProducerMaster(Integer producerId, String orignizationName, Date lastLoginTimestamp, Integer sendRemindMail, String contactName, String producerStatus, String email, String salesContact, String city, String salesEmail, String salesPhone, String salesFax, String salesUrl, Date createDate, Date updateDate, String anonymous, String state, Integer userId, Integer consumeQty, Integer totalQty, Integer prodRegionId, Integer productId, Set raProducerDataUploads) {
        this.producerId = producerId;
        this.orignizationName = orignizationName;
        this.lastLoginTimestamp = lastLoginTimestamp;
        this.sendRemindMail = sendRemindMail;
        this.contactName = contactName;
        this.producerStatus = producerStatus;
        this.email = email;
        this.salesContact = salesContact;
        this.city = city;
        this.salesEmail = salesEmail;
        this.salesPhone = salesPhone;
        this.salesFax = salesFax;
        this.salesUrl = salesUrl;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.anonymous = anonymous;
        this.state = state;
        this.userId = userId;
        this.consumeQty = consumeQty;
        this.totalQty = totalQty;
        this.prodRegionId = prodRegionId;
        this.productId = productId;
        this.raProducerDataUploads = raProducerDataUploads;
    }

   
    // Property accessors

    public Integer getProducerId() {
        return this.producerId;
    }
    
    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public String getOrignizationName() {
        return this.orignizationName;
    }
    
    public void setOrignizationName(String orignizationName) {
        this.orignizationName = orignizationName;
    }

    public Date getLastLoginTimestamp() {
        return this.lastLoginTimestamp;
    }
    
    public void setLastLoginTimestamp(Date lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    public Integer getSendRemindMail() {
        return this.sendRemindMail;
    }
    
    public void setSendRemindMail(Integer sendRemindMail) {
        this.sendRemindMail = sendRemindMail;
    }

    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getProducerStatus() {
        return this.producerStatus;
    }
    
    public void setProducerStatus(String producerStatus) {
        this.producerStatus = producerStatus;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalesContact() {
        return this.salesContact;
    }
    
    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getSalesEmail() {
        return this.salesEmail;
    }
    
    public void setSalesEmail(String salesEmail) {
        this.salesEmail = salesEmail;
    }

    public String getSalesPhone() {
        return this.salesPhone;
    }
    
    public void setSalesPhone(String salesPhone) {
        this.salesPhone = salesPhone;
    }

    public String getSalesFax() {
        return this.salesFax;
    }
    
    public void setSalesFax(String salesFax) {
        this.salesFax = salesFax;
    }

    public String getSalesUrl() {
        return this.salesUrl;
    }
    
    public void setSalesUrl(String salesUrl) {
        this.salesUrl = salesUrl;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAnonymous() {
        return this.anonymous;
    }
    
    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getConsumeQty() {
        return this.consumeQty;
    }
    
    public void setConsumeQty(Integer consumeQty) {
        this.consumeQty = consumeQty;
    }

    public Integer getTotalQty() {
        return this.totalQty;
    }
    
    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Integer getProdRegionId() {
        return this.prodRegionId;
    }
    
    public void setProdRegionId(Integer prodRegionId) {
        this.prodRegionId = prodRegionId;
    }

    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Set getRaProducerDataUploads() {
        return this.raProducerDataUploads;
    }
    
    public void setRaProducerDataUploads(Set raProducerDataUploads) {
        this.raProducerDataUploads = raProducerDataUploads;
    }
   








}