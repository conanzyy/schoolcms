package com.cuckoo.cms.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.admin.dao.IRoleManagerDao;
import com.cuckoo.cms.admin.pojo.req.RoleAddReq;
import com.cuckoo.cms.admin.pojo.req.RoleIdReq;
import com.cuckoo.cms.admin.pojo.req.RoleReq;
import com.cuckoo.cms.admin.pojo.resp.AuthorityResp;
import com.cuckoo.cms.admin.pojo.resp.RoleInfoResp;
import com.cuckoo.cms.admin.service.RoleManagerService;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.dao.IUserDao;
import com.cuckoo.cms.common.user.pojo.Authority;
import com.cuckoo.cms.common.user.pojo.Role;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.dao.IGrantManagerDao;
import com.cuckoo.cms.teacher.pojo.Grant;

/**
 * 
 * @author worker
 *
 */
@Service
public class GrantManagerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GrantManagerService.class);

	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;

//	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.TEACHER_GRANT_MODIFY;

	private static final int INSERT_FAILED = 30000;
	@Autowired
	private IGrantManagerDao iGrantManagerDao;
	
	
	// 查询当前用户的 奖助活动
	public List<Grant> getGrantList(int tenantId,int currentUserId) {
		
		return iGrantManagerDao.getGrantList(tenantId,currentUserId);
	}

//	@Transactional
//	public void createRole(RoleAddReq rolereq, User user) {
//
//		Role role = new Role(rolereq.getRoleName(), user.getUserId(), user.getTenantId());
//		iRoleManagerDao.createRole(role);
//		String roleId = role.getRoleId();
//		if (StringUtils.isBlank(roleId)) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "insert role failed.");
//			throw new CmsException("insert role failed.", INSERT_FAILED);
//		}
//
//		List<String> authIds = rolereq.getAuthIds();
//		if (authIds != null && !authIds.isEmpty()) {
//			iRoleManagerDao.createRoleAuthList(roleId, authIds);
//		}
//	}

	

	
	
	

}
