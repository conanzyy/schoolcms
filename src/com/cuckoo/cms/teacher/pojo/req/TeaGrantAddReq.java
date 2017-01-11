package com.cuckoo.cms.teacher.pojo.req;

import java.sql.Date;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaGrantAddReq extends BasePojo{
	private String grantId;//奖助ID
	private String userId;//创建奖助活动教师ID
	private String name;//奖助名称
	private String proId;//专业ID
	private String classId;//班级ID
	private String grantType;//奖助级别
	private Date applyTime;//申请开放时间
	private Date overTime;//申请结束时间
	private String description;//奖助描述
	private String departId;//系ID
	
	public TeaGrantAddReq(String userId,String name,String proId,String classId,
					String grantType,Date applyTime,Date overTime,String description,
					String departId){
		setUserId(userId);
		setName(name);
		setProId(proId);
		setClassId(classId);
		setGrantType(grantType);
		setApplyTime(applyTime);
		setOverTime(overTime);
		setDescription(description);
		setDepartId(departId);
		
	}
	
	public TeaGrantAddReq(){
		
	}
}
