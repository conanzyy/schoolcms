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
import com.cuckoo.cms.teacher.dao.TeaStudentInfoDao;
import com.cuckoo.cms.teacher.pojo.TeaStudent;
import com.cuckoo.cms.teacher.pojo.req.TeaStudentEditReq;

@Service
public class TeaStudentManagerService {
	
	//异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_INFO_MODIFY;

	private static final int INSERT_FAILED = 30000;
	
	//注入Dao对象
	@Autowired
	private TeaStudentInfoDao teaStudentInfoDao;
	
	//获取学生信息列表
	@Transactional
	public List<TeaStudent> getStudentList(String userId,String tenantId) {
		return teaStudentInfoDao.getStudentList(userId, tenantId);
	}
	
	//获取学生信息
	@Transactional
	public TeaStudent getStudentInfo(String userId) {
		TeaStudent studentInfo = teaStudentInfoDao.getTeaStudentInfo(userId);
		if (studentInfo == null) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get studentInfo failed.");
			throw new CmsException("select studentInfo failed.", INSERT_FAILED);
		}
		System.out.println(studentInfo);
		return studentInfo;
	}
	
	//编辑学生信息
	@Transactional
	public void updateStudentInfo(TeaStudentEditReq teaStudentEditReq){
		int updateInfo = teaStudentInfoDao.updateTeaStudentInfo(teaStudentEditReq.getStuName(),teaStudentEditReq.getAddress(),
				teaStudentEditReq.getPhone(),teaStudentEditReq.getFamilyName1(),teaStudentEditReq.getFamilySex1(),teaStudentEditReq.getFamilyRelation1(),
				teaStudentEditReq.getFamilyAddress1(),teaStudentEditReq.getFamilyZipCode1(),teaStudentEditReq.getFamilyPhone1(),teaStudentEditReq.getFamilyMarriage1(),
				teaStudentEditReq.getFamilyName2(),teaStudentEditReq.getFamilySex2(),teaStudentEditReq.getFamilyRelation2(),
				teaStudentEditReq.getFamilyAddress2(),teaStudentEditReq.getFamilyZipCode2(),teaStudentEditReq.getFamilyPhone2(),teaStudentEditReq.getFamilyMarriage2(),
				teaStudentEditReq.getPrizeInfo(),
				teaStudentEditReq.getUserId()
				);
		System.out.println(teaStudentEditReq);
		if (updateInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_SERVICE
					+ Constants.strChar.VERTICAL_LINE + "update studentInfo failed.");
			throw new CmsException("update studentInfo failed.", INSERT_FAILED);
		}
	}
	
	//删除学生信息
	@Transactional
	public void delectStudentInfo(String userId) {
		int delStudentInfo = teaStudentInfoDao.delectStudentInfo(userId);
		if (delStudentInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete studentInfo failed.");
			throw new CmsException("delete studentInfo failed.", INSERT_FAILED);
		}
	}
	
	
}