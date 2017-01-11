package com.cuckoo.cms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.pojo.MyOrderInfo;

public interface IMyOrderDao {
List<MyOrderInfo> getMyOrderList(User user);

int cancleMyOrder(@Param("orderId")String orderId,@Param("userId")String userId);
}
