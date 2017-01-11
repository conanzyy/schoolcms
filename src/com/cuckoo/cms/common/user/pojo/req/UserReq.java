package com.cuckoo.cms.common.user.pojo.req;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 
 * @author tsx270129
 *
 */
@Data
public class UserReq {
	@NotNull(message = "用户名不能为空")
	private String userName;
	@NotNull(message = "密码不能为空")
	private String passWord;

}
