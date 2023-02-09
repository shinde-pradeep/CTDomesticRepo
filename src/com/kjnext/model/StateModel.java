package com.kjnext.model;

import com.kjnext.hibernate.RaSellingRegion;

public class StateModel
{
	 private String description;
     private String stateStatus;
     private String stateType;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStateStatus() {
		return stateStatus;
	}
	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}
	public String getStateType() {
		return stateType;
	}
	public void setStateType(String stateType) {
		this.stateType = stateType;
	}
}
