package com.kjnext.hibernate;

import java.util.HashSet;
import java.util.Set;


/**
 * RaMaterialMaster generated by MyEclipse - Hibernate Tools
 */

public class RaMaterialMaster  implements java.io.Serializable {


    // Fields    

     private Integer materialId;
     private String description;
     private Set raSealMaterials = new HashSet(0);


    // Constructors

    /** default constructor */
    public RaMaterialMaster() {
    }

	/** minimal constructor */
    public RaMaterialMaster(Integer materialId) {
        this.materialId = materialId;
    }
    
    /** full constructor */
    public RaMaterialMaster(Integer materialId, String description, Set raSealMaterials) {
        this.materialId = materialId;
        this.description = description;
        this.raSealMaterials = raSealMaterials;
    }

   
    // Property accessors

    public Integer getMaterialId() {
        return this.materialId;
    }
    
    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getRaSealMaterials() {
        return this.raSealMaterials;
    }
    
    public void setRaSealMaterials(Set raSealMaterials) {
        this.raSealMaterials = raSealMaterials;
    }
   








}