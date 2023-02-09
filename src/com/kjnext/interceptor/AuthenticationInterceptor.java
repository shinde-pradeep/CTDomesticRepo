package com.kjnext.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.UserTo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor  implements Interceptor {

	private static final long serialVersionUID = 108L;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		System.out.println("AuthenticationInterceptor :intercept(ActionInvocation) ");

		UserTo user = null;

		System.out.println("USER Action Name :"+ actionInvocation.getInvocationContext().getName());

		Map session = actionInvocation.getInvocationContext().getSession();
		
		HttpServletRequest request = (HttpServletRequest) actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
	
		if (session != null &&!session.isEmpty() ) {
			
			user = (UserTo) session.get("UserInfo");
		}
		else {System.out.println("session is null .. not able to get userInfo object");
			ValidationAware action = (ValidationAware)actionInvocation.getAction();
			action.getActionErrors().clear();
			action.addActionError(((ActionSupport)actionInvocation.getAction()).getText("login.errormsg.sessionExpire") );
			return "login";
		}
		// Authentication
		boolean isAuthenticated = false;
		boolean isAuthorised = false;
		
		
		if (user != null) {
			/*if (logger.isInfoEnabled()) {
				logger.info("USER ACL List :" + user.getUserAcl());
			}*/
			isAuthenticated = true;
			isAuthorised=true;
			/**
			 *  Modification done for giving ACL to Manage Masters by Kiran Digrase, the ACL will be given to the specific 
			 *  user according to it's ACTION_TYPE.
			 *  ACTION_TYPE is maintained in both REQUEST & SESSION and used accordingly.
			 */
			/*
			if (user.getUserAcl() != null) {
				
				if((request!=null && request.getParameter(CommonConstants.ACTION_TYPE)!=null && !request.getParameter(CommonConstants.ACTION_TYPE).trim().equals("")) 
						|| (session!=null && session.get(CommonConstants.ACTION_TYPE)!=null && !session.get(CommonConstants.ACTION_TYPE).equals("")))
				{
					isAuthorised = user.getUserAcl().contains(request.getParameter(CommonConstants.ACTION_TYPE) == null ? session.get(CommonConstants.ACTION_TYPE):request.getParameter(CommonConstants.ACTION_TYPE));					
				}else{
					isAuthorised = user.getUserAcl().contains(actionInvocation.getInvocationContext().getName());				
				}				
			}*/
			//Map contextParameters = actionInvocation.getInvocationContext().getParameters();
			
			//if(user.getPreferredLanguageCode() != null && !user.getPreferredLanguageCode().trim().equals("")){
			//	contextParameters.put("request_locale", user.getPreferredLanguageCode().trim());
			//}

		}

		if (!isAuthenticated){ System.out.println("Authentication interceptors me error hai...session me userInfo nahi hai");
			return "login";
		}
		
		if (!isAuthorised) {
			 System.out.println("Authentication interceptors me error hai...session me userInfo nahi hai");
			return "unauthorized";
		} else {
			return actionInvocation.invoke();
		}

	}

}
