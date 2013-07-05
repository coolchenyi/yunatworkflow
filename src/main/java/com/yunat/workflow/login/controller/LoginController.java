package com.yunat.workflow.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yunat.workflow.login.domain.LoginForm;
import com.yunat.workflow.login.pojo.AdminInfo;
import com.yunat.workflow.login.service.LoginService;

/**
 * @author chenyi8888
 * 
 */
@Controller
public class LoginController {

	private final Log logger = LogFactory.getLog(LoginController.class);
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "login.do")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, LoginForm command) {
		logger.info("user:" + command.getUsername() + " start loginning");
		String username = command.getUsername();
		String passwd = command.getPassword();
		AdminInfo tmp = loginService.getAdminInfo(username);
		if (tmp == null) {
			logger.warn("the login user is null,username=" + username);
			ModelAndView mv = new ModelAndView("/loginerror", "ermessager",
					"用户不存在,请联系管理员");
			return mv;
		} else if (!tmp.getPassword().equals(passwd)) {
			logger.warn("the login user is error passwd ,username=" + username);
			ModelAndView mv = new ModelAndView("/loginerror", "ermessager",
					"用户密码错误");
			return mv;
		}
		logger.info("the user=" + tmp.getUsername() + "is login sucess!");
		ModelAndView mv = new ModelAndView("/mainbase", "command",
				"LOGIN SUCCESS, " + username);
		logger.info("tmp" + tmp.getUsername() + " " + tmp.getPassword());

		return mv;
	}
}
