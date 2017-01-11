package com.cuckoo.cms.student.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.service.RoleManagerService;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.LeaveInfoDao;
import com.cuckoo.cms.student.pojo.Leave;
import com.cuckoo.cms.student.pojo.req.LeaveAddReq;

@Service
public class LeaveManagerService {
		//错误异常日志
		private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

		private static final String STUDENT_SERVICE = Constants.ServiceType.STUDENT_SERVICE;

		private static final String STUDENT_MODULE_DEFINE = Constants.STUDENT_MODULE_DEFINE.STUDENT_INFO_MODIFY;

		private static final int INSERT_FAILED = 20000;
		
		//注入Dao对象
		@Autowired
		private LeaveInfoDao leaveInfoDao;
		
		//获取请假信息
		@Transactional
		public List<Leave> getLeaveInfo(String userId,User user){
			List<Leave>  leaveInfo = leaveInfoDao.getLeaveInfo(user.getUserId());
			if (leaveInfo == null) {
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "get leaveInfo failed.");
				throw new CmsException("select leaveInfo failed.", INSERT_FAILED);
			}
			System.out.println(leaveInfo);
			return leaveInfo;
		}
		
		//销假
		@Transactional
		public void updateLeaveInfo(String leaveId,User user){
			int updateLeave = leaveInfoDao.updateLeaveInfo(leaveId,user.getUserId());
			if(updateLeave<=0){
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "get leaveInfo failed.");
				throw new CmsException("update leaveInfo failed.", INSERT_FAILED);
			}
		}
		
		//新增课假
		@Transactional
		public void createCourseLeave(LeaveAddReq leave,User user){
			LeaveAddReq leaveAddReq = new LeaveAddReq(user.getUserId(),leave.getCause(),
											leave.getLeaveDays(),leave.getLeaveTime(),
											leave.getComeTime(),leave.getCourseId());
			leaveInfoDao.createCourseLeave(leaveAddReq);
			String leaveId = leaveAddReq.getLeaveId();
			if (StringUtils.isBlank(leaveId)) {
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "insert courseLeave failed.");
				throw new CmsException("insert courseLeave failed.", INSERT_FAILED);
			}
		}
		
		//新增校假
		@Transactional
		public void createSchoolLeave(LeaveAddReq leave,User user){
			LeaveAddReq leaveAddReq = new LeaveAddReq(user.getUserId(),
					leave.getCause(),leave.getLeaveDays(),leave.getLeaveTime(),
					leave.getComeTime(),
					leave.getCourseId());
			leaveInfoDao.createSchoolLeave(leaveAddReq);
			String leaveId = leaveAddReq.getLeaveId();
			if (StringUtils.isBlank(leaveId)) {
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "insert schoolLeave failed.");
				throw new CmsException("insert schoolLeave failed.", INSERT_FAILED);
			}
		}
}










