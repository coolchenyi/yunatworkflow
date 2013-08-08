package com.yunat.workflow.definiton.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class workflowController {

	@RequestMapping(value = "addworkflowdefine.do")
	public ModelAndView addWorkflowName(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	@RequestMapping(value = "addworkflowdenode.do")
	public ModelAndView addNode(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}
	
	@RequestMapping(value = "workflowview.do")
	public ModelAndView getview() {
		ModelAndView mv = new ModelAndView("/definiton/wdefinition");
		return mv;
	}

}
