package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.kjnext.hibernate.RaTraceability;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.kjnext.utility.hibernate.HibernateUtil;

public class MyTransactionDao 
{
	List<RaTraceability> listTraceability=new ArrayList<RaTraceability>();
	UserTo userTo=new  UserTo();
	public List<RaTraceability> loadTraceability(UserTo userTo)
	{		
	HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		//listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("userId", userTo.getUserId())).list();
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		Criteria cr=session.createCriteria(RaTraceability.class);		
		Criterion user=Restrictions.eq("userId",userTo.getUserId());
		Criterion sell=Restrictions.eq("sellerId",userTo.getUserId().toString());
		//Criterion state=Restrictions.eq("status",'D');
		LogicalExpression orExp = Restrictions.or(user,sell);
		cr.add( orExp );
		Criterion state=Restrictions.eq("status","D");
		cr.add(state);
		listTraceability=cr.list();
		
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	public List<RaTraceability> loadTransactionReport(UserTo userTo)
	{		
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		//listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("userId", userTo.getUserId())).list();
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		Criteria cr=session.createCriteria(RaTraceability.class);		
		Criterion user=Restrictions.eq("userId",userTo.getUserId());
		Criterion sell=Restrictions.eq("sellerId",userTo.getUserId().toString());
		Criterion state=Restrictions.eq("status",'D');
		LogicalExpression orExp = Restrictions.or(user,sell);
		cr.add( orExp );
		
		listTraceability=cr.list();
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	public List<RaTraceability> loadAchivedTransaction(UserTo userTo)
	{		
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		//listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("userId", userTo.getUserId())).list();
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		Criteria cr=session.createCriteria(RaTraceability.class);		
		Criterion user=Restrictions.eq("userId",userTo.getUserId());
		Criterion sell=Restrictions.eq("sellerId",userTo.getUserId().toString());
		//Criterion state=Restrictions.eq("status",'D');
		LogicalExpression orExp = Restrictions.or(user,sell);
		cr.add( orExp );
		Criterion state=Restrictions.eq("status","A");
		cr.add(state);
		listTraceability=cr.list();
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	public List<RaTraceability> loadTraceability1(UserTo userTo)
	{		
		
		listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("status","D")).list();;
		
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	public List<RaTraceability> loadReport(UserTo userTo)
	{		
		
		listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();;
		
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	
	public List<RaTraceability> loadAcievedTransaction(UserTo userTo)
	{		
		
		listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("status","A")).list();
		//List list=HibernateUtil.getSession().createCriteria(RaTraceability.class).list();
		//listTraceability=list;
		System.out.println(listTraceability+".....listTraceability.......");
		return listTraceability;
	}
	public void complete(Integer traceId)
	{
		if(traceId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaTraceability raTraceability=(RaTraceability)session.load(RaTraceability.class, traceId);
			raTraceability.setStatus("A");
			session.saveOrUpdate(raTraceability);
			transaction.commit();		
		}
	}

	
	
	
	public void insertRecord(RaTraceability raTraceability)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		//HibernateUtil.beginTransaction();
		session.saveOrUpdate(raTraceability);
		 System.out.println("Insert into Traceability.......");

		 transaction.commit();
	}
	public void updateRecord(RaTraceability raTraceability)
	{
		System.out.println(raTraceability+"dao....");
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.saveOrUpdate(raTraceability);
		System.out.println("State updated successfully...");
		HibernateUtil.commitTransaction();
		
	}
	public List<RaTraceability> loadSingleTransaction(RaTraceability raTraceability ,Integer transactionId)
	{
		listTraceability=HibernateUtil.getSession().createCriteria(RaTraceability.class).add(Expression.eq("transactionId", raTraceability.getTransactionId())).list();
		/*System.out.println(traceId+"..transID..");
		RaTraceability raTraceability=(RaTraceability)HibernateUtil.getSession().load(RaTraceability.class, transactionId);*/
		System.out.println(listTraceability.size()+"....size...........");
		
		for(RaTraceability ratrac:listTraceability)
		{
			System.out.println(ratrac.getTransactionId()+"...TID..");
		}
		return listTraceability;
	}
	public void deActiveTransaction(Integer traceId)
	{
		if(traceId>0)
		{
			RaTraceability raTraceability=(RaTraceability)HibernateUtil.getSession().load(RaTraceability.class, traceId);
			raTraceability.setPrevStatus("Active");
			raTraceability.setStatus("Deactive");
			HibernateUtil.getSession().update(raTraceability);
			HibernateUtil.commitTransaction();
		}
	}

}
