package com.kjnext.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.Product;
import com.kjnext.model.UserTo;
import com.kjnext.service.AllUserServiceImpl;
import com.kjnext.service.ManageMasterServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AllUserAction extends BaseAction{
	
	
	 
		private static final long serialVersionUID = 1L;

		Map<String, String> mapMenu = null;
		Boolean flag;
		List<RaUserMaster> listUser = null;

		AllUserServiceImpl alluserServiceImpl = new AllUserServiceImpl();
		//System.out.println(alluserServiceImpl);
		RaUserMaster raUserMaster;
		String navigationFlg;
	
	
	
	public String loadUser() {
		return SUCCESS;
	}
	public Map<String, String> getMapMenu() {
		return mapMenu;
	}

	public void setMapMenu(Map<String, String> mapMenu) {
		this.mapMenu = mapMenu;
	}

	public String loadUsers() {
		
		UserTo userTo = (UserTo) session.get("UserInfo");
		
		String position=userTo.getPosition();
		System.out.println(position);
		flag=("administrator".equalsIgnoreCase(position));
		System.out.println(flag);
		listUser = alluserServiceImpl.getUserList(userTo);
		if ((!listUser.isEmpty())&&flag==true)
		{	
			return "admin";
		}
		else if((!listUser.isEmpty())&&flag==false)
			
		{	return "user";
		}
		return INPUT;
	}
	public String setPriamryUser()
	{
		alluserServiceImpl.setUser(raUserMaster.getUserId());
		loadUsers();
		
		return SUCCESS;
	}
	public List<RaUserMaster> getListUser() {
		return listUser;
	}
	public void setListUser(List<RaUserMaster> listUser) {
		this.listUser = listUser;
	}
	public String getNavigationFlg() {
		return navigationFlg;
	}
	public void setNavigationFlg(String navigationFlg) {
		this.navigationFlg = navigationFlg;
	}
	public RaUserMaster getRaUserMaster() {
		return raUserMaster;
	}
	public void setRaUserMaster(RaUserMaster raUserMaster) {
		this.raUserMaster = raUserMaster;
	}
	public String deActiveUser()
	{
		alluserServiceImpl.deActiveRecords(raUserMaster.getUserId());
		loadUsers();
		return SUCCESS;
	}
	public String ActiveUser()
	{
		alluserServiceImpl.ActiveRecords(raUserMaster.getUserId());
		loadUsers();
		return SUCCESS;
	}
	
	public String SendUserNotificationInput()
	{
		raUserMaster=alluserServiceImpl.loadSingleuser(raUserMaster.getUserId());
		navigationFlg="SUCCESS";
		
	    return SUCCESS;
	}
	
	
	

	
	
	
	
	
	
}
