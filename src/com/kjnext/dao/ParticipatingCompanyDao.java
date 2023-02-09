package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaOutletMaster;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.utility.hibernate.HibernateUtil;

public class ParticipatingCompanyDao {

	static List<RaCompanyMaster> listProduct = new ArrayList<RaCompanyMaster>();

	public List<RaCompanyMaster> getCompany() {

		List list = HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		listProduct = list;
		return listProduct;
	}
	public List<RaCompanyMaster> loadCompanyReport() {

		List list = HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		listProduct = list;
		return listProduct;
	}
	/** ****Insert Record**** */
	public void insertRecord(RaCompanyMaster raCompanyMaster) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.save(raCompanyMaster);
		System.out.println("inserted successfully..");
		HibernateUtil.commitTransaction();
	}
	/***********Insert into Outlet*************/
	public void insertOutlet(RaOutletMaster raOutletMaster)
	{
		HibernateUtil.closeSession();
		Session session2=HibernateUtil.getSession();
		session2.save(raOutletMaster);
		HibernateUtil.commitTransaction();
	}
	
	/******Update****/
	public void updateRecord(RaCompanyMaster raCompanyMaster) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.saveOrUpdate(raCompanyMaster);
		HibernateUtil.commitTransaction();
	}
	/********Load Single Row *******/
	public RaCompanyMaster loadSingleCompany(Integer companyId)
	{
		RaCompanyMaster raCompanyMaster=(RaCompanyMaster)HibernateUtil.getSession().load(RaCompanyMaster.class, companyId);
		return raCompanyMaster;
	}
	/*****DeActive Record**/
	public void deActiveCompany(Integer companyId)
	{
		if(companyId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaCompanyMaster raCompanyMaster =(RaCompanyMaster )session.load(RaCompanyMaster .class, companyId);
			raCompanyMaster .setCompanyStatus("D");
			session.saveOrUpdate(raCompanyMaster);
			transaction.commit();
			
			
			/*RaCompanyMaster raCompanyMaster=(RaCompanyMaster)HibernateUtil.getSession().load(RaCompanyMaster.class, companyId);
			raCompanyMaster.setCompanyStatus("D");
			HibernateUtil.getSession().update(raCompanyMaster);
			HibernateUtil.commitTransaction();*/
		}
	}
	public void ActiveCompany(Integer companyId)
	{
		if(companyId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaCompanyMaster raCompanyMaster =(RaCompanyMaster )session.load(RaCompanyMaster .class, companyId);
			raCompanyMaster .setCompanyStatus("A");
			session.saveOrUpdate(raCompanyMaster);
			transaction.commit();
		}
	}
}
