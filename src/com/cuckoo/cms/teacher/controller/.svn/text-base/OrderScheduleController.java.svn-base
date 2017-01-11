package com.cuckoo.cms.teacher.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.OrderSchedule;
import com.cuckoo.cms.teacher.pojo.req.OrderScheduleReq;
import com.cuckoo.cms.teacher.service.OrderScheduleService;

@Controller
public class OrderScheduleController {
	@Autowired
	private OrderScheduleService orderScheduleService;

	@RequestMapping(value = "/getOrderScheduleList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getOrderScheduleList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", orderScheduleService.getOrderScheduleList(user));
		return responseMap;

	}

	@RequestMapping(value = "/cancleOrderSchedule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> cancleOrderSchedule(@Valid @RequestBody OrderScheduleReq req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		orderScheduleService.cancleOrderSchedule(req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;

	}

	@RequestMapping(value = "/updateOrderSchedule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateOrderSchedule(@Valid @RequestBody OrderSchedule req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		orderScheduleService.updateOrderSchedule(req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;

	}

	@RequestMapping(value = "/createOrderSchedule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createOrderSchedule(@Valid @RequestBody OrderSchedule req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		orderScheduleService.createOrderSchedule(req,user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;

	}
}
