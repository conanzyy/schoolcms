package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.teacher.pojo.MentalHealth;



/**
 * 
 * @author chenxuefeng
 *
 */
public interface IMentalHealthDao {
	List<MentalHealth> getMentalHealthList(String tenantId);
	MentalHealth getMentalHealthInfo(@Param("healthId")String healthId);
	int updateMentalHealth(String healthId,String result,String way,String record, String step);
	int deleteMentalHealth(String healthId);
	void batchInsert(List<MentalHealth> mentalHealths);
}
