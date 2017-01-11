package com.cuckoo.cms.student.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.student.pojo.req.LeaveAddReq;
import com.cuckoo.cms.student.service.LeaveManagerService;

@Controller
public class LeaveManagerController {
	
	//注入service对象
	@Autowired
	private LeaveManagerService leaveManagerService;
	
	//获取请假信息
	@RequestMapping(value = "/getLeaveInfo" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getLeaveInfo(String userId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user=SessionUtil.getUserInfo(request);
		responseMap.put("data",leaveManagerService.getLeaveInfo(userId, user));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
			
	//销假
	@RequestMapping(value = "/updateLeaveInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateLeaveInfo(@Valid String leaveId,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		leaveManagerService.updateLeaveInfo(leaveId, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//查看详情
	
	//新增课假
	@RequestMapping(value = "/createCourseLeave", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createCourseLeave(@Valid LeaveAddReq leave, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		leaveManagerService.createCourseLeave(leave, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//新增校假
	@RequestMapping(value = "/createSchoolLeave", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createSchoolLeave(@Valid LeaveAddReq leave, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		leaveManagerService.createSchoolLeave(leave, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}		
	
}

