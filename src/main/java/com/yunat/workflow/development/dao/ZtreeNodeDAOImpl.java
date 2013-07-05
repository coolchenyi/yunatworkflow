package com.yunat.workflow.development.dao;

import java.util.List;

import org.hibernate.Query;
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

	/**
	 * <p>增加树节点，返回完整节点信息</p>
	 * 
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#addZtreeNode()
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 3:41:13 PM
	 */
	public ZtreeNode addZtreeNode(ZtreeNode ztreeNode) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ztreeNode);
		ZtreeNode newZtreeNode = (ZtreeNode) session.load(ZtreeNode.class,ztreeNode.getId());
		return newZtreeNode;
	}

	/**
	 * 
	 * <p>删除节点</p>
	 * <p>1.删除本节点</p>
	 * <p>2.删除以本节点为父节点的所有节点</p>
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#deleteZtreeNode(com.yunat.workflow.development.pojo.ZtreeNode)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 6:20:22 PM
	 */
	public void deleteZtreeNode(ZtreeNode ztreeNode){
		Session session = sessionFactory.getCurrentSession();
		Query delete = session.createQuery("delete from ZtreeNode t where t.id=:id");
		delete.setParameter("id", ztreeNode.getId());
		delete.executeUpdate();
		Query delete2 = session.createQuery("delete from ZtreeNode t where t.pid=:pid");
		delete2.setParameter("pid", ztreeNode.getId());
		delete2.executeUpdate();
	}
	
	/**
	 * <p>修改节点名称</p>
	 * 
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#renameZtreeNode(com.yunat.workflow.development.pojo.ZtreeNode)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 6:35:15 PM
	 */
	public void renameZtreeNode(ZtreeNode ztreeNode){
		Session session = sessionFactory.getCurrentSession();
		Query update = session.createQuery("update ZtreeNode t set t.name=:name where t.id=:id");
		update.setParameter("name", ztreeNode.getName());
		update.setParameter("id", ztreeNode.getId());
		update.executeUpdate();
	}

	/**
	 * <p>查询节点内容</p>
	 * 
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#queryZtreeContent()
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 1, 2013 1:53:35 PM
	 */
	public ZtreeNode queryZtreeNodeContent(ZtreeNode ztreeNode) {
		Session session = sessionFactory.getCurrentSession();
		ZtreeNode zn = (ZtreeNode)session.get(ZtreeNode.class, ztreeNode.getId());
		return zn;
	}

	/**
	 * <p>修改节点内容</p>
	 * 
	 * @see com.yunat.workflow.development.dao.ZtreeNodeDAO#updateZtreeNodeContent(com.yunat.workflow.development.pojo.ZtreeNode)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 1, 2013 2:41:29 PM
	 */
	public void updateZtreeNodeContent(ZtreeNode ztreeNode) {
		Session session = sessionFactory.getCurrentSession();
		Query update = session.createQuery("update ZtreeNode t set t.content=:content where t.id=:id");
		update.setParameter("content", ztreeNode.getContent());
		update.setParameter("id", ztreeNode.getId());
		update.executeUpdate();
	}
}
