package com.cuckoo.cms.teacher.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.dao.IOrderDao;
import com.cuckoo.cms.teacher.pojo.OrderInfo;
import com.cuckoo.cms.teacher.pojo.req.OrderDeleteReq;
import com.cuckoo.cms.teacher.pojo.req.OrderOneDoneReq;

@Service
public class OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;
	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.ORDER_MODIFY;
	private static final int ONE_DONE_ORDER = 10000;
	private static final int UPDATE_FAILED = 10001;
	private static final int DELETE_FAILED = 10002;
	@Autowired
private IOrderDao iOrderDao;
	
	public List<OrderInfo> getOrderList(User user){
		return iOrderDao.getOrderList(user);
	}
	
	public void updateOrder(OrderInfo info){
		int updateCount =iOrderDao.updateOrder(info);
		if(updateCount<=0){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "update orderinfo failed."); //$NON-NLS-1$
			throw new CmsException("系统异常,请稍后再试.", UPDATE_FAILED);  //$NON-NLS-1$
		}
	}
	
	public void oneDoneOrder(OrderOneDoneReq req,User user){
	 int oneDoneCount=	iOrderDao.oneDoneOrder(req.getOrderId(), user.getTenantId());
		if(oneDoneCount<=0){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "one Done order failed."); //$NON-NLS-1$
			throw new CmsException("系统异常,请稍后再试.", ONE_DONE_ORDER);  //$NON-NLS-1$
		}
	}
	@Transactional
	public void deleteOrder(OrderDeleteReq req,User user){
		for(String orderId:req.getOrderId()){
			
	int deleteCount = 	iOrderDao.deleteOrder(orderId, user.getTenantId());
	if(deleteCount<=0){
		LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
				+ Constants.strChar.VERTICAL_LINE + "delete order failed."); //$NON-NLS-1$
		throw new CmsException("系统异常,请稍后再试.", DELETE_FAILED);  //$NON-NLS-1$
	}
		}
	}
}
