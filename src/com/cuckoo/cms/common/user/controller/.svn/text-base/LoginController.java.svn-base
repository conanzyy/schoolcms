package com.cuckoo.cms.common.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.cuckoo.cms.common.CommonUtil;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.user.pojo.req.UserReq;
import com.cuckoo.cms.common.user.service.UserService;
import com.cuckoo.cms.common.utils.SessionUtil;

/**
 * 
 * @author tsx270129
 *
 */
@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
		if (SessionUtil.getUserInfo(request) != null) {
			return new ModelAndView("redirect:/univ/index"); //$NON-NLS-1$
		} else {
			return new ModelAndView("jsp/login"); //$NON-NLS-1$
		}
	}

	@RequestMapping(value = "/univ/index")
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response) {
		if (SessionUtil.getUserInfo(request) != null) {
			return new ModelAndView("index"); //$NON-NLS-1$
		} else {
			return new ModelAndView("redirect:/"); //$NON-NLS-1$
		}
	}

	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request, @Valid UserReq req, BindingResult bindResult) {

		String realIp = CommonUtil.getRealIp(request);
		User user = null;
		try {
			user = userService.login(req);

		} catch (Exception e) {
			LOGGER.error("Login error!" + e.getCause());
			// 错误页面
			return new ModelAndView("jsp/login");
		}
		if (user == null) {
			LOGGER.info(
					"Account :" + req.getUserName() + "Login failed! Can't get userInfo in DB,Operate by " + realIp);
			return new ModelAndView("jsp/login", Constants.ERROR_MSG, Messages.getString("LoginController.0")); //$NON-NLS-1$ //$NON-NLS-2$
			// //$NON-NLS-3$
		}
		JSONArray resourceArray = null;
		try {
			resourceArray = userService.getAllMenuResourceByUserId(user);
		} catch (Exception e) {
			LOGGER.error("getMenu error!" + e.getCause());
			// 错误页面
			return new ModelAndView("jsp/login");
		}
		SessionUtil.invalidate(request.getSession());
		SessionUtil.setUserInfo(request, user, resourceArray);

		LOGGER.info("Account :" + user.getUserName() + "Login Successfull! Operate by " + realIp);
		return new ModelAndView("redirect:/univ/index"); //$NON-NLS-1$

	}

	
}
