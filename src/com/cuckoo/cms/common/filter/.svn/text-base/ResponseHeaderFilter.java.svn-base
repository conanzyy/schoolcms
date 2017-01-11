package com.cuckoo.cms.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author tsx270129
 *
 */
public class ResponseHeaderFilter implements Filter {

	private static String cmsIframeUrl = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		cmsIframeUrl = config.getInitParameter("cmsIframeUrl");

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestUrl = httpRequest.getRequestURL().toString();
		if (StringUtils.isNotBlank(requestUrl) && !requestUrl.endsWith(".css") && !requestUrl.endsWith(".png")
				&& !requestUrl.endsWith(".jpg") && !requestUrl.endsWith(".gif") && !requestUrl.endsWith(".jpeg")
				&& !requestUrl.endsWith(".js") && !requestUrl.endsWith(".jsp")) {
			httpResponse.setHeader("Cache-Control", "max-age=0");
			httpResponse.setHeader("Pragma", "No-cache");
			httpResponse.setHeader("Expires", "0");
		}

		if (StringUtils.isNotBlank(cmsIframeUrl)) {
			httpResponse.setHeader("Access-Control-Allow-Origin", cmsIframeUrl);
		} else {
			httpResponse.setHeader("x-frame-options", "SAMEORIGIN");
		}
		filterChain.doFilter(request, response);

	}

}
