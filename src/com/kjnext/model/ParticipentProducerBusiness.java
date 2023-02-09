package com.kjnext.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ParticipentProducerBusiness 
{

	 public ParticipentProducerBusiness()
     {

     }

     private String[] cert_year;
     private String[] company_name;
     private String[] farm_name;
     private String[] certification_exp;
     private String[] total_area;
     private String[]  area_in_prod;
     private String[] latitude;
     private String[] longitude;
     private String[] prod_total;
     private String[] country;
     private String[] producer_con_name;
     private String[] email;
     private String[] certification_no;
     private String[] failureReason;
     private String[] productType;
	public String[] getArea_in_prod() {
		return area_in_prod;
	}
	public void setArea_in_prod(String[] area_in_prod) {
		this.area_in_prod = area_in_prod;
	}
	public String[] getCert_year() {
		return cert_year;
	}
	public void setCert_year(String[] cert_year) {
		this.cert_year = cert_year;
	}
	public String[] getCertification_exp() {
		return certification_exp;
	}
	public void setCertification_exp(String[] certification_exp) {
		this.certification_exp = certification_exp;
	}
	public String[] getCertification_no() {
		return certification_no;
	}
	public void setCertification_no(String[] certification_no) {
		this.certification_no = certification_no;
	}
	public String[] getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String[] company_name) {
		this.company_name = company_name;
	}
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public String[] getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String[] failureReason) {
		this.failureReason = failureReason;
	}
	public String[] getFarm_name() {
		return farm_name;
	}
	public void setFarm_name(String[] farm_name) {
		this.farm_name = farm_name;
	}
	public String[] getLatitude() {
		return latitude;
	}
	public void setLatitude(String[] latitude) {
		this.latitude = latitude;
	}
	public String[] getLongitude() {
		return longitude;
	}
	public void setLongitude(String[] longitude) {
		this.longitude = longitude;
	}
	public String[] getProd_total() {
		return prod_total;
	}
	public void setProd_total(String[] prod_total) {
		this.prod_total = prod_total;
	}
	public String[] getProducer_con_name() {
		return producer_con_name;
	}
	public void setProducer_con_name(String[] producer_con_name) {
		this.producer_con_name = producer_con_name;
	}
	public String[] getProductType() {
		return productType;
	}
	public void setProductType(String[] productType) {
		this.productType = productType;
	}
	public String[] getTotal_area() {
		return total_area;
	}
	public void setTotal_area(String[] total_area) {
		this.total_area = total_area;
	}
     
	//::::::::::::::::::::::::::::::::::::
			/* public String  storeUploadedFile(File file) throws Exception{
		         String filePath = null;
		         if(file.getName() == null)
		         {
		           return "";
		         }
		         //String fileName="/com/eximware/RA/common/dao/db.properties";
		         try{
		               InputStream is=getClass().getResourceAsStream(fileName);
		               Properties properties=new Properties();
		               properties.load(is);
		               String uploadDir = ResourceProperties.getInstance().getProperty("uploadDir");
		               InputStream uploadInStream = file.getInputStream();
		               String filename = file.getFileName();
		               String path = uploadDir.substring(uploadDir.lastIndexOf("\\")+1);
		               filePath = path+"/"+ filename;
		               FileOutputStream fOut = new FileOutputStream(uploadDir+"\\"+ filename);
		               int c=0;
		               while ( (c= uploadInStream.read()) != -1) {
		                     fOut.write(c);
		               } // while
		               fOut.flush();
		               fOut.close();
		         }catch(Exception e) {
		             e.printStackTrace();
		             throw new Exception ("Error while saving uploaded file. please try again.");
		         }
		         return filePath;
		}
		*//**
			 *   If user has not selected file on edit option of registration than
			 *     date that file
			 * @param filename
			 *//*
		
			public void deleteUploadedFile(String filename) throws Exception
			{
					  //String fileName="/com/eximware/RA/common/dao/db.properties";
					  try{
							InputStream is  = getClass().getResourceAsStream(fileName);
							Properties properties=new Properties();
							properties.load(is);
							String uploadDir = ResourceProperties.getInstance().getProperty("uploadDir");
							File fileObj = new File(uploadDir+"\\"+ filename.substring((filename.indexOf("/")+1)));
							fileObj.delete();
					  }catch(Exception ex) {
						ex.printStackTrace();
		              throw new Exception("Error while removing file from hard drive. please try agian.");
		           }
		}*/
}
