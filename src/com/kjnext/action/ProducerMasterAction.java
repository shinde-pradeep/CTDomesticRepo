package com.kjnext.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import com.kjnext.excelRead.ParticipentProducerModel;
import com.kjnext.excelRead.ProducerUploadExcel;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.model.ParticipentProducerBusiness;
import com.kjnext.service.ProducerMasterServiceImpl;
//import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaProducerDataUpload;
import com.kjnext.hibernate.RaProducerDataUploadId;
public class ProducerMasterAction extends BaseAction
{
	ProducerMasterServiceImpl producerService=new ProducerMasterServiceImpl();
	List<RaProducerMaster> producerList;
	RaProducerMaster raProducerMaster;
	RaProducerDataUpload raProducerDataUpload;
	List<RaProducerDataUpload> producerinfoList;
	RaProducerDataUploadId raProducerDataUploadId;
	List<RaProducerDataUploadId> producerIdinfoList;
	private File exclFile;
	private String excelFile = null;
	    

	public File getExclFile() {
		return exclFile;
	}
	public void setExclFile(File exclFile) {
		this.exclFile = exclFile;
	}
	public String getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}
	
	public String loadProducer()
	{
		producerList=producerService.loadProducers();
		producerIdinfoList=producerService.loadProducerDataUploadId();
		producerinfoList=producerService.loadProducerDataUpload();
		if(!producerList.isEmpty())
		{
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String insertExcelData1()
	{
		raProducerDataUploadId=new RaProducerDataUploadId();
		producerService.readExcelSheet1(excelFile, raProducerMaster,raProducerDataUploadId);
		loadProducer();
		System.out.println("producer load.........");
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	public String insertExcelData()
	{   
		
		//raProducerDataUploadId=raProducerDataUpload.getId();
		//raProducerDataUpload.setId(raProducerDataUploadId);
		//raProducerMaster=raProducerDataUploadId.getRaProducerMaster();
		//raProducerDataUploadId.setRaProducerMaster(raProducerMaster);
		//raProducerDataUploadId=raProducerDataUpload.getId();
		
		//raProducerDataUpload=raProducerDataUpload.getId();
		 //raProducerDataUploadId=new RaProducerDataUploadId();
	//	 raProducerMaster=(RaProducerMaster)session.load(RaProducerMaster.class,raProducerMaster.getProducerId());
		// raProducerMaster=new RaProducerMaster(); 
		//raProducerDataUpload=new RaProducerDataUpload();
		//System.out.println(raProducerMaster.getProducerId());
		//raProducerMaster=producerService.loadSingleProducer(raProducerMaster.getProducerId());
		//System.out.println(raProducerDataUpload);
		//System.out.println(raProducerMaster);
				producerService.readExcelSheet(excelFile,raProducerMaster,raProducerDataUploadId);
		loadProducer();
		System.out.println("producer load.........");
		setNavigationFlg("success");
		return SUCCESS;
	}
	public String uploadExcel()
	{
		return SUCCESS;
	}
	
	public List<RaProducerMaster> getProducerList() {
		return producerList;
	}
	public void setProducerList(List<RaProducerMaster> producerList) {
		this.producerList = producerList;
	}
	public RaProducerMaster getRaProducerMaster() {
		return raProducerMaster;
	}
	public void setRaProducerMaster(RaProducerMaster raProducerMaster) {
		this.raProducerMaster = raProducerMaster;
	}
	public List<RaProducerDataUpload> getProducerinfoList() {
		return producerinfoList;
	}
	public void setProducerinfoList(List<RaProducerDataUpload> producerinfoList) {
		this.producerinfoList = producerinfoList;
	}
	public RaProducerDataUpload getRaProducerDataUpload() {
		return raProducerDataUpload;
	}
	public void setRaProducerDataUpload(
			RaProducerDataUpload raProducerDataUpload) {
		this.raProducerDataUpload = raProducerDataUpload;
	}
	public RaProducerDataUploadId getRaProducerDataUploadId() {
		return raProducerDataUploadId;
	}
	public void setRaProducerDataUploadId(
			RaProducerDataUploadId raProducerDataUploadId) {
		this.raProducerDataUploadId = raProducerDataUploadId;
	}
	public List<RaProducerDataUploadId> getProducerIdinfoList() {
		return producerIdinfoList;
	}
	public void setProducerIdinfoList(
			List<RaProducerDataUploadId> producerIdinfoList) {
		this.producerIdinfoList = producerIdinfoList;
	}
	
}
