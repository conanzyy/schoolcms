package com.cuckoo.cms.common.user.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.cuckoo.cms.common.BasePojo;

/**
 * 
 * @author tsx270129
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BasePojo {
	private String userId;
	private String userName;
	private String passWord;
	private String isSys;
	private String status;
	private String isChangePwd;
}
