package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kjnext.hibernate.RaTraceOffers;
import com.kjnext.utility.hibernate.HibernateUtil;

public class TraderOfferDao 
{
	List<RaTraceOffers> listOffers=new ArrayList<RaTraceOffers>();
	public List<RaTraceOffers> loadOffers()
	{
		List list=HibernateUtil.getSession().createCriteria(RaTraceOffers.class).list();
		listOffers=list;
		return listOffers;
	}
	public void insertOffers(RaTraceOffers raTraceOffers)
	{
		HibernateUtil.closeSession();
		Session  session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.save(raTraceOffers);
		System.out.println("Insert successfullg .........");
		HibernateUtil.commitTransaction();
	}
	public void updateOffers(RaTraceOffers raTraceOffers)
	{
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.saveOrUpdate(raTraceOffers);
		System.out.println("Update Successfully.......");
		HibernateUtil.commitTransaction();
	}
	
	public RaTraceOffers loadSingleOffer(Integer offerId)
	{
		RaTraceOffers raTraceOffers=(RaTraceOffers)HibernateUtil.getSession().load(RaTraceOffers.class, offerId);
		return raTraceOffers;
	}
	public void deActiveTraderOffer(Integer offerId)
	{
		if(offerId>0)
		{
			RaTraceOffers raTraceOffers=(RaTraceOffers)HibernateUtil.getSession().load(RaTraceOffers.class, offerId);
			HibernateUtil.closeSession();
			HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			
			HibernateUtil.getSession().saveOrUpdate(raTraceOffers);
			HibernateUtil.commitTransaction();
		}
	}
	
}
