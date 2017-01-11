package com.cuckoo.cms.common.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;

/**
 * 
 * @author tsx270129
 *
 */
@Aspect
@Component
public class DaoAspect {
	private static final Logger logger = LoggerFactory.getLogger(DaoAspect.class);

	@Pointcut("execution(* com.cuckoo.cms.teacher.dao.*.*(..))")
	public void pointTeacherFolderDao() {

	}

	@Pointcut("execution(* com.cuckoo.cms.student.dao.*.*(..))")
	public void pointStudentFolderDao() {

	}

	@Pointcut("execution(* com.cuckoo.cms.admin.dao.*.*(..))")
	public void pointAdminFolderDao() {

	}

	@Around("pointTeacherFolderDao()&&pointStudentFolderDao()&&pointAdminFolderDao()")
	public Object aroundFolderDao(ProceedingJoinPoint pjp) {

		return new AroundDao() {

			protected void processExp(Throwable e) {
				throw new CmsException("DB error", Constants.RTN_CODES.DB_ERROR);
			}
		}.around(pjp);
	}

	private abstract class AroundDao {

		public Object around(ProceedingJoinPoint pjp) {
			Object result = null;
			String methodName = pjp.getSignature().getName();

			try {
				result = pjp.proceed();
			} catch (Throwable e) {
				logger.error("db error,methodName={}(),message={}", methodName, e.getMessage());
				processExp(e);
			}

			return result;
		}

		protected abstract void processExp(Throwable e);
	}

}
