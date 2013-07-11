/**
 * 文件名：DevelopmentServiceImpl.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 26, 2013 6:44:44 PM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yunat.workflow.development.dao.AttachmentDAO;
import com.yunat.workflow.development.dao.RuleDAO;
import com.yunat.workflow.development.dao.ZtreeNodeDAO;
import com.yunat.workflow.development.domain.AttachmentDomain;
import com.yunat.workflow.development.domain.RuleDomain;
import com.yunat.workflow.development.domain.Ztree;
import com.yunat.workflow.development.pojo.Attachment;
import com.yunat.workflow.development.pojo.Rule;
import com.yunat.workflow.development.pojo.ZtreeNode;

/**
 * <p>
 * 开发中心相关业务接口实现
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:44:44 PM
 */
@Service
public class DevelopmentServiceImpl implements DevelopmentService {
	
	@Autowired
	private ZtreeNodeDAO ztreeNodeDAO;
	
	@Autowired
	private AttachmentDAO attachmentDAO;
	
	@Autowired
	private RuleDAO ruleDAO;

	/**
	 * <p>
	 * 查询树接口实现
	 * </p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#queryZtreeNodeList()
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 26, 2013 6:44:44 PM
	 */
	@Transactional
	public List<Ztree> queryZtreeNode() {
		List<ZtreeNode> ztreeNodeList = ztreeNodeDAO.queryZtreeNodeList();
		List<Ztree> ztreeList = new ArrayList<Ztree>();
		for(ZtreeNode zn:ztreeNodeList){
			Ztree zt =new Ztree();
			zt.setId(zn.getId());
			zt.setpId(zn.getPid());
			zt.setName(zn.getName());
			if(zn.getType().equals("folder")){
				zt.setIsParent("true");
			}else{
				zt.setIsParent("false");
			}
			zt.setTaskId(zn.getTask_id());
			ztreeList.add(zt);
		}
		return ztreeList;
	}

	/**
	 * <p>增加树节点</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#addZtreeNode(com.yunat.workflow.development.domain.Ztree)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 3:33:41 PM
	 */
	@Transactional
	public Ztree addZtreeNode(Ztree ztree) {
		ZtreeNode zn = new ZtreeNode();
		zn.setPid(ztree.getpId());
		if(ztree.getIsParent().equals("true")){
			zn.setType("folder");
		}else{
			zn.setType(ztree.getName().substring(ztree.getName().lastIndexOf(".")+1));
		}
		zn.setName(ztree.getName());
		zn.setId(UUID.randomUUID().toString().replace("-", ""));
		if(StringUtils.isEmpty(ztree.getTaskId())){
			zn.setTask_id(zn.getId());
		}else{
			zn.setTask_id(ztree.getTaskId());
		}
		zn = ztreeNodeDAO.addZtreeNode(zn);
		
		Ztree zt =new Ztree();
		zt.setId(zn.getId());
		zt.setpId(zn.getPid());
		zt.setName(zn.getName());
		if(zn.getType().equals("folder")){
			zt.setIsParent("true");
		}else{
			zt.setIsParent("false");
		}
		zt.setTaskId(zn.getTask_id());
		
		return zt;
	}
	
	/**
	 * <p>删除节点</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#deleteZtreeNode(com.yunat.workflow.development.domain.Ztree)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 6:16:54 PM
	 */
	@Transactional
	public void deleteZtreeNode(Ztree ztree){
		ZtreeNode zn = new ZtreeNode();
		zn.setId(ztree.getId());
		ztreeNodeDAO.deleteZtreeNode(zn);
	}

	/**
	 * <p>修改节点名称</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#renameZtreeNode(com.yunat.workflow.development.domain.Ztree)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jun 28, 2013 6:39:41 PM
	 */
	@Transactional
	public void renameZtreeNode(Ztree ztree){
		ZtreeNode zn = new ZtreeNode();
		zn.setId(ztree.getId());
		zn.setName(ztree.getName());
		ztreeNodeDAO.renameZtreeNode(zn);
	}

	/**
	 * <p>查询节点内容信息</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#queryZtreeNodeNodeContent(com.yunat.workflow.development.domain.Ztree)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 1, 2013 2:02:30 PM
	 */
	@Transactional
	public Ztree queryZtreeNodeNodeContent(Ztree ztree) {
		ZtreeNode zn = new ZtreeNode();
		zn.setId(ztree.getId());
		zn = ztreeNodeDAO.queryZtreeNodeContent(zn);
		
		ztree.setContent(zn.getContent());
		ztree.setName(zn.getName());
		ztree.setTaskId(zn.getTask_id());
		return ztree;
	}

	/**
	 * <p>保存节点内容信息</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#saveZtreeNodeContent(com.yunat.workflow.development.domain.Ztree)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 1, 2013 2:43:21 PM
	 */
	@Transactional
	public void saveZtreeNodeContent(Ztree ztree) {
		ZtreeNode zn = new ZtreeNode();
		zn.setId(ztree.getId());
		zn.setContent(ztree.getContent());
		ztreeNodeDAO.updateZtreeNodeContent(zn);
		
	}

	/**
	 * <p>根据任务id查询附件信息</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#queryAttachmentByTaskId(java.lang.String)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 4, 2013 4:29:57 PM
	 */
	@Transactional
	public List<AttachmentDomain> queryAttachmentByTaskId(String task_id) {
		List<Attachment> attachmentPojo = attachmentDAO.queryAttachmentByTaskId(task_id);
		List<AttachmentDomain> attachmentDomain = new ArrayList<AttachmentDomain>();
		for(Attachment ap :attachmentPojo){
			AttachmentDomain ad = new AttachmentDomain();
			ad.setFid(ap.getFid());
			ad.setTask_id(ap.getTask_id());
			ad.setFile_name(ap.getFile_name());
			ad.setDescription(ap.getDescription());
			attachmentDomain.add(ad);
		}
		System.out.println(attachmentDomain.size());
		return attachmentDomain;
	}

	/**
	 * <p>上传新附件保存附件信息</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#insertAttachment(com.yunat.workflow.development.domain.AttachmentDomain)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 5, 2013 4:58:16 PM
	 */
	@Transactional
	public void insertAttachment(AttachmentDomain attachmentDomain) {
		Attachment ap =new Attachment();
		ap.setFid(UUID.randomUUID().toString().replace("-", ""));
		ap.setTask_id(attachmentDomain.getTask_id());
		ap.setFile_name(attachmentDomain.getFile_name());
		ap.setDescription(attachmentDomain.getDescription());
		attachmentDAO.insertAttachment(ap);
	}

	/**
	 * <p>删除附件</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#deleteAttachment(com.yunat.workflow.development.domain.AttachmentDomain)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 9, 2013 6:13:05 PM
	 */
	@Transactional
	public void deleteAttachment(AttachmentDomain attachmentDomain) {
		Attachment ap =new Attachment();
		ap.setFid(attachmentDomain.getFid());
		attachmentDAO.deleteAttachment(ap);
	}

	/**
	 * <p>查询规则</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#queryRuleByTaskId(java.lang.String)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:46:02 PM
	 */
	@Transactional
	public List<RuleDomain> queryRuleByTaskId(String task_id) {
		List<Rule> attachmentPojo = ruleDAO.queryRuleList(task_id);
		List<RuleDomain> ruleDomain = new ArrayList<RuleDomain>();
		for(Rule rp :attachmentPojo){
			RuleDomain rd = new RuleDomain();
			rd.setRid(rp.getRid());
			rd.setTask_id(rp.getTask_id());
			rd.setOriginal_value(rp.getOriginal_value());
			rd.setNew_value(rp.getNew_value());
			rd.setRule_type(rp.getRule_type());
			ruleDomain.add(rd);
		}
		return ruleDomain;
	}

	/**
	 * <p>插入规则</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#insertRule(com.yunat.workflow.development.domain.RuleDomain)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:46:02 PM
	 */
	@Transactional
	public void insertRule(RuleDomain ruleDomain) {
		Rule rp = new Rule();
		rp.setRid(UUID.randomUUID().toString().replace("-", ""));
		rp.setOriginal_value(ruleDomain.getOriginal_value());
		rp.setNew_value(ruleDomain.getNew_value());
		rp.setRule_type(ruleDomain.getRule_type());
		rp.setTask_id(ruleDomain.getTask_id());
		ruleDAO.insertRule(rp);
	}

	/**
	 * <p>删除规则</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#deleteRule(com.yunat.workflow.development.domain.RuleDomain)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 10, 2013 5:46:02 PM
	 */
	@Transactional
	public void deleteRule(RuleDomain ruleDomain) {
		Rule rp = new Rule();
		rp.setRid(ruleDomain.getRid());
		ruleDAO.deleteRule(rp);
	}

	/**
	 * <p>规则应用</p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#ruleApply(java.lang.String, java.lang.String)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 11, 2013 10:16:53 AM
	 */
	@Override
	public String ruleApply(String task_id, String script) {
		List<Rule> attachmentPojo = ruleDAO.queryRuleList(task_id);
		for(Rule r:attachmentPojo){
			if(r.getRule_type().equals("contant")){
				script = script.replaceAll(r.getOriginal_value(), r.getNew_value());
			}
			if(r.getRule_type().equals("variable")){
				script = script.replaceAll(r.getOriginal_value(), r.getNew_value());
			}
			if(r.getRule_type().equals("regex")){
				script = script.replaceAll(r.getOriginal_value(), r.getNew_value());
			}
				
		}
		return script;
	}
}
