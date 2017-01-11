package com.cuckoo.cms.common.filter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.StreamUtils;

import com.cuckoo.cms.common.CmsBeanFactory;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;

/**
 * 
 * @author tsx270129
 *
 */
public class XssFilter implements Filter {

	private List<String> unsafeWords = new ArrayList<String>();

	@Override
	public void init(FilterConfig conf) throws ServletException {

		Properties properties = CmsBeanFactory.getBean("configProperties"); //$NON-NLS-1$
		String words = properties.getProperty("reserved.xss.script.words"); //$NON-NLS-1$
		if (StringUtils.isNotBlank(words)) {
			unsafeWords = Arrays.asList(words.split(",")); //$NON-NLS-1$
		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) {
			filterChain.doFilter(request, response);
			return;
		}
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		Enumeration<?> params = httpServletRequest.getParameterNames();
		if (!params.hasMoreElements()) {
			checkRequestBody(request, response, filterChain);
			return;
		}

		checkParamters(request, response, filterChain, httpServletRequest, params);
		return;
	}

	@Override
	public void destroy() {

	}

	private void checkParamters(ServletRequest request, ServletResponse response, FilterChain filterChain,
			HttpServletRequest httpServletRequest, Enumeration<?> params) throws IOException, ServletException {

		while (params.hasMoreElements()) {
			String cache = httpServletRequest.getParameter((String) params.nextElement());
			if (!isSafeParam(cache)) {
				throw new CmsException(Messages.getString("XssFilter.0"), Constants.RTN_CODES.PARAM_ERROR); //$NON-NLS-1$
			}
		}

		filterChain.doFilter(request, response);
	}

	private void checkRequestBody(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		ServletRequest requestWrapper = BodyReaderHttpServletRequestWrapper
				.createInstance((HttpServletRequest) request);
		String requestContent = StreamUtils.copyToString(requestWrapper.getInputStream(), Charset.forName("UTF-8")); //$NON-NLS-1$
		if (!isSafeParam(requestContent)) {
			throw new CmsException(Messages.getString("XssFilter.1"), Constants.RTN_CODES.PARAM_ERROR); //$NON-NLS-1$
		}
		filterChain.doFilter(requestWrapper, response);

	}

	private boolean isSafeParam(String content) {

		if (StringUtils.isBlank(content)) {
			return true;
		}

		String checkString = content.toLowerCase(Locale.US);
		for (String unsafeString : unsafeWords) {
			if (checkString.contains(unsafeString)) {
				return false;
			}
		}
		return true;

	}
}
