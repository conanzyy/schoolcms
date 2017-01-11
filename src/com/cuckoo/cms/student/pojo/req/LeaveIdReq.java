package com.cuckoo.cms.student.pojo.req;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LeaveIdReq {
	@NotNull
	private String leaveId;
}
