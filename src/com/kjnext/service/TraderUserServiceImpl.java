package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.TraderUserDao;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;

public class TraderUserServiceImpl
{
	TraderUserDao traderUserDao=new TraderUserDao();
	public List<RaUserMaster> loadTraders(UserTo userTo)
	{
		List<RaUserMaster> traderList=traderUserDao.loadTrader(userTo);
		return traderList;
	}
	public void insertTraderUser(RaUserMaster raUserMaster)
	{
		traderUserDao.insertTraderUser(raUserMaster);
	}
	public void updatetraderUser(RaUserMaster raUserMaster)
	{
		traderUserDao.updateTraderUser(raUserMaster);
	}
	public RaUserMaster loadSingleUser(Integer userId)
	{
		return traderUserDao.loadSingleUser(userId);
	}
	public void deActiveTraders(Integer userId)
	{
		traderUserDao.deActiveTrader(userId);
	}
	public boolean isUserExist(RaUserMaster raUserMaster)
	{
		return traderUserDao.isUserExist(raUserMaster);
	}
	public void setUser(Integer userId)
	{
		
		traderUserDao.setUserPosition(userId);
		
	}

	
	
}
