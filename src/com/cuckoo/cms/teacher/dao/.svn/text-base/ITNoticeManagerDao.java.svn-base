package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.cuckoo.cms.teacher.pojo.TNotice;

/**
 * 
 * @author chenxuefeng
 *
 */
public interface ITNoticeManagerDao {
	TNotice getTNoticeInfo(@Param("noticeId")String tnoticeId,@Param("tenantId")String tenantId);
	List<TNotice>	getTNoticeList(String tenantId );
	void createTNotice (TNotice notice);
}
