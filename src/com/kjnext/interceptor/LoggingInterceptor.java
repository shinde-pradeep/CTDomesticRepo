package com.kjnext.interceptor;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class LoggingInterceptor implements Interceptor {
	
	private static final long serialVersionUID = 106L;
	
	private static Logger logger = Logger.getLogger(LoggingInterceptor.class);

	public void destroy() {
		logger.debug("destroy");
	}

	public void init() {
		logger.debug("init");

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Enter LoggingInterceptor invoking " + invocation.getAction().getClass().getName() + "." + invocation.getInvocationContext().getName());
		
		String result = null;
		try {
			result = invocation.invoke();
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error("LoggingInterceptor caught error " + e.getMessage(), e);
			ServletActionContext.getRequest().setAttribute("com.project.customization.applicationError.exception",
					e);
			return "applicationError";
		}
		System.out.println("Exit LoggingInterceptor from " + invocation.getAction().getClass().getName() + "." + invocation.getInvocationContext().getName());
		return result;
	}

}
