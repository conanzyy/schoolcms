package com.cuckoo.cms.student.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.pojo.req.RoleReq;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.IPracticeDao;
import com.cuckoo.cms.student.pojo.Notice;
import com.cuckoo.cms.student.pojo.Practice;
import com.cuckoo.cms.student.pojo.req.PracticeAddReq;
import com.cuckoo.cms.student.pojo.req.PracticeReq;
import com.cuckoo.cms.student.pojo.resp.NoticeInfoResp;
import com.cuckoo.cms.student.pojo.resp.PracticeInfoResp;

/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class PracticeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	
	@Autowired
	private IPracticeDao iPracticeDao;
	
	public 	List<Practice> getPracticeList(String userId){
		return iPracticeDao.getPracticeList(userId);
	}
	
	@Transactional
	public void createPractice(PracticeAddReq practicereq, User user) {
		Practice practice = new Practice(practicereq.getEmType(),practicereq.getWorkCompany(),
				practicereq.getCompanyNature(),practicereq.getWorkPhone(),practicereq.getSuperName(),
				practicereq.getWorkAddress(),practicereq.getSuperPhone(),practicereq.getPracticeRecord(),user.getUserId());
		iPracticeDao.createPractice(practice);
		//String practiceId = practice.getPracticeId();
//		if (StringUtils.isBlank(practiceId)) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "insert practice failed.");
//			throw new CmsException("insert practice failed.", INSERT_FAILED);
//		}

	}
	
	@Transactional
	public void updatePractice(PracticeReq practiceDelReq, User user) {
		int updateCount = iPracticeDao.updatePractice(practiceDelReq.getPracticeId(), practiceDelReq.getEmType(),
				practiceDelReq.getWorkCompany(),practiceDelReq.getCompanyNature(),practiceDelReq.getWorkPhone(),
				practiceDelReq.getSuperName(),practiceDelReq.getWorkAddress(),practiceDelReq.getSuperPhone(),
				practiceDelReq.getPracticeRecord(),user.getUserId());
		if (updateCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "update practice failed.");
			throw new CmsException("update practice failed.", INSERT_FAILED);
		}
//	iRoleManagerDao.deleteRoleAuth(roleDelReq.getRoleId());
//		List<String> authIds = roleDelReq.getAuthIds();
//		if (authIds != null && !authIds.isEmpty()) {
//			iRoleManagerDao.createRoleAuthList(roleDelReq.getRoleId(), authIds);
//		}
	}
	
	public PracticeInfoResp getPracticeInfo(String practiceId, User user) {
		Practice practiceInfo= iPracticeDao.getPracticeInfo(practiceId, user.getUserId());
		if (practiceInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get practiceInfo failed.");
			throw new CmsException("get practiceInfo failed.", INSERT_FAILED);
		}
		PracticeInfoResp resp = new PracticeInfoResp();
		resp.setPracticeInfo(practiceInfo);
		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
		return resp;
	}
}
