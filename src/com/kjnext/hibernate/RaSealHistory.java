package com.kjnext.hibernate;



/**
 * RaSealHistory generated by MyEclipse - Hibernate Tools
 */

public class RaSealHistory  implements java.io.Serializable {


    // Fields    

     private RaSealHistoryId id;
     private RaSealMaster raSealMaster;


    // Constructors

    /** default constructor */
    public RaSealHistory() {
    }

	/** minimal constructor */
    public RaSealHistory(RaSealHistoryId id) {
        this.id = id;
    }
    
    /** full constructor */
    public RaSealHistory(RaSealHistoryId id, RaSealMaster raSealMaster) {
        this.id = id;
        this.raSealMaster = raSealMaster;
    }

   
    // Property accessors

    public RaSealHistoryId getId() {
        return this.id;
    }
    
    public void setId(RaSealHistoryId id) {
        this.id = id;
    }

    public RaSealMaster getRaSealMaster() {
        return this.raSealMaster;
    }
    
    public void setRaSealMaster(RaSealMaster raSealMaster) {
        this.raSealMaster = raSealMaster;
    }
   








}