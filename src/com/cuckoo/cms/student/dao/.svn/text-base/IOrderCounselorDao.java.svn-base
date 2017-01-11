package com.cuckoo.cms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.teacher.pojo.OrderSchedule;

public interface IOrderCounselorDao {
	List<OrderSchedule> getOrderScheduleList(@Param("counselorId")String counselorId);
	int orderCounselorSchedule(@Param("userId")String userId,@Param("scheduleId")String scheduleId);
}
