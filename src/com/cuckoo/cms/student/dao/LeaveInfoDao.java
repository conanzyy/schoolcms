package com.cuckoo.cms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.student.pojo.Leave;
import com.cuckoo.cms.student.pojo.req.LeaveAddReq;

public interface LeaveInfoDao {
	List<Leave> getLeaveInfo(String userId);
	int updateLeaveInfo(@Param("leaveId")String leaveId,@Param("userId")String userId);
	void createCourseLeave(LeaveAddReq leaveAddReq);
	void createSchoolLeave(LeaveAddReq leaveAddReq);
}
