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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.pojo.req.TNoticeAddReq;
import com.cuckoo.cms.teacher.service.TNoticeManagerService;
/**
 * 
 * @author chenxuefeng
 *
 */
@Controller
public class TNoticeManagerController extends BaseController {
	@Autowired
	private TNoticeManagerService noticeManagerService;
	
	@RequestMapping(value = "/getTNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNoticeList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", noticeManagerService.getTNoticeList(tenantId));
		return responseMap;

	}
	
	@RequestMapping(value = "/getTNoticeInfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getNoticeInfo(
			@RequestParam(value="noticeId") String noticeId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMap.put("title",noticeManagerService.getTNoticeInfo(noticeId, user).getTnoticeInfo().getTitle());
		responseMap.put("content",noticeManagerService.getTNoticeInfo(noticeId, user).getTnoticeInfo().getContent());
		responseMap.put("createBy",noticeManagerService.getTNoticeInfo(noticeId, user).getTnoticeInfo().getCreateBy());
		responseMap.put("createTime",noticeManagerService.getTNoticeInfo(noticeId, user).getTnoticeInfo().getCreateTime());
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	
	@RequestMapping(value = "/createNotice",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createTNotice(@Valid TNoticeAddReq noticereq, BindingResult bindResult,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		noticeManagerService.createNotice(noticereq, user);
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
}
