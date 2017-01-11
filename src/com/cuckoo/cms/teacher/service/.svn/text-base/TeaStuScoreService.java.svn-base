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
import com.cuckoo.cms.teacher.dao.TeaStuScoreDao;
import com.cuckoo.cms.teacher.pojo.TeaStuScore;
import com.cuckoo.cms.teacher.pojo.req.TeaStuScoreAddReq;

@Service
public class TeaStuScoreService {
	
	//异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_INFO_MODIFY;

	private static final int INSERT_FAILED = 32000;
		
	//注入Dao对象
	@Autowired
	private TeaStuScoreDao teaStuScoreDao;
	
	//获取学生成绩列表
	@Transactional
	public List<TeaStuScore> getTeaStuScoreList(String userId,String tenantId) {
		return teaStuScoreDao.getTeaStuScoreList(userId, tenantId);
	}
	
	//获取学生成绩详情
	@Transactional
	public TeaStuScore getTeaStuScoreInfo(String scoreId) {
		TeaStuScore scoreInfo = teaStuScoreDao.getTeaStuScoreInfo(scoreId);
		if (scoreInfo == null) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get scoreInfo failed.");
			throw new CmsException("select scoreInfo failed.", INSERT_FAILED);
		}
		System.out.println(scoreInfo);
		return scoreInfo;
	}
	
	//编辑学生成绩信息
	@Transactional
	public void updateTeaStuScoreInfo(TeaStuScoreAddReq teaStuScoreAddReq){
		int updateInfo = teaStuScoreDao.updateTeaStuScoreInfo(teaStuScoreAddReq.getScore(), teaStuScoreAddReq.getScoreId());
		if (updateInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_SERVICE
					+ Constants.strChar.VERTICAL_LINE + "update scoreInfo failed.");
			throw new CmsException("update scoreInfo failed.", INSERT_FAILED);
		}
	}
	
	//删除学生成绩信息
	@Transactional
	public void deleteTeaStuScoreInfo(String scoreId) {
		int deleteTeaStuScoreInfo = teaStuScoreDao.deleteTeaStuScoreInfo(scoreId);
		if (deleteTeaStuScoreInfo <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete scoreInfo failed.");
			throw new CmsException("delete scoreInfo failed.", INSERT_FAILED);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
