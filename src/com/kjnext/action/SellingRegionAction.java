package com.kjnext.action;

import java.util.List;
import java.util.Map;

import com.kjnext.hibernate.RaSellingRegion;
import com.kjnext.model.Product;
import com.kjnext.model.SellingRegionModel;
import com.kjnext.service.SellingRegionServiceImpl;

public class SellingRegionAction extends BaseAction {
	Map<String, String> mapMenu = null;

	List<RaSellingRegion> listRegion = null;

	SellingRegionServiceImpl regionService = new SellingRegionServiceImpl();
	SellingRegionModel regionModel=new SellingRegionModel();
	RaSellingRegion sellingRegion;
	
	/*******************DB Operation ****************************/
	public String getRegion() {
		listRegion = regionService.selectRecord();
		//return SUCCESS;
		if(!listRegion.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String addRegionInput()
	{
		return SUCCESS;
	}
	public String addRegion()
	{
		if(isRegionExist(sellingRegion)){
			addActionError(getText("error.duplicate.region"));
			return SUCCESS;
		}
		System.out.println("insert data...............");
		sellingRegion.setStatus("Active");
		regionService.insertRecords(sellingRegion);
		
		getRegion(); 
		setNavigationFlg("success");
		return SUCCESS;
	}
	private boolean isRegionExist(RaSellingRegion sellingRegion2) {
		// TODO Auto-generated method stub
		//return false;
		return regionService.isRegionExist(sellingRegion2);
	}
	public String updateRegionInput()
	{
		System.out.println("update .........region"+sellingRegion.getRegionId());
		sellingRegion=regionService.loadSingleRegion(sellingRegion.getRegionId());
		return SUCCESS;
	}
	public String updateRegion()
	{
		if(isRegionExist(sellingRegion)){
			addActionError(getText("error.duplicate.region"));
			return SUCCESS;
		}
		sellingRegion.setStatus("Active");
		regionService.updateRegion(sellingRegion);
		getRegion();
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	public String deActiveRegion()
	{
		System.out.println("Deactive regionId :: ");
		regionService.deActiveRegions(sellingRegion.getRegionId());
		getRegion();
		return SUCCESS;
	}
	
	/** ***************************** */
	public SellingRegionServiceImpl getRegionService() {
		return regionService;
	}

	public void setRegionService(SellingRegionServiceImpl regionService) {
		this.regionService = regionService;
	}

	public RaSellingRegion getSellingRegion() {
		return sellingRegion;
	}

	public void setSellingRegion(RaSellingRegion sellingRegion) {
		this.sellingRegion = sellingRegion;
	}

	public List<RaSellingRegion> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<RaSellingRegion> listRegion) {
		this.listRegion = listRegion;
	}

	public Map<String, String> getMapMenu() {
		return mapMenu;
	}

	public void setMapMenu(Map<String, String> mapMenu) {
		this.mapMenu = mapMenu;
	}

	public SellingRegionModel getRegionModel() {
		return regionModel;
	}

	public void setRegionModel(SellingRegionModel regionModel) {
		this.regionModel = regionModel;
	}
}
