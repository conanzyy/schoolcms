package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.teacher.pojo.TeaStuScore;

public interface TeaStuScoreDao {
	List<TeaStuScore> getTeaStuScoreList(String userId,String tenantId);
	TeaStuScore getTeaStuScoreInfo(@Param("scoreId")String scoreId);
	int updateTeaStuScoreInfo(String score,String scoreId);
	int deleteTeaStuScoreInfo(@Param("scoreId")String scoreId);
}
