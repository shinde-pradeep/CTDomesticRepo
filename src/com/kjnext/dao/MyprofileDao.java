package com.kjnext.dao;

import java.util.List;
import org.hibernate.Query;
import com.kjnext.hibernate.RaBussinessTypeMaster;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.utility.hibernate.HibernateUtil;

public class MyprofileDao {

	@SuppressWarnings("unchecked")
	public List<RaProductMaster> getProduct() {
		List<RaProductMaster> list = HibernateUtil.getSession().createCriteria(
				RaProductMaster.class).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<RaCompanyMaster> getCompanyMaster() {
		List<RaCompanyMaster> list1 = HibernateUtil.getSession()
				.createCriteria(RaCompanyMaster.class).list();
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<RaStateMaster> getStateMaster() {
		List<RaStateMaster> list1 = HibernateUtil.getSession().createCriteria(
				RaStateMaster.class).list();
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<RaBussinessTypeMaster> getBusinesMaster() {
		List<RaBussinessTypeMaster> list1 = HibernateUtil.getSession()
				.createCriteria(RaBussinessTypeMaster.class).list();
		return list1;
	}

	public RaCompanyMaster loadSingleProfileData(Integer companyId) {
		// TODO Auto-generated method stub
		// companyId=1;
		System.out.println("company ID........" + companyId);
		RaCompanyMaster raCompanyMaster = (RaCompanyMaster) HibernateUtil
				.getSession().load(RaCompanyMaster.class, companyId);
		System.out.println("id====" + raCompanyMaster.getCompanyId());
		return raCompanyMaster;
	}

	@SuppressWarnings("unchecked")
	public List<RaUserMaster> getUserMaster() {
		// TODO Auto-generated method stub
		List<RaUserMaster> list1 = HibernateUtil.getSession().createCriteria(
				RaUserMaster.class).list();
		return list1;
	}

	public RaUserMaster loadUserProfileData(Integer userId) {
		// TODO Auto-generated method stub
		RaUserMaster raUserMaster = (RaUserMaster) HibernateUtil.getSession()
				.load(RaUserMaster.class, userId);
		System.out.println("id====" + raUserMaster.getUserId());
		return raUserMaster;
	}
	public RaUserMaster loadProducrProfileData(Integer userId)
	{
		RaUserMaster raUserMaster = (RaUserMaster) HibernateUtil.getSession()
		.load(RaUserMaster.class, userId);

		return raUserMaster;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> loadProductList(Integer companyId) {
		Query query = HibernateUtil
				.getSession()
				.createSQLQuery(
						"select c.product_id from ra_company_master r,ra_company_product c where r.company_id=c.company_id and c.company_id='"+companyId+"'");
		System.out.println(query.list());
		List<Object[]> objList = query.list();
		System.out.println(objList);
		System.out.println(objList.get(0));// objList.get(0);
		return objList;
	}

	// to load product detail
	public RaProductMaster loadProduct(Object productId) {
		RaProductMaster raProductMaster1 = new RaProductMaster();
		System.out.println(productId.toString());
		Integer productId11 = Integer.valueOf(productId.toString());
		RaProductMaster raProductMaster = (RaProductMaster) HibernateUtil
				.getSession().load(RaProductMaster.class, productId11);

		System.out.println("product name" + raProductMaster.getDescription());
		raProductMaster1.setDescription(raProductMaster.getDescription());
		return raProductMaster1;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> loadBussinessList(Integer companyId) {
		Query query = HibernateUtil.getSession().createSQLQuery(
				"select b.BUISNESS_TYPE_ID from ra_company_bussiness b where b.company_id='"
						+ companyId + "'");
		System.out.println(query.list());
		List<Object[]> objList = query.list();
		System.out.println(objList);
		System.out.println(objList.get(0));// objList.get(0);
		return objList;
	}

	public RaBussinessTypeMaster loadBussiness(Object buisnessTypeId) {

		RaBussinessTypeMaster raBussinessTypeMaster1 = new RaBussinessTypeMaster();
		System.out.println(buisnessTypeId.toString());
		Integer buisnessTypeId1 = Integer.valueOf(buisnessTypeId.toString());
		RaBussinessTypeMaster raBussinessTypeMaster = (RaBussinessTypeMaster) HibernateUtil
				.getSession()
				.load(RaBussinessTypeMaster.class, buisnessTypeId1);
		System.out.println("bussiness name::"
				+ raBussinessTypeMaster.getDescription());
		raBussinessTypeMaster1.setDescription(raBussinessTypeMaster
				.getDescription());
		return raBussinessTypeMaster1;

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> loadStateList(Integer companyId) {
		Query query = HibernateUtil.getSession().createSQLQuery(
				"select s.State_id from ra_company_state s where s.company_id='"
						+ companyId + "';");
		System.out.println(query.list());
		List<Object[]> objList = query.list();
		System.out.println(objList);
		System.out.println(objList.get(0));// objList.get(0);
		return objList;
	}

	public RaStateMaster loadState(Object stateId) {
		RaStateMaster raStateMaster = new RaStateMaster();
		System.out.println(stateId.toString());
		Integer stateId1 = Integer.valueOf(stateId.toString());
		RaStateMaster raMaster = (RaStateMaster) HibernateUtil.getSession()
				.load(RaStateMaster.class, stateId1);
		System.out.println("state name::" + raMaster.getStateType());
		raStateMaster.setDescription(raMaster.getStateType());
		return raStateMaster;
	}

}
