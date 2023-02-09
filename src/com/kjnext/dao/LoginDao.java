package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.registry.infomodel.User;

import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.omg.PortableInterceptor.SUCCESSFUL;

//import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaTraceability;
import com.kjnext.hibernate.RaUserMaster;

import com.kjnext.utility.hibernate.HibernateUtil;

public class LoginDao {

	public boolean loginCheck(RaUserMaster users) {
		System.out.println(users.getLoginName());
		System.out.println(users.getPassword());
		List list = HibernateUtil.getSession().createCriteria(
				RaUserMaster.class).add(
				Expression.eq("loginName", users.getLoginName())).add(
				Expression.eq("password", users.getPassword())).add(
				Expression.eq("userStatus", "A")).list();

		List<RaUserMaster> listUsers = list;
		if (!listUsers.isEmpty()) {
			RaUserMaster users2 = listUsers.get(0);
			users.setUserId(users2.getUserId());
			return true;
		}
		return false;

	}

	public RaUserMaster loadUser(Integer userId) {
		RaUserMaster user = (RaUserMaster) HibernateUtil.getSession().load(
				RaUserMaster.class, userId);
		return user;
	}

	@SuppressWarnings("unchecked")
	public boolean checkMail(RaUserMaster raUserMaster) {

		System.out.println(raUserMaster.getEmail());
		List list = HibernateUtil.getSession().createCriteria(
				RaUserMaster.class).add(
				Expression.eq("email", raUserMaster.getEmail())).list();
		List<RaUserMaster> listUsers = list;
		System.out.println(listUsers);
		if (!listUsers.isEmpty()) {
			System.out.println("checkMail....email");
			RaUserMaster users = listUsers.get(0);
			raUserMaster.setPassword(users.getPassword());
			System.out.println(users.getEmail());
			System.out.println(users.getEmail());
			System.out.println(users.getPassword());
			return true;
		}
		System.out.println("not");
		return false;
	}

	public boolean isEmailExist(RaUserMaster raUserMaster) {
		// TODO Auto-generated method stub
		try {
			System.out.println("isExist");
			List<RaUserMaster> list = (ArrayList<RaUserMaster>) HibernateUtil
					.getSession().createCriteria(RaUserMaster.class).add(
							Expression.eq("email", raUserMaster.getEmail()))
					.list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
