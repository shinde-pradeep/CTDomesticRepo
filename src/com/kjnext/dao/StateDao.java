package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaSellingRegion;
import com.kjnext.hibernate.RaStateMaster;
import com.kjnext.utility.hibernate.HibernateUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class StateDao
{
	List<RaStateMaster> stateList=new ArrayList<RaStateMaster>();
	/* load table data...*/
	public List<RaStateMaster> loadState()
	{
		List list=HibernateUtil.getSession().createCriteria(RaStateMaster.class).list();
		 stateList=list;
		 return stateList;
	}
	/* insert data into table*/
	public int inserState(RaStateMaster stateMaster)
	{
		System.out.println("insert state......");
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.save(stateMaster);
		System.out.println("State inserted successfully....");
		HibernateUtil.commitTransaction();
		return stateMaster.getStateId();
	}
	/* update data of table */
	public int updateState(RaStateMaster stateMaster)
	{
		
		HibernateUtil.closeSession();
		Session session=HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		session.saveOrUpdate(stateMaster);
		System.out.println("State updated successfully...");
		HibernateUtil.commitTransaction();
		return stateMaster.getStateId();
	}
	
	/* load single data of table */
	public RaStateMaster loadSingleState(Integer stateId)
	{
		System.out.println(stateId+"State ID");
		RaStateMaster stateMaster=(RaStateMaster)HibernateUtil.getSession().load(RaStateMaster.class, stateId);
		return stateMaster;
	}
	
	/* Deactive data*/
	public void deActiveState(Integer stateId)
	{
		if(stateId>0)
		{
			RaStateMaster stateMaster=(RaStateMaster)HibernateUtil.getSession().load(RaStateMaster.class, stateId);
			stateMaster.setStateStatus("Deactive");
			HibernateUtil.getSession().update(stateMaster);
			HibernateUtil.commitTransaction();
		}
	}
	public boolean isStateExist(RaStateMaster raMaster)
	{
		try {

			List<RaStateMaster> list = (ArrayList<RaStateMaster>) HibernateUtil
					.getSession().createCriteria(RaStateMaster.class).add(
							Expression.eq("stateType", raMaster
									.getStateType())).list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
		
}
