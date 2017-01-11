package com.cuckoo.cms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.student.pojo.Notice;
/**
 * 
 * @author chenxuefeng
 *
 */
public interface INoticeManagerDao {
	Notice getNoticeInfo(@Param("noticeId")String noticeId,@Param("tenantId")String tenantId);
	List<Notice>	getNoticeList(String tenantId );
	List<Notice>	getIndexNoticeList(String tenantId );//学生端首页公告
}
