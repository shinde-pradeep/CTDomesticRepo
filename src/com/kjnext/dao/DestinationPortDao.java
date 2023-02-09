package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaSellingRegion;

import com.kjnext.utility.hibernate.HibernateUtil;
import com.kjnext.hibernate.RaLoadPort;
public class DestinationPortDao {
	
//	 take from DB
	static List<RaDestinationPort> listDestinationPort = new ArrayList<RaDestinationPort>();
	static List<RaLoadPort> listPort = new ArrayList<RaLoadPort>();
	public List<RaDestinationPort> getDestinationPort() {
		
		List list=HibernateUtil.getSession().createCriteria(RaDestinationPort.class).list();
		listDestinationPort=list;
		return listDestinationPort;
	}
   public List<RaLoadPort> loadPort() {
		
		List list=HibernateUtil.getSession().createCriteria(RaLoadPort.class).list();
		listPort =list;
		return listPort;
	}
	
	
	// add to DB from Hibernate
	public void addPort(RaDestinationPort destinationport) {
		
		HibernateUtil.closeSession();
		HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		HibernateUtil.getSession().save(destinationport);
		HibernateUtil.commitTransaction();
	}
	
	 // updation in db

	 public void updateDestinationPort(RaDestinationPort destinationPort){
		    
		   
		    HibernateUtil.closeSession();
			HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			HibernateUtil.getSession().saveOrUpdate(destinationPort);
			HibernateUtil.commitTransaction();
			
		 }
	
	 public RaDestinationPort loadSingleDestinationPort(Integer destPortId)
	   {
		 return (RaDestinationPort)listDestinationPort.get(destPortId-1); 
		 
	   }
	
	 public void deActivePort(Integer destPortId)
		{
			if(destPortId>0)
			{
				RaDestinationPort destinationPort=(RaDestinationPort)HibernateUtil.getSession().load(RaDestinationPort.class, destPortId);
				destinationPort.setDestPortStatus("Deactive");
				HibernateUtil.getSession().update(destinationPort);
				HibernateUtil.commitTransaction();
			}
		}


	public boolean isPortExist(RaDestinationPort destinationPort2) {
		// TODO Auto-generated method stub
		try {

			List<RaDestinationPort> list = (ArrayList<RaDestinationPort>) HibernateUtil
					.getSession().createCriteria(RaDestinationPort.class).add(
							Expression.eq("destinationPort", destinationPort2
									.getDestinationPort())).list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}

