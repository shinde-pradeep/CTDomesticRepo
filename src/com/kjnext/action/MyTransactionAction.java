package com.kjnext.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaDeliveryMonth;
import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaLoadPort;
import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.hibernate.RaPriceBasis;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaTracCropYear;
import com.kjnext.hibernate.RaTraceability;
import com.kjnext.hibernate.RaUnitMeasures;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.MyTransaction;
import com.kjnext.model.UserTo;
import com.kjnext.service.MyTransactionServiceImpl;
import com.kjnext.utility.hibernate.HibernateUtil;

public class MyTransactionAction extends BaseAction {
	MyTransactionServiceImpl transactionService = new MyTransactionServiceImpl();

	MyTransaction myTransaction;

	RaTraceability raTraceability;

	List<RaTraceability> listTraceability;

	List<RaOriginMaster> listOrigin;

	List<RaTracCropYear> listCropYear;

	List<RaPriceBasis> listPriceBasis;

	List<RaStateMaster> listState;

	List<RaLoadPort> listLoadport;

	List<RaDestinationPort> listDestPort;

	List<RaDeliveryMonth> listDeliveryMonth;
    List <RaUserMaster> listuser;
	List<RaCompanyMaster> listCompanymaster;
	List<RaProducerMaster> listProducerMaster;
	
	/** ********Foreign key class****** */
	RaOriginMaster raOriginMaster;

	RaTracCropYear raTracCropYear;

	RaPriceBasis raPriceBasis;

	RaDeliveryMonth raDeliveryMonth;

	RaStateMaster raStateMaster;

	RaLoadPort raLoadPort;

	RaDestinationPort raDestinationPort;
	RaUserMaster raUserMaster;
	RaCompanyMaster raCompanyMaster;
	RaProducerMaster raProducerMaster;
	
	// UserTo userTo;

	/** ***********List value*************** */
	private Integer priceNameId;

	private Integer stateNameId;

	private Integer loadPortNameId;

	private Integer destPortNameId;

	private Integer raCompanyMaster_CustomerId;
	private Integer raProducerMaster_ProducerId;
	private Integer originNameId;

	private Integer cropNameId;

	private Integer deliverMonthId;

	/** ************************************ */
	public String loadTraceability() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadTraceability(userTo);
		//raUserMaster=(RaUserMaster)HibernateUtil.getSession().createCriteria(RaUserMaster.class,raTraceability.getBuyerId() ).list();
	/*	HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		raUserMaster=(RaUserMaster)session.load(RaUserMaster.class,Integer.parseInt(raTraceability.getBuyerId()));
		System.out.println(raUserMaster);*/
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String loadTransactionReport() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadTransactionReport(userTo);
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	
	public String loadTraceability1() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadTraceability1(userTo);
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String loadAchivedTransaction() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadAchivedTransaction(userTo);
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String loadReport() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadReport(userTo);
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}
	public String loadAcievedTransaction() {
		UserTo userTo = (UserTo) session.get("UserInfo");
		listTraceability = transactionService.loadAcievedTransaction(userTo);
		if (!listTraceability.isEmpty())
			return SUCCESS;
		return INPUT;
	}

	public String complete()
	{
		transactionService.complete(raTraceability.getTraceId());
		loadTraceability1();
		return SUCCESS;
	}



	public String addTraceabilityInput() {
		listOrigin = HibernateUtil.getSession().createCriteria(
				RaOriginMaster.class).list();
		listCropYear = HibernateUtil.getSession().createCriteria(
				RaTracCropYear.class).list();
		listPriceBasis = HibernateUtil.getSession().createCriteria(
				RaPriceBasis.class).list();
		listState = HibernateUtil.getSession().createCriteria(
				RaStateMaster.class).list();
		listLoadport = HibernateUtil.getSession().createCriteria(
				RaLoadPort.class).list();
		listDestPort = HibernateUtil.getSession().createCriteria(
				RaDestinationPort.class).list();
		listCompanymaster = HibernateUtil.getSession().createCriteria(
				RaCompanyMaster.class).list();
		listDeliveryMonth = HibernateUtil.getSession().createCriteria(
				RaDeliveryMonth.class).list();
		listProducerMaster = HibernateUtil.getSession().createCriteria(
				RaProducerMaster.class).list();
		listuser= HibernateUtil.getSession().createCriteria(
				RaUserMaster.class).list();
		return SUCCESS;
	}

	public void loadListData() {
		listOrigin = HibernateUtil.getSession().createCriteria(
				RaOriginMaster.class).list();
		listCropYear = HibernateUtil.getSession().createCriteria(
				RaTracCropYear.class).list();
		listPriceBasis = HibernateUtil.getSession().createCriteria(
				RaPriceBasis.class).list();
		listState = HibernateUtil.getSession().createCriteria(
				RaStateMaster.class).list();
		listLoadport = HibernateUtil.getSession().createCriteria(
				RaLoadPort.class).list();
		listDestPort = HibernateUtil.getSession().createCriteria(
				RaDestinationPort.class).list();
		listCompanymaster = HibernateUtil.getSession().createCriteria(
				RaCompanyMaster.class).list();
		listDeliveryMonth = HibernateUtil.getSession().createCriteria(
				RaDeliveryMonth.class).list();
		listuser= HibernateUtil.getSession().createCriteria(
				RaUserMaster.class).list();
	}

	public String addTraceability() {

		UserTo userTo = (UserTo) session.get("UserInfo");

		RaOriginMaster originMaster = new RaOriginMaster();
		RaTracCropYear tracCropYear = new RaTracCropYear();
		RaPriceBasis priceBasis = new RaPriceBasis();
		RaDeliveryMonth deliveryMonth = new RaDeliveryMonth();
		RaStateMaster stateMaster = new RaStateMaster();
		RaLoadPort loadPort = new RaLoadPort();
		RaDestinationPort destinationPort = new RaDestinationPort();
		RaCompanyMaster companyMaster = new RaCompanyMaster();

		for (int i = 1; i < 3; i++) {

			originMaster.setOriginId(originNameId);

			stateMaster.setStateId(stateNameId);

			loadPort.setLoadId(loadPortNameId);

			destinationPort.setDestPortId(destPortNameId);

			priceBasis.setPrBasisId(priceNameId);

			deliveryMonth.setMonthId(deliverMonthId);

			tracCropYear.setCropYearId(cropNameId);

			companyMaster.setCompanyId(raCompanyMaster_CustomerId);

			raTraceability.setCustomerId(companyMaster.getCompanyId());
			raTraceability.setRaTracCropYear(tracCropYear);
			raTraceability.setRaPriceBasis(priceBasis);
			raTraceability.setRaDestinationPort(destinationPort);
			raTraceability.setRaLoadPort(loadPort);
			raTraceability.setRaStateMaster(stateMaster);
			raTraceability.setRaOriginMaster(originMaster);
			raTraceability.setRaDeliveryMonth(deliveryMonth);
			raTraceability.setUserId(userTo.getUserId());
			if (i < 2) {
				raTraceability.setOrderType("Buy");
			} else {
				raTraceability.setOrderType("Sell");
			}
			raTraceability.setTransDate(raTraceability.getTransDate());
			raTraceability.setCreateDate(new java.util.Date());
			raTraceability.setStatus("D");
			transactionService.insertRecords(raTraceability);
		}
		System.out.println(raTraceability + ".....raTraceability....");

		loadTraceability();
		loadListData();
		setNavigationFlg("success");
		return SUCCESS;
	}

	public String updateTraceabilityInput() {
		System.out.println("updateTraceabilityInput");
		loadListData();
		addTraceabilityInput();
		listTraceability = transactionService
				.loadSingleTransactions(raTraceability,raTraceability.getTransactionId());
		
		for(RaTraceability ratrac:listTraceability)
		{ 
			
			ratrac.getTransactionId();
			System.out.println(ratrac.getTransactionId()+"......ratrac.getTransactionId()..");
			System.out.println(ratrac.getTraceId()+".......traceID..");
		}
		/*Iterator itr=listTraceability.iterator();
		 while(itr.hasNext())
		  {
			RaTraceability aRaTraceability1 = (RaTraceability)itr.next();
			
			//aRaTraceability1.setBuyerId(raTraceability.getBuyerId());
			System.out.println(raTraceability.getTraceId()+"..traceID..");
			System.out.println(aRaTraceability1.getTraceId()+"..............ID..ID..");
		  }*/
		
		
		
		return SUCCESS;

	}

	public String updateTraceability() {

		UserTo userTo = (UserTo) session.get("UserInfo");
		System.out.println(userTo.getUserType() + "......userTo.....");
		System.out.println("...addTraceability()..");
		RaOriginMaster originMaster = new RaOriginMaster();
		RaTracCropYear tracCropYear = new RaTracCropYear();
		RaPriceBasis priceBasis = new RaPriceBasis();
		RaDeliveryMonth deliveryMonth = new RaDeliveryMonth();
		RaStateMaster stateMaster = new RaStateMaster();
		RaLoadPort loadPort = new RaLoadPort();
		RaDestinationPort destinationPort = new RaDestinationPort();
		RaCompanyMaster companyMaster = new RaCompanyMaster();
		
		/***************************/
		listTraceability = transactionService.loadSingleTransactions(raTraceability,raTraceability.getTransactionId());
			raTraceability.getTransactionId();
			//int tID[]=new int[2];
			//int k=1;
			for(RaTraceability ratrac:listTraceability)
			{ 
				//tID[k]=ratrac.getTraceId();
				//k++;
				ratrac.getTransactionId();
				System.out.println(ratrac.getTransactionId()+"......ratrac.getTransactionId()..");
				System.out.println(ratrac.getTraceId()+".......traceID..");
			}
			System.out.println(raTraceability.getTransactionId()+"......raTraceability.getTransactionId()...");
			System.out.println(raTraceability.getTraceId()+".....raTraceability.getTraceId()........");
			int i=1;
			for(RaTraceability ratrac:listTraceability)
			{
				raTraceability.setTransactionId(ratrac.getTransactionId());
				System.out.println(ratrac.getTransactionId()+"......update()..");
				/*****************/
				originMaster.setOriginId(originNameId);

				stateMaster.setStateId(stateNameId);

				loadPort.setLoadId(loadPortNameId);

				destinationPort.setDestPortId(destPortNameId);

				priceBasis.setPrBasisId(priceNameId);

				deliveryMonth.setMonthId(deliverMonthId);

				tracCropYear.setCropYearId(cropNameId);

				companyMaster.setCompanyId(raCompanyMaster_CustomerId);

				raTraceability.setCustomerId(companyMaster.getCompanyId());
				raTraceability.setRaTracCropYear(tracCropYear);
				raTraceability.setRaPriceBasis(priceBasis);
				raTraceability.setRaDestinationPort(destinationPort);
				raTraceability.setRaLoadPort(loadPort);
				raTraceability.setRaStateMaster(stateMaster);
				raTraceability.setRaOriginMaster(originMaster);
				raTraceability.setRaDeliveryMonth(deliveryMonth);
				raTraceability.setUserId(userTo.getUserId());
				if (i < 2) {
					raTraceability.setOrderType("Buy");
					++i;
				} else {
					raTraceability.setOrderType("Sell");
				}
				raTraceability.setCreateDate(new java.util.Date());
				raTraceability.setStatus("Active");

				raTraceability.setPrevStatus("Active");
				transactionService.updateTransactions(raTraceability);
			}
		
		for (int j = 0; j < 2; j++) {
			/*originMaster.setOriginId(originNameId);

			stateMaster.setStateId(stateNameId);

			loadPort.setLoadId(loadPortNameId);

			destinationPort.setDestPortId(destPortNameId);

			priceBasis.setPrBasisId(priceNameId);

			deliveryMonth.setMonthId(deliverMonthId);

			tracCropYear.setCropYearId(cropNameId);

			companyMaster.setCompanyId(raCompanyMaster_CustomerId);

			raTraceability.setCustomerId(companyMaster.getCompanyId());
			raTraceability.setRaTracCropYear(tracCropYear);
			raTraceability.setRaPriceBasis(priceBasis);
			raTraceability.setRaDestinationPort(destinationPort);
			raTraceability.setRaLoadPort(loadPort);
			raTraceability.setRaStateMaster(stateMaster);
			raTraceability.setRaOriginMaster(originMaster);
			raTraceability.setRaDeliveryMonth(deliveryMonth);
			raTraceability.setUserId(userTo.getUserId());
			if (i < 1) {
				raTraceability.setOrderType("Buy");
			} else {
				raTraceability.setOrderType("Sell");
			}
			raTraceability.setCreateDate(new java.util.Date());
			raTraceability.setStatus("Active");

			raTraceability.setPrevStatus("Active");
			transactionService.updateTransactions(raTraceability);*/
		}
		loadTraceability();
		loadListData();
		
		setNavigationFlg("success");
		return SUCCESS;
	}

	public String deActiveTransaction() {
		transactionService.deActiveTransactions(raTraceability
				.getTransactionId());
		loadListData();
		loadTraceability();
		return SUCCESS;
	}

	public List<RaTracCropYear> getListCropYear() {
		return listCropYear;
	}

	public void setListCropYear(List<RaTracCropYear> listCropYear) {
		this.listCropYear = listCropYear;
	}

	public List<RaDestinationPort> getListDestPort() {
		return listDestPort;
	}

	public void setListDestPort(List<RaDestinationPort> listDestPort) {
		this.listDestPort = listDestPort;
	}

	public List<RaLoadPort> getListLoadport() {
		return listLoadport;
	}

	public void setListLoadport(List<RaLoadPort> listLoadport) {
		this.listLoadport = listLoadport;
	}

	public List<RaOriginMaster> getListOrigin() {
		return listOrigin;
	}

	public void setListOrigin(List<RaOriginMaster> listOrigin) {
		this.listOrigin = listOrigin;
	}

	public List<RaPriceBasis> getListPriceBasis() {
		return listPriceBasis;
	}

	public void setListPriceBasis(List<RaPriceBasis> listPriceBasis) {
		this.listPriceBasis = listPriceBasis;
	}

	public List<RaStateMaster> getListState() {
		return listState;
	}

	public void setListState(List<RaStateMaster> listState) {
		this.listState = listState;
	}

	public List<RaTraceability> getListTraceability() {
		return listTraceability;
	}

	public void setListTraceability(List<RaTraceability> listTraceability) {
		this.listTraceability = listTraceability;
	}

	public List<RaCompanyMaster> getListCompanymaster() {
		return listCompanymaster;
	}

	public void setListCompanymaster(List<RaCompanyMaster> listCompanymaster) {
		this.listCompanymaster = listCompanymaster;
	}

	public MyTransaction getMyTransaction() {
		return myTransaction;
	}

	public void setMyTransaction(MyTransaction myTransaction) {
		this.myTransaction = myTransaction;
	}

	public void setRaTraceability(RaTraceability raTraceability) {
		this.raTraceability = raTraceability;
	}

	public RaTraceability getRaTraceability() {
		return raTraceability;
	}

	/** ************************** */
	public Integer getCropNameId() {
		return cropNameId;
	}

	public void setCropNameId(Integer cropNameId) {
		this.cropNameId = cropNameId;
	}

	public Integer getDestPortNameId() {
		return destPortNameId;
	}

	public void setDestPortNameId(Integer destPortNameId) {
		this.destPortNameId = destPortNameId;
	}

	public Integer getLoadPortNameId() {
		return loadPortNameId;
	}

	public void setLoadPortNameId(Integer loadPortNameId) {
		this.loadPortNameId = loadPortNameId;
	}

	public Integer getOriginNameId() {
		return originNameId;
	}

	public void setOriginNameId(Integer originNameId) {
		this.originNameId = originNameId;
	}

	public Integer getPriceNameId() {
		return priceNameId;
	}

	public void setPriceNameId(Integer priceNameId) {
		this.priceNameId = priceNameId;
	}

	public Integer getRaCompanyMaster_CustomerId() {
		return raCompanyMaster_CustomerId;
	}

	public void setRaCompanyMaster_CustomerId(Integer raCompanyMaster_CustomerId) {
		this.raCompanyMaster_CustomerId = raCompanyMaster_CustomerId;
	}

	public Integer getStateNameId() {
		return stateNameId;
	}

	public void setStateNameId(Integer stateNameId) {
		this.stateNameId = stateNameId;
	}

	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}

	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

	public RaDeliveryMonth getRaDeliveryMonth() {
		return raDeliveryMonth;
	}

	public void setRaDeliveryMonth(RaDeliveryMonth raDeliveryMonth) {
		this.raDeliveryMonth = raDeliveryMonth;
	}

	public RaDestinationPort getRaDestinationPort() {
		return raDestinationPort;
	}

	public void setRaDestinationPort(RaDestinationPort raDestinationPort) {
		this.raDestinationPort = raDestinationPort;
	}

	public RaLoadPort getRaLoadPort() {
		return raLoadPort;
	}

	public void setRaLoadPort(RaLoadPort raLoadPort) {
		this.raLoadPort = raLoadPort;
	}

	public RaOriginMaster getRaOriginMaster() {
		return raOriginMaster;
	}

	public void setRaOriginMaster(RaOriginMaster raOriginMaster) {
		this.raOriginMaster = raOriginMaster;
	}

	public RaPriceBasis getRaPriceBasis() {
		return raPriceBasis;
	}

	public void setRaPriceBasis(RaPriceBasis raPriceBasis) {
		this.raPriceBasis = raPriceBasis;
	}

	public RaStateMaster getRaStateMaster() {
		return raStateMaster;
	}

	public void setRaStateMaster(RaStateMaster raStateMaster) {
		this.raStateMaster = raStateMaster;
	}

	public RaTracCropYear getRaTracCropYear() {
		return raTracCropYear;
	}

	public void setRaTracCropYear(RaTracCropYear raTracCropYear) {
		this.raTracCropYear = raTracCropYear;
	}

	public Integer getDeliverMonthId() {
		return deliverMonthId;
	}

	public void setDeliverMonthId(Integer deliverMonthId) {
		this.deliverMonthId = deliverMonthId;
	}

	public List<RaDeliveryMonth> getListDeliveryMonth() {
		return listDeliveryMonth;
	}

	public void setListDeliveryMonth(List<RaDeliveryMonth> listDeliveryMonth) {
		this.listDeliveryMonth = listDeliveryMonth;
	}
	public List<RaProducerMaster> getListProducerMaster() {
		return listProducerMaster;
	}
	public void setListProducerMaster(List<RaProducerMaster> listProducerMaster) {
		this.listProducerMaster = listProducerMaster;
	}
	public RaProducerMaster getRaProducerMaster() {
		return raProducerMaster;
	}
	public void setRaProducerMaster(RaProducerMaster raProducerMaster) {
		this.raProducerMaster = raProducerMaster;
	}
	public Integer getRaProducerMaster_ProducerId() {
		return raProducerMaster_ProducerId;
	}
	public void setRaProducerMaster_ProducerId(Integer raProducerMaster_ProducerId) {
		this.raProducerMaster_ProducerId = raProducerMaster_ProducerId;
	}
	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}
	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}
	public List<RaUserMaster> getListuser() {
		return listuser;
	}
	public void setListuser(List<RaUserMaster> listuser) {
		this.listuser = listuser;
	}

}
