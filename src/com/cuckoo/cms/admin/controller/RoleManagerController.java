package com.cuckoo.cms.admin.controller;

import java.util.HashMap;
import java.util.List;
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

import com.cuckoo.cms.admin.pojo.req.RoleAddReq;
import com.cuckoo.cms.admin.pojo.req.RoleIdReq;
import com.cuckoo.cms.admin.pojo.req.RoleReq;
import com.cuckoo.cms.admin.pojo.resp.AuthorityResp;
import com.cuckoo.cms.admin.service.RoleManagerService;
import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;

/**
 * 
 * @author tsx270129
 *
 */
@Controller
public class RoleManagerController extends BaseController {
	@Autowired
	private RoleManagerService roleManagerService;

	@RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRoleList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", roleManagerService.getRoleList(tenantId));
		return responseMap;

	}

	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createRole(@Valid @RequestBody RoleAddReq rolereq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		roleManagerService.createRole(rolereq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}

	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteRole(@Valid @RequestBody RoleIdReq roleDelReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		roleManagerService.deleteRole(roleDelReq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	@RequestMapping(value = "/getRoleInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRoleInfo(@Valid @RequestBody RoleIdReq req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMap.put("roleInfo",roleManagerService.getRoleInfo(req, user) );
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateRole(@Valid @RequestBody RoleReq roleDelReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		roleManagerService.updateRole(roleDelReq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}

	@RequestMapping(value = "/getAuthIds", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAuthIds(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		List<AuthorityResp> authResp = roleManagerService.getAuthIds(user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("authIds", authResp);
		return responseMap;
	}

}
