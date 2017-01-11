package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.teacher.pojo.TeaStudent;

public interface TeaStudentInfoDao {
	List<TeaStudent> getStudentList(String userId,String tenantId);
	TeaStudent getTeaStudentInfo(@Param("userId")String userId);
	int updateTeaStudentInfo(String stuName,String address,String phone,
			  String familyName1,String familySex1,String familyRelation1,String familyAddress1,
			  String familyZipCode1,String familyPhone1,String familyMarriage1,
			  String familyName2,String familySex2,String familyRelation2,String familyAddress2,
			  String familyZipCode2,String familyPhone2,String familyMarriage2,String prizeInfo,
			  String userId
			  );
	int delectStudentInfo(@Param("userId")String userId);
	List<String> getTeaStudentUserId(List<String> stuNums);
}
