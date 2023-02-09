package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.StateDao;
import com.kjnext.hibernate.RaStateMaster;

public class StateServiceImpl 
{
	StateDao stateDao=new StateDao();
	public List<RaStateMaster> loadStates()
	{
		List<RaStateMaster> stateList=stateDao.loadState();
		return stateList;
	}
	public int insertStates(RaStateMaster stateMaster)
	{
		return stateDao.inserState(stateMaster);
	}
	public int updateStates(RaStateMaster stateMaster)
	{
		return stateDao.updateState(stateMaster);
	}
	public RaStateMaster loadSingleStates(Integer stateId)
	{
		return stateDao.loadSingleState(stateId);
	}
	public void deActiveStates(Integer stateId)
	{
		stateDao.deActiveState(stateId);
	}
	public boolean isStateExist(RaStateMaster raStateMaster)
	{
		return stateDao.isStateExist(raStateMaster);
	}
}
