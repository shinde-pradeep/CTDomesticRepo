package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.TraderOfferDao;
import com.kjnext.dao.TraderUserDao;
import com.kjnext.hibernate.RaTraceOffers;

public class TraderOfferServiceImpl
{
	TraderOfferDao offerDao=new TraderOfferDao();
	public List<RaTraceOffers> loadOffers()
	{
		List<RaTraceOffers> traderList=offerDao.loadOffers();
		return traderList;
	}
	public void insertOffers(RaTraceOffers raTraceOffers)
	{
		offerDao.insertOffers(raTraceOffers);
	}
	public RaTraceOffers loadSingleTraderOffer(Integer offerId)
	{
		 return offerDao.loadSingleOffer(offerId);
	}
	public void updateOffers(RaTraceOffers raTraceOffers)
	{
		offerDao.updateOffers(raTraceOffers);
	}
	public void deActiveTraderOffers(Integer offerId)
	{
		offerDao.deActiveTraderOffer(offerId);
	}
}
