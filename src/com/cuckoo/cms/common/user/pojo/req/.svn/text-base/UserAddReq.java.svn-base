package com.cuckoo.cms.common.user.pojo.req;

import javax.validation.constraints.NotNull;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAddReq extends BasePojo{
	private String userId;
	@NotNull(message = "旧密码不能为空")
	private String oldPassWord;
	@NotNull(message = "旧密码不能为空")
	private String newPassWord;
}
