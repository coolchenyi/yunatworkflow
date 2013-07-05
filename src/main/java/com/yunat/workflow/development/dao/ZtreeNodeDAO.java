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
	
	/**
	 * <p>增加树节点，返回完整节点信息</p>
	 * 
	 * @return
	 * @return: ZtreeNode
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 3:40:29 PM
	 */
	public ZtreeNode addZtreeNode(ZtreeNode ztreeNode);
	
	/**
	 * <p>删除节点</p>
	 * 
	 * @param ztree
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:19:32 PM
	 */
	public void deleteZtreeNode(ZtreeNode ztreeNode);
	
	/**
	 * <p>修改节点名称</p>
	 * 
	 * @param ztreeNode
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:34:40 PM
	 */
	public void renameZtreeNode(ZtreeNode ztreeNode);
	
	/**
	 * <p>查询节点内容</p>
	 * 
	 * @return
	 * @return: ZtreeNode
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 1:53:13 PM
	 */
	public ZtreeNode queryZtreeNodeContent(ZtreeNode ztreeNode);
	
	
	/**
	 * <p>修改节点内容</p>
	 * 
	 * @param ztreeNode
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:40:47 PM
	 */
	public void updateZtreeNodeContent(ZtreeNode ztreeNode);
}
