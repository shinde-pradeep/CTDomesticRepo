package com.kjnext.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaProducerMaster;
//import com.kjnext.hibernate.RaUserMaster;
//import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.Product;
import com.kjnext.model.UserTo;
//import com.kjnext.service.AllUserServiceImpl;
import com.kjnext.service.ParticipatingProducerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import com.kjnext.hibernate.RaTraceability;  
public class ParticipatingProducerAction  extends BaseAction{

	
	private static final long serialVersionUID = 1L;

	Map<String, String> mapMenu = null;

	List<RaProducerMaster> listProducer = null;

	ParticipatingProducerServiceImpl allproducerServiceImpl = new ParticipatingProducerServiceImpl();
	//System.out.println(alluserServiceImpl);
	RaProducerMaster raProducerMaster;
	String navigationFlg;
	RaTraceability raTraceability;
	List<RaTraceability> listTransaction = null;
	
	public String loadProducer() {
		return SUCCESS;
	}
	public Map<String, String> getMapMenu() {
		return mapMenu;
	}

	public void setMapMenu(Map<String, String> mapMenu) {
		this.mapMenu = mapMenu;
	}

	public String loadProducers() {
		listProducer = allproducerServiceImpl .getProducerList();
		if (!listProducer.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	public String getProducerUser() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		
		listProducer = allproducerServiceImpl .getProducerUser(userTo);
		if (!listProducer.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	public String ProducersReport() {
		listProducer = allproducerServiceImpl .loadProducersReport();
		if (!listProducer.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	public String ProducersTransaction() {
		
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTransaction = allproducerServiceImpl.ProducersTransaction(userTo);
		if (!listTransaction.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	
	
	public List<RaProducerMaster> getListProducer() {
		return listProducer;
	}
	public void setListProducer(List<RaProducerMaster> listProducer) {
		this.listProducer = listProducer;
	}
	public String getNavigationFlg() {
		return navigationFlg;
	}
	public void setNavigationFlg(String navigationFlg) {
		this.navigationFlg = navigationFlg;
	}
	public RaProducerMaster getRaProducerMaster() {
		return raProducerMaster;
	}
	public void setRaProducerMaster(
			RaProducerMaster raProducerMaster) {
		this.raProducerMaster= raProducerMaster;
	}
	public String deActiveProducer()
	{
		allproducerServiceImpl.deActiveRecords(raProducerMaster.getProducerId());
		loadProducers();
		return SUCCESS;
	}
	public String ActiveProducer()
	{
		allproducerServiceImpl.ActiveRecords(raProducerMaster.getProducerId());
		loadProducers();
		return SUCCESS;
	}
	public RaTraceability getRaTraceability() {
		return raTraceability;
	}
	public void setRaTraceability(RaTraceability raTraceability) {
		this.raTraceability = raTraceability;
	}
	public List<RaTraceability> getListTransaction() {
		return listTransaction;
	}
	public void setListTransaction(List<RaTraceability> listTransaction) {
		this.listTransaction = listTransaction;
	}


	
	
	
	
	
}
