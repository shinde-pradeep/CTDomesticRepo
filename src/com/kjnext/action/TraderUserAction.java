package com.kjnext.action;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.kjnext.service.TraderUserServiceImpl;
import com.kjnext.utility.hibernate.HibernateUtil;

public class TraderUserAction extends BaseAction {
	TraderUserServiceImpl traderUserServiceImpl = new TraderUserServiceImpl();
	List<RaCompanyMaster> listCompany;
	List<RaStateMaster> listState;
	List<RaProducerMaster> listProducer;
	List<RaUserMaster> traderList;
	RaUserMaster raUserMaster;
	RaStateMaster raStateMaster;
	RaCompanyMaster raCompanyMaster;
	RaProducerMaster raProducerMaster;
	Integer producerTraderId;
	Integer companyTraderId; //name of list on jsp page...
	String stateTraderName;
	String userType;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String loadTrader() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		
		traderList = traderUserServiceImpl.loadTraders(userTo);
		if (!traderList.isEmpty())

			return SUCCESS;

		return INPUT;
	}
	public String addTraderInput()
	{
		List list=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		listState=list;
		listProducer=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listCompany=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		return SUCCESS;
	}
	public void loadLists()
	{
		listState=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		listProducer=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listCompany=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
	}
	private boolean isUserExist(RaUserMaster raUserMaster2) {
		// TODO Auto-generated method stub
		return traderUserServiceImpl.isUserExist(raUserMaster2);

	}
	@SuppressWarnings("unchecked")
	public String addTrader()
	{
		if(isUserExist(raUserMaster)){
			System.out.println("duplicate");
			addActionError(getText("error.duplicate.User"));
			return SUCCESS;
		}     
		RaProducerMaster producerMaster=new RaProducerMaster();
		RaStateMaster stateMaster=new RaStateMaster();
		RaCompanyMaster companyMaster=new  RaCompanyMaster();
		producerMaster.setProductId(producerTraderId);
		companyMaster.setCompanyId(companyTraderId);
		stateMaster.setStateType(stateTraderName);
		System.out.println(stateTraderName+".......stateTraderName...");
		raUserMaster.setProducerId(producerMaster.getProducerId());
		raUserMaster.setRaCompanyMaster(companyMaster);
		raUserMaster.setState(stateMaster.getStateType());
		System.out.println(stateMaster.getStateType()+"........stateMaster.getStateType()......");
		 raUserMaster.setCreateDate(new java.util.Date());
		 //raUserMaster.setUserType(userType);
		 //System.out.println(userType+".....userType...");
		 raUserMaster.setUserStatus("A");
		 traderUserServiceImpl.insertTraderUser(raUserMaster);
		 loadTrader();
		 loadLists();
		 setNavigationFlg("success");
		 return SUCCESS;
	}
	public String updateTraderInput()
	{
		listState=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		listProducer=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listCompany=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		raUserMaster=traderUserServiceImpl.loadSingleUser(raUserMaster.getUserId());
		return SUCCESS;
		
	}
	public String setPriamryUser()
	{
		traderUserServiceImpl.setUser(raUserMaster.getUserId());
		loadTrader();
		
		return SUCCESS;
	}
	public String updateTrader()
	{
		if(isUserExist(raUserMaster)){
			System.out.println("Updateduplicate");
			addActionError(getText("error.duplicate.User"));
			return SUCCESS;
		}
		RaProducerMaster producerMaster=new RaProducerMaster();
		RaStateMaster stateMaster=new RaStateMaster();
		RaCompanyMaster companyMaster=new  RaCompanyMaster();
		producerMaster.setProductId(producerTraderId);
		companyMaster.setCompanyId(companyTraderId);
		raUserMaster.setProducerId(producerMaster.getProducerId());
		raUserMaster.setRaCompanyMaster(companyMaster);
		raUserMaster.setState(stateMaster.getStateType());
		raUserMaster.setModifyDate(new java.util.Date());
		raUserMaster.setUserStatus("A");
		traderUserServiceImpl.updatetraderUser(raUserMaster);
		loadTrader();
		loadLists();
		setNavigationFlg("success");
		return SUCCESS;
	}
	public String deActiveTrader()
	{
		traderUserServiceImpl.deActiveTraders(raUserMaster.getUserId());
		loadTrader();
		 loadLists();
		setNavigationFlg("success");
		return SUCCESS;
	}
	/*************************/
	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}
	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}
	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}
	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}
	public List<RaUserMaster> getTraderList() {
		return traderList;
	}
	public void setTraderList(List<RaUserMaster> traderList) {
		this.traderList = traderList;
	}
	
	
	public List<RaCompanyMaster> getListCompany() {
		return listCompany;
	}
	public void setListCompany(List<RaCompanyMaster> listCompany) {
		this.listCompany = listCompany;
	}
	public List<RaStateMaster> getListState() {
		return listState;
	}
	public void setListState(List<RaStateMaster> listState) {
		this.listState = listState;
	}
	public RaStateMaster getRaStateMaster() {
		return raStateMaster;
	}
	public void setRaStateMaster(RaStateMaster raStateMaster) {
		this.raStateMaster = raStateMaster;
	}
	
	public Integer getProducerTraderId() {
		return producerTraderId;
	}
	public void setProducerTraderId(Integer producerTraderId) {
		this.producerTraderId = producerTraderId;
	}
	public RaProducerMaster getRaProducerMaster() {
		return raProducerMaster;
	}
	public void setRaProducerMaster(RaProducerMaster raProducerMaster) {
		this.raProducerMaster = raProducerMaster;
	}
	public Integer getCompanyTraderId() {
		return companyTraderId;
	}
	public void setCompanyTraderId(Integer companyTraderId) {
		this.companyTraderId = companyTraderId;
	}
	public List<RaProducerMaster> getListProducer() {
		return listProducer;
	}
	public void setListProducer(List<RaProducerMaster> listProducer) {
		this.listProducer = listProducer;
	}
	public String getStateTraderName() {
		return stateTraderName;
	}
	public void setStateTraderName(String stateTraderName) {
		this.stateTraderName = stateTraderName;
	}
	
	
}
