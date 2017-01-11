package com.cuckoo.cms.teacher.dao;

import java.util.List;

import com.cuckoo.cms.common.user.pojo.Role;
import com.cuckoo.cms.teacher.pojo.Grant;

/**
 * 奖助管理
 * @author worker
 *
 */
public interface IGrantManagerDao {
	// 获取奖助列表
	List<Grant> getGrantList(int tenantId,int currentUserId);
	
}
