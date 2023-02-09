package com.kjnext.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * RaGradeMaster generated by MyEclipse - Hibernate Tools
 */

public class RaGradeMaster  implements java.io.Serializable {


    // Fields    

     private Integer gradeId;
     private RaOriginMaster raOriginMaster;
     private String gradeDispName;
     private String gradeType;
     private String status;
     private Set raTraceOfferses = new HashSet(0);


    // Constructors

    /** default constructor */
    public RaGradeMaster() {
    }

	/** minimal constructor */
    public RaGradeMaster(Integer gradeId) {
        this.gradeId = gradeId;
    }
    
    /** full constructor */
    public RaGradeMaster(Integer gradeId, RaOriginMaster raOriginMaster, String gradeDispName, String gradeType, String status, Set raTraceOfferses) {
        this.gradeId = gradeId;
        this.raOriginMaster = raOriginMaster;
        this.gradeDispName = gradeDispName;
        this.gradeType = gradeType;
        this.status = status;
        this.raTraceOfferses = raTraceOfferses;
    }

   
    // Property accessors

    public Integer getGradeId() {
        return this.gradeId;
    }
    
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public RaOriginMaster getRaOriginMaster() {
        return this.raOriginMaster;
    }
    
    public void setRaOriginMaster(RaOriginMaster raOriginMaster) {
        this.raOriginMaster = raOriginMaster;
    }

    public String getGradeDispName() {
        return this.gradeDispName;
    }
    
    public void setGradeDispName(String gradeDispName) {
        this.gradeDispName = gradeDispName;
    }

    public String getGradeType() {
        return this.gradeType;
    }
    
    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Set getRaTraceOfferses() {
        return this.raTraceOfferses;
    }
    
    public void setRaTraceOfferses(Set raTraceOfferses) {
        this.raTraceOfferses = raTraceOfferses;
    }
   








}