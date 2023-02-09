package com.kjnext.service;

import java.util.List;
import java.security.SecureRandom;
import com.kjnext.dao.CompanyRegisterDao;
import com.kjnext.hibernate.RaCompanyBussiness;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.model.RegisterCompany;
import com.kjnext.utility.email.SendEmail;

public class CompanyRegisterService {
	CompanyRegisterDao companyRegisterDao = new CompanyRegisterDao();
	RegisterCompany registerCompany;
	
	public List<RaCompanyMaster> loadCompanys() {
		List<RaCompanyMaster> listCompany = companyRegisterDao.loadCompany();
		return listCompany;
	}

	public void insertRecord(RaCompanyMaster raCompanyMaster) {
		companyRegisterDao.insertRecords(raCompanyMaster);
	}

	public void insertCompany_Business(RaCompanyBussiness raCompanyBussiness) {
		companyRegisterDao.insertCompan_Bussiness(raCompanyBussiness);
	}

	public void insertCompany_Product(RaCompanyProduct raCompanyProduct) {
		companyRegisterDao.insertCompany_Product(raCompanyProduct);
	}
	/*****generate random String for Password******/
	private static final String ALLOWED_PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!&$%*";  
	   
	public static String generatePassword( int length )  
	{  
	    SecureRandom rng = new SecureRandom();  
	    StringBuffer result = new StringBuffer();  
	   
	    for( int i=0; i<length; i++ )  
	    {  
	        result.append( ALLOWED_PASSWORD_CHARS.charAt(  
	                                rng.nextInt( ALLOWED_PASSWORD_CHARS.length() ) ) );  
	    }  
	   System.out.println(result.toString());
	    return result.toString();  
	}  
	/**********************************/
	public void sendMail(RaCompanyMaster raCompanyMaster) {
		try {
			System.out.println("Preparing to send email.");

			// Prepare Our Mail Message

			SendEmail ed = new SendEmail();

			// Update the to/cc/bcc/from email addresseses. Note that the to,
			// cc, and bcc
			// methods can take a command separated list.
			ed.setTo(raCompanyMaster.getPriEmail());
			
			//ed.setCC("nchopra@eximware.com");
			// ed.setBCC("nchopra@eximware.com");
			ed.setFrom("narendrakumar@kjnext.com", "Narendra");
			ed.setReplyTo("narendrakumar@kjnext.com", "Reply To Me");
			ed.setPriority("1");
			ed.setSubject("Register successfully");
			ed.setBody("Provided password for login."+raCompanyMaster.getPassWord());
			// Add the file attachment. Make sure this file exists for your
			// testing.
			// ed.addFileAttachment("c:\\temp\\attachment.txt");
			// ed.addFileAttachment("c:\\temp\\Template For Mockup.doc");
			// ed.addFileAttachment("c:\\temp\\TestReqForInfo.java");
			// ed.addFileAttachment("c:\\temp\\TLM_Coffee_SAMPLING.pdf");

			// Set the SMTP host to use to relay the message, and if it requires
			// smtp authentication then also specify the username and password.
			// ed.setSMTPHost("smtp.kjnext.com");
			ed.setSMTPHost("mail.kjnext.com", "narendrakumar@kjnext.com", "kjnext123");
			
			System.out.println(raCompanyMaster.getPassWord()+"....password....");
			ed.sendMsg();
			
			System.out.println("Test message sent.");
			//log.info("Test message sent.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** ********** */
	public void updateRecord(RaCompanyMaster raCompanyMaster) {
		companyRegisterDao.updateRecords(raCompanyMaster);
	}

	public RaCompanyMaster loadSingleCompanys(Integer companyId) {
		return companyRegisterDao.loadSingleCompany(companyId);
	}

	public void deleteCompanys(Integer companyId) {
		companyRegisterDao.deleteCompany(companyId);
	}
}
