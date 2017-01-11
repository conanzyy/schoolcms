package com.cuckoo.cms.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.service.RoleManagerService;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.StudentInfoDao;
import com.cuckoo.cms.student.pojo.Student;
import com.cuckoo.cms.student.pojo.req.StudentEditReq;


@Service
public class StudentManagerService{
	
	//错误异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String STUDENT_SERVICE = Constants.ServiceType.STUDENT_SERVICE;

	private static final String STUDENT_MODULE_DEFINE = Constants.STUDENT_MODULE_DEFINE.STUDENT_INFO_MODIFY;

	private static final int INSERT_FAILED = 20000;
		
		//注入Dao对象
		@Autowired
		private StudentInfoDao studentInfoDao;
		
		//获取学生信息
		@Transactional
		public Student getStudentInfo(String userId, String tenantId) {
			Student studentInfo = studentInfoDao.getStudentInfo(userId,tenantId);
			if (studentInfo == null) {
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "get studentInfo failed.");
				throw new CmsException("select studentInfo failed.", INSERT_FAILED);
			}
			System.out.println(studentInfo);
			return studentInfo;
		}
		
		
		//更新学生信息
		@Transactional
		public void updateStudentInfo(StudentEditReq studentEditReq,User user){
			int updateInfo = studentInfoDao.updateStudentInfo(studentEditReq.getStuName(),studentEditReq.getAddress(),
					studentEditReq.getPhone(),studentEditReq.getFamilyName1(),studentEditReq.getFamilySex1(),studentEditReq.getFamilyRelation1(),
					studentEditReq.getFamilyAddress1(),studentEditReq.getFamilyZipCode1(),studentEditReq.getFamilyPhone1(),studentEditReq.getFamilyMarriage1(),
					studentEditReq.getFamilyName2(),studentEditReq.getFamilySex2(),studentEditReq.getFamilyRelation2(),
					studentEditReq.getFamilyAddress2(),studentEditReq.getFamilyZipCode2(),studentEditReq.getFamilyPhone2(),studentEditReq.getFamilyMarriage2(),
					studentEditReq.getPrizeInfo(),
					user.getUserId()
					);
			if (updateInfo <= 0) {
				LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + STUDENT_SERVICE
						+ Constants.strChar.VERTICAL_LINE + "update studentInfo failed.");
				throw new CmsException("update studentInfo failed.", INSERT_FAILED);
			}
		}
}
