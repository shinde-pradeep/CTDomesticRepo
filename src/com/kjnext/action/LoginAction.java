package com.kjnext.action;
import java.util.List;

import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.kjnext.service.LoginServiceImpl;
import com.kjnext.hibernate.RaTraceOffers;
import com.kjnext.utility.hibernate.HibernateUtil;
public class LoginAction extends BaseAction {
	UserTo userTo;
	RaUserMaster raUserMaster;
	RaTraceOffers raTraceOffers;
	LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
	List<RaTraceOffers> listOffer;


	public String loginCheck() {
		if (userTo == null) {
			addActionError(getText("error.login"));
			return "error";
		}
		userTo = loginServiceImpl.getLoginDetail(userTo);

		if (userTo == null) {
			addActionError(getText("error.login"));
			return "error";
		}
		request.getSession().setMaxInactiveInterval(1800);
		session.put("UserInfo", userTo);
		session.put("UserName", userTo.getLoginName());
		if ("admin".equals(userTo.getUserType())) {
			return "admin";
		} else if ("traders".equals(userTo.getUserType())) {
			return "traders";
		} else if ("producers".equals(userTo.getUserType())) {
			return "producers";
		}

		addActionError(getText("error.login"));
		return "error";
	}
	

	/**
	 * Log off user
	 * 
	 * @return
	 */

	public String userLogOff() {

		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			((org.apache.struts2.dispatcher.SessionMap) session)
					.remove("UserInfo");
		}

		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
		}

		return SUCCESS;
	}

	public UserTo getUserTo() {
		return userTo;
	}

	public void setUserTo(UserTo userTo) {
		this.userTo = userTo;
	}
	
	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}


	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}
public String email;


	public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


	public String aa(){
		System.out.println("inside method");
		/*loginServiceImpl.checkMail(raUserMaster);
		System.out.println(raUserMaster.getLoginName());*/
		return "success";
	}
	public String checkEmail(){
		System.out.println(raUserMaster.getEmail());
		if(isEmailExist(raUserMaster)){
			System.out.println("login check....");
			loginServiceImpl.checkMail(raUserMaster);
			loginServiceImpl.sentMail(raUserMaster.getPassword());
			//return SUCCESS;
		}else{
		System.out.println("not available in db");
		addActionError(getText("error.notEmail.value"));
		return ERROR;
		}
		return SUCCESS;
	}


	private boolean isEmailExist(RaUserMaster raUserMaster) {
		// TODO Auto-generated method stub
		//return manageMasterServiceImpl.isProductExist(raProductMaster2);
		return loginServiceImpl.isEmailExist(raUserMaster);
	}
	public String loadGuestOffers()
	{
		listOffer=HibernateUtil.getSession().createCriteria(RaTraceOffers.class).list();
		if (!listOffer.isEmpty())
			return SUCCESS;
		return INPUT;
	}


	public RaTraceOffers getRaTraceOffers() {
		return raTraceOffers;
	}


	public void setRaTraceOffers(RaTraceOffers raTraceOffers) {
		this.raTraceOffers = raTraceOffers;
	}


	public List<RaTraceOffers> getListOffer() {
		return listOffer;
	}


	public void setListOffer(List<RaTraceOffers> listOffer) {
		this.listOffer = listOffer;
	}


	
	
	
}
