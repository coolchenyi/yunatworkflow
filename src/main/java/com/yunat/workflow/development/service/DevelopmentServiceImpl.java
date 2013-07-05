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
import com.yunat.workflow.development.dao.ZtreeNodeDAO;
import org.springframework.util.StringUtils;

import com.yunat.workflow.development.domain.Ztree;
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
}
