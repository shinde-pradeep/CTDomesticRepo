package com.kjnext.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kjnext.hibernate.RaBussinessTypeMaster;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.hibernate.RaCompanyProductId;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.kjnext.service.MyProfileService;
import com.kjnext.utility.hibernate.HibernateUtil;

public class MyProfileAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MyProfileService myProfileService = new MyProfileService();

	RaProductMaster raProductMaster;

	RaCompanyMaster raCompanyMaster;

	RaUserMaster raUserMaster;

	RaCompanyProduct raCompanyProduct;

	RaCompanyProductId raCompanyProductId;

	List<RaProductMaster> productlist;

	List<RaProductMaster> selectedProductlist;

	List<RaCompanyMaster> companylist;

	List<RaStateMaster> statelist;

	List<RaStateMaster> selectedStatelist;

	List<RaBussinessTypeMaster> businesslist;

	List<RaBussinessTypeMaster> selectedBusinesslist;

	List<RaUserMaster> raList;

	List<RaCompanyProduct> raList2;

	@SuppressWarnings("unchecked")
	public List<RaProductMaster> loadList() {
		return myProfileService.loadProductList(raUserMaster.raCompanyMaster
				.getCompanyId());
	}

	public List<RaBussinessTypeMaster> loadBussinessList() {
		System.out.println("bussinessList");
		return myProfileService.loadBussinessList(raUserMaster.raCompanyMaster
				.getCompanyId());
	}

	public List<RaStateMaster> loadStateList() {
		System.out.println("State List");
		return myProfileService.loadStateList(raUserMaster.raCompanyMaster
				.getCompanyId());
	}

	public String loadProduct() {
		System.out.println("load productss for company");
		productlist = myProfileService.getProductList();
		companylist = myProfileService.getCompanyMaster();
		statelist = myProfileService.getStateMaster();
		businesslist = myProfileService.getBusinessMaster();
		raList = myProfileService.getUserMaster();
		return SUCCESS;
	}

	public String loadProfileData() {
		UserTo user = (UserTo) session.get("UserInfo");
		System.out.println(user.getUserId());
		raUserMaster = myProfileService.loadUserProfileData(user.getUserId());
		System.out.println("userProfile" + raUserMaster.getUserId());
		raCompanyMaster = myProfileService
				.loadSingleProfileData(raUserMaster.raCompanyMaster
						.getCompanyId());
		selectedProductlist = loadList();
		for (RaProductMaster raProductMaster : selectedProductlist) {
			System.out.println("product name::"
					+ raProductMaster.getDescription());
		}
		selectedBusinesslist = loadBussinessList();
		for (RaBussinessTypeMaster raBussinessTypeMaster : selectedBusinesslist) {
			System.out.println("bussiness name:: "
					+ raBussinessTypeMaster.getDescription());
		}
		selectedStatelist = loadStateList();
		for (RaStateMaster raStateMaster : selectedStatelist) {
			System.out.println("state forloop list");
			System.out.println("state name:: " + raStateMaster.getDescription());
		}
		loadProduct();
		return SUCCESS;
	}
	public String loadProducerProfileData() 
	{
	
		UserTo user = (UserTo) session.get("UserInfo");
		System.out.println(user.getUserId());
		raUserMaster = myProfileService.loadProducerProfileData(user.getUserId());
		System.out.println(raUserMaster.getUserId());
	
	
	
	
	return SUCCESS;
	}
	public List<RaStateMaster> getSelectedStatelist() {
		return selectedStatelist;
	}

	public void setSelectedStatelist(List<RaStateMaster> selectedStatelist) {
		this.selectedStatelist = selectedStatelist;
	}

	public List<RaBussinessTypeMaster> getSelectedBusinesslist() {
		return selectedBusinesslist;
	}

	public void setSelectedBusinesslist(
			List<RaBussinessTypeMaster> selectedBusinesslist) {
		this.selectedBusinesslist = selectedBusinesslist;
	}

	public List<RaProductMaster> getSelectedProductlist() {
		return selectedProductlist;
	}

	public void setSelectedProductlist(List<RaProductMaster> selectedProductlist) {
		this.selectedProductlist = selectedProductlist;
	}

	public List<RaStateMaster> getStatelist() {
		return statelist;
	}

	public void setStatelist(List<RaStateMaster> statelist) {
		this.statelist = statelist;
	}

	public List<RaProductMaster> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<RaProductMaster> productlist) {
		this.productlist = productlist;
	}

	public RaProductMaster getRaProductMaster() {
		return raProductMaster;
	}

	public void setRaProductMaster(RaProductMaster raProductMaster) {
		this.raProductMaster = raProductMaster;
	}

	public List<RaCompanyMaster> getCompanylist() {
		return companylist;
	}

	public void setCompanylist(List<RaCompanyMaster> companylist) {
		this.companylist = companylist;
	}

	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}

	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

	public List<RaBussinessTypeMaster> getBusinesslist() {
		return businesslist;
	}

	public void setBusinesslist(List<RaBussinessTypeMaster> businesslist) {
		this.businesslist = businesslist;
	}

	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}

	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}

}
