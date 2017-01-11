package com.cuckoo.cms.student.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.cuckoo.cms.student.pojo.Notice;
import com.cuckoo.cms.student.pojo.req.NoticeIdReq;
import com.cuckoo.cms.student.service.NoticeManagerService;

/**
 * 
 * @author chenxuefeng
 *
 */
@Controller
public class NoticeManagerController extends BaseController {
	@Autowired
	private NoticeManagerService noticeManagerService;
	
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNoticeList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		responseMap.put("data", noticeManagerService.getNoticeList(tenantId));
		return responseMap;

	}
	
	@RequestMapping(value = "/getNoticeInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNoticeInfo(
			@RequestParam(value="noticeId") String noticeId,
			HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = SessionUtil.getUserInfo(request);
		responseMap.put("title",noticeManagerService.getNoticeInfo(noticeId, user).getNoticeInfo().getTitle());
		responseMap.put("content",noticeManagerService.getNoticeInfo(noticeId, user).getNoticeInfo().getContent());
		responseMap.put("createBy",noticeManagerService.getNoticeInfo(noticeId, user).getNoticeInfo().getCreateBy());
		responseMap.put("createTime",noticeManagerService.getNoticeInfo(noticeId, user).getNoticeInfo().getCreateTime());
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		return responseMap;
	}
	//学生端公告首页
	@RequestMapping(value = "/getIndexNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getIndexNoticeList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		List<Notice> indexNoticeList = noticeManagerService.getIndexNoticeList(tenantId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
		for (int i = 0; i < indexNoticeList.size(); i++) {
			try {
				Date parse = simpleDateFormat.parse(indexNoticeList.get(i).getCreateTime());
				indexNoticeList.get(i).setCreateTime(simpleDateFormat.format(parse));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		responseMap.put("data", indexNoticeList);
		return responseMap;

	}
	
}
