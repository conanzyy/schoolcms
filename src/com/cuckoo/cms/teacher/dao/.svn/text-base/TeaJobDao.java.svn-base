package com.cuckoo.cms.teacher.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cuckoo.cms.teacher.pojo.Job;

public interface TeaJobDao {
	List<Job> getTeaJobList(@Param("userId")String userId,@Param("tenantId")String tenantId);
	Job getTeaJob(String jobId);
	int updateTeaJobInfo(String jobType,String companyNature,String companyName,
						 String address,String phone,String jobId);
	int deleteTeaJobInfo(String jobId);
	void bacthInsert(List<Job> jobs);
}
