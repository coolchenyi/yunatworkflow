/**
 * 文件名：RuleDAOImpl.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 10, 2013 5:39:27 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunat.workflow.development.pojo.Rule;

/**
 * <p>规则信息表</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 10, 2013 5:39:27 PM
 */
@Repository
public class RuleDAOImpl implements RuleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <p>查询所有规则</p>
	 * 
	 * @see com.yunat.workflow.development.dao.RuleDAO#queryRuleList(java.lang.String)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:39:27 PM
	 */
	@Override
	public List<Rule> queryRuleList(String task_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Rule t where t.task_id=:task_id");
		query.setParameter("task_id", task_id);
		List<Rule> list= query.list();
		return list;
	}

	/**
	 * <p>增加规则</p>
	 * 
	 * @see com.yunat.workflow.development.dao.RuleDAO#insertRule(com.yunat.workflow.development.pojo.Rule)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:39:27 PM
	 */
	@Override
	public void insertRule(Rule rule) {
		Session session = sessionFactory.getCurrentSession();
		session.save(rule);
	}

	/**
	 * <p>删除规则</p>
	 * 
	 * @see com.yunat.workflow.development.dao.RuleDAO#deleteRule(com.yunat.workflow.development.pojo.Rule)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:39:27 PM
	 */
	@Override
	public void deleteRule(Rule rule) {
		Session session = sessionFactory.getCurrentSession();
		Query delete = session.createQuery("delete from Rule t where t.rid=:rid");
		delete.setParameter("rid", rule.getRid());
		delete.executeUpdate();
	}

}
