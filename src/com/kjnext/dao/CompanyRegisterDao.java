
package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kjnext.hibernate.RaCompanyBussiness;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.utility.hibernate.HibernateUtil;

public class CompanyRegisterDao 
{
	static List<RaCompanyMaster> listCompany=new ArrayList<RaCompanyMaster>();
	/* load table data  */
	public List<RaCompanyMaster> loadCompany()
	{
		List list=HibernateUtil.getSession().createCriteria(RaCompanyMaster.class).list();
		 listCompany=list;
		return listCompany;
	}
	/*  insert into Company Master table  */
	public void insertRecords(RaCompanyMaster raCompanyMaster)
	{
		//HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		//raCompanyMaster.setCompanyStatus("Active");
		session.save(raCompanyMaster);
		HibernateUtil.commitTransaction();
	
	}
	/* ****Insert into  Company_Product table **** */
	public void insertCompany_Product(RaCompanyProduct  raCompanyProduct)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.save(raCompanyProduct);
		HibernateUtil.commitTransaction();
	}
	/* IN SERT INTO RACOMPANY_BUSINESS TABLE**/
	public void insertCompan_Bussiness(RaCompanyBussiness raCompanyBussiness)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.save(raCompanyBussiness);
		HibernateUtil.commitTransaction();
	}
	public void updateRecords(RaCompanyMaster raCompanyMaster)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.saveOrUpdate(raCompanyMaster);
		HibernateUtil.commitTransaction();
	}
	/* load singal data from table*/
	public RaCompanyMaster loadSingleCompany(Integer companyId)
	{
		RaCompanyMaster  raCompanyMaster=(RaCompanyMaster)HibernateUtil.getSession().load(RaCompanyMaster.class,companyId);
		return raCompanyMaster;
	}
	public void deleteCompany(Integer companyId)
	{
		if(companyId>0){
			RaCompanyMaster raCompanyMaster=(RaCompanyMaster)HibernateUtil.getSession().load(RaCompanyMaster.class,companyId);
			Session session=HibernateUtil.getSession();
			raCompanyMaster.setCompanyStatus("DeActive");
			session.update(raCompanyMaster);
			HibernateUtil.commitTransaction();
		}
	}
}
