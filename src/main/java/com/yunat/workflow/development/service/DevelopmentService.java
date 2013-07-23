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

import com.yunat.workflow.development.domain.AttachmentDomain;
import com.yunat.workflow.development.domain.RuleDomain;
import com.yunat.workflow.development.domain.Ztree;

/**
 * <p>
 * 开发中心相关业务接口
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:39:59 PM
 */
public interface DevelopmentService {

	/**
	 * <p>
	 * 查询树接口
	 * </p>
	 * 
	 * @return
	 * @return: String
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 26, 2013 6:45:27 PM
	 */
	public List<Ztree> queryZtreeNode();

	/**
	 * <p>
	 * 增加树节点
	 * </p>
	 * 
	 * @param zt
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 3:33:04 PM
	 */
	public Ztree addZtreeNode(Ztree ztree);

	/**
	 * <p>
	 * 删除节点
	 * </p>
	 * 
	 * @param zt
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:16:18 PM
	 */
	public void deleteZtreeNode(Ztree ztree);

	/**
	 * <p>
	 * 修改节点名称
	 * </p>
	 * 
	 * @param ztree
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:39:09 PM
	 */
	public void renameZtreeNode(Ztree ztree);

	/**
	 * <p>
	 * 查询节点内容信息
	 * </p>
	 * 
	 * @param ztree
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:01:23 PM
	 */
	public Ztree queryZtreeNodeNodeContent(Ztree ztree);

	/**
	 * <p>
	 * 保存节点内容信息
	 * </p>
	 * 
	 * @param ztree
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:42:44 PM
	 */
	public void saveZtreeNodeContent(Ztree ztree);

	/**
	 * <p>
	 * 根据任务id查询附件信息
	 * </p>
	 * 
	 * @param task_id
	 * @return
	 * @return: List<Attachment>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 4:29:21 PM
	 */
	public List<AttachmentDomain> queryAttachmentByTaskId(String task_id);

	/**
	 * <p>
	 * 插入新附件信息
	 * </p>
	 * 
	 * @param attachment
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 5, 2013 4:55:40 PM
	 */
	public void insertAttachment(AttachmentDomain attachmentDomain);

	/**
	 * <p>
	 * 删除附件
	 * </p>
	 * 
	 * @param attachment
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 9, 2013 6:01:35 PM
	 */
	public void deleteAttachment(AttachmentDomain attachmentDomain);

	/**
	 * <p>
	 * 根据任务id查询附件信息
	 * </p>
	 * 
	 * @param task_id
	 * @return
	 * @return: List<Attachment>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 4:29:21 PM
	 */
	public List<RuleDomain> queryRuleByTaskId(String task_id);

	/**
	 * <p>
	 * 插入规则
	 * </p>
	 * 
	 * @param ruleDomain
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 5, 2013 4:55:40 PM
	 */
	public void insertRule(RuleDomain ruleDomain);

	/**
	 * <p>
	 * 删除规则
	 * </p>
	 * 
	 * @param ruleDomain
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 9, 2013 6:01:35 PM
	 */
	public void deleteRule(RuleDomain ruleDomain);

	/**
	 * <p>规则应用</p>
	 * 
	 * @param task_id
	 * @param script
	 * @return
	 * @return: String
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 11, 2013 10:16:36 AM
	 */
	public String ruleApply(String task_id, String script);
}
