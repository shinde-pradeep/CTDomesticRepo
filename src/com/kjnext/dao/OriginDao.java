package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.hibernate.RaSellingRegion;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.utility.hibernate.HibernateUtil;

public class OriginDao {

	
	static List<RaOriginMaster> originList=new ArrayList<RaOriginMaster>();

//	select from db..
	public List<RaOriginMaster> getOrigin()
	{
		return originList=HibernateUtil.getSession().createCriteria(RaOriginMaster.class).list();	

	}

//	add 2 db..

	public void addOrigin(RaOriginMaster raOriginMaster)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(raOriginMaster);
		transaction.commit();
		
	}

//	 updation in db

	public void updateOrigin(RaOriginMaster raOriginMaster )
	{
		
		
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
	    session.saveOrUpdate(raOriginMaster);
	    transaction.commit();
		
	   }

	public RaOriginMaster loadSingleOrigin(Integer originId)
	{
		return (RaOriginMaster)originList.get(originId-1);
		
	}

	 public void deActiveOrigin(Integer originId)
		{
			if(originId>0)
			{
				RaOriginMaster raOriginMaster=(RaOriginMaster)HibernateUtil.getSession().load(RaOriginMaster.class, originId);
				raOriginMaster.setOriginStatus("Deactive");
				HibernateUtil.getSession().update(raOriginMaster);
				HibernateUtil.commitTransaction();
			}
		}

	public boolean isOriginExist(RaOriginMaster raOriginMaster2) {
		// TODO Auto-generated method stub
		try {

			List<RaOriginMaster> list = (ArrayList<RaOriginMaster>) HibernateUtil
					.getSession().createCriteria(RaOriginMaster.class).add(
							Expression.eq("originType", raOriginMaster2
									.getOriginType())).list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	
	
	
}
