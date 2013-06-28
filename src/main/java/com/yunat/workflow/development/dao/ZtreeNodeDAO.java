package com.yunat.workflow.development.dao;

import java.util.List;

import com.yunat.workflow.development.pojo.ZtreeNode;

/**
 * <p>开发中心任务数相关DAO接口</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:18:59 PM
 */
public interface ZtreeNodeDAO {
	/**
	 * <p>获取整棵任务数</p>
	 * 
	 * @return
	 * @return: List<ZtreeNode>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 26, 2013 6:22:07 PM
	 */
	public List<ZtreeNode> queryZtreeNodeList();
}
