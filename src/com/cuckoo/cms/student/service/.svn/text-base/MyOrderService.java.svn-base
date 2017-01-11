package com.cuckoo.cms.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.IMyOrderDao;
import com.cuckoo.cms.student.pojo.MyOrderInfo;

@Service
public class MyOrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyOrderService.class);
	private static final String STUDENT_SERVICE = Constants.ServiceType.STUDENT_SERVICE;
	private static final String MY_ORDER_MODIFY = Constants.STUDENT_MODULE_DEFINE.MY_ORDER_MODIFY;
	private static final int CANCLE_MYORDER_FAILED = 10000;
	@Autowired
private IMyOrderDao  iMyOrderDao;
	
	public List<MyOrderInfo> getMyOrderList(User user){
		return iMyOrderDao.getMyOrderList(user);
		
	}
	
	public void cancleMyOrder(String orderId,String userId){
		int count =  iMyOrderDao.cancleMyOrder(orderId, userId);
		if(count<=0){
			LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + MY_ORDER_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "cancle MyOrder failed."); //$NON-NLS-1$
			throw new CmsException("系统异常,请稍后再试.", CANCLE_MYORDER_FAILED);  //$NON-NLS-1$
		}
	}
}
