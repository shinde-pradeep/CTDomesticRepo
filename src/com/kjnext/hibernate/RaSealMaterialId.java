package com.kjnext.hibernate;



/**
 * RaSealMaterialId generated by MyEclipse - Hibernate Tools
 */

public class RaSealMaterialId  implements java.io.Serializable {


    // Fields    

     private RaMaterialMaster raMaterialMaster;
     private RaSealMaster raSealMaster;


    // Constructors

    /** default constructor */
    public RaSealMaterialId() {
    }

    
    /** full constructor */
    public RaSealMaterialId(RaMaterialMaster raMaterialMaster, RaSealMaster raSealMaster) {
        this.raMaterialMaster = raMaterialMaster;
        this.raSealMaster = raSealMaster;
    }

   
    // Property accessors

    public RaMaterialMaster getRaMaterialMaster() {
        return this.raMaterialMaster;
    }
    
    public void setRaMaterialMaster(RaMaterialMaster raMaterialMaster) {
        this.raMaterialMaster = raMaterialMaster;
    }

    public RaSealMaster getRaSealMaster() {
        return this.raSealMaster;
    }
    
    public void setRaSealMaster(RaSealMaster raSealMaster) {
        this.raSealMaster = raSealMaster;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RaSealMaterialId) ) return false;
		 RaSealMaterialId castOther = ( RaSealMaterialId ) other; 
         
		 return ( (this.getRaMaterialMaster()==castOther.getRaMaterialMaster()) || ( this.getRaMaterialMaster()!=null && castOther.getRaMaterialMaster()!=null && this.getRaMaterialMaster().equals(castOther.getRaMaterialMaster()) ) )
 && ( (this.getRaSealMaster()==castOther.getRaSealMaster()) || ( this.getRaSealMaster()!=null && castOther.getRaSealMaster()!=null && this.getRaSealMaster().equals(castOther.getRaSealMaster()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRaMaterialMaster() == null ? 0 : this.getRaMaterialMaster().hashCode() );
         result = 37 * result + ( getRaSealMaster() == null ? 0 : this.getRaSealMaster().hashCode() );
         return result;
   }   





}