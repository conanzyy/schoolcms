package com.cuckoo.cms.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.admin.pojo.Counselor;
import com.cuckoo.cms.common.user.pojo.User;


public interface ICounselorDao {
	List<Counselor> getCounselorList(String tenantId);
	
	int  createCounselor(Counselor req) ;
	String getCounselorByUserId(User user);
	 int updateCounselor(Counselor req);

	String teacherByTeaNum(Counselor req);
	
	 int deleteCounselor(@Param("counselorId")String counselorId ,@Param("tenantId")String tenantId);
}
