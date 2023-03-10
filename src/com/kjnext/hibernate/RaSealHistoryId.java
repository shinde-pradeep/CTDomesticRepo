package com.kjnext.hibernate;

import java.util.Date;


/**
 * RaSealHistoryId generated by MyEclipse - Hibernate Tools
 */

public class RaSealHistoryId  implements java.io.Serializable {


    // Fields    

     private RaSealMaster raSealMaster;
     private Date createDate;
     private Integer userId;
     private String activityType;
     private String activityDesc;


    // Constructors

    /** default constructor */
    public RaSealHistoryId() {
    }

    
    /** full constructor */
    public RaSealHistoryId(RaSealMaster raSealMaster, Date createDate, Integer userId, String activityType, String activityDesc) {
        this.raSealMaster = raSealMaster;
        this.createDate = createDate;
        this.userId = userId;
        this.activityType = activityType;
        this.activityDesc = activityDesc;
    }

   
    // Property accessors

    public RaSealMaster getRaSealMaster() {
        return this.raSealMaster;
    }
    
    public void setRaSealMaster(RaSealMaster raSealMaster) {
        this.raSealMaster = raSealMaster;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivityType() {
        return this.activityType;
    }
    
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDesc() {
        return this.activityDesc;
    }
    
    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RaSealHistoryId) ) return false;
		 RaSealHistoryId castOther = ( RaSealHistoryId ) other; 
         
		 return ( (this.getRaSealMaster()==castOther.getRaSealMaster()) || ( this.getRaSealMaster()!=null && castOther.getRaSealMaster()!=null && this.getRaSealMaster().equals(castOther.getRaSealMaster()) ) )
 && ( (this.getCreateDate()==castOther.getCreateDate()) || ( this.getCreateDate()!=null && castOther.getCreateDate()!=null && this.getCreateDate().equals(castOther.getCreateDate()) ) )
 && ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) )
 && ( (this.getActivityType()==castOther.getActivityType()) || ( this.getActivityType()!=null && castOther.getActivityType()!=null && this.getActivityType().equals(castOther.getActivityType()) ) )
 && ( (this.getActivityDesc()==castOther.getActivityDesc()) || ( this.getActivityDesc()!=null && castOther.getActivityDesc()!=null && this.getActivityDesc().equals(castOther.getActivityDesc()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRaSealMaster() == null ? 0 : this.getRaSealMaster().hashCode() );
         result = 37 * result + ( getCreateDate() == null ? 0 : this.getCreateDate().hashCode() );
         result = 37 * result + ( getUserId() == null ? 0 : this.getUserId().hashCode() );
         result = 37 * result + ( getActivityType() == null ? 0 : this.getActivityType().hashCode() );
         result = 37 * result + ( getActivityDesc() == null ? 0 : this.getActivityDesc().hashCode() );
         return result;
   }   





}