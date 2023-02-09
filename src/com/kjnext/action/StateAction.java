package com.kjnext.action;

import java.util.ArrayList;
import java.util.List;

import com.kjnext.hibernate.RaSellingRegion;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.model.StateModel;
import com.kjnext.service.StateServiceImpl;
import com.kjnext.utility.hibernate.HibernateUtil;

public class StateAction extends BaseAction 
{
	RaSellingRegion raSellingRegion;//=new RaSellingRegion();
	StateModel stateModel=new StateModel();
	StateServiceImpl stateService=new StateServiceImpl();
	RaStateMaster stateMaster;
	Integer stateMaster_raSellingRegions;
	int regionId;
	List<RaSellingRegion> regionList=new ArrayList<RaSellingRegion>();
	List<RaStateMaster> stateList;
	public String loadState()
	{
		stateList=stateService.loadStates();
		if(!stateList.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String addStateInput()
	{
		List list=HibernateUtil.getSession().createCriteria(RaSellingRegion.class).list();
		regionList=list;
		return SUCCESS;
	}
	public String addState()
	{	
		if(isStateExist(stateMaster)){
			System.out.println("duplicate");
			addActionError(getText("error.duplicate.state"));
			return SUCCESS;
		}
		System.out.println(stateMaster_raSellingRegions+"***********");
		RaSellingRegion sellingRegion=new RaSellingRegion();
		sellingRegion.setRegionId(stateMaster_raSellingRegions);
		stateMaster.setRaSellingRegion(sellingRegion);
		
		stateMaster.setStateStatus("Active");
		stateService.insertStates(stateMaster);
		System.out.println(loadState()+"..........load State");
		loadState();
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	private boolean isStateExist(RaStateMaster stateMaster2) {
		// TODO Auto-generated method stub
		return stateService.isStateExist(stateMaster2);

	}
	@SuppressWarnings("unchecked")
	public String updateStateInput()
	{
		regionList=HibernateUtil.getSession().createCriteria(RaSellingRegion.class).list();
		stateMaster=stateService.loadSingleStates(stateMaster.getStateId());
		return SUCCESS;
	}
	public String updateState()
	{
		if(isStateExist(stateMaster)){
			System.out.println("Updateduplicate");
			addActionError(getText("error.duplicate.state"));
			return SUCCESS;
		}
		System.out.println(stateMaster_raSellingRegions+"***********");
		RaSellingRegion sellingRegion=new RaSellingRegion();
		sellingRegion.setRegionId(stateMaster_raSellingRegions);
		stateMaster.setRaSellingRegion(sellingRegion);
		stateMaster.setStateStatus("Active");
		stateService.updateStates(stateMaster);
		loadState();
		setNavigationFlg("success");
		return SUCCESS;
	}
	public String deActiveState()
	{
		System.out.println("Deactive StateId :: ");
		stateService.deActiveStates(stateMaster.getStateId());
		loadState();
		return SUCCESS;
	}
	/*  ****************************  */
	public List<RaStateMaster> getStateList() {
		return stateList;
	}
	public void setStateList(List<RaStateMaster> stateList) {
		this.stateList = stateList;
	}
	public RaStateMaster getStateMaster() {
		return stateMaster;
	}
	public void setStateMaster(RaStateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}
	public StateServiceImpl getStateService() {
		return stateService;
	}
	public void setStateService(StateServiceImpl stateService) {
		this.stateService = stateService;
	}
	public StateModel getStateModel() {
		return stateModel;
	}
	public void setStateModel(StateModel stateModel) {
		this.stateModel = stateModel;
	}
	public List<RaSellingRegion> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<RaSellingRegion> regionList) {
		this.regionList = regionList;
	}
	public RaSellingRegion getRaSellingRegion() {
		return raSellingRegion;
	}
	public void setRaSellingRegion(RaSellingRegion raSellingRegion) {
		this.raSellingRegion = raSellingRegion;
	}
	public Integer getStateMaster_raSellingRegions() {
		return stateMaster_raSellingRegions;
	}
	public void setStateMaster_raSellingRegions(Integer stateMaster_raSellingRegions) {
		this.stateMaster_raSellingRegions = stateMaster_raSellingRegions;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
}
