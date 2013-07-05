/**
 * 文件名：DevelopMentService.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 26, 2013 6:39:59 PM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.service;

import java.util.List;

import com.yunat.workflow.development.domain.Ztree;

/**
 * <p>开发中心相关业务接口</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:39:59 PM
 */
public interface DevelopmentService {

	/**
	 * <p>查询树接口</p>
	 * 
	 * @return
	 * @return: String
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 26, 2013 6:45:27 PM
	 */
	public List<Ztree> queryZtreeNode();
	
	/**
	 * <p>增加树节点</p>
	 * 
	 * @param zt
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 3:33:04 PM
	 */
	public Ztree addZtreeNode(Ztree ztree);
	
	/**
	 * <p>删除节点</p>
	 * 
	 * @param zt
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:16:18 PM
	 */
	public void deleteZtreeNode(Ztree ztree);
	
	/**
	 * <p>修改节点名称</p>
	 * 
	 * @param ztree
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:39:09 PM
	 */
	public void renameZtreeNode(Ztree ztree);
	
	/**
	 * <p>查询节点内容信息</p>
	 * 
	 * @param ztree
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:01:23 PM
	 */
	public Ztree queryZtreeNodeNodeContent(Ztree ztree);
	
	/**
	 * <p>保存节点内容信息</p>
	 * 
	 * @param ztree
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:42:44 PM
	 */
	public void saveZtreeNodeContent(Ztree ztree);
}
