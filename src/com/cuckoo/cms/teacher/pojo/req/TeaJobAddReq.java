package com.cuckoo.cms.teacher.pojo.req;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaJobAddReq extends BasePojo{
	private String jobId;
	private String userId;
	private String jobType;
	private String companyNature;
	private String companyName;
	private String address;
	private String phone;
	private String status;

}
