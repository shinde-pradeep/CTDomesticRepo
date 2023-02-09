package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaSellingRegion;
import com.kjnext.model.Product;
import com.kjnext.utility.hibernate.HibernateUtil;

public class SellingRegionDao 
{

	static List<RaSellingRegion> listRegion = new ArrayList<RaSellingRegion>();
	
	/* ..........SELECT DATABASE.............*/
	public List<RaSellingRegion> retriveRecord()
	{
		List list=HibernateUtil.getSession().createCriteria(RaSellingRegion.class).list();
		listRegion=list;
		return listRegion;
	}
	/*................INSERT INTO DATABASE..........*/
	 public int insertRecord(RaSellingRegion raSellingRegion)
	 {
		 	
		 	HibernateUtil.closeSession();
		 	Session session=HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			session.save(raSellingRegion);
			System.out.println("inserted successfully..");
			HibernateUtil.commitTransaction();
		 	return raSellingRegion.getRegionId();
	 }
	 /* update table row */
	public int updateRegion(RaSellingRegion raSellingRegion)
	{
		System.out.println("....update region..."+raSellingRegion.getRegionId());
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(raSellingRegion);
		//HibernateUtil.commitTransaction();
		transaction.commit();
		return raSellingRegion.getRegionId();
	}
	/* load single row value of table*/
	public RaSellingRegion loadSingleRegion(Integer regionId)
	{
		System.out.println("Region ID........"+regionId);
		RaSellingRegion raSellingRegion=(RaSellingRegion)HibernateUtil.getSession().load(RaSellingRegion.class, regionId);
		return raSellingRegion;
	}
	
	/* DeActivate data **********/
	public void deActiveRegion(Integer regionId)
	{
		if(regionId>0)
		{
			RaSellingRegion sellingRegion=(RaSellingRegion)HibernateUtil.getSession().load(RaSellingRegion.class, regionId);
			sellingRegion.setStatus("Deactive");
			HibernateUtil.getSession().update(sellingRegion);
			HibernateUtil.commitTransaction();
		}
	}

	public boolean isRegionExist(RaSellingRegion raSellingRegion) {
		List<RaSellingRegion> list = (ArrayList<RaSellingRegion>) HibernateUtil
				.getSession().createCriteria(RaSellingRegion.class).add(
						Expression.eq("regionType", raSellingRegion
								.getRegionType())).list();
		if (list.isEmpty()) {
			return false;
		}
		return true;

	}

}

