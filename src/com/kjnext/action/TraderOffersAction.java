package com.kjnext.action;

import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import ognl.ListPropertyAccessor;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaFarmMaster;
import com.kjnext.hibernate.RaGradeMaster;
import com.kjnext.hibernate.RaLoadPort;
import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaTraceOffers;
import com.kjnext.model.TraderOfferModel;
import com.kjnext.model.UserTo;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.service.TraderOfferServiceImpl;
import com.kjnext.utility.hibernate.HibernateUtil;
public class TraderOffersAction extends BaseAction {
	TraderOfferServiceImpl offerServiceImpl = new TraderOfferServiceImpl();
	/***************/
	TraderOfferModel traderOfferModel;
     RaGradeMaster raGradeMaster;
    RaOriginMaster raOriginMaster;
     RaDestinationPort raDestinationPort;
    RaCompanyMaster raCompanyMaster;
    RaTraceOffers raTraceOffers;
    RaStateMaster raStateMaster;
    RaFarmMaster raFarmMaster;
    RaProducerMaster raProducerMaster;
    RaProductMaster raProductMaster;
    
	/******************/
	Integer companyTraderId;
	Integer stateTraderOffer;
	Integer OriginOfferId;
	Integer destPortOfferId;
	Integer gradeOfferId;
	Integer loadPortNameId;
	Integer farmId;
	Integer productTraderId;
	Integer productId;
	String product;
	
	List<RaStateMaster> listStates;
	List<RaTraceOffers> listOffer;
	List<RaOriginMaster> listOrigin;
	List<RaGradeMaster> listGrade;
	List<RaDestinationPort> listDestPort;
	List<RaCompanyMaster> listCompany;
	List<RaLoadPort> listLoadPort;
	List<RaFarmMaster> listFarm;
	List<RaProducerMaster> listProduct;
	List<RaProductMaster> listProduct1;
	public List<RaProducerMaster> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<RaProducerMaster> listProduct) {
		this.listProduct = listProduct;
	}
	public Integer getProductTraderId() {
		return productTraderId;
	}
	public void setProductTraderId(Integer productTraderId) {
		this.productTraderId = productTraderId;
	}
	public RaProducerMaster getRaProducerMaster() {
		return raProducerMaster;
	}
	public void setRaProducerMaster(RaProducerMaster raProducerMaster) {
		this.raProducerMaster = raProducerMaster;
	}
	public Integer getStateTraderOffer() {
		return stateTraderOffer;
	}
	public void setStateTraderOffer(Integer stateTraderOffer) {
		this.stateTraderOffer = stateTraderOffer;
	}
	/*  load data of ratraderOffer */
	public String loadOffers() {
	
		
		listOffer = offerServiceImpl.loadOffers();
		if (!listOffer.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	/*   */
	public String addOfferInput()
	{
		List list1=HibernateUtil.getSession().createCriteria(RaOriginMaster.class).list();
		listOrigin=list1;
		List list2=HibernateUtil.getSession().createCriteria(RaGradeMaster.class).list();
		listGrade=list2;
		List listPort=HibernateUtil.getSession().createCriteria(RaDestinationPort.class).list();
		listDestPort=listPort;
		List list4=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		listCompany=list4;
		List list5=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		listStates=list5;
		listFarm=HibernateUtil.getSession().createCriteria(RaFarmMaster.class).list();
		listLoadPort=HibernateUtil.getSession().createCriteria(RaLoadPort.class).list();
		listProduct=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listProduct1=HibernateUtil.getSession().createCriteria(RaProductMaster.class).list();
		return SUCCESS;
	}
	public void loadLists()
	{
		listOrigin=HibernateUtil.getSession().createCriteria(RaOriginMaster.class).list();
		listGrade=HibernateUtil.getSession().createCriteria(RaGradeMaster.class).list();
		listDestPort=HibernateUtil.getSession().createCriteria(RaDestinationPort.class).list();
		listCompany=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		listStates=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		listFarm=HibernateUtil.getSession().createCriteria(RaFarmMaster.class).list();
		listLoadPort=HibernateUtil.getSession().createCriteria(RaLoadPort.class).list();
		listProduct=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listProduct1=HibernateUtil.getSession().createCriteria(RaProductMaster.class).list();
	}
	public String addOffers()
	{		
		UserTo userTo=(UserTo) session.get("UserInfo");
        RaStateMaster stateMaster=new RaStateMaster();
        RaOriginMaster originMaster=new RaOriginMaster();
        RaGradeMaster gradeMaster=new RaGradeMaster();
        RaDestinationPort destinationPort=new RaDestinationPort();
        RaCompanyMaster companyMaster=new RaCompanyMaster();
        RaFarmMaster farmMaster=new RaFarmMaster();
        RaLoadPort loadPort=new RaLoadPort();
        RaProducerMaster producerMaster=new RaProducerMaster();
        RaProductMaster productMaster=new RaProductMaster();
       /********/
        raTraceOffers.setUserId(userTo.getUserId());
	     companyMaster.setCompanyId(companyTraderId);
	     raTraceOffers.setRaCompanyMaster(companyMaster);
	     
	     stateMaster.setStateId(stateTraderOffer);
	     raTraceOffers.setCountryId(stateMaster.getStateId());
	     
	     originMaster.setOriginId(OriginOfferId);
	     raTraceOffers.setRaOriginMaster(originMaster);
	     
	     destinationPort.setDestPortId(destPortOfferId);
	     raTraceOffers.setRaDestinationPort(destinationPort);
	     
	     gradeMaster.setGradeId(gradeOfferId);
	     raTraceOffers.setRaGradeMaster(gradeMaster);
	     
	     loadPort.setLoadId(loadPortNameId);
	     raTraceOffers.setLoadId(loadPort.getLoadId());
	     farmMaster.setFarmId(farmId);
	     raTraceOffers.setFarmId(farmMaster.getFarmId());
	     productMaster.setProductId(productId);
	     raTraceOffers.setProductId(productMaster.getProductId());
	     raTraceOffers.setOfferDate(new java.util.Date());
	     raTraceOffers.setAvailabilityDate(new java.util.Date());
	     offerServiceImpl.insertOffers(raTraceOffers);
	     //raTraceOffers.setexp
	     loadOffers();
	     loadLists();
	     setNavigationFlg("success");
        return SUCCESS;
	}
	public String updateOfferInput()
	{
		raTraceOffers=offerServiceImpl.loadSingleTraderOffer(raTraceOffers.getOfferId());
		 loadLists();
		return SUCCESS;
	}
	public String updateOffer()
	{
		UserTo userTo=(UserTo) session.get("UserInfo");
        RaStateMaster stateMaster=new RaStateMaster();
        RaOriginMaster originMaster=new RaOriginMaster();
        RaGradeMaster gradeMaster=new RaGradeMaster();
        RaDestinationPort destinationPort=new RaDestinationPort();
        RaCompanyMaster companyMaster=new RaCompanyMaster();
        RaFarmMaster farmMaster=new RaFarmMaster();
        RaLoadPort loadPort=new RaLoadPort();
        RaProducerMaster producerMaster=new RaProducerMaster();
        RaProductMaster productMaster=new RaProductMaster();
        /********/
        raTraceOffers.setUserId(userTo.getUserId());
	     companyMaster.setCompanyId(companyTraderId);
	     raTraceOffers.setRaCompanyMaster(companyMaster);
	     
	     stateMaster.setStateId(stateTraderOffer);
	     raTraceOffers.setCountryId(stateMaster.getStateId());
	     
	     originMaster.setOriginId(OriginOfferId);
	     raTraceOffers.setRaOriginMaster(originMaster);
	     
	     destinationPort.setDestPortId(destPortOfferId);
	     raTraceOffers.setRaDestinationPort(destinationPort);
	     
	     gradeMaster.setGradeId(gradeOfferId);
	     raTraceOffers.setRaGradeMaster(gradeMaster);
	     
	     loadPort.setLoadId(loadPortNameId);
	     raTraceOffers.setLoadId(loadPort.getLoadId());
	     farmMaster.setFarmId(farmId);
	     raTraceOffers.setFarmId(farmMaster.getFarmId());
	     productMaster.setProductId(productId);
	     raTraceOffers.setProductId(productMaster.getProductId());
	     raTraceOffers.setOfferDate(new java.util.Date());
	     raTraceOffers.setAvailabilityDate(new java.util.Date());
	     offerServiceImpl.updateOffers(raTraceOffers);
	     
	     loadOffers();
	     loadLists();
	     setNavigationFlg("success");
		return SUCCESS;
	}
	/**************************/
	public List<RaTraceOffers> getListOffer() {
		return listOffer;
	}
	public void setListOffer(List<RaTraceOffers> listOffer) {
		this.listOffer = listOffer;
	}
	public RaTraceOffers getRaTraceOffers() {
		return raTraceOffers;
	}
	public void setRaTraceOffers(RaTraceOffers raTraceOffers) {
		this.raTraceOffers = raTraceOffers;
	}
	public List<RaCompanyMaster> getListCompany() {
		return listCompany;
	}
	public void setListCompany(List<RaCompanyMaster> listCompany) {
		this.listCompany = listCompany;
	}
	public List<RaDestinationPort> getListDestPort() {
		return listDestPort;
	}
	public void setListDestPort(List<RaDestinationPort> listDestPort) {
		this.listDestPort = listDestPort;
	}
	public List<RaGradeMaster> getListGrade() {
		return listGrade;
	}
	public void setListGrade(List<RaGradeMaster> listGrade) {
		this.listGrade = listGrade;
	}
	public List<RaOriginMaster> getListOrigin() {
		return listOrigin;
	}
	public void setListOrigin(List<RaOriginMaster> listOrigin) {
		this.listOrigin = listOrigin;
	}
	
	public Integer getCompanyTraderId() {
		return companyTraderId;
	}
	public void setCompanyTraderId(Integer companyTraderId) {
		this.companyTraderId = companyTraderId;
	}
	public Integer getFarmId() {
		return farmId;
	}
	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
	}
	public Integer getGradeOfferId() {
		return gradeOfferId;
	}
	public void setGradeOfferId(Integer gradeOfferId) {
		this.gradeOfferId = gradeOfferId;
	}
	public List<RaFarmMaster> getListFarm() {
		return listFarm;
	}
	public void setListFarm(List<RaFarmMaster> listFarm) {
		this.listFarm = listFarm;
	}
	public List<RaLoadPort> getListLoadPort() {
		return listLoadPort;
	}
	public void setListLoadPort(List<RaLoadPort> listLoadPort) {
		this.listLoadPort = listLoadPort;
	}
	public Integer getLoadPortNameId() {
		return loadPortNameId;
	}
	public void setLoadPortNameId(Integer loadPortNameId) {
		this.loadPortNameId = loadPortNameId;
	}
	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}
	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}
	public RaDestinationPort getRaDestinationPort() {
		return raDestinationPort;
	}
	public void setRaDestinationPort(RaDestinationPort raDestinationPort) {
		this.raDestinationPort = raDestinationPort;
	}
	public RaFarmMaster getRaFarmMaster() {
		return raFarmMaster;
	}
	public void setRaFarmMaster(RaFarmMaster raFarmMaster) {
		this.raFarmMaster = raFarmMaster;
	}
	public RaGradeMaster getRaGradeMaster() {
		return raGradeMaster;
	}
	public void setRaGradeMaster(RaGradeMaster raGradeMaster) {
		this.raGradeMaster = raGradeMaster;
	}
	public RaOriginMaster getRaOriginMaster() {
		return raOriginMaster;
	}
	public void setRaOriginMaster(RaOriginMaster raOriginMaster) {
		this.raOriginMaster = raOriginMaster;
	}
	public RaStateMaster getRaStateMaster() {
		return raStateMaster;
	}
	public void setRaStateMaster(RaStateMaster raStateMaster) {
		this.raStateMaster = raStateMaster;
	}
	
	public Integer getDestPortOfferId() {
		return destPortOfferId;
	}
	public void setDestPortOfferId(Integer destPortOfferId) {
		this.destPortOfferId = destPortOfferId;
	}
	public List<RaStateMaster> getListStates() {
		return listStates;
	}
	public void setListStates(List<RaStateMaster> listStates) {
		this.listStates = listStates;
	}
	public Integer getOriginOfferId() {
		return OriginOfferId;
	}
	public void setOriginOfferId(Integer originOfferId) {
		OriginOfferId = originOfferId;
	}
	
	public TraderOfferModel getTraderOfferModel() {
		return traderOfferModel;
	}
	public void setTraderOfferModel(TraderOfferModel traderOfferModel) {
		this.traderOfferModel = traderOfferModel;
	}
	public TraderOfferServiceImpl getOfferServiceImpl() {
		return offerServiceImpl;
	}
	public void setOfferServiceImpl(TraderOfferServiceImpl offerServiceImpl) {
		this.offerServiceImpl = offerServiceImpl;
	}
	public RaProductMaster getRaProductMaster() {
		return raProductMaster;
	}
	public void setRaProductMaster(RaProductMaster raProductMaster) {
		this.raProductMaster = raProductMaster;
	}
	public List<RaProductMaster> getListProduct1() {
		return listProduct1;
	}
	public void setListProduct1(List<RaProductMaster> listProduct1) {
		this.listProduct1 = listProduct1;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
}
