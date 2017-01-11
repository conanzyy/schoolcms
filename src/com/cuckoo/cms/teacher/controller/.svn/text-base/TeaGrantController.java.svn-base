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

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.req.TeaGrantAddReq;
import com.cuckoo.cms.teacher.service.TeaGrantService;
@Controller
public class TeaGrantController {
	
	//注入Service
	@Autowired
	private TeaGrantService teaGrantService;
	
	//获取奖助信息列表
	@RequestMapping(value = "/getTeaGrantList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaGrantList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId = SessionUtil.getUserInfo(request).getUserId();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data",teaGrantService.getTeaGrantList(userId, tenantId));
		return responseMap;
	}
	
	//获取奖助信息详情
	@RequestMapping(value = "/getTeaGrantApplyInfo" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaGrantApplyInfo(@RequestParam(value="applyId") String applyId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("studentInfo",teaGrantService.getTeaGrantApplyInfo(applyId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//审核奖助信息
	@RequestMapping(value = "/updateTeaGrantApplyInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeaGrantApplyInfo(@Valid String applyId,int audit
,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaGrantService.updateTeaGrantApplyInfo(applyId, audit);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	//批量删除奖助信息
	@RequestMapping(value = "/deleteTeaGrantApplyInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTeaGrantApplyInfo(@Valid @RequestBody HashMap<String, Object> applyIdMap, 
			HttpServletRequest request) throws MsgException {
		@SuppressWarnings("unchecked")
		ArrayList<String> applyIds= (ArrayList<String>) applyIdMap.get("applyIds");
		for(String applyId : applyIds){
			teaGrantService.deleteTeaGrantApplyInfo(applyId);
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//创建奖助
	@RequestMapping(value = "/createTeaGrantInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createTeaGrantInfo(@Valid TeaGrantAddReq teaGrantAddReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		teaGrantService.createTeaGrantInfo(teaGrantAddReq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	
	
}
