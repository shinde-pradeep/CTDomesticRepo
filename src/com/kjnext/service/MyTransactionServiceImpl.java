package com.kjnext.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kjnext.dao.MyTransactionDao;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaOriginMaster;
import com.kjnext.hibernate.RaTraceability;
import com.kjnext.model.UserTo;

public class MyTransactionServiceImpl {
	MyTransactionDao myTransactionDao = new MyTransactionDao();

	List<RaTraceability> listTraceability;

	public List loadTraceability(UserTo userTo) {
		listTraceability = myTransactionDao.loadTraceability(userTo);

		return listTraceability;
	}
	public List loadTransactionReport(UserTo userTo) {
		listTraceability = myTransactionDao.loadTransactionReport(userTo);

		return listTraceability;
	}

	public List loadAchivedTransaction(UserTo userTo) {
		listTraceability = myTransactionDao.loadAchivedTransaction(userTo);

		return listTraceability;
	}
	public List loadTraceability1(UserTo userTo) {
		listTraceability = myTransactionDao.loadTraceability1(userTo);

		return listTraceability;
	}
	public List loadReport(UserTo userTo) {
		listTraceability = myTransactionDao.loadReport(userTo);

		return listTraceability;
	}

	public List loadAcievedTransaction(UserTo userTo) {
		listTraceability = myTransactionDao.loadAcievedTransaction(userTo);

		return listTraceability;
	}
	
	public void complete(Integer traceId)
	{
		myTransactionDao.complete(traceId);
	}


	public void insertRecords(RaTraceability raTraceability) {
		myTransactionDao.insertRecord(raTraceability);
	}
	public void updateTransactions(RaTraceability raTraceability)
	{
		myTransactionDao.updateRecord(raTraceability);
	}
	public List<RaTraceability> loadSingleTransactions(RaTraceability raTraceability ,Integer transactionId)
	{
		return myTransactionDao.loadSingleTransaction(raTraceability,transactionId);
	}
	public void deActiveTransactions(Integer traceId)
	{
		myTransactionDao.deActiveTransaction(traceId);
	}

}
