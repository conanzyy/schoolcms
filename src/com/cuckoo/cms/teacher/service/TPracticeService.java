package com.cuckoo.cms.teacher.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.dao.ITPracticeDao;
import com.cuckoo.cms.teacher.pojo.TPractice;
import com.cuckoo.cms.teacher.pojo.req.TPracticeIdReq;
import com.cuckoo.cms.teacher.pojo.resp.TPracticeInfoResp;

/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class TPracticeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TPracticeService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	
	@Autowired
	private ITPracticeDao iPracticeDao;
	
	public 	List<TPractice> getTPracticeList(String userId){
		return iPracticeDao.getTPracticeList(userId);
	}
	
	
	public TPracticeInfoResp getTPracticeInfo(String practiceId) {
		TPractice tpracticeInfo= iPracticeDao.getTPracticeInfo(practiceId);
		if (tpracticeInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get tpracticeInfo failed.");
			throw new CmsException("get tpracticeInfo failed.", INSERT_FAILED);
		}
		TPracticeInfoResp resp = new TPracticeInfoResp();
		resp.setTpracticeInfo(tpracticeInfo);
		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
		return resp;
	}
	
	public void deleteTpractice(String practiceId) {
		int delCount = iPracticeDao.deleteTPractice(practiceId);
		if (delCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete practice failed.");
			throw new CmsException("delete practice failed.", INSERT_FAILED);
		}
	}
	
//	@Transactional
//	public void createPractice(PracticeAddReq practicereq, User user) {
//		Practice practice = new Practice(practicereq.getEmType(),practicereq.getWorkCompany(),
//				practicereq.getCompanyNature(),practicereq.getWorkPhone(),practicereq.getSuperName(),
//				practicereq.getWorkAddress(),practicereq.getSuperPhone(),practicereq.getPracticeRecord(),user.getUserId());
//		iPracticeDao.createPractice(practice);
		//String practiceId = practice.getPracticeId();
//		if (StringUtils.isBlank(practiceId)) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "insert practice failed.");
//			throw new CmsException("insert practice failed.", INSERT_FAILED);
//		}

//	}
//	
//	@Transactional
//	public void updatePractice(PracticeReq practiceDelReq, User user) {
//		int updateCount = iPracticeDao.updatePractice(practiceDelReq.getPracticeId(), practiceDelReq.getEmType(),
//				practiceDelReq.getWorkCompany(),practiceDelReq.getCompanyNature(),practiceDelReq.getWorkPhone(),
//				practiceDelReq.getSuperName(),practiceDelReq.getWorkAddress(),practiceDelReq.getSuperPhone(),
//				practiceDelReq.getPracticeRecord(),user.getUserId());
//		if (updateCount <= 0) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "update practice failed.");
//			throw new CmsException("update practice failed.", INSERT_FAILED);
//		}
//	iRoleManagerDao.deleteRoleAuth(roleDelReq.getRoleId());
//		List<String> authIds = roleDelReq.getAuthIds();
//		if (authIds != null && !authIds.isEmpty()) {
//			iRoleManagerDao.createRoleAuthList(roleDelReq.getRoleId(), authIds);
//		}
//	}
//	
//	public PracticeInfoResp getPracticeInfo(String practiceId, User user) {
//		Practice practiceInfo= iPracticeDao.getPracticeInfo(practiceId, user.getUserId());
//		if (practiceInfo==null) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "get practiceInfo failed.");
//			throw new CmsException("get practiceInfo failed.", INSERT_FAILED);
//		}
//		PracticeInfoResp resp = new PracticeInfoResp();
//		resp.setPracticeInfo(practiceInfo);
//		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
//		return resp;
//	}
}
