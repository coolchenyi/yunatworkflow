/**
 * 文件名：DevelopmentController.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 27, 2013 4:15:46 PM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yunat.workflow.common.WorkflowProperties;
import com.yunat.workflow.development.domain.AttachmentDomain;
import com.yunat.workflow.development.domain.RuleDomain;
import com.yunat.workflow.development.domain.Ztree;
import com.yunat.workflow.development.service.DevelopmentService;

/**
 * <p>
 * 开发中心控制器
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 27, 2013 4:15:46 PM
 */
@Controller
public class DevelopmentController {

	@Autowired
	private DevelopmentService developmentService;

	/**
	 * <p>
	 * 查询任务树
	 * </p>
	 * 
	 * @return
	 * @return: List<Ztree>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 3:25:33 PM
	 */
	@ResponseBody
	@RequestMapping(value = "queryZtree.do")
	public List<Ztree> queryZtree() {
		return developmentService.queryZtreeNode();
	}

	/**
	 * <p>
	 * 增加树节点
	 * </p>
	 * 
	 * @param zNodeJson
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 3:31:42 PM
	 */
	@ResponseBody
	@RequestMapping(value = "addZtreeNode.do")
	public Ztree addZtreeNode(Ztree zNodeJson) {
		Ztree zt = developmentService.addZtreeNode(zNodeJson);
		return zt;
	}

	/**
	 * <p>
	 * 删除节点
	 * </p>
	 * 
	 * @param zNodeJson
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:15:09 PM
	 */
	@ResponseBody
	@RequestMapping(value = "deleteZtreeNode.do")
	public void deleteZtreeNode(Ztree zNodeJson) {
		developmentService.deleteZtreeNode(zNodeJson);
	}

	/**
	 * <p>
	 * 修改节点名称
	 * </p>
	 * 
	 * @param zNodeJson
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 28, 2013 6:40:29 PM
	 */
	@ResponseBody
	@RequestMapping(value = "renameZtreeNode.do")
	public void renameZtreeNode(Ztree zNodeJson) {
		developmentService.renameZtreeNode(zNodeJson);
	}

	/**
	 * <p>
	 * 查询节点内容信息
	 * </p>
	 * 
	 * @param zNodeJson
	 * @return
	 * @return: Ztree
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:05:33 PM
	 */
	@ResponseBody
	@RequestMapping(value = "queryZtreeNodeContent.do")
	public Ztree queryZtreeNodeContent(Ztree zNodeJson) {
		return developmentService.queryZtreeNodeNodeContent(zNodeJson);
	}

	/**
	 * <p>
	 * 保存节点内容信息
	 * </p>
	 * 
	 * @param zNodeJson
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 1, 2013 2:45:28 PM
	 */
	@ResponseBody
	@RequestMapping(value = "saveZtreeNodeContent.do")
	public void saveZtreeNodeContent(Ztree zNodeJson) {
		developmentService.saveZtreeNodeContent(zNodeJson);
	}

	/**
	 * <p>
	 * 开发中心总界面
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 10:10:00 AM
	 */
	@RequestMapping(value = "deveopmentview.do")
	public ModelAndView getview() {
		ModelAndView mv = new ModelAndView("/development/develop");
		return mv;
	}

	/**
	 * <p>
	 * 开发中心树界面
	 * </p>
	 * 
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 2:23:27 PM
	 */
	@RequestMapping(value = "treeview.do")
	public ModelAndView treeView() {
		ModelAndView mv = new ModelAndView("/development/tree");
		return mv;
	}

	/**
	 * <p>
	 * 开发中心上传界面
	 * </p>
	 * 
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 10:10:08 AM
	 */
	@RequestMapping(value = "uploadview.do")
	public ModelAndView uploadView(Ztree zNodeJson) {
		zNodeJson = developmentService.queryZtreeNodeNodeContent(zNodeJson);
		ModelAndView mv = new ModelAndView("/development/upload", "ztree",
				zNodeJson);
		return mv;
	}

	/**
	 * <p>
	 * 开发中心配置变量界面
	 * </p>
	 * 
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 2:25:23 PM
	 */
	@RequestMapping(value = "configview.do")
	public ModelAndView configView(Ztree zNodeJson) {
		zNodeJson = developmentService.queryZtreeNodeNodeContent(zNodeJson);
		ModelAndView mv = new ModelAndView("/development/config", "ztree",
				zNodeJson);
		return mv;
	}

	/**
	 * <p>
	 * 查询附件信息列表
	 * </p>
	 * 
	 * @param ad
	 * @return
	 * @return: List<AttachmentDomain>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 5:19:51 PM
	 */
	@ResponseBody
	@RequestMapping(value = "queryattachment.do")
	public List<AttachmentDomain> queryAttachmentList(AttachmentDomain ad) {
		return developmentService.queryAttachmentByTaskId(ad.getTask_id());
	}
	
	/**
	 * <p>上传附件</p>
	 * 
	 * @param name
	 * @param file
	 * @return
	 * @return: String
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @throws FileNotFoundException 
	 * @date: Created on Jul 5, 2013 2:12:36 PM
	 */
	@RequestMapping(value = "uploadfile.do", method = RequestMethod.POST)  
    public String handleFormUpload(AttachmentDomain ad,@RequestParam("file") MultipartFile file) throws Exception { 
        //MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数  
		/* 获取上传的文件名称 */
		String fileNameLong = file.getOriginalFilename();
		/* 获取文件扩展名 */
		//String extensionName = fileNameLong.substring(fileNameLong.lastIndexOf(".") + 1);
		String attachmentPath = WorkflowProperties.getInstance().getValue("attachmentpath");
		File fileDir = new File(attachmentPath +ad.getTask_id()+"/");
		if (!fileDir.exists()) {
		   fileDir.mkdirs();
		}
		if (!file.isEmpty()) {
			FileOutputStream out;
			out = new FileOutputStream(attachmentPath +ad.getTask_id()+"/" +fileNameLong);
			out.write(file.getBytes()); // 写入文件
			out.close();
		}
		ad.setFile_name(fileNameLong);
		developmentService.insertAttachment(ad);
		return "/development/upload";
    } 
	
	/**
	 * <p>删除附件</p>
	 * 
	 * @param ad
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 9, 2013 6:14:47 PM
	 */
	@ResponseBody
	@RequestMapping(value = "deleteattachment.do")
	public void deleteAttachment(AttachmentDomain ad){
		String attachmentPath = WorkflowProperties.getInstance().getValue("attachmentpath");
		File file = new File(attachmentPath +ad.getTask_id()+"/"+ad.getFile_name());
		if(file.exists()){
			file.delete();
		}
		developmentService.deleteAttachment(ad);
	}
	
	/**
	 * <p>查询规则列表</p>
	 * 
	 * @param rd
	 * @return
	 * @return: List<RuleDomain>
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 6:27:10 PM
	 */
	@ResponseBody
	@RequestMapping(value = "queryrulelist.do")
	public List<RuleDomain> queryRuleList(RuleDomain rd){
		return developmentService.queryRuleByTaskId(rd.getTask_id());
	}
	
	/**
	 * <p>插入新规则</p>
	 * 
	 * @param rd
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 6:30:07 PM
	 */
	@ResponseBody
	@RequestMapping(value = "addrule.do")
	public List<RuleDomain> addRule(RuleDomain rd){
		developmentService.insertRule(rd);
		return developmentService.queryRuleByTaskId(rd.getTask_id());
	}
	
	/**
	 * <p>删除规则</p>
	 * 
	 * @param rd
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 10, 2013 6:31:15 PM
	 */
	@ResponseBody
	@RequestMapping(value = "deleterule.do")
	public void deleteRule(RuleDomain rd){
		developmentService.deleteRule(rd);
	}
}
