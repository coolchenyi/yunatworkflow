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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunat.workflow.development.service.DevelopmentService;

/**
 * <p>开发中心控制器</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 27, 2013 4:15:46 PM
 */
@Controller
public class DevelopmentController {
	
	@Autowired
	private DevelopmentService developmentService;
	
	@ResponseBody
	@RequestMapping(value = "queryZtree.do")
	public String queryZtree(){
		String ztreeJson = developmentService.queryZtreeNode();
		return ztreeJson;
	}

}
