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

import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.student.pojo.req.StudentEditReq;
import com.cuckoo.cms.student.service.StudentManagerService;

@Controller
public class StudentManagerController extends BaseController{
	
	//注入service对象
	@Autowired
	private StudentManagerService studentManagerService;
	
	
	//获取学生信息
	@RequestMapping(value = "/getStudentInfo" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStudentInfo(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user=SessionUtil.getUserInfo(request);
		responseMap.put("studentInfo",studentManagerService.getStudentInfo(user.getUserId(),user.getTenantId()) );
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//更新学生信息
	@RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateStudentInfo(@Valid  StudentEditReq studentEditReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		studentManagerService.updateStudentInfo(studentEditReq,user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
