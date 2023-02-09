package com.kjnext.action;

import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.kjnext.hibernate.RaBussinessTypeMaster;
import com.kjnext.hibernate.RaCompanyBussiness;
import com.kjnext.hibernate.RaCompanyBussinessId;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.hibernate.RaCompanyProductId;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.RegisterCompany;
import com.kjnext.service.CompanyRegisterService;
import com.kjnext.service.TraderUserServiceImpl;
import com.kjnext.utility.hibernate.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyRegisterAction extends BaseAction {
	CompanyRegisterService registerService = new CompanyRegisterService();

	TraderUserServiceImpl userServiceImpl = new TraderUserServiceImpl();

	List<RaCompanyMaster> listCompanys;

	List<RaStateMaster> listStates;

	List<RaProductMaster> listProducts;

	List<RaBussinessTypeMaster> listBussTypeMaster;

	/** **************** */
	RaProductMaster raProductMaster;// =new RaProductMaster();

	RaStateMaster raStateMaster;

	RaBussinessTypeMaster raBussinessTypeMaster;

	RaCompanyBussiness raCompanyBussiness;

	RaUserMaster userMaster;

	// RaCompanyProduct raCompanyProduct;

	RaCompanyMaster raCompanyMaster;

	RegisterCompany registerCompany;

	RaCompanyProductId raCompanyProductId;

	public String loadCompany() {
		listCompanys = registerService.loadCompanys();
		if (!listCompanys.isEmpty())
			return SUCCESS;
		return INPUT;
	}

	public String addCompanyInput() {
		listBussTypeMaster = HibernateUtil.getSession().createCriteria(
				RaBussinessTypeMaster.class).list();

		List list = HibernateUtil.getSession().createCriteria(
				RaProductMaster.class).list();
		listProducts = list;
		listStates = HibernateUtil.getSession().createCriteria(
				RaStateMaster.class).list();
		return SUCCESS;
	}

	public void loadList() {

		listBussTypeMaster = HibernateUtil.getSession().createCriteria(
				RaBussinessTypeMaster.class).list();

		List list = HibernateUtil.getSession().createCriteria(
				RaProductMaster.class).list();
		listProducts = list;

		listStates = HibernateUtil.getSession().createCriteria(
				RaStateMaster.class).list();

	}

	public String addCompany() {

		/** ************ */
		System.out.println(raProductMaster + ".....raProductMaster.");
		System.out.println(raProductMaster.getCompanyProduct()
				+ "getCompanyProduct()...");
		Integer[] arr = raProductMaster.getCompanyProduct();

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ".....arr value...");
		}
		/** ****************************** */
		raCompanyMaster.setCreateDate(new java.util.Date());
		System.out.println(raCompanyMaster.getPriLname() + "***********");
		raCompanyMaster.setCompanyStatus("Active");
		raCompanyMaster.setRaProdBrand1("banana,Apple");
		registerService.insertRecord(raCompanyMaster);
		/** *************************** */
		/** * COmpnanyProduct Table...* */

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ".....arr value...");
			RaCompanyProduct raCompanyProductTab = new RaCompanyProduct();
			RaCompanyProductId raCompanyProductIdTab = new RaCompanyProductId();
			raProductMaster.setProductId(arr[i]);

			raCompanyProductIdTab.setRaProductMaster(raProductMaster);
			raCompanyProductTab.setId(raCompanyProductIdTab);

			raCompanyMaster.getCompanyId();
			raCompanyProductIdTab.setRaCompanyMaster(raCompanyMaster);
			raCompanyProductTab.setId(raCompanyProductIdTab);

			registerService.insertCompany_Product(raCompanyProductTab);

		}
		/** ******ra_company_bussiness Table*********** */
		Integer[] arrBussiness = raBussinessTypeMaster.getCompanyBussiness();
		for (int i = 0; i < arrBussiness.length; i++) {
			System.out.println(arrBussiness[i] + "..... BUISNESS_TYPE_ID...");
		}

		/** ********CompanyBussiness Table **** */

		for (int i = 0; i < arrBussiness.length; i++) {
			System.out.println(arrBussiness[i] + "..... BUISNESS_TYPE_ID...");
			RaCompanyBussiness raCompanyBussinessTab = new RaCompanyBussiness();
			RaCompanyBussinessId raCompanyBussinessIdTab = new RaCompanyBussinessId();
			raBussinessTypeMaster.setBuisnessTypeId(arrBussiness[i]);
			raCompanyBussinessIdTab
					.setRaBussinessTypeMaster(raBussinessTypeMaster);
			raCompanyBussinessTab.setId(raCompanyBussinessIdTab);
			raCompanyMaster.getCompanyId();
			raCompanyBussinessIdTab.setRaCompanyMaster(raCompanyMaster);
			raCompanyBussinessTab.setId(raCompanyBussinessIdTab);
			registerService.insertCompany_Business(raCompanyBussinessTab);
		}
		/** ********UserMaster******** */
		 userMaster=new RaUserMaster();
		userMaster.setRaCompanyMaster(raCompanyMaster);
		userMaster.setProducerId(raProductMaster.getProductId());
		raCompanyMaster.getPriStateId();
		System.out.println(raCompanyMaster.getPriStateId()+"state....");
		userMaster.setState("MH");
        
		userMaster.setCreateDate(new java.util.Date());
		//userMaster.setUserType(userType);
		userMaster.setFirstName(raCompanyMaster.getPriFname());
		userMaster.setLastName(raCompanyMaster.getPriLname());
		userMaster.setEmail(raCompanyMaster.getPriEmail());
		userMaster.setPosition(raCompanyMaster.getPriPosition());
		userMaster.setOfficeAddress(raCompanyMaster.getPriOffaddress());
		userMaster.setCity(raCompanyMaster.getPriCity());
		userMaster.setDistrict(raCompanyMaster.getPriDistrict());
		userMaster.setLoginName(raCompanyMaster.getPriEmail());
		userMaster.setPassword(CompanyRegisterService.generatePassword(8));
		userMaster.setPhone(raCompanyMaster.getPriPhone());
		userMaster.setZip(raCompanyMaster.getPriZip());
		userMaster.setFax(raCompanyMaster.getPriFax());
		userMaster.setUserType("traders");
		userMaster.setUserStatus("Active");
		userServiceImpl.insertTraderUser(userMaster);
		raCompanyMaster.setPassWord(userMaster.getPassword());
		
		registerService.sendMail(raCompanyMaster);
		loadList();
		loadCompany();
		setNavigationFlg("success");

		return SUCCESS;
	}

	public String updateCompanyInput() {
		raCompanyMaster = registerService.loadSingleCompanys(raCompanyMaster
				.getCompanyId());
		loadList();
		return SUCCESS;
	}

	public String updateCompany() {
		raCompanyMaster.setCompanyStatus("Active");
		// deleteChild();
		registerService.updateRecord(raCompanyMaster);
		// first delete child class id ....RaCompanyProduct Table
		// deleteChild();
		loadList();
		loadCompany();
		setNavigationFlg("success");
		return SUCCESS;
	}

	/** ******Delete/Update Child table ID******* */
	/*
	 * public void deleteChild() {
	 * 
	 * //RaCompanyBussinessId raCompanyBussinessIdTab = new
	 * RaCompanyBussinessId();
	 * //companyID=raCompanyProductIdTab.getRaCompanyMaster();
	 * //RaCompanyProduct
	 * raCompanyProduct=(RaCompanyProduct)HibernateUtil.getSession().load(RaCompanyProduct.class,raCompanyProductIdTab.getRaCompanyMaster());
	 * //RaCompanyBussiness
	 * raCompanyBussiness=(RaCompanyBussiness)HibernateUtil.getSession().load(RaCompanyBussiness.class,
	 * raCompanyBussinessIdTab.getRaCompanyMaster());
	 * 
	 * HibernateUtil.beginTransaction();
	 *//** * COmpnanyProduct Table...* */
	/*
	 * Integer[] tabId = raProductMaster.getCompanyProduct(); for (int i = 0; i <
	 * tabId.length; i++) { RaCompanyProduct raCompanyProduct = new
	 * RaCompanyProduct(); RaCompanyProductId raCompanyProductIdTab = new
	 * RaCompanyProductId(); System.out.println(tabId[i] + ".....tabId
	 * value...");
	 * 
	 * raCompanyMaster.getCompanyId();
	 * //raCompanyProduct=(RaCompanyProduct)HibernateUtil.getSession().load(RaCompanyProduct.class,raCompanyMaster.getCompanyId()); //
	 * raCompanyProduct.getId().getRaCompanyMaster().getCompanyId();
	 * System.out.println(raCompanyProduct.getId().getRaCompanyMaster().getCompanyId()+"**$$&&");
	 * raProductMaster.setProductId(tabId[i]);
	 * 
	 * raCompanyProductIdTab.setRaProductMaster(raProductMaster);
	 * raCompanyProduct.setId(raCompanyProductIdTab);
	 * 
	 * 
	 * System.out.println(raCompanyMaster.getCompanyId()+"......deleteChild..raCompanyMaster.getCompanyId()");
	 * //raCompanyProductIdTab.setRaCompanyMaster(raCompanyMaster);
	 * //raCompanyProduct.setId(raCompanyProductIdTab);
	 * 
	 * //registerService.insertCompany_Product(raCompanyProductTab);
	 * HibernateUtil.getSession().saveOrUpdate(raCompanyProduct);
	 * //.commitTransaction();
	 *  } HibernateUtil.commitTransaction(); }
	 */
	public String deleteCompany() {
		raCompanyMaster.setCompanyStatus("DeActive");
		registerService.deleteCompanys(raCompanyMaster.getCompanyId());
		loadCompany();
		return SUCCESS;
	}

	/** ********************************** */
	public RegisterCompany getRegisterCompany() {
		return registerCompany;
	}

	public void setRegisterCompany(RegisterCompany registerCompany) {
		this.registerCompany = registerCompany;
	}

	public RaCompanyMaster getCompanyMaster() {
		return raCompanyMaster;
	}

	public void setCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

	public List<RaCompanyMaster> getListCompanys() {
		return listCompanys;
	}

	public void setListCompanys(List<RaCompanyMaster> listCompanys) {
		this.listCompanys = listCompanys;
	}

	public List<RaBussinessTypeMaster> getListBussTypeMaster() {
		return listBussTypeMaster;
	}

	public void setListBussTypeMaster(
			List<RaBussinessTypeMaster> listBussTypeMaster) {
		this.listBussTypeMaster = listBussTypeMaster;
	}

	public List<RaProductMaster> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<RaProductMaster> listProducts) {
		this.listProducts = listProducts;
	}

	public List<RaStateMaster> getListStates() {
		return listStates;
	}

	public void setListStates(List<RaStateMaster> listStates) {
		this.listStates = listStates;
	}

	public RaBussinessTypeMaster getRaBussinessTypeMaster() {
		return raBussinessTypeMaster;
	}

	public void setRaBussinessTypeMaster(
			RaBussinessTypeMaster raBussinessTypeMaster) {
		this.raBussinessTypeMaster = raBussinessTypeMaster;
	}

	public RaProductMaster getRaProductMaster() {
		return raProductMaster;
	}

	public void setRaProductMaster(RaProductMaster raProductMaster) {
		this.raProductMaster = raProductMaster;
	}

	public RaStateMaster getRaStateMaster() {
		return raStateMaster;
	}

	public void setRaStateMaster(RaStateMaster raStateMaster) {
		this.raStateMaster = raStateMaster;
	}

	public RaCompanyBussiness getRaCompanyBussiness() {
		return raCompanyBussiness;
	}

	public void setRaCompanyBussiness(RaCompanyBussiness raCompanyBussiness) {
		this.raCompanyBussiness = raCompanyBussiness;
	}

	public RaCompanyProductId getRaCompanyProductId() {
		return raCompanyProductId;
	}

	public void setRaCompanyProductId(RaCompanyProductId raCompanyProductId) {
		this.raCompanyProductId = raCompanyProductId;
	}

	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}

	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

	public RaUserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(RaUserMaster userMaster) {
		this.userMaster = userMaster;
	}

	

}
