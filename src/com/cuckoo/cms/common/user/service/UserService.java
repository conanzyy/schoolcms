package com.cuckoo.cms.common.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.dao.IUserDao;
import com.cuckoo.cms.common.user.pojo.Authority;
import com.cuckoo.cms.common.user.pojo.Role;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.user.pojo.req.UserAddReq;
import com.cuckoo.cms.common.user.pojo.req.UserReq;

/**
 * 
 * @author tsx270129
 *
 */
@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private static final String COMMON_SERVICE = Constants.ServiceType.COMMON_SERVICE;

	private static final String COMMON_MODULE_DEFINE = Constants.COMMON_MODULE_DEFINE.USER_INFO_MODIFY;

	@Autowired
	private IUserDao iUserDao;
	private String IS_SYS = "1"; //$NON-NLS-1$
	
	private static final int EDIT_USER_FAIL=10000;
	
	private static final int USER_HAS_EXIST=10001;
	
	private static final int UPDATA_USER_FAIL=10002;

	public User login(UserReq req) {

		return iUserDao.login(req);
	}

	private List<Authority> getAllByUserId(User user) {

		List<Authority> resourceList = new ArrayList<Authority>();

		if (IS_SYS.equals(user.getIsSys())) {

			return iUserDao.getAllResource(user);
		}

		List<Role> roleList = iUserDao.getRoles(user);
		if (roleList == null || roleList.isEmpty()) {
			return resourceList;
		}

		List<Authority> authorityList = null;

		for (Role role : roleList) {

			authorityList = iUserDao.getResourceByRole(role);
			if (authorityList == null || authorityList.isEmpty()) {
				continue;
			}
			resourceList.addAll(authorityList);
		}
		 Collections.sort(resourceList);
		return resourceList;

	}
	
	public JSONArray getAllMenuResourceByUserId(User user) throws Exception {

		List<Authority> resourceList = getAllByUserId(user);
		JSONArray resourceArray = new JSONArray();
		handleMenuLevel(resourceList, resourceArray);
		return resourceArray;

	}

	public void handleMenuLevel(List<Authority> resourceList, JSONArray resourceArray) {
		for (Authority resource : resourceList) {

			if (StringUtils.isBlank(resource.getParentId())) {
				JSONObject firstMenu = convertResourcetojSONObject(resource);
				JSONArray childResourceArray = new JSONArray();
				for (Authority childResource : resourceList) {
					if (resource.getAuthId().equals(childResource.getParentId())) {

						JSONObject secondMenu = convertResourcetojSONObject(childResource);
						childResourceArray.add(secondMenu);

					}
				}

				if (childResourceArray.size() > 0) {
					firstMenu.put("childMenuList", childResourceArray); //$NON-NLS-1$
					firstMenu.put("childSize", childResourceArray.size()); //$NON-NLS-1$
				}else{
					firstMenu.put("childSize", 0); //$NON-NLS-1$
				}
				resourceArray.add(firstMenu);
			}
		}
	}

	private JSONObject convertResourcetojSONObject(Authority resource) {

		JSONObject firstMenu = new JSONObject();

		firstMenu.put("menuId", resource.getAuthId()); //$NON-NLS-1$
		firstMenu.put("menuName", resource.getAuthName()); //$NON-NLS-1$
		firstMenu.put("path", resource.getPath()); //$NON-NLS-1$

		return firstMenu;
	}
	
	
	public void editUser(User user,UserAddReq addReq){
		UserReq req =new UserReq();
		req.setUserName(user.getUserName());
		req.setPassWord(addReq.getOldPassWord());
		
		if(login(req)==null){
			LOGGER.error(COMMON_SERVICE + Constants.strChar.VERTICAL_LINE + COMMON_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "edit user failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("UserService.8"), EDIT_USER_FAIL); //$NON-NLS-1$
		
	}
		
		req.setPassWord(addReq.getNewPassWord());
		
		
		if(login(req)!=null){
			LOGGER.error(COMMON_SERVICE + Constants.strChar.VERTICAL_LINE + COMMON_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "edit user failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("UserService.10"), USER_HAS_EXIST); //$NON-NLS-1$
		
	}
		addReq.setUserId(user.getUserId());
		addReq.setTenantId(user.getTenantId());
	int count=	iUserDao.editUser(addReq);
	
	if(count<=0){
		LOGGER.error(COMMON_SERVICE + Constants.strChar.VERTICAL_LINE + COMMON_MODULE_DEFINE
				+ Constants.strChar.VERTICAL_LINE + "edit user failed."); //$NON-NLS-1$
		throw new CmsException(Messages.getString("UserService.12"), UPDATA_USER_FAIL); //$NON-NLS-1$
	}
		
}
} 