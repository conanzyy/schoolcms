package com.cuckoo.cms.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.common.user.pojo.Role;
/**
 * 
 * @author tsx270129
 *
 */
public interface IRoleManagerDao {
List<Role>	getRoleList(String tenantId );
 void createRole (Role role);
 int deleteRole(String roleId,String tenantId);
 int updateRole(String roleId,String roleName,String tenantId);
 int deleteRoleAuth(@Param("roleId")String roleId);
 Role getRoleInfo(@Param("roleId")String roleId,@Param("tenantId")String tenantId);
 void createRoleAuthList(@Param("roleId") String roleId,@Param("authids")List<String> authIds);
}
