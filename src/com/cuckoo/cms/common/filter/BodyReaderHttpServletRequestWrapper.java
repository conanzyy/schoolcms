package com.cuckoo.cms.common.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.Charsets;
import org.springframework.util.StreamUtils;
/**
 * 
 * @author tsx270129
 *
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private final byte[] body;

	public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = StreamUtils.copyToByteArray(request.getInputStream());

	}

	public static BodyReaderHttpServletRequestWrapper createInstance(HttpServletRequest httpServletRequest)
			throws IOException {
		BodyReaderHttpServletRequestWrapper requestWrapper = null;
		if (httpServletRequest instanceof BodyReaderHttpServletRequestWrapper) {
			requestWrapper = (BodyReaderHttpServletRequestWrapper) httpServletRequest;
		} else {
			requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
		}

		return requestWrapper;
	}

	public BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(getInputStream(), Charsets.UTF_8));
	}

	@Override
	public ServletInputStream getInputStream() {
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

		return new ServletInputStremlmp(bais);
	}

	static class ServletInputStremlmp extends ServletInputStream {

		private ByteArrayInputStream bais;

		public ServletInputStremlmp(ByteArrayInputStream bais) {
			super();
			this.bais = bais;
		}

		@Override
		public int read() throws IOException {
			return bais.read();
		}

	}
}
