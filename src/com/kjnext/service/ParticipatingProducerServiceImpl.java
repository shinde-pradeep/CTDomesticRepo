package com.kjnext.service;
import java.util.ArrayList;
import java.util.List;
import com.kjnext.dao.ParticipitingProducerDao;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.model.UserTo;
import com.kjnext.hibernate.RaTraceability;
public class ParticipatingProducerServiceImpl {
	
	
	ParticipitingProducerDao allproducer=new ParticipitingProducerDao();
	static List<RaProducerMaster> listproducer=new ArrayList<RaProducerMaster>();
	
	//List<RaTraceability> listTransaction = null;
	static List<RaTraceability> listTransaction =new ArrayList<RaTraceability>();

	
	public List<RaProducerMaster> getProducerList()
	{
		
		
		List list= allproducer.getProducers();
		listproducer=list;
		System.out.println(listproducer);
		return listproducer;
		
	}
	public List<RaProducerMaster> getProducerUser(UserTo userTo)
	{
		
		
		List list= allproducer.getProducerUser(userTo);
		listproducer=list;
		System.out.println(listproducer);
		return listproducer;
		
	}
	
	public List<RaProducerMaster> loadProducersReport()
	{
		
		
		List list= allproducer.loadProducersReport();
		listproducer=list;
		System.out.println(listproducer);
		return listproducer;
		
	}
	public List<RaTraceability> ProducersTransaction(UserTo userTo)
	{
		
		
		List<RaTraceability>  list= allproducer.ProducersTransaction(userTo);
		listTransaction =list;
		System.out.println(listTransaction );
		return listTransaction ;
		
	}
	public void ActiveRecords(Integer producerId)
	{
		allproducer.Active(producerId);
	}
	public void deActiveRecords(Integer producerId)
	{
		allproducer.deActive(producerId);
	}
	
	
	

}
