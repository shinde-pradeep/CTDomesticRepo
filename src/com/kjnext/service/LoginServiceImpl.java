package com.kjnext.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.kjnext.dao.LoginDao;
import com.kjnext.hibernate.RaUserMaster;

import com.kjnext.model.UserTo;
import com.kjnext.utility.email.SendEmail;

public class LoginServiceImpl {
	LoginDao loginDao = new LoginDao();

	public UserTo getLoginDetail(UserTo userTo) {
		try {
			System.out.println("service --"+userTo.getLoginName());
			System.out.println("service "+userTo.getPassword());
			RaUserMaster users = new RaUserMaster();
			BeanUtils.copyProperties(users, userTo);
			if (loginDao.loginCheck(users)) {
				BeanUtils.copyProperties(userTo,loginDao.loadUser(users.getUserId()));
				return userTo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkMail(RaUserMaster raUserMaster) {
		 return loginDao.checkMail(raUserMaster);
	}
	public String sentMail(String password){
		 try {
	            System.out.println("Preparing to send email.");

	            //
	            //Prepare Our Mail Message
	            //
	            SendEmail ed1 = new SendEmail();
	            System.out.println("sendemail.......cls");
	            //Update the to/cc/bcc/from email addresseses. Note that the to, cc, and bcc
	            //methods can take a command separated list.
	            ed1.setTo("ashwinid111@gmail.com");
	            System.out.println("password.."+password);
	            //ed.setCC("nchopra@eximware.com");
	            //ed.setBCC("nchopra@eximware.com");
	            ed1.setFrom("ashwini@kjnext.com", "ashu Digrase");
	            ed1.setReplyTo("ashwini@kjnext.com", "Reply To Me");
	            ed1.setPriority("1");
	            ed1.setSubject("Test Message Subject");
	            ed1.setBody("Your  passord is  " +password+ " Now you can login with this password::" );
	            //Add the file attachment. Make sure this file exists for your testing.
	           // ed.addFileAttachment("c:\\temp\\attachment.txt");
	           // ed.addFileAttachment("c:\\temp\\Template For Mockup.doc");
	            //ed.addFileAttachment("c:\\temp\\TestReqForInfo.java");
	           // ed.addFileAttachment("c:\\temp\\TLM_Coffee_SAMPLING.pdf");
	           //Set the SMTP host to use to relay the message, and if it requires
	            //smtp authentication then also specify the username and password.
	            //ed.setSMTPHost("smtp.kjnext.com");    
	            ed1.setSMTPHost("mail.kjnext.com", "ashwini@kjnext.com", "kjnext123");
	            ed1.sendMsg();            
	            System.out.println("Test message sent.");
	            //log.info("Test message sent.");
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return password;
	}

	public boolean isEmailExist(RaUserMaster raUserMaster) {
		// TODO Auto-generated method stub
		return loginDao.isEmailExist(raUserMaster);
	}
}
