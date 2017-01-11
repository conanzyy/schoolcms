package com.cuckoo.cms.teacher.pojo;

import java.sql.Date;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaIndexLeave extends BasePojo{
	private String leaveId;
	private String userId;
	private String stuNum;
	private String stuName;
	private String className;
	private Date applyTime;
	private String cause;
	private String leaveDays;
	private Date leaveTime;
	private Date comeTime;
	private int status;
	private String type;
	private String courseId;
}
