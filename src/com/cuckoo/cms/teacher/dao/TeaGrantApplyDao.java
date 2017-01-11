package com.cuckoo.cms.teacher.dao;

import com.cuckoo.cms.teacher.pojo.TeaGrantApply;

public interface TeaGrantApplyDao {
	TeaGrantApply getTeaGrantApplyInfo(String applyId);
	int updateTeaGrantApplyInfoYes(String applyId);
	int updateTeaGrantApplyInfoNo(String applyId);
	int deleteTeaGrantApplyInfo(String applyId);
}
