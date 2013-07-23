/**
 * 文件名：RuleDAO.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 10, 2013 5:33:25 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.dao;

import java.util.List;

import com.yunat.workflow.development.pojo.Rule;

/**
 * <p>规则信息表</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 10, 2013 5:33:25 PM
 */
public interface RuleDAO {
	
	/**
	 * <p>查询该任务下的所有规则</p>
	 * 
	 * @param task_id
	 * @return
	 * @return: List<Rule>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 5:35:15 PM
	 */
	public List<Rule> queryRuleList(String task_id);
	
	/**
	 * 
	 * <p>增加规则</p>
	 * 
	 * @param rule
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 5:36:10 PM
	 */
	public void insertRule(Rule rule);
	
	/**
	 * <p>删除规则</p>
	 * 
	 * @param rule
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 5:36:47 PM
	 */
	public void deleteRule(Rule rule);
}
