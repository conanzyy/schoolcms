package com.cuckoo.cms.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
/**
 * 
 * @author tsx270129
 *
 */
public class CommonUtil {

	private static final String IPV6 = "0:0:0:0:0:0:0:1";
	private static final String IPV4 = "127.0.0.1";

	public static String getRealIp(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isBlank(ip)) {
			return IPV6.equals(request.getRemoteAddr()) ? IPV4 : request.getRemoteAddr();
		}
		return null;

	}

}
