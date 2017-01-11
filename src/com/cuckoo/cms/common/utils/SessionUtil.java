package com.cuckoo.cms.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.cuckoo.cms.common.user.pojo.User;

/**
 * 
 * @author tsx270129
 *
 */
public class SessionUtil {

	private static final String LABEL_USER_INFO = "cmsUser";
	private static final String NEED_CHANGE_PWD = "1";
	private static final String IS_CHANGE_PWD = "isChangePwd";

	public static User getUserInfo(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute(LABEL_USER_INFO);
		String tenantId = StringUtils.EMPTY;
		if (user != null) {
			tenantId = user.getTenantId();
		}
		return StringUtils.isBlank(tenantId) ? null : user;
	}

	public static void setUserInfo(HttpServletRequest request, User userInfo,JSONArray resourceArray) {

		request.getSession().setAttribute(LABEL_USER_INFO, userInfo);
		if (NEED_CHANGE_PWD.equals(userInfo.getIsChangePwd())) {
			request.getSession().setAttribute(IS_CHANGE_PWD, true);
		}
		request.getSession().setAttribute("menuList", resourceArray);
	}

	public static void invalidate(HttpSession httpsession) {
		if (httpsession != null) {

			httpsession.invalidate();
		}

	}
}
