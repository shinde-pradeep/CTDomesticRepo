package com.kjnext.service;

import java.util.List;
import java.io.*;
import com.kjnext.dao.AllUsersDao;
import com.kjnext.hibernate.RaUserMaster;
//import com.kjnext.model.Product;
import com.kjnext.model.UserTo;

public class AllUserServiceImpl {
	
	
	AllUsersDao alluser=new AllUsersDao();

	public List<RaUserMaster> getUserList(UserTo userTo)
	{
		
		List<RaUserMaster> listuser=alluser.getUsers(userTo);
		System.out.println(listuser);
		return listuser;
		
	}
	
	public RaUserMaster loadSingleuser(Integer userId)
	{
		return alluser.LoadSingleUser(userId);
		
	}
	public void deActiveRecords(Integer userId)
	{
		alluser.deActiveUser(userId);
	}
	public void ActiveRecords(Integer userId)
	{
		alluser.ActiveUser(userId);
	}
	public void setUser(Integer userId)
	{
		
		alluser.setUserPosition(userId);
		
	}
	
	
	

}
