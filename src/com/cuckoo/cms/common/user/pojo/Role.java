package com.cuckoo.cms.common.user.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.cuckoo.cms.common.BasePojo;

@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BasePojo {
	private String roleId;
	private String roleName;
	private String status;
	private String createTime;
	private String createBy;
public Role(String roleName,String createBy,String tenantId){
	setRoleName(roleName);
	setCreateBy(createBy);
	setTenantId(tenantId);
}
public Role(){
	
}
}
