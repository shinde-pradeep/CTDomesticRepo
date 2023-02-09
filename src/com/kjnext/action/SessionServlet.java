package com.kjnext.action;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.kjnext.utility.hibernate.HibernateUtil;

public class SessionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SessionServlet() {
		super();
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException 
	{
		HibernateUtil.getSession();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
}
