package com.cuckoo.cms.admin.service;

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
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.dao.IUserDao;
import com.cuckoo.cms.common.user.pojo.Authority;
import com.cuckoo.cms.common.user.pojo.Role;
import com.cuckoo.cms.common.user.pojo.User;

/**
 * 
 * @author tsx270129
 *
 */
@Service
public class RoleManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagerService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	@Autowired
	private IRoleManagerDao iRoleManagerDao;
	@Autowired
	private IUserDao iUserDao;

	public List<Role> getRoleList(String tenantId) {
		return iRoleManagerDao.getRoleList(tenantId);
	}

	@Transactional
	public void createRole(RoleAddReq rolereq, User user) {

		Role role = new Role(rolereq.getRoleName(), user.getUserId(), user.getTenantId());
		iRoleManagerDao.createRole(role);
		String roleId = role.getRoleId();
		if (StringUtils.isBlank(roleId)) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "insert role failed.");
			throw new CmsException("insert role failed.", INSERT_FAILED);
		}

		List<String> authIds = rolereq.getAuthIds();
		if (authIds != null && !authIds.isEmpty()) {
			iRoleManagerDao.createRoleAuthList(roleId, authIds);
		}
	}

	public void deleteRole(RoleIdReq roleDelReq, User user) {
		int delCount = iRoleManagerDao.deleteRole(roleDelReq.getRoleId(), user.getTenantId());
		if (delCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete role failed.");
			throw new CmsException("delete role failed.", INSERT_FAILED);
		}
	}

	public RoleInfoResp getRoleInfo(RoleIdReq req, User user) {
		Role roleInfo = iRoleManagerDao.getRoleInfo(req.getRoleId(), user.getTenantId());
		if (roleInfo == null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get roleInfo failed.");
			throw new CmsException("delete role failed.", INSERT_FAILED);
		}
		RoleInfoResp resp = new RoleInfoResp();
		resp.setRoleInfo(roleInfo);
		List<Authority> authIds=iUserDao.getResourceByRole(roleInfo);
		List<String> list=new ArrayList<String>();
		for(Authority auth:authIds){
			list.add(auth.getAuthId());
		}
		resp.setAuthIds(list);
		return resp;
	}

	@Transactional
	public void updateRole(RoleReq roleDelReq, User user) {
		int updateCount = iRoleManagerDao.updateRole(roleDelReq.getRoleId(), roleDelReq.getRoleName(),
				user.getTenantId());
		if (updateCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "update role failed.");
			throw new CmsException("update role failed.", INSERT_FAILED);
		}
		iRoleManagerDao.deleteRoleAuth(roleDelReq.getRoleId());
		List<String> authIds = roleDelReq.getAuthIds();
		if (authIds != null && !authIds.isEmpty()) {
			iRoleManagerDao.createRoleAuthList(roleDelReq.getRoleId(), authIds);
		}
	}

	public List<AuthorityResp> getAuthIds(User user) {
		List<Authority> authList = iUserDao.getAllResource(user);
		List<AuthorityResp> authResp = new ArrayList<AuthorityResp>();
		AuthorityResp resp = null;
		for (Authority auth : authList) {
			resp = new AuthorityResp();
			resp.setId(auth.getAuthId());
			resp.setParent(StringUtils.isBlank(auth.getParentId()) ? "#" : auth.getParentId());
			resp.setText(auth.getAuthName());
			authResp.add(resp);
		}

		return authResp;

	}
}
