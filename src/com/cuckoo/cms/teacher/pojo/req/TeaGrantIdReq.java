package com.cuckoo.cms.teacher.pojo.req;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TeaGrantIdReq {
	@NotNull
	private String grantId;
}
