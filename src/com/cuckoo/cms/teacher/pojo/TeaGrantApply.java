package com.cuckoo.cms.teacher.pojo;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaGrantApply extends BasePojo{
	private String applyId;
	private String userId;
	private String creatTime;
	private String stuNum;
	private String stuName;
	private String grantId;
	private String name;
	private String proName;
	private String className;
	private String grantType;
	private String applyTime;
	private String overTime;
	private String description;
	private String status;
}
