package com.cuckoo.cms.teacher.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.service.TeaIndexService;

@Controller
public class TeaIndexController {
	
		//注入service对象
		@Autowired
		private TeaIndexService teaIndexService;
		
		//获取前八条未处理信息列表
		@RequestMapping(value = "/getTeaUntreatedList" , method = RequestMethod.GET)
		@ResponseBody
		public Map<String, Object> getTeaUntreatedList(HttpServletRequest request) throws MsgException {

			Map<String, Object> responseMap = new HashMap<String, Object>();
			String userId=SessionUtil.getUserInfo(request).getUserId();
			String tenantId=SessionUtil.getUserInfo(request).getTenantId();
			responseMap.put("data",teaIndexService.getTeaLeaveUntreatedList(userId, tenantId));
			responseMap.put("data1",teaIndexService.getTeaGrantUntreatedList(userId, tenantId));
			responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
			return responseMap;
		}
		
		
}
