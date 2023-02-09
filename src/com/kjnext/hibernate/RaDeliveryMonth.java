package com.kjnext.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * RaDeliveryMonth generated by MyEclipse - Hibernate Tools
 */

public class RaDeliveryMonth  implements java.io.Serializable {


    // Fields    

     private Integer monthId;
     private String description;
     private String status;
     private String deliveryMonth;
     private String exchangeType;
     private Set raTraceabilities = new HashSet(0);


    // Constructors

    /** default constructor */
    public RaDeliveryMonth() {
    }

	/** minimal constructor */
    public RaDeliveryMonth(Integer monthId) {
        this.monthId = monthId;
    }
    
    /** full constructor */
    public RaDeliveryMonth(Integer monthId, String description, String status, String deliveryMonth, String exchangeType, Set raTraceabilities) {
        this.monthId = monthId;
        this.description = description;
        this.status = status;
        this.deliveryMonth = deliveryMonth;
        this.exchangeType = exchangeType;
        this.raTraceabilities = raTraceabilities;
    }

   
    // Property accessors

    public Integer getMonthId() {
        return this.monthId;
    }
    
    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryMonth() {
        return this.deliveryMonth;
    }
    
    public void setDeliveryMonth(String deliveryMonth) {
        this.deliveryMonth = deliveryMonth;
    }

    public String getExchangeType() {
        return this.exchangeType;
    }
    
    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Set getRaTraceabilities() {
        return this.raTraceabilities;
    }
    
    public void setRaTraceabilities(Set raTraceabilities) {
        this.raTraceabilities = raTraceabilities;
    }
   








}