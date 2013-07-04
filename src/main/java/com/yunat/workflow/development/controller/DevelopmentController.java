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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	 * <p>[描述方法实现的功能]</p>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 10:10:00 AM
	 */
	@RequestMapping(value = "deveopmentview.do")
	public ModelAndView getview(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/development/develop");
		return mv;
	}

	/**
	 * <p>[描述方法实现的功能]</p>
	 * 
	 * @return
	 * @return: ModelAndView
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 4, 2013 10:10:08 AM
	 */
	@RequestMapping(value = "upload.do")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/development/upload");
		return mv;
	}
}
