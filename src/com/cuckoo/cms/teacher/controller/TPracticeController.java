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
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.req.TPracticeIdReq;
import com.cuckoo.cms.teacher.service.TPracticeService;
@Controller
public class TPracticeController extends BaseController {
	@Autowired
	private TPracticeService practiceService;
	//教师获取实习信息列表
	@RequestMapping(value = "/getTPracticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTPracticeList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String userId = SessionUtil.getUserInfo(request).getUserId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", practiceService.getTPracticeList(userId));
		return responseMap;
	}
	
	//教师获取实习信息详情
	@RequestMapping(value = "/getTPracticeInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTPracticeInfo(
			@RequestParam(value="practiceId") String practiceId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMapin = new HashMap<String, Object>();
		//User user = SessionUtil.getUserInfo(request);
		responseMapin.put("stuName",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getStuName());
		responseMapin.put("stuNum",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getStuNum());
		responseMapin.put("proName",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getProName());
		responseMapin.put("className",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getClassName());
		responseMapin.put("emType",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getEmType());
		responseMapin.put("workCompany",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getWorkCompany());
		responseMapin.put("companyNature",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getCompanyNature());
		responseMapin.put("workPhone",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getWorkPhone());
		responseMapin.put("superName",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getSuperName());
		responseMapin.put("superPhone",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getSuperPhone());
		responseMapin.put("workAddress",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getWorkAddress());
		responseMapin.put("practiceRecord",practiceService.getTPracticeInfo(practiceId).getTpracticeInfo().getPracticeRecord());
		//return responseMap;
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap.put("data",responseMapin);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除学生实习信息
	@RequestMapping(value = "/deletePractice", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deletePractice(@Valid String practiceId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		//User user = SessionUtil.getUserInfo(request);
		practiceService.deleteTpractice(practiceId);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	//删除多条学生实习信息
		@RequestMapping(value = "/deletePracticeAll", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> deletePracticeAll(@Valid @RequestBody HashMap<String,Object> practiceIdMap,
				HttpServletRequest request) throws MsgException {
			System.out.println(practiceIdMap);
			@SuppressWarnings("unchecked")
			ArrayList<String> practiceIds = (ArrayList<String>) practiceIdMap.get("practiceIds"); 
			System.out.println( practiceIds);
			for(String practiceId : practiceIds){
				practiceService.deleteTpractice(practiceId);
			}
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
			return responseMap;
		}

}
