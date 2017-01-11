package com.cuckoo.cms.admin.pojo.resp;

import java.util.List;

import com.cuckoo.cms.common.user.pojo.Role;

import lombok.Data;
@Data
public class RoleInfoResp {
private Role roleInfo;
private List<String>  authIds;
}
