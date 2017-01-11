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
import com.cuckoo.cms.teacher.pojo.OrderInfo;
import com.cuckoo.cms.teacher.pojo.req.OrderDeleteReq;
import com.cuckoo.cms.teacher.pojo.req.OrderOneDoneReq;
import com.cuckoo.cms.teacher.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getOrderList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", orderService.getOrderList(user));
		return responseMap;

	}
	

	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateOrder(@Valid @RequestBody OrderInfo req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		orderService.updateOrder(req);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;

	}
	
	@RequestMapping(value = "/oneDoneOrder", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> oneDoneOrder(@Valid @RequestBody OrderOneDoneReq req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		orderService.oneDoneOrder(req,user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteOrder(@Valid @RequestBody OrderDeleteReq req, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		orderService.deleteOrder(req,user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
