package com.cuckoo.cms.teacher.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.service.RoleManagerService;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.teacher.dao.TeaLeaveDao;
import com.cuckoo.cms.teacher.pojo.TeaLeave;

@Service
public class TeaLeaveManageService {
	//错误异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_INFO_MODIFY;

	private static final int INSERT_FAILED = 30000;
			
	//注入Dao对象
	@Autowired
	private TeaLeaveDao teaLeaveDao;
	
	//获取请假信息列表
	@Transactional
	public List<TeaLeave> getTeaLeaveList(String userId,String tenantId) {
		return teaLeaveDao.getTeaLeaveList(userId, tenantId);
	}
	
	//获取请假信息详情
	@Transactional
	public List<TeaLeave> getTeaLeave(String leaveId){
		List<TeaLeave>  TeaLeaveInfo = teaLeaveDao.getTeaLeave(leaveId);
		if (TeaLeaveInfo == null) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get TeaLeaveInfo failed.");
			throw new CmsException("select TeaLeaveInfo failed.", INSERT_FAILED);
		}
		System.out.println(TeaLeaveInfo);
		return TeaLeaveInfo;
	}
	
	//请假信息审核
	@Transactional
	public void updateTeaLeaveInfo(String leaveId,int audit){
		int updateLeaveInfo=0;
		if(audit==1){
			updateLeaveInfo = teaLeaveDao.updateTeaLeaveInfoYes(leaveId);
		}
		if(audit==2){
			updateLeaveInfo = teaLeaveDao.updateTeaLeaveInfoNo(leaveId);
		}
		if(updateLeaveInfo<=0){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get TeaLeaveInfo failed.");
			throw new CmsException("update TeaLeaveInfo failed.", INSERT_FAILED);
		}
		
	}
	
	public void deleteTeaLeave(String leaveId) {
		//int delCount = iMentalHealthDao.deleteMentalHealth(healthId);
		int delCount = teaLeaveDao.deleteTeaLeave(leaveId);
		if (delCount <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete Leave failed.");
			throw new CmsException("delete Leave  failed.", INSERT_FAILED);
		}
	}
}









