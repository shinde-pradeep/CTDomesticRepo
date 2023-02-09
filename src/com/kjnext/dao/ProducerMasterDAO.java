package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.utility.hibernate.HibernateUtil;
import com.kjnext.hibernate.RaProducerDataUpload;
import com.kjnext.hibernate.RaProducerDataUploadId;
import com.kjnext.hibernate.RaProductMaster;
public class ProducerMasterDAO
{
	List<RaProducerMaster> produerList=new ArrayList<RaProducerMaster>();
	List<RaProducerDataUploadId> produerList1=new ArrayList<RaProducerDataUploadId>();
	List<RaProducerDataUpload> produerList2=new ArrayList<RaProducerDataUpload>();

	Integer prodID;
	public List<RaProducerMaster> loadProducer()
	{
		produerList=HibernateUtil.getSession().createCriteria(RaProducerMaster.class).list();
		return produerList;
	}
	public List<RaProducerDataUploadId> loadProducer1()
	{
		produerList1=HibernateUtil.getSession().createCriteria(RaProducerDataUploadId.class).list();
		return produerList1;
	}
	public List<RaProducerDataUpload> loadProducer2()
	{
		produerList2=HibernateUtil.getSession().createCriteria(RaProducerDataUpload.class).list();
		return produerList2;
	}
	public RaProducerMaster loadSingleProducer(Integer ProdId)
	{
		RaProducerMaster raProducerMaster= (RaProducerMaster) HibernateUtil
		.getSession().load(RaProducerMaster.class, ProdId);
		return raProducerMaster;
	}
	/* Insert data into table*/
	public int insertProducer(RaProducerMaster producerMaster,RaProducerDataUploadId raProducerDataUploadId)
	{
		
		//producerMaster.setProducerId(2);
		//RaProducerDataUpload raProducerDataUpload=new RaProducerDataUpload(raProducerDataUploadId,producerMaster);
		
		RaProducerDataUpload raProducerDataUpload=new RaProducerDataUpload(producerMaster,raProducerDataUploadId);
		
		HibernateUtil.closeSession();
	//	HibernateUtil.beginTransaction();
		Session session= HibernateUtil.getSession();
		//producerMaster=(RaProducerMaster)session.load(RaProducerMaster.class,ProdId);
		
		Transaction transaction=session.beginTransaction();
		//HibernateUtil.getSession().saveOrUpdate(producerMaster);
		
		session.saveOrUpdate(raProducerDataUpload);
	
		//session.saveOrUpdate(producerMaster);
		
		transaction.commit();
		
//		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		System.out.println("Producer inserted successfully......");
		return producerMaster.getProducerId();
	}
	public int insertProducer1(RaProducerMaster producerMaster)
	{
		//RaProducerDataUpload raProducerDataUpload=new RaProducerDataUpload(producerMaster,raProducerDataUploadId);
		
		HibernateUtil.closeSession();
		HibernateUtil.beginTransaction();
		HibernateUtil.getSession().save(producerMaster);
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		System.out.println("Producer inserted successfully......");
		return producerMaster.getProducerId();
	}
	}
