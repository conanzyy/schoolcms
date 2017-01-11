package com.cuckoo.cms.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cuckoo.cms.common.CommonUtil;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;

/**
 * 
 * @author tsx270129
 *
 */
public class LogUtil {
	private static final Logger OPLOGGER = LoggerFactory.getLogger("opLogger");

	private static final Logger SECUR_LOGGER = LoggerFactory.getLogger("securlogger");

	public static void opLog(HttpServletRequest request, String service, String module, String content)
			throws MsgException {
		String reallp = CommonUtil.getRealIp(request);
		User userInfo = SessionUtil.getUserInfo(request);

		if (null == userInfo) {
			return;
		}

		String userId = userInfo.getUserId();
		String userName = userInfo.getUserName();
		opLog(reallp, userId, userName, service, module, content);
	}

	public static void opLog(String clientlp, String id, String userName, String service, String module,
			String content) {
		if (StringUtils.isNotBlank(userName) && userName.length() >= 3)

		{
			userName = userName.substring(0, 2) + "***" + userName.charAt(userName.length() - 1);
		}

		OPLOGGER.info("{}|{}|{}|{}|{}|{}", clientlp, id, userName, service, module, content);
	}

	public static void securLog(HttpServletRequest request, String service, String module, String content)
			throws MsgException {
		String reallP = CommonUtil.getRealIp(request);
		User userInfo = SessionUtil.getUserInfo(request);
		if (null == userInfo) {
			return;

		}

		String userId = userInfo.getUserId();
		String userName = userInfo.getUserName();
		securLog(reallP, userId, userName, service, module, content);
	}

	public static void securLog(String clientlp, String id, String userName, String service, String module,
			String content) {
		if (StringUtils.isNotBlank(userName) && userName.length() >= 3) {
			userName = userName.substring(0, 2) + "***" + userName.charAt(userName.length() - 1);
		}
		SECUR_LOGGER.warn("{}|{}|{}|{}|{}|{}", clientlp, id, userName, service, module, content);
	}
}
