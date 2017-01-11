package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.pojo.OrderSchedule;

public interface IOrderScheduleDao {
	List<OrderSchedule> getOrderScheduleList(User user);

	int cancleOrderSchedule(@Param("scheduleId") String scheduleId,@Param("cancleRemark")String cancleRemark);

	int updateOrderSchedule(OrderSchedule orderSchedule);

	int createOrderSchedule(OrderSchedule orderSchedule);

	String getOrderUser(@Param("scheduleId") String scheduleId);

	int insertNomalToOrder(@Param("scheduleId") String scheduleId);

	String getCounselorIdByUserId(@Param("userId") String userId);
}
