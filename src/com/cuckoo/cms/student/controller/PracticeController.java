package com.cuckoo.cms.student.controller;

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

import com.cuckoo.cms.admin.pojo.req.RoleAddReq;
import com.cuckoo.cms.admin.pojo.req.RoleReq;
import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.student.pojo.Practice;
import com.cuckoo.cms.student.pojo.req.PracticeAddReq;
import com.cuckoo.cms.student.pojo.req.PracticeReq;
import com.cuckoo.cms.student.service.PracticeService;

/**
 * 
 * @author chenxuefeng
 *
 */
@Controller
public class PracticeController extends BaseController {
	@Autowired
	private PracticeService practiceService;
	
	@RequestMapping(value = "/getPracticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPracticeList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId = SessionUtil.getUserInfo(request).getUserId();
//		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", practiceService.getPracticeList(userId));
		return responseMap;
	}
	
	@RequestMapping(value = "/createPractice",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createPractice(@Valid PracticeAddReq practicereq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		practiceService.createPractice(practicereq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	@RequestMapping(value = "/updatePractice", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatePractice(@Valid  PracticeReq practiceDelReq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		practiceService.updatePractice(practiceDelReq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
//	@RequestMapping(value = "/getPracticeInfo", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> getPracticeInfo(
//			@RequestParam(value="practiceId") String practiceId,
//			HttpServletRequest request) throws MsgException {
//
//		Map<String, Object> responseMap = new HashMap<String, Object>();
//		User user = SessionUtil.getUserInfo(request);
//		responseMap.put("practiceDetail",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getPracticeDetail());
//		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
//		return responseMap;
//	}
	@RequestMapping(value = "/getPracticeInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPracticeInfo(
			@RequestParam(value="practiceId") String practiceId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMapin = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMapin.put("emType",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getEmType());
		responseMapin.put("workCompany",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getWorkCompany());
		responseMapin.put("companyNature",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getCompanyNature());
		responseMapin.put("workPhone",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getWorkPhone());
		responseMapin.put("superName",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getSuperName());
		responseMapin.put("superPhone",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getSuperPhone());
		responseMapin.put("workAddress",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getWorkAddress());
		responseMapin.put("practiceRecord",practiceService.getPracticeInfo(practiceId, user).getPracticeInfo().getPracticeRecord());
		//return responseMap;
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap.put("data",responseMapin);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
