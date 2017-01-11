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
import com.cuckoo.cms.common.exception.MsgException;
import com.cuckoo.cms.teacher.dao.TeaJobDao;
import com.cuckoo.cms.teacher.dao.TeaStudentInfoDao;
import com.cuckoo.cms.teacher.pojo.Job;
import com.cuckoo.cms.teacher.pojo.req.TeaJobAddReq;

@Service
public class TeaJobService {
	//错误异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_INFO_MODIFY;

	private static final int INSERT_FAILED = 31000;
	
	//注入Dao对象
	@Autowired
	private TeaJobDao teaJobDao;
	
	@Autowired
	private TeaStudentInfoDao teaStudentInfoDao;
	
	//获取学生就业信息列表
	@Transactional
	public List<Job> getTeaJobList(String userId,String tenantId) {
		return teaJobDao.getTeaJobList(userId,tenantId);
	}
	
	//获取学生就业信息详情
	public Job getTeaJob(String jobId){
		Job jobInfo = teaJobDao.getTeaJob(jobId);
		if (jobInfo == null) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get jobInfo failed.");
			throw new CmsException("select jobInfo failed.", INSERT_FAILED);
		}
		System.out.println(jobInfo);
		return jobInfo;
	}
	
	//编辑学生就业信息
	@Transactional
	public void updateTeaJobInfo(TeaJobAddReq teaJobAddReq){
		int updateTeaJobInfo = teaJobDao.updateTeaJobInfo(
					teaJobAddReq.getJobType(),teaJobAddReq.getCompanyNature(),
					teaJobAddReq.getCompanyName(),teaJobAddReq.getAddress(),
					teaJobAddReq.getPhone(),teaJobAddReq.getJobId());
		System.out.println(updateTeaJobInfo);
		if (updateTeaJobInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_SERVICE
					+ Constants.strChar.VERTICAL_LINE + "update updateTeaJobInfo failed.");
			throw new CmsException("update updateTeaJobInfo failed.", INSERT_FAILED);
		}
	}
	
	//删除学生就业信息
	public void deleteTeaJobInfo(String jobId) {
		int deleteTeaJobInfo = teaJobDao.deleteTeaJobInfo(jobId);
		if (deleteTeaJobInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete deleteTeaJobInfo failed.");
			throw new CmsException("delete deleteTeaJobInfo failed.", INSERT_FAILED);
		}
	}

	//批量查询出userId，再批量插入
	@Transactional
	public void batchAdd(List<Job> jobs, List<String> stuNums) throws MsgException {
		List<String> userIds = teaStudentInfoDao.getTeaStudentUserId(stuNums);
		if (userIds.size() != jobs.size()) {
			throw new MsgException("数据有误，学号可能有填错。");
		}
		for (int i = 0; i < userIds.size(); i++) {
			jobs.get(i).setUserId(userIds.get(i));
		}
		teaJobDao.bacthInsert(jobs);
	}
	
	
	
	
	
	
	
}
