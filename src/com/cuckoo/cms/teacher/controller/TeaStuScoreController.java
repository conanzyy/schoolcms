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
import com.cuckoo.cms.teacher.pojo.req.TeaStuScoreAddReq;
import com.cuckoo.cms.teacher.service.TeaStuScoreService;

@Controller
public class TeaStuScoreController extends BaseController{
	
	//注入Service
	@Autowired
	private TeaStuScoreService teaStuScoreService;
	
	//获取学生成绩列表
	@RequestMapping(value = "/getTeaStuScoreList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaStuScoreList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId = SessionUtil.getUserInfo(request).getUserId();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", teaStuScoreService.getTeaStuScoreList(userId, tenantId));
		return responseMap;
	}
	
	//获取学生成绩详情
	@RequestMapping(value = "/getTeaStuScoreInfo" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeaStuScoreInfo(@RequestParam(value="scoreId") String scoreId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("studentInfo",teaStuScoreService.getTeaStuScoreInfo(scoreId));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//编辑学生成绩信息
	@RequestMapping(value = "/updateTeaStuScoreInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeaStuScoreInfo(@Valid  TeaStuScoreAddReq teaStuScoreAddReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaStuScoreService.updateTeaStuScoreInfo(teaStuScoreAddReq);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//单条删除学生成绩信息
	@RequestMapping(value = "/deleteTeaStuScoreInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTeaStuScoreInfo(@Valid  String scoreId, 
			HttpServletRequest request) throws MsgException {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		teaStuScoreService.deleteTeaStuScoreInfo(scoreId);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//多条删除学生成绩信息
	@RequestMapping(value = "/deleteTeaStuScoreInfoAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTeaStuScoreInfoAll(@Valid @RequestBody HashMap<String, Object> scoreIdMap, 
			HttpServletRequest request) throws MsgException {
		@SuppressWarnings("unchecked")
		ArrayList<String> scoreIds= (ArrayList<String>) scoreIdMap.get("scoreIds");
		for(String scoreId : scoreIds){
			teaStuScoreService.deleteTeaStuScoreInfo(scoreId);
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	
	
	
}
