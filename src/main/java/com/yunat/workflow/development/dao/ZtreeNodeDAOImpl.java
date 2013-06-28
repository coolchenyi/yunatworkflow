package com.yunat.workflow.development.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunat.workflow.development.pojo.ZtreeNode;

/**
 * 
 * <p>开发中心任务数相关DAO接口实现</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:18:27 PM
 */
@Repository
public class ZtreeNodeDAOImpl implements ZtreeNodeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <p>获取整棵任务数现实</p>
	 * 
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#queryZtreeNodeList()
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 26, 2013 6:25:25 PM
	 */
	public List<ZtreeNode> queryZtreeNodeList() {
		Session session = sessionFactory.getCurrentSession();
		List<ZtreeNode> ztreeNodeList = session.createQuery("from ZtreeNode").list();
		return ztreeNodeList;
	}

}
