package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.Product;
import com.kjnext.model.UserTo;
import com.kjnext.utility.hibernate.HibernateUtil;

public class AllUsersDao {
	
	
	
	static List<RaUserMaster> listUser=new ArrayList<RaUserMaster>();
	
	public List<RaUserMaster> getUsers(UserTo userTo)
	{
		
		List list=HibernateUtil.getSession().createCriteria(RaUserMaster.class).add(Expression.eq("userType", userTo.getUserType())).list();
		listUser=list;
		return listUser;
	}
	public void deActiveUser(Integer userId)
	{
		if(userId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaUserMaster raUserMaster=(RaUserMaster)session.load(RaUserMaster.class, userId);
			raUserMaster.setUserStatus("D");
			session.saveOrUpdate(raUserMaster);
			transaction.commit();		
		}
	}
	public void ActiveUser(Integer userId)
	{
		if(userId>0)
		{
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaUserMaster raUserMaster=(RaUserMaster)session.load(RaUserMaster.class, userId);
			raUserMaster.setUserStatus("A");
			session.saveOrUpdate(raUserMaster);
			transaction.commit();
			
			
			/*RaUserMaster raUserMaster=(RaUserMaster)HibernateUtil.getSession().load(RaUserMaster.class, userId);
			raUserMaster.setUserStatus("A");
			HibernateUtil.getSession().saveOrUpdate(raUserMaster);
			HibernateUtil.commitTransaction();
			*/
		}
	}
	public RaUserMaster  LoadSingleUser(Integer userId)
	{
		RaUserMaster raUserMaster=(RaUserMaster)HibernateUtil.getSession().load(RaUserMaster.class, userId);
		return raUserMaster;
		
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
				raUserMaster.setPosition("Administrator");
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
}