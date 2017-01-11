package com.cuckoo.cms.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.exception.MsgException;

/**
 * 
 * @author tsx270129
 *
 */
public class BaseController {
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleException(Exception ex) {

		LOGGER.error("Exception", ex);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, Constants.RTN_CODES.INTERNAL_SERVER_ERROR);
		responseMap.put(Constants.ERROR_MSG, "System error");
		return responseMap;

	}

	@ExceptionHandler(CmsException.class)
	@ResponseBody
	public Map<String, Object> handleException(CmsException ex) {

		LOGGER.error("CmsException:{}", ex.getMessage());
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, ex.getRtnCode());
		responseMap.put(Constants.ERROR_MSG, ex.getMessage());
		return responseMap;

	}

	@ExceptionHandler(MsgException.class)
	@ResponseBody
	public Map<String, Object> handleException(MsgException ex) {
		LOGGER.error("MsgException:{}", ex.getMessage());
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(Constants.RTN_CODE, ex.getRtnCode());
		responseMap.put(Constants.ERROR_MSG, ex.getMessage());
		return responseMap;

	}
}
