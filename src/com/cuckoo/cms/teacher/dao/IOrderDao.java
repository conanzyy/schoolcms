package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.pojo.OrderInfo;

public interface IOrderDao {
	List<OrderInfo> getOrderList(User user);
//学生报名
	int createOrder(OrderInfo info);
    //修改预约信息以及建立档案
	int updateOrder(OrderInfo info);
	
	int oneDoneOrder(@Param("orderId")String orderId,@Param("tenantId")String tenantId);
	int deleteOrder(@Param("orderId")String orderId,@Param("tenantId")String tenantId);
}
