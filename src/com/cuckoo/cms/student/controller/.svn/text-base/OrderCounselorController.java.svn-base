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
import com.cuckoo.cms.student.pojo.req.OrderCounselorReq;
import com.cuckoo.cms.student.pojo.req.OrderCounselorScheduleReq;
import com.cuckoo.cms.student.service.OrderCounselorService;

@Controller
public class OrderCounselorController {
	@Autowired
	private OrderCounselorService orderCounselorService;
	@RequestMapping(value = "/getOrderScheduleListByCounselorId" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getOrderScheduleListByCounselorId(@Valid OrderCounselorReq req, BindingResult bindResult,HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("data",orderCounselorService.getOrderScheduleList(req));
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	
	@RequestMapping(value = "/orderCounselorSchedule" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderCounselorSchedule(@Valid OrderCounselorScheduleReq req, BindingResult bindResult,HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user=SessionUtil.getUserInfo(request);
		orderCounselorService.orderCounselorSchedule(user,req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
