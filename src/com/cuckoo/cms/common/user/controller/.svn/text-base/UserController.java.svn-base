package com.cuckoo.cms.common.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.user.pojo.req.UserAddReq;
import com.cuckoo.cms.common.user.service.UserService;
import com.cuckoo.cms.common.utils.SessionUtil;
@Controller
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editUser(@Valid @RequestBody UserAddReq addReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		userService.editUser(user,addReq);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
}
	
}
