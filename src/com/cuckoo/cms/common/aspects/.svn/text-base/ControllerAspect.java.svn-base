package com.cuckoo.cms.common.aspects;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.utils.LogUtil;

/**
 * 
 * @author tsx270129
 *
 */
@Aspect
@Component
public class ControllerAspect {

	private static final String OP_SUCCESSED = "Successed";
	private static final String OP_FAILED = "Failed";

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void pointRequestMapping() {
		

	}

	@Pointcut("execution(* com.cuckoo.cms.teacher.controller.*.*(..))")
	public void pointCutTeacherFoler() {

	}

	@Pointcut("execution(* com.cuckoo.cms.student.controller.*.*(..))")
	public void pointCutStudentFoler() {

	}

	@Pointcut("execution(* com.cuckoo.cms.admin.controller.*.*(..))")
	public void pointCutAdminFoler() {

	}

	@Around("pointCutTeacherFoler() && pointRequestMapping()")
	public Object aroundTeacherFolerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		return aroundController(pjp, Constants.ServiceType.TEACHER_SERVICE);
	}

	@Around("pointCutStudentFoler() && pointRequestMapping()")
	public Object aroundStudentFolerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		return aroundController(pjp, Constants.ServiceType.STUDENT_SERVICE);
	}

	@Around("pointCutAdminFoler() && pointRequestMapping()")
	public Object aroundAdminFolerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		return aroundController(pjp, Constants.ServiceType.CMSADMIN_SERVICE);
	}

	private Object aroundController(ProceedingJoinPoint pjp, String serviceName) throws Throwable {

		Object result = null;
		Object[] arg = pjp.getArgs();
		BindingResult bindResult = null;

		for (int i = 0; i < arg.length; i++) {
			if (arg[i] instanceof BindingResult) {
				bindResult = (BindingResult) arg[i];
				break;
			}

		}

		String opResult = StringUtils.EMPTY;

		try {

			processParamErrors(bindResult, pjp, serviceName);
			result = pjp.proceed();
			opResult = getOpResult(result);

		} catch (Throwable e) {
			opResult = OP_FAILED;
			throw e;
		} finally {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String methodName = pjp.getSignature().getName();
				LogUtil.opLog(request, serviceName, methodName, opResult);
			}

		}
		return result;

	}

	private void processParamErrors(BindingResult bindResult, ProceedingJoinPoint pjp, String serviceName)
			throws MsgException {
		HttpServletRequest request = getRequest();
		if (bindResult != null && bindResult.hasErrors() && request != null) {
			String methodName = pjp.getSignature().getName();
			LogUtil.securLog(request, serviceName, methodName, bindResult.getAllErrors().toString());
			throw new MsgException("parma error", Constants.RTN_CODES.PARAM_ERROR);
		}
	}

	private String getOpResult(Object result) {
		String opResult = OP_SUCCESSED;
		if (result instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = (Map<String, Object>) result;
			Object errMsg = responseMap.get(Constants.ERROR_MSG);
			if (errMsg != null && StringUtils.isNotEmpty(errMsg.toString())) {
				opResult = OP_FAILED;
			} else {
				opResult = OP_SUCCESSED;
			}
		}
		return opResult;
	}

	private HttpServletRequest getRequest() {
		HttpServletRequest request = null;
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes instanceof ServletRequestAttributes) {
			request = ((ServletRequestAttributes) requestAttributes).getRequest();
		}

		return request;
	}
}
