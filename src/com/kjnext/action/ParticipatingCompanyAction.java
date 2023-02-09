package com.kjnext.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyOutlet;
import com.kjnext.hibernate.RaCompanyOutletId;
import com.kjnext.hibernate.RaOutletMaster;
import com.kjnext.model.ParticiatingComany;
import com.kjnext.service.ParticipatingCompanyServiceImpl;

public class ParticipatingCompanyAction extends BaseAction {
	List<ParticiatingComany> listCompany;

	RaCompanyMaster raCompanyMaster;

	RaOutletMaster raOutletMaster;

	RaCompanyOutlet raCompanyOutlets;

	RaCompanyOutletId raCompanyOutletId;
	
	static HashMap<String, List<ParticiatingComany>> hashCompany=new HashMap<String, List<ParticiatingComany>>();

	ParticipatingCompanyServiceImpl participatingCompanyServiceImpl = new ParticipatingCompanyServiceImpl();

	public String loadCompany() {
		//if(hashCompany.containsKey("listCountry")){
			//listCompany =(List<ParticiatingComany>)hashCompany.get("listCountry");
	//	}else{
			listCompany = participatingCompanyServiceImpl.getCompanyList();
	//		hashCompany.put("listCountry", listCompany);
	//	}
	/*	if (!listCompany.isEmpty()) {
			return SUCCESS;
		}else{
			
		}*/

		return SUCCESS;
	}
	public String loadCompanyReport() {
		//if(hashCompany.containsKey("listCountry")){
			//listCompany =(List<ParticiatingComany>)hashCompany.get("listCountry");
	//	}else{
			listCompany = participatingCompanyServiceImpl.loadCompanyReport();
	//		hashCompany.put("listCountry", listCompany);
	//	}
	/*	if (!listCompany.isEmpty()) {
			return SUCCESS;
		}else{
			
		}*/

		return SUCCESS;
	}
	
	public String addCompanyInput()
	{
		return SUCCESS;
	}
	public String addCompany()
	{
		
		java.util.Date date1 = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        raCompanyMaster.setCreateDate(sqlDate);
		raCompanyMaster.setCompanyStatus("A");
		participatingCompanyServiceImpl.insertRecords(raCompanyMaster);
		participatingCompanyServiceImpl.insertOutlets(raOutletMaster);
		loadCompany();
		setNavigationFlg("success");
		return SUCCESS;
	}
	public String updateCompanyInput()
	{
		raCompanyMaster=participatingCompanyServiceImpl.loadSinglecompany(raCompanyMaster.getCompanyId());
		return SUCCESS;
	}
	public String updateCompany()
	{
		java.util.Date date1 = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        raCompanyMaster.setModifyDate(sqlDate);
		raCompanyMaster.setCompanyStatus("A");
		participatingCompanyServiceImpl.updateRecords(raCompanyMaster);
		//participatingCompanyServiceImpl.
		loadCompany();
		setNavigationFlg("success");
		return SUCCESS;
	}
	public String deActiveCompany()
	{
		participatingCompanyServiceImpl.deActiveRecords(raCompanyMaster.getCompanyId());
		loadCompany();
		return SUCCESS;
	}
	public String ActiveCompany()
	{
		participatingCompanyServiceImpl.ActiveRecords(raCompanyMaster.getCompanyId());
		loadCompany();
		return SUCCESS;
	}

	/************************************************/
	public List<ParticiatingComany> getListCompany() {
		return listCompany;
	}

	public void setListCompany(List<ParticiatingComany> listCompany) {
		this.listCompany = listCompany;
	}

	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}

	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

}
