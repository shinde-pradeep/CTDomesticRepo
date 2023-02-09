package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.SellingRegionDao;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaSellingRegion;

public class SellingRegionServiceImpl {
	SellingRegionDao regionDao=new SellingRegionDao();

	//RaSellingRegion sellingRegion=new RaSellingRegion();
	public List selectRecord()
	{
		List<RaSellingRegion> listRegion=regionDao.retriveRecord();
		return listRegion;
	}

	public int insertRecords(RaSellingRegion sellingRegion)
	{
		System.out.println(sellingRegion+"....Selling Region.........");
		return regionDao.insertRecord(sellingRegion);
	}

	public int updateRegion(RaSellingRegion sellingRegion)
	{
		return regionDao.updateRegion(sellingRegion);
	}

	public RaSellingRegion loadSingleRegion(Integer regionId)
	{
		return regionDao.loadSingleRegion(regionId);
	}

	public void deActiveRegions(Integer stateId)
	{
		regionDao.deActiveRegion(stateId);
	}

	public boolean isRegionExist(RaSellingRegion raRegion) {
		return regionDao.isRegionExist(raRegion);

	}
}
