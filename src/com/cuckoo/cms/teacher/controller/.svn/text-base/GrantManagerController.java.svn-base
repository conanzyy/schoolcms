package com.cuckoo.cms.teacher.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.BaseController;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.teacher.service.GrantManagerService;

/**
 * 奖助管理 
 * @author worker
 *
 */
@Controller
public class GrantManagerController extends BaseController {
	
	@Autowired
	private GrantManagerService grantManagerService;
	
	//获取奖助活动列表
	@RequestMapping(value = "/getGrantList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getGrantList(HttpServletRequest request) throws MsgException {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		//获取租户id
		String tenantId = SessionUtil.getUserInfo(request).getTenantId();
		//获取用户id
		String currentUserId = SessionUtil.getUserInfo(request).getUserId();
		responseMap.put(Constants.RTN_CODE, Constants.SUCCESS);
		//根据租户id 和 当前用户id 来查询 该用户 创建的奖助活动
		responseMap.put("data", grantManagerService.getGrantList(Integer.parseInt(tenantId),Integer.parseInt(currentUserId)));
		return responseMap;

	}

}
