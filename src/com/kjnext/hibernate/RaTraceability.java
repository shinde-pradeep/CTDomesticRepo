package com.kjnext.hibernate;

import java.util.Date;


/**
 * RaTraceability generated by MyEclipse - Hibernate Tools
 */

public class RaTraceability  implements java.io.Serializable {


    // Fields    

     private Integer traceId;
     private RaTracCropYear raTracCropYear;
     private RaDeliveryMonth raDeliveryMonth;
     private RaStateMaster raStateMaster;
     private RaPriceBasis raPriceBasis;
     private RaOriginMaster raOriginMaster;
     private RaDestinationPort raDestinationPort;
     private RaLoadPort raLoadPort;
     private Integer customerId;
     private Date transDate;
     private String buyerId;
     private String sellerId;
     private String priceType;
     private Double price;
     private String priceUnit;
     private String prcieExchange;
     private String orderType;
     private Integer userId;
     private Integer noOfContainers;
     private String status;
     private Integer parentTransId;
     private Date createDate;
     private Double premPrice;
     private String premPriceUom;
     private String prevStatus;
     private Integer transactionId;


    // Constructors

    /** default constructor */
    public RaTraceability() {
    }

	/** minimal constructor */
    public RaTraceability(Integer traceId) {
        this.traceId = traceId;
    }
    
    /** full constructor */
    public RaTraceability(Integer traceId, RaTracCropYear raTracCropYear, RaDeliveryMonth raDeliveryMonth, RaStateMaster raStateMaster, RaPriceBasis raPriceBasis, RaOriginMaster raOriginMaster, RaDestinationPort raDestinationPort, RaLoadPort raLoadPort, Integer customerId, Date transDate, String buyerId, String sellerId, String priceType, Double price, String priceUnit, String prcieExchange, String orderType, Integer userId, Integer noOfContainers, String status, Integer parentTransId, Date createDate, Double premPrice, String premPriceUom, String prevStatus, Integer transactionId) {
        this.traceId = traceId;
        this.raTracCropYear = raTracCropYear;
        this.raDeliveryMonth = raDeliveryMonth;
        this.raStateMaster = raStateMaster;
        this.raPriceBasis = raPriceBasis;
        this.raOriginMaster = raOriginMaster;
        this.raDestinationPort = raDestinationPort;
        this.raLoadPort = raLoadPort;
        this.customerId = customerId;
        this.transDate = transDate;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.priceType = priceType;
        this.price = price;
        this.priceUnit = priceUnit;
        this.prcieExchange = prcieExchange;
        this.orderType = orderType;
        this.userId = userId;
        this.noOfContainers = noOfContainers;
        this.status = status;
        this.parentTransId = parentTransId;
        this.createDate = createDate;
        this.premPrice = premPrice;
        this.premPriceUom = premPriceUom;
        this.prevStatus = prevStatus;
        this.transactionId = transactionId;
    }

   
    // Property accessors

    public Integer getTraceId() {
        return this.traceId;
    }
    
    public void setTraceId(Integer traceId) {
        this.traceId = traceId;
    }

    public RaTracCropYear getRaTracCropYear() {
        return this.raTracCropYear;
    }
    
    public void setRaTracCropYear(RaTracCropYear raTracCropYear) {
        this.raTracCropYear = raTracCropYear;
    }

    public RaDeliveryMonth getRaDeliveryMonth() {
        return this.raDeliveryMonth;
    }
    
    public void setRaDeliveryMonth(RaDeliveryMonth raDeliveryMonth) {
        this.raDeliveryMonth = raDeliveryMonth;
    }

    public RaStateMaster getRaStateMaster() {
        return this.raStateMaster;
    }
    
    public void setRaStateMaster(RaStateMaster raStateMaster) {
        this.raStateMaster = raStateMaster;
    }

    public RaPriceBasis getRaPriceBasis() {
        return this.raPriceBasis;
    }
    
    public void setRaPriceBasis(RaPriceBasis raPriceBasis) {
        this.raPriceBasis = raPriceBasis;
    }

    public RaOriginMaster getRaOriginMaster() {
        return this.raOriginMaster;
    }
    
    public void setRaOriginMaster(RaOriginMaster raOriginMaster) {
        this.raOriginMaster = raOriginMaster;
    }

    public RaDestinationPort getRaDestinationPort() {
        return this.raDestinationPort;
    }
    
    public void setRaDestinationPort(RaDestinationPort raDestinationPort) {
        this.raDestinationPort = raDestinationPort;
    }

    public RaLoadPort getRaLoadPort() {
        return this.raLoadPort;
    }
    
    public void setRaLoadPort(RaLoadPort raLoadPort) {
        this.raLoadPort = raLoadPort;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getTransDate() {
        return this.transDate;
    }
    
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getBuyerId() {
        return this.buyerId;
    }
    
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return this.sellerId;
    }
    
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPriceType() {
        return this.priceType;
    }
    
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return this.priceUnit;
    }
    
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getPrcieExchange() {
        return this.prcieExchange;
    }
    
    public void setPrcieExchange(String prcieExchange) {
        this.prcieExchange = prcieExchange;
    }

    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNoOfContainers() {
        return this.noOfContainers;
    }
    
    public void setNoOfContainers(Integer noOfContainers) {
        this.noOfContainers = noOfContainers;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getParentTransId() {
        return this.parentTransId;
    }
    
    public void setParentTransId(Integer parentTransId) {
        this.parentTransId = parentTransId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getPremPrice() {
        return this.premPrice;
    }
    
    public void setPremPrice(Double premPrice) {
        this.premPrice = premPrice;
    }

    public String getPremPriceUom() {
        return this.premPriceUom;
    }
    
    public void setPremPriceUom(String premPriceUom) {
        this.premPriceUom = premPriceUom;
    }

    public String getPrevStatus() {
        return this.prevStatus;
    }
    
    public void setPrevStatus(String prevStatus) {
        this.prevStatus = prevStatus;
    }

    public Integer getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
   








}