package com.cuckoo.cms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.cuckoo.cms.teacher.pojo.OrderRecord;



/**
 * 
 * @author chenxuefeng
 *
 */
public interface IOrderRecordManagerDao {
	void createOrderRecord (OrderRecord orderRecord);
	List<OrderRecord> getOrderRecordList(String tenantId);
	OrderRecord getOrderRecordInfo(@Param("orderRecordId")String orderRecordId);
//	int updateMentalHealth(String healthId,String result,String way,String record, String step);
	int deleteOrderRecord(String orderRecordId);
}
