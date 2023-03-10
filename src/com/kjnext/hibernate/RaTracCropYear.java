package com.kjnext.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * RaTracCropYear generated by MyEclipse - Hibernate Tools
 */

public class RaTracCropYear  implements java.io.Serializable {


    // Fields    

     private Integer cropYearId;
     private String description;
     private Set raTraceabilities = new HashSet(0);


    // Constructors

    /** default constructor */
    public RaTracCropYear() {
    }

	/** minimal constructor */
    public RaTracCropYear(Integer cropYearId) {
        this.cropYearId = cropYearId;
    }
    
    /** full constructor */
    public RaTracCropYear(Integer cropYearId, String description, Set raTraceabilities) {
        this.cropYearId = cropYearId;
        this.description = description;
        this.raTraceabilities = raTraceabilities;
    }

   
    // Property accessors

    public Integer getCropYearId() {
        return this.cropYearId;
    }
    
    public void setCropYearId(Integer cropYearId) {
        this.cropYearId = cropYearId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getRaTraceabilities() {
        return this.raTraceabilities;
    }
    
    public void setRaTraceabilities(Set raTraceabilities) {
        this.raTraceabilities = raTraceabilities;
    }
   








}