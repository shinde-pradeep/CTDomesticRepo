package com.kjnext.hibernate;



/**
 * RaRoleMaster generated by MyEclipse - Hibernate Tools
 */

public class RaRoleMaster  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private String roleName;
     private String roleShortName;


    // Constructors

    /** default constructor */
    public RaRoleMaster() {
    }

	/** minimal constructor */
    public RaRoleMaster(Integer roleId) {
        this.roleId = roleId;
    }
    
    /** full constructor */
    public RaRoleMaster(Integer roleId, String roleName, String roleShortName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleShortName = roleShortName;
    }

   
    // Property accessors

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleShortName() {
        return this.roleShortName;
    }
    
    public void setRoleShortName(String roleShortName) {
        this.roleShortName = roleShortName;
    }
   








}