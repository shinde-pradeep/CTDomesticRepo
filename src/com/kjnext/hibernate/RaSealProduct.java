package com.kjnext.hibernate;



/**
 * RaSealProduct generated by MyEclipse - Hibernate Tools
 */

public class RaSealProduct  implements java.io.Serializable {


    // Fields    

     private RaSealProductId id;
     private RaSealMaster raSealMaster;
     private RaProductMaster raProductMaster;


    // Constructors

    /** default constructor */
    public RaSealProduct() {
    }

	/** minimal constructor */
    public RaSealProduct(RaSealProductId id) {
        this.id = id;
    }
    
    /** full constructor */
    public RaSealProduct(RaSealProductId id, RaSealMaster raSealMaster, RaProductMaster raProductMaster) {
        this.id = id;
        this.raSealMaster = raSealMaster;
        this.raProductMaster = raProductMaster;
    }

   
    // Property accessors

    public RaSealProductId getId() {
        return this.id;
    }
    
    public void setId(RaSealProductId id) {
        this.id = id;
    }

    public RaSealMaster getRaSealMaster() {
        return this.raSealMaster;
    }
    
    public void setRaSealMaster(RaSealMaster raSealMaster) {
        this.raSealMaster = raSealMaster;
    }

    public RaProductMaster getRaProductMaster() {
        return this.raProductMaster;
    }
    
    public void setRaProductMaster(RaProductMaster raProductMaster) {
        this.raProductMaster = raProductMaster;
    }
   








}