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
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.dao.IMentalHealthDao;
import com.cuckoo.cms.teacher.dao.TeaStudentInfoDao;
import com.cuckoo.cms.teacher.pojo.MentalHealth;
import com.cuckoo.cms.teacher.pojo.req.MentalHealthReq;
import com.cuckoo.cms.teacher.pojo.resp.MentalHealthInfoResp;


/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class MentalHealthService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MentalHealthService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	
	@Autowired
	private IMentalHealthDao iMentalHealthDao;
	
	@Autowired
	private TeaStudentInfoDao teaStudentInfoDao;
	
	public 	List<MentalHealth> getMentalHealthList(String tenantId){
		return iMentalHealthDao.getMentalHealthList(tenantId);
	}
	
	
	public MentalHealthInfoResp getMentalHealthInfo(String healthId) {
		MentalHealth mentalHealthInfo= iMentalHealthDao.getMentalHealthInfo(healthId);
		if (mentalHealthInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get mentalHealthInfo failed.");
			throw new CmsException("get mentalHealthInfo failed.", INSERT_FAILED);
		}
		MentalHealthInfoResp resp = new MentalHealthInfoResp();
		resp.setMentalHealthInfo(mentalHealthInfo);
//		resp.setTpracticeInfo(tpracticeInfo);
		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
		return resp;
	}
	
	@Transactional
	public void updateMentalHealth(MentalHealthReq mentalHealthDelReq) {
		int updateCount = iMentalHealthDao.updateMentalHealth(mentalHealthDelReq.getHealthId(), mentalHealthDelReq.getResult(),
				mentalHealthDelReq.getWay(),mentalHealthDelReq.getRecord(),mentalHealthDelReq.getStep());
		if (updateCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "update mentalHealth failed.");
			throw new CmsException("update mentalHealth failed.", INSERT_FAILED);
		}
	}
	
	public void deleteMentalHealth(String healthId) {
		int delCount = iMentalHealthDao.deleteMentalHealth(healthId);
		if (delCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete mentalHealth failed.");
			throw new CmsException("delete mentalHealth  failed.", INSERT_FAILED);
		}
	}
//	
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


	public void batchAdd(List<MentalHealth> mentalHealths, List<String> stuNums) throws MsgException {
		List<String> userIds = teaStudentInfoDao.getTeaStudentUserId(stuNums);
		if (userIds.size() != mentalHealths.size()) {
			throw new MsgException("插入错误，请检查学号是否填写错误");
		}
		for (int i = 0; i < userIds.size(); i++) {
			mentalHealths.get(i).setUserId(userIds.get(i));
		}
		iMentalHealthDao.batchInsert(mentalHealths);
	}

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
