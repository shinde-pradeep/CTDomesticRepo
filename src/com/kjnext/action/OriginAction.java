package com.kjnext.action;

import java.util.List;

import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.model.OriginModel;
import com.kjnext.service.OriginServiceImpl;

public class OriginAction extends BaseAction {

	OriginServiceImpl originServiceImpl=new OriginServiceImpl();
	RaOriginMaster raOriginMaster;
	List<RaOriginMaster> raOriginMasterList;
	
	public OriginServiceImpl getOriginServiceImpl() {
		return originServiceImpl;
	}

	public void setOriginServiceImpl(OriginServiceImpl originServiceImpl) {
		this.originServiceImpl = originServiceImpl;
	}

	public String loadOrigin()
	{
		raOriginMasterList=originServiceImpl.getOriginList();
		if(!raOriginMasterList.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	
	public String addOriginInput()
	{   
		//raOriginMaster.setOriginId(null);
		return SUCCESS;
	}
	
	public String addOrigin()
	{
		if(isOriginExist(raOriginMaster)){
			System.out.println("uplicate origin");
			addActionError(getText("error.duplicate.origin"));
			return SUCCESS;
		}
		raOriginMaster.setOriginStatus("Active");
		originServiceImpl.addOriginList(raOriginMaster);
		loadOrigin();
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	private boolean isOriginExist(RaOriginMaster raOriginMaster2) {
		// TODO Auto-generated method stub
		return originServiceImpl.isOriginExist(raOriginMaster2);
	}

	public String updateOriginInput()
	{
		raOriginMaster=originServiceImpl.loadSingleOrigin(raOriginMaster.getOriginId());
		return SUCCESS;
	}
	
	public String updateOrigin()
	{
		originServiceImpl.updateOriginList(raOriginMaster);
		loadOrigin();
		setNavigationFlg("success");
		return SUCCESS;
		
	}

	public String deActiveOrigin()
	{
		
		originServiceImpl.deActiveOrigin(raOriginMaster.getOriginId());
		loadOrigin();
		return SUCCESS;
	}
	
	////////////////
	
	public RaOriginMaster getRaOriginMaster() {
		return raOriginMaster;
	}

	public void setRaOriginMaster(RaOriginMaster raOriginMaster) {
		this.raOriginMaster = raOriginMaster;
	}

	public List<RaOriginMaster> getRaOriginMasterList() {
		return raOriginMasterList;
	}

	public void setRaOriginMasterList(List<RaOriginMaster> raOriginMasterList) {
		this.raOriginMasterList = raOriginMasterList;
	}
	
}
