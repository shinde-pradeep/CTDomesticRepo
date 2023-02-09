package com.kjnext.hibernate;



/**
 * RaBussSupplyProd generated by MyEclipse - Hibernate Tools
 */

public class RaBussSupplyProd  implements java.io.Serializable {


    // Fields    

     private RaBussSupplyProdId id;
     private RaBussinessTypeMaster raBussinessTypeMaster;


    // Constructors

    /** default constructor */
    public RaBussSupplyProd() {
    }

	/** minimal constructor */
    public RaBussSupplyProd(RaBussSupplyProdId id) {
        this.id = id;
    }
    
    /** full constructor */
    public RaBussSupplyProd(RaBussSupplyProdId id, RaBussinessTypeMaster raBussinessTypeMaster) {
        this.id = id;
        this.raBussinessTypeMaster = raBussinessTypeMaster;
    }

   
    // Property accessors

    public RaBussSupplyProdId getId() {
        return this.id;
    }
    
    public void setId(RaBussSupplyProdId id) {
        this.id = id;
    }

    public RaBussinessTypeMaster getRaBussinessTypeMaster() {
        return this.raBussinessTypeMaster;
    }
    
    public void setRaBussinessTypeMaster(RaBussinessTypeMaster raBussinessTypeMaster) {
        this.raBussinessTypeMaster = raBussinessTypeMaster;
    }
   








}