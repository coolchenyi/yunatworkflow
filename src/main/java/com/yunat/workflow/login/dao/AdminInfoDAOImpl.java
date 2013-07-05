package com.yunat.workflow.login.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunat.workflow.login.pojo.AdminInfo;

@Repository
public class AdminInfoDAOImpl implements AdminInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public AdminInfo getAdminInfo(String username) {
		AdminInfo admin = (AdminInfo) sessionFactory.getCurrentSession().get(
				AdminInfo.class, username);
		return admin;
	}
	
	public void addAdminInfo(AdminInfo adminInfo){
	}

}
