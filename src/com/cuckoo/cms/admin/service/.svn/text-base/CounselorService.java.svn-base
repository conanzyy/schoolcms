package com.cuckoo.cms.admin.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.dao.ICounselorDao;
import com.cuckoo.cms.admin.pojo.Counselor;
import com.cuckoo.cms.admin.pojo.req.CounselorDelReq;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;

@Service
public class CounselorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CounselorService.class);
	@Autowired
	private ICounselorDao iCounselorDao;
	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String COUNSELOR_INFO_MODIFY = Constants.CMSAUTH_MODULE_DEFINE.COUNSELOR_INFO_MODIFY;
	private static final int INSERT_FAILED = 10000;
	private static final int TEACHER_NOT_EXIST = 10001;
	private static final int DELETE_FAILED = 10002;
	private static final int UPDATE_FAILED = 10003;
	private static final int COUNSELOR_BY_USERID_HAVE_EXIST = 10001;

	public List<Counselor> getCounselorList(String tenantId) {
		return iCounselorDao.getCounselorList(tenantId);
	}

	public void createCounselor(User user, Counselor req) {

		String userId = iCounselorDao.teacherByTeaNum(req);
		if (StringUtils.isBlank(userId)) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "teacher not exist."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("CounselorService.1"), TEACHER_NOT_EXIST); //$NON-NLS-1$
		}
		req.setUserId(userId);
		String counselorId = iCounselorDao.getCounselorByUserId(user);
		if (StringUtils.isNotBlank(counselorId)) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "counselor by userId have exist."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("CounselorService.0"), COUNSELOR_BY_USERID_HAVE_EXIST);  //$NON-NLS-1$
		}
		int count = iCounselorDao.createCounselor(req);
		if (count <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "insert Counselor failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("CounselorService.2"), INSERT_FAILED);  //$NON-NLS-1$
		}
	}

	public void updateCounselor(Counselor req) {
		String userId = iCounselorDao.teacherByTeaNum(req);
		if (StringUtils.isBlank(userId)) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "teacher not exist."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("CounselorService.3"), TEACHER_NOT_EXIST);  //$NON-NLS-1$
		}
		req.setUserId(userId);
		int count = iCounselorDao.updateCounselor(req);
		if (count <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "update Counselor failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("CounselorService.4"), UPDATE_FAILED);  //$NON-NLS-1$
		}
	}

	@Transactional
	public void deleteCounselor(CounselorDelReq req, User user) {
		for (String counselorId : req.getCounselorId()) {

			int delCount = iCounselorDao.deleteCounselor(counselorId, user.getTenantId());
			if (delCount <= 0) {
				LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + COUNSELOR_INFO_MODIFY
						+ Constants.strChar.VERTICAL_LINE + "delete Counselor failed."); //$NON-NLS-1$
				throw new CmsException(Messages.getString("CounselorService.5"), DELETE_FAILED);  //$NON-NLS-1$
			}
		}
	}

}