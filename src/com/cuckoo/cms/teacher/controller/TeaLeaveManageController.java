package com.cuckoo.cms.teacher.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.service.TeaLeaveManageService;

@Controller
public class TeaLeaveManageController {

	//注入service对象
	@Autowired
	private TeaLeaveManageService teaLeaveManageService;
	
	//获取请假信息列表
	@RequestMapping(value = "/getTeaLeaveList" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaLeaveList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId=SessionUtil.getUserInfo(request).getUserId();
		String tenantId=SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put("data",teaLeaveManageService.getTeaLeaveList(userId,tenantId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//获取请假信息详情
	@RequestMapping(value = "/getTeaLeave" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaLeave(@Valid String leaveId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("data",teaLeaveManageService.getTeaLeave(leaveId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//请假信息审核
	@RequestMapping(value = "/updateTeaLeaveInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeaLeaveInfo(@Valid String leaveId,int audit
,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaLeaveManageService.updateTeaLeaveInfo(leaveId,audit);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除多条请假信息
			@RequestMapping(value = "/deleteTeaLeaveAll", method = RequestMethod.POST)
			@ResponseBody
			public Map<String, Object> deleteTeaLeaveAll(@Valid @RequestBody HashMap<String,Object> leaveIdMap,
					HttpServletRequest request) throws MsgException {
				System.out.println(leaveIdMap);
				@SuppressWarnings("unchecked")
				ArrayList<String> leaveIds = (ArrayList<String>) leaveIdMap.get("leaveIds"); 
				System.out.println(leaveIds);
				for(String leaveId : leaveIds){
					teaLeaveManageService.deleteTeaLeave(leaveId);
				}
				Map<String, Object> responseMap = new HashMap<String, Object>();
				responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
				return responseMap;
			}
}
