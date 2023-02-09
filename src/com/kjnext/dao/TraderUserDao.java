package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.kjnext.utility.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class TraderUserDao 
{
	
	
	RaUserMaster raUserMaster;
	Integer compId;
	List<RaUserMaster> listTrader=new ArrayList<RaUserMaster>();
	public List<RaUserMaster> loadTrader(UserTo userTo)
	{
		List list;
		Session session= HibernateUtil.getSession();
		Criteria cr = session.createCriteria(RaUserMaster.class);
		Criterion user=Restrictions.eq("userType",userTo.getUserType());
		Criterion company=Restrictions.eq("raCompanyMaster.companyId",userTo.getRaCompanyMaster().getCompanyId());
		LogicalExpression andExp = Restrictions.and(user,company);
		cr.add( andExp );
		
		//.add(Expression.eq("userId", userTo.getUserId())).list();
		listTrader=cr.list();
		return listTrader;
	}
	public void insertTraderUser(RaUserMaster userMaster)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		//HibernateUtil.beginTransaction();
		Transaction transaction=session.beginTransaction();
		
		System.out.println(userMaster+"....userMaster..");
		session.saveOrUpdate(userMaster);
		transaction.commit();
		//HibernateUtil.commitTransaction();
	}
	public void updateTraderUser(RaUserMaster raUserMaster)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		
		session.saveOrUpdate(raUserMaster);
		transaction.commit();
		
		//	HibernateUtil.commitTransaction();
	}
	public RaUserMaster loadSingleUser(Integer userId)
	{
		RaUserMaster raUserMaster=(RaUserMaster)HibernateUtil.getSession().load(RaUserMaster.class, userId);
		return raUserMaster;
	}
	public void deActiveTrader(Integer userId)
	{
		if(userId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaUserMaster raUserMaster=(RaUserMaster)HibernateUtil.getSession().load(RaUserMaster.class, userId);
			//HibernateUtil.beginTransaction();
			if("A".equalsIgnoreCase(raUserMaster.getUserStatus()))
				raUserMaster.setUserStatus("D");
			else
				raUserMaster.setUserStatus("A");
			session.saveOrUpdate(raUserMaster);
			transaction.commit();

			
		}
		
	}
    public void	 setUserPosition(Integer userId)
    {
    	
    	if(userId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaUserMaster raUserMaster=(RaUserMaster)session.load(RaUserMaster.class, userId);
			//String position=raUserMaster.getPosition();
			if("user".equalsIgnoreCase(raUserMaster.getPosition()))
			{
				raUserMaster.setPosition("Trader");
				session.saveOrUpdate(raUserMaster);
				transaction.commit();
    	
			}
			else
			{	
				raUserMaster.setPosition("user");
				session.saveOrUpdate(raUserMaster);
				transaction.commit();
	    	

			}
    }
    }
	public boolean isUserExist(RaUserMaster raUserMaster) {
		try {

			List<RaUserMaster> list = (ArrayList<RaUserMaster>) HibernateUtil
					.getSession().createCriteria(RaUserMaster.class).add(
							Expression.eq("email", raUserMaster.getEmail()))
					.list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}
	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
}
