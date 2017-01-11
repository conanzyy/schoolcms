package com.cuckoo.cms.teacher.service;

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
import com.cuckoo.cms.teacher.dao.TeaGrantApplyDao;
import com.cuckoo.cms.teacher.dao.TeaGrantDao;
import com.cuckoo.cms.teacher.pojo.TeaGrant;
import com.cuckoo.cms.teacher.pojo.TeaGrantApply;
import com.cuckoo.cms.teacher.pojo.req.TeaGrantAddReq;

@Service
public class TeaGrantService {
	
	//错误异常日志
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_INFO_MODIFY;

	private static final int INSERT_FAILED = 33000;
	
	//注入Dao对象
	@Autowired
	private TeaGrantDao teaGrantDao;
	
	@Autowired
	private TeaGrantApplyDao teaGrantApplyDao;
	
	//获取奖助列表
	@Transactional
	public List<TeaGrant> getTeaGrantList(String userId,String tenantId) {
		return teaGrantDao.getTeaGrantList(userId, tenantId);
	}
	
	//获取奖助详情
	@Transactional
	public TeaGrantApply getTeaGrantApplyInfo(String applyId){
		TeaGrantApply  TeaGrantApplyInfo = teaGrantApplyDao.getTeaGrantApplyInfo(applyId);
		if (TeaGrantApplyInfo == null) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get TeaGrantApplyInfo failed.");
			throw new CmsException("select TeaGrantApplyInfo failed.", INSERT_FAILED);
		}
		System.out.println(TeaGrantApplyInfo);
		return TeaGrantApplyInfo;
	}
	
	//审核奖助信息
	@Transactional
	public void updateTeaGrantApplyInfo(String applyId,int audit){
		int updateGrantApplyInfo=0;
		if(audit==1){
			updateGrantApplyInfo = teaGrantApplyDao.updateTeaGrantApplyInfoYes(applyId);
		}
		if(audit==2){
			updateGrantApplyInfo = teaGrantApplyDao.updateTeaGrantApplyInfoNo(applyId);
		}
		if(updateGrantApplyInfo<=0){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get TeaGrantApplyInfo failed.");
			throw new CmsException("update TeaGrantApplyInfo failed.", INSERT_FAILED);
		}
		
	}
	
	//删除奖助信息
	@Transactional
	public void deleteTeaGrantApplyInfo(String applyId){
		int deleteTeaGrantInfo = teaGrantApplyDao.deleteTeaGrantApplyInfo(applyId);
		if(deleteTeaGrantInfo<=0){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get TeaGrantApplyInfo failed.");
			throw new CmsException("delete TeaGrantApplyInfo failed.", INSERT_FAILED);
		}
	}
	
	//创建奖助
	@Transactional
	public void createTeaGrantInfo(TeaGrantAddReq teaGrantAddReq,User user){
		TeaGrantAddReq createTeaGrant = new TeaGrantAddReq(user.getUserId(), 
						teaGrantAddReq.getName(), teaGrantAddReq.getProId(), 
						teaGrantAddReq.getClassId(), teaGrantAddReq.getGrantType(), 
						teaGrantAddReq.getApplyTime(), teaGrantAddReq.getOverTime(), 
						teaGrantAddReq.getDescription(), teaGrantAddReq.getDepartId() 
						);
		teaGrantDao.createTeaGrantInfo(createTeaGrant);
		String grantId = createTeaGrant.getGrantId();
		if (StringUtils.isBlank(grantId)) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "insert TeaGrantInfo failed.");
			throw new CmsException("insert TeaGrantInfo failed.", INSERT_FAILED);
		}
		
	}
	
	
}
