package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.DestinationPortDao;
import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.utility.hibernate.HibernateUtil;
import com.kjnext.hibernate.RaLoadPort;
public class DestinationPortServiceImpl {

	DestinationPortDao destinationPortDao=new DestinationPortDao();
	
	
	public List<RaDestinationPort> getDestinationPortlist() {
		
		List<RaDestinationPort> destinationportlist=destinationPortDao.getDestinationPort();
		return destinationportlist;
		
      }
  public List<RaLoadPort> loadPort() {
		
		List<RaLoadPort> list=destinationPortDao.loadPort();
		return list;
		
      }

	
	public void addPortlist(RaDestinationPort destinationport) {
	
	   destinationPortDao.addPort(destinationport);
	}
	
	public void updateDestinationPortList(RaDestinationPort destinationPort){
		destinationPortDao.updateDestinationPort(destinationPort);
		
	}
	
	public RaDestinationPort loadSingleDestinationPort(Integer destPortId){
		return destinationPortDao.loadSingleDestinationPort(destPortId);
		
	}
	
	public void deActivePort(Integer destPortId)
	{
		destinationPortDao.deActivePort(destPortId);
	}

	public boolean isPortExist(RaDestinationPort destinationPort2) {
		// TODO Auto-generated method stub
		return destinationPortDao.isPortExist(destinationPort2);
	}
	
	
	
}
