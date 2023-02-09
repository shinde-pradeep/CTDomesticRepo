package com.kjnext.hibernate;



/**
 * RaCompanyOutletId generated by MyEclipse - Hibernate Tools
 */

public class RaCompanyOutletId  implements java.io.Serializable {


    // Fields    

     private RaCompanyMaster raCompanyMaster;
     private RaOutletMaster raOutletMaster;


    // Constructors

    /** default constructor */
    public RaCompanyOutletId() {
    }

    
    /** full constructor */
    public RaCompanyOutletId(RaCompanyMaster raCompanyMaster, RaOutletMaster raOutletMaster) {
        this.raCompanyMaster = raCompanyMaster;
        this.raOutletMaster = raOutletMaster;
    }

   
    // Property accessors

    public RaCompanyMaster getRaCompanyMaster() {
        return this.raCompanyMaster;
    }
    
    public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
        this.raCompanyMaster = raCompanyMaster;
    }

    public RaOutletMaster getRaOutletMaster() {
        return this.raOutletMaster;
    }
    
    public void setRaOutletMaster(RaOutletMaster raOutletMaster) {
        this.raOutletMaster = raOutletMaster;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RaCompanyOutletId) ) return false;
		 RaCompanyOutletId castOther = ( RaCompanyOutletId ) other; 
         
		 return ( (this.getRaCompanyMaster()==castOther.getRaCompanyMaster()) || ( this.getRaCompanyMaster()!=null && castOther.getRaCompanyMaster()!=null && this.getRaCompanyMaster().equals(castOther.getRaCompanyMaster()) ) )
 && ( (this.getRaOutletMaster()==castOther.getRaOutletMaster()) || ( this.getRaOutletMaster()!=null && castOther.getRaOutletMaster()!=null && this.getRaOutletMaster().equals(castOther.getRaOutletMaster()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRaCompanyMaster() == null ? 0 : this.getRaCompanyMaster().hashCode() );
         result = 37 * result + ( getRaOutletMaster() == null ? 0 : this.getRaOutletMaster().hashCode() );
         return result;
   }   





}