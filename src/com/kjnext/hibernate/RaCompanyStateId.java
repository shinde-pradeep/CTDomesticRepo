package com.kjnext.hibernate;



/**
 * RaCompanyStateId generated by MyEclipse - Hibernate Tools
 */

public class RaCompanyStateId  implements java.io.Serializable {


    // Fields    

     private RaCompanyMaster raCompanyMaster;
     private RaStateMaster raStateMaster;


    // Constructors

    /** default constructor */
    public RaCompanyStateId() {
    }

    
    /** full constructor */
    public RaCompanyStateId(RaCompanyMaster raCompanyMaster, RaStateMaster raStateMaster) {
        this.raCompanyMaster = raCompanyMaster;
        this.raStateMaster = raStateMaster;
    }

   
    // Property accessors

    public RaCompanyMaster getRaCompanyMaster() {
        return this.raCompanyMaster;
    }
    
    public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
        this.raCompanyMaster = raCompanyMaster;
    }

    public RaStateMaster getRaStateMaster() {
        return this.raStateMaster;
    }
    
    public void setRaStateMaster(RaStateMaster raStateMaster) {
        this.raStateMaster = raStateMaster;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RaCompanyStateId) ) return false;
		 RaCompanyStateId castOther = ( RaCompanyStateId ) other; 
         
		 return ( (this.getRaCompanyMaster()==castOther.getRaCompanyMaster()) || ( this.getRaCompanyMaster()!=null && castOther.getRaCompanyMaster()!=null && this.getRaCompanyMaster().equals(castOther.getRaCompanyMaster()) ) )
 && ( (this.getRaStateMaster()==castOther.getRaStateMaster()) || ( this.getRaStateMaster()!=null && castOther.getRaStateMaster()!=null && this.getRaStateMaster().equals(castOther.getRaStateMaster()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRaCompanyMaster() == null ? 0 : this.getRaCompanyMaster().hashCode() );
         result = 37 * result + ( getRaStateMaster() == null ? 0 : this.getRaStateMaster().hashCode() );
         return result;
   }   





}