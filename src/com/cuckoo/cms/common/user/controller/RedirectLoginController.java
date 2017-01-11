package com.cuckoo.cms.common.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
@Controller
public class RedirectLoginController extends AbstractController{
	private static final Logger LOGGER = LoggerFactory.getLogger(RedirectLoginController.class);
	@Autowired
	private ModelAndView redirectLoginModelAndView;
	
	public ModelAndView getRedirectLoginModelAndView() {
		return redirectLoginModelAndView;
	}

	public void setRedirectLoginModelAndView(ModelAndView redirectLoginModelAndView) {
		this.redirectLoginModelAndView = redirectLoginModelAndView;
	}

	@RequestMapping(value = "/loginOut")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws MsgException {
		User user=SessionUtil.getUserInfo(request);
		if(user!=null){
			LOGGER.info("Account :" + user.getUserName() + Constants.strChar.VERTICAL_LINE+"LoginOut Successfull!");
		}
		SessionUtil.invalidate(request.getSession());
		return this.getRedirectLoginModelAndView();
	}

}
