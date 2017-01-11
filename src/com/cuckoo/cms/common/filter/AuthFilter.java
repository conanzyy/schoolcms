package com.cuckoo.cms.common.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cuckoo.cms.common.CmsBeanFactory;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.utils.SessionUtil;
import com.cuckoo.cms.common.utils.StringUtil;

public class AuthFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);
	private static String CONTENT_TYPE_JSON = "application/json;charset=utf-8"; //$NON-NLS-1$
	private String redirectUrlStr;
	private String urlWhiteList;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.redirectUrlStr = config.getInitParameter("loginUrl"); //$NON-NLS-1$
		Properties properties = CmsBeanFactory.getBean("configProperties"); //$NON-NLS-1$
		this.urlWhiteList = properties.getProperty("url.auth.resource.whiteList"); //$NON-NLS-1$

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestUrl = getRequestUrl(httpRequest);
		boolean hasAuth = false;
		try {
			// TODO要考虑到用户权限鉴权
			if (noNeedAuth(requestUrl)) {
				hasAuth = true;
			} else {
				hasAuth = SessionUtil.getUserInfo(httpRequest) != null ? true : false;
			}
		} catch (Exception ce) {
			LOGGER.error("Exception when check user's rights,Exception : " + ce.getMessage()); //$NON-NLS-1$
		}
		if (!hasAuth) {
			String contentType = httpRequest.getHeader("content-type"); //$NON-NLS-1$
			if (StringUtils.equals(CONTENT_TYPE_JSON, contentType)) {
				httpResponse.getWriter().print("{\"rtnCode\":"+Constants.RTN_CODES.SESSION_OUT+Messages.getString("AuthFilter.7")); //$NON-NLS-1$ //$NON-NLS-2$
				httpResponse.getWriter().flush();
			} else {
				httpResponse.sendRedirect(this.redirectUrlStr);
			}
			return;
		}
		filterChain.doFilter(request, response);

	}

	private String getRequestUrl(HttpServletRequest request) {
		String requestUrl = request.getRequestURI();
		String context = request.getContextPath();
		if (requestUrl.startsWith(context)) {
			if (requestUrl.indexOf(Constants.strChar.SEMICOLON) >= 0) {
				requestUrl = requestUrl.split(Constants.strChar.SEMICOLON)[0].substring(context.length());
			} else if (requestUrl.indexOf(Constants.strChar.UNKNOW) >= 0) {
				requestUrl = requestUrl.split("\\?")[0].substring(context.length()); //$NON-NLS-1$

			} else {
				requestUrl = requestUrl.substring(context.length());
			}
		}

		return requestUrl;
	}

	private boolean noNeedAuth(String url) {
		String pattern = this.urlWhiteList;
		return StringUtil.checkPattern(url, pattern);
	}

}
