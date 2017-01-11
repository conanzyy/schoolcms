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
import com.cuckoo.cms.teacher.pojo.req.OrderRecordAddReq;
import com.cuckoo.cms.teacher.service.OrderRecordManagerService;

@Controller
public class OrderRecordManagerController extends BaseController {
	@Autowired
	private OrderRecordManagerService orderRecordManagerService;
	//教师获取约谈记录列表
	@RequestMapping(value = "/getOrderRecordList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getOrderRecordList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		System.out.print(tenantId);
		System.out.print("111111");
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", orderRecordManagerService.getOrderRecordList(tenantId));
		return responseMap;
	}
	//老师创建约谈记录
	@RequestMapping(value = "/createOrderRecord",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createOrderRecord(@Valid OrderRecordAddReq orderrecordreq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		orderRecordManagerService.createOrderRecord(orderrecordreq);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	
	//教师获取 约谈详情
	@RequestMapping(value = "/getOrderRecordInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getOrderRecordInfo(
			@RequestParam(value="orderRecordId") String orderRecordId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMapin = new HashMap<String, Object>();
		//User user = SessionUtil.getUserInfo(request);
		responseMapin.put("stuName",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getStuName());
		responseMapin.put("stuNum",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getStuNum());
		responseMapin.put("proName",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getProName());
		responseMapin.put("className",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getClassName());
		responseMapin.put("talkTime",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getTalkTime());
		responseMapin.put("talkBackground",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getTalkBackground());
		responseMapin.put("prombleType",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getPrombleType());
		responseMapin.put("talkCount",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getTalkCount());
		responseMapin.put("talkEffect",orderRecordManagerService.getOrderRecordInfo(orderRecordId).getOrderRecordInfo().getTalkEffect());
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap.put("data",responseMapin);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}

	//删除多条约谈记录
	@RequestMapping(value = "/deleteOrderRecordAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteOrderRecordAll(@Valid @RequestBody HashMap<String, Object> orderRecordIdMap,
			HttpServletRequest request) throws MsgException {
		System.out.print(orderRecordIdMap);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		ArrayList<String> orderRecordIds= (ArrayList<String>) orderRecordIdMap.get("orderRecordIds");
		for(String orderRecordId : orderRecordIds){
			orderRecordManagerService.deleteOrderRecord(orderRecordId);
		}
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}


}
