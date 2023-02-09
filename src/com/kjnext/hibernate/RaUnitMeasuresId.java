package com.kjnext.hibernate;



/**
 * RaUnitMeasuresId generated by MyEclipse - Hibernate Tools
 */

public class RaUnitMeasuresId  implements java.io.Serializable {


    // Fields    

     private String unitDspVal;
     private String unitShrtName;


    // Constructors

    /** default constructor */
    public RaUnitMeasuresId() {
    }

    
    /** full constructor */
    public RaUnitMeasuresId(String unitDspVal, String unitShrtName) {
        this.unitDspVal = unitDspVal;
        this.unitShrtName = unitShrtName;
    }

   
    // Property accessors

    public String getUnitDspVal() {
        return this.unitDspVal;
    }
    
    public void setUnitDspVal(String unitDspVal) {
        this.unitDspVal = unitDspVal;
    }

    public String getUnitShrtName() {
        return this.unitShrtName;
    }
    
    public void setUnitShrtName(String unitShrtName) {
        this.unitShrtName = unitShrtName;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RaUnitMeasuresId) ) return false;
		 RaUnitMeasuresId castOther = ( RaUnitMeasuresId ) other; 
         
		 return ( (this.getUnitDspVal()==castOther.getUnitDspVal()) || ( this.getUnitDspVal()!=null && castOther.getUnitDspVal()!=null && this.getUnitDspVal().equals(castOther.getUnitDspVal()) ) )
 && ( (this.getUnitShrtName()==castOther.getUnitShrtName()) || ( this.getUnitShrtName()!=null && castOther.getUnitShrtName()!=null && this.getUnitShrtName().equals(castOther.getUnitShrtName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUnitDspVal() == null ? 0 : this.getUnitDspVal().hashCode() );
         result = 37 * result + ( getUnitShrtName() == null ? 0 : this.getUnitShrtName().hashCode() );
         return result;
   }   





}