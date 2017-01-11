package com.cuckoo.cms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.student.pojo.Notice;
import com.cuckoo.cms.student.pojo.Practice;

/**
 * 
 * @author chenxuefeng
 *
 */
public interface IPracticeDao {
	Practice getPracticeInfo(@Param("practiceId")String practiceId,@Param("userId")String userId);
	List<Practice> getPracticeList(String userId);
	void createPractice (Practice practice);
	int updatePractice(String practiceId,String emType,String workCompany,String companyNature, String workPhone,
			String superName,String workAddress,String superPhone,String practiceRecord,String userId);
}
