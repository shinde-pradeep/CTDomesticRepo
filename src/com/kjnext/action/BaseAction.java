package com.kjnext.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.utility.hibernate.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author kiran
 * The base class which will be extended by all action classes
 */
public abstract class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	protected Map<String,Object> session = null;
	protected HttpServletRequest request = null;
	String navigationFlg;
    public String getNavigationFlg() {
		return navigationFlg;
	}

	public void setNavigationFlg(String navigationFlg) {
		this.navigationFlg = navigationFlg;
	}

	/**
     * Sets the session
     */
	public void setSession(Map session){ 
		this.session = session;
	}
	
	/**
	 * 
	 * @return session
	 */
	public Map getSession() {
		 return session;
	}
	  /**
     * Sets the request
     */
	public void setServletRequest(HttpServletRequest request){ 
		this.request = request;
	}
	
	/**
	 * 
	 * @return request
	 */
	public HttpServletRequest getServletRequest() {
		 return request;
	}

}