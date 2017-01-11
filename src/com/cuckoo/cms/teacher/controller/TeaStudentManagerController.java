package com.cuckoo.cms.teacher.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.req.TeaStudentEditReq;
import com.cuckoo.cms.teacher.service.TeaStudentManagerService;

@Controller
public class TeaStudentManagerController extends BaseController{
	
	@Autowired
	private TeaStudentManagerService teaStudentManagerService;
	
	//获取学生信息列表
	@RequestMapping(value = "/getStudentList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStudentList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId = SessionUtil.getUserInfo(request).getUserId();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", teaStudentManagerService.getStudentList(userId, tenantId));
		return responseMap;
	}
	
	//获取学生信息
	@RequestMapping(value = "/getTeaStudentInfo" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaStudentInfo(@RequestParam(value="userId") String userId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("studentInfo",teaStudentManagerService.getStudentInfo(userId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//编辑学生个人信息
	@RequestMapping(value = "/updateTeaStudentInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeaStudentInfo(@Valid  TeaStudentEditReq teaStudentEditReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaStudentManagerService.updateStudentInfo(teaStudentEditReq);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//单条删除学生信息
	@RequestMapping(value = "/delectStudentInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delectStudentInfo(@Valid  String userId, 
			HttpServletRequest request) throws MsgException {
		System.out.println(userId);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaStudentManagerService.delectStudentInfo(userId);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//批量删除学生信息
	@RequestMapping(value = "/delectStudentInfoAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delectStudentInfoAll(@Valid @RequestBody HashMap<String, Object> userIdMap, 
			HttpServletRequest request) throws MsgException {
		@SuppressWarnings("unchecked")
		ArrayList<String> userIds= (ArrayList<String>) userIdMap.get("userIds");
		for(String userId : userIds){
			teaStudentManagerService.delectStudentInfo(userId);
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}









