package com.kjnext.service;

import java.util.ArrayList;
import java.util.List;

import com.kjnext.dao.MyprofileDao;
import com.kjnext.hibernate.RaBussinessTypeMaster;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaUserMaster;

public class MyProfileService {

	MyprofileDao myprofileDao = new MyprofileDao();

	public List<RaProductMaster> getProductList() {
		List<RaProductMaster> list = myprofileDao.getProduct();
		return list;

	}

	public List<RaCompanyMaster> getCompanyMaster() {
		List<RaCompanyMaster> list1 = myprofileDao.getCompanyMaster();
		return list1;

	}

	public List<RaStateMaster> getStateMaster() {
		List<RaStateMaster> list1 = myprofileDao.getStateMaster();
		return list1;

	}

	public List<RaBussinessTypeMaster> getBusinessMaster() {
		List<RaBussinessTypeMaster> list1 = myprofileDao.getBusinesMaster();
		return list1;

	}

	public List<RaUserMaster> getUserMaster() {
		List<RaUserMaster> list1 = myprofileDao.getUserMaster();
		return list1;

	}

	public RaCompanyMaster loadSingleProfileData(Integer companyId) {
		// TODO Auto-generated method stub
		return myprofileDao.loadSingleProfileData(companyId);
	}

	public RaUserMaster loadUserProfileData(Integer userId) {
		// TODO Auto-generated method stub
		return myprofileDao.loadUserProfileData(userId);
	}
	public RaUserMaster loadProducerProfileData(Integer userId)
	{
		
		
		return myprofileDao.loadProducrProfileData(userId); 
	}

	public List<RaProductMaster> loadProductList(Integer companyId) {
		// TODO Auto-generated method stub
		List<RaProductMaster> productList = new ArrayList<RaProductMaster>();
		List<Object[]> ll = myprofileDao.loadProductList(companyId);
		for (int i = 0; i < ll.size(); i++) {
			RaProductMaster raProductMaster = myprofileDao.loadProduct(ll
					.get(i));
			productList.add(raProductMaster);
		}
		return productList;
	}

	public List<RaBussinessTypeMaster> loadBussinessList(Integer companyId) {
		// TODO Auto-generated method stub
		List<RaBussinessTypeMaster> bussinessList = new ArrayList<RaBussinessTypeMaster>();
		@SuppressWarnings("unused")
		List<Object[]> ll = myprofileDao.loadBussinessList(companyId);
		for (int i = 0; i < ll.size(); i++) {
			RaBussinessTypeMaster raBussinessTypeMaster = myprofileDao
					.loadBussiness(ll.get(i));
			bussinessList.add(raBussinessTypeMaster);
		}
		return bussinessList;

	}

	public List<RaStateMaster> loadStateList(Integer companyId) {
		List<RaStateMaster> stateList = new ArrayList<RaStateMaster>();
		@SuppressWarnings("unused")
		List<Object[]> ll = myprofileDao.loadStateList(companyId);
		for (int i = 0; i < ll.size(); i++) {
			RaStateMaster raStateMaster = myprofileDao.loadState(ll.get(i));
			stateList.add(raStateMaster);
		}
		return stateList;
	}

}
