package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.hibernate.RaTraceability;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.Product;
import com.kjnext.model.UserTo;
import com.kjnext.utility.hibernate.HibernateUtil;


public class ParticipitingProducerDao {

static List<RaProducerMaster> listproducer=new ArrayList<RaProducerMaster>();
static List<RaTraceability> listTransaction =new ArrayList<RaTraceability>();	
	public List<RaProducerMaster> getProducers()
	{

		
		
		List list=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listproducer=list;
		System.out.println(listproducer);
		return listproducer;
		
		
	}
	public List<RaProducerMaster> getProducerUser(UserTo userTo)
	{
		
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();

		
		Criteria cr=session.createCriteria(RaProducerMaster.class);		
		Criterion user=Restrictions.eq("userId",userTo.getUserId());
		cr.add(user);
		//Criterion user=Restrictions.eq("userId",userTo.getUserId());
		//List list=HibernateUtil.getSession().createCriteria(RaProducerMaster.class);
		listproducer=cr.list();
		System.out.println(listproducer);
		return listproducer;
		
		
	}

	
	public List<RaProducerMaster> loadProducersReport()
	{
		
		
		List list=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		listproducer=list;
		System.out.println(listproducer);
		return listproducer;
		
		
	}

	public List<RaTraceability> ProducersTransaction(UserTo userTo)
	{
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		
		Criteria cr=session.createCriteria(RaTraceability.class);
		Criterion user=Restrictions.eq("sellerId",userTo.getUserId().toString());
		cr.add(user);
				//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		listTransaction=cr.list();
		System.out.println(listTransaction );
		return listTransaction ;
		
		
	}

	public void deActive(Integer producerId)
	{
		if(producerId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaProducerMaster raProducerMaster=(RaProducerMaster)session.load(RaProducerMaster.class,producerId);
			raProducerMaster.setProducerStatus("D");
			session.saveOrUpdate(raProducerMaster);
			transaction.commit();
			
			
			/*RaCompanyMaster raCompanyMaster=(RaCompanyMaster)HibernateUtil.getSession().load(RaCompanyMaster.class, companyId);
			raCompanyMaster.setCompanyStatus("D");
			HibernateUtil.getSession().update(raCompanyMaster);
			HibernateUtil.commitTransaction();*/
		}
	}
	public void Active(Integer producerId)
	{
		if(producerId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaProducerMaster raProducerMaster=(RaProducerMaster)session.load(RaProducerMaster.class,producerId);
			raProducerMaster.setProducerStatus("A");
			session.saveOrUpdate(raProducerMaster);
			transaction.commit();
		}
	}
	
	
}
