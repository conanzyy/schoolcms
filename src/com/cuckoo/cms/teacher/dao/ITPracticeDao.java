package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.teacher.pojo.TPractice;
import com.cuckoo.cms.teacher.pojo.req.TPracticeIdReq;

/**
 * 
 * @author chenxuefeng
 *
 */
public interface ITPracticeDao {
	List<TPractice> getTPracticeList(String userId);
	TPractice getTPracticeInfo(@Param("practiceId")String practiceId);
	int deleteTPractice(String practiceId);
//	int updatePractice(String practiceId,String emType,String workCompany,String companyNature, String workPhone,
//			String superName,String workAddress,String superPhone,String practiceRecord,String userId);
}
