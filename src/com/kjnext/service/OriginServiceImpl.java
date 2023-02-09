package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.OriginDao;
import com.kjnext.hibernate.RaOriginMaster;

public class OriginServiceImpl {

	OriginDao originDao=new OriginDao();
	
	public List<RaOriginMaster> getOriginList()
	{
		List<RaOriginMaster> list=originDao.getOrigin();
		return list;
		
	}
	
	public void addOriginList(RaOriginMaster raOriginMaster)
	{
		originDao.addOrigin(raOriginMaster);
		
	}
	
	public void updateOriginList(RaOriginMaster raOriginMaster)
	{
		originDao.updateOrigin(raOriginMaster);
		
	}
	
	public RaOriginMaster loadSingleOrigin(Integer originId)
	{
		return (RaOriginMaster)originDao.loadSingleOrigin(originId);
		
	}
	
	public void deActiveOrigin(Integer originId)
	{
		originDao.deActiveOrigin(originId);
	}

	public boolean isOriginExist(RaOriginMaster raOriginMaster2) {
		// TODO Auto-generated method stub
		return originDao.isOriginExist(raOriginMaster2);
	}
	
}
