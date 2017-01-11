package com.cuckoo.cms.student.pojo.req;

import java.sql.Date;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LeaveAddReq extends BasePojo{
	private String leaveId;
	private String userId;
	private Date applyTime;
	private String cause;
	private String leaveDays;
	private Date leaveTime;
	private Date comeTime;
	private int status;
	private String type;
	private String courseId;
	
	public LeaveAddReq(String userId,String cause,String leaveDays,
			Date leaveTime,Date comeTime,String courseId){
		setUserId(userId);
		setCause(cause);
		setLeaveDays(leaveDays);
		setLeaveTime(leaveTime);
		setComeTime(comeTime);
		setCourseId(courseId);
		
	}
	public LeaveAddReq(){
		
	}
	
}









