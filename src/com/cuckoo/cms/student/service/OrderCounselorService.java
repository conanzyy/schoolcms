package com.cuckoo.cms.student.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.IOrderCounselorDao;
import com.cuckoo.cms.student.pojo.req.OrderCounselorReq;
import com.cuckoo.cms.student.pojo.req.OrderCounselorScheduleReq;
import com.cuckoo.cms.teacher.dao.IOrderScheduleDao;
import com.cuckoo.cms.teacher.pojo.OrderSchedule;

@Service
public class OrderCounselorService {
	@Autowired
private IOrderCounselorDao iOrderCounselorDao;
	@Autowired
	private IOrderScheduleDao iOrderScheduleDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderCounselorService.class);
	private static final String STUDENT_SERVICE = Constants.ServiceType.STUDENT_SERVICE;
	private static final String ORDER_COUNSELOR_MODIFY = Constants.STUDENT_MODULE_DEFINE.ORDER_COUNSELOR_MODIFY;
	private static final int ORDER_COUNSELOR_SCHEDULE_FAILED = 10000;
	private static final int SOMEBODY_HAVE_APPLY = 10001;

	public List<OrderSchedule> getOrderScheduleList(OrderCounselorReq req){
		return iOrderCounselorDao.getOrderScheduleList(req.getCounserlorId());
		
	}
	
	public  synchronized void orderCounselorSchedule(User user,OrderCounselorScheduleReq req){
		String userId = iOrderScheduleDao.getOrderUser(req.getScheduleId());
		if(StringUtils.isNotBlank(userId)){
			LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + ORDER_COUNSELOR_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "someBody apply so can not apply again"); //$NON-NLS-1$
			throw new CmsException("该档期已经有人预约过,请选择其他档期或稍后再试.", SOMEBODY_HAVE_APPLY);  //$NON-NLS-1$
		}
		int count = iOrderCounselorDao.orderCounselorSchedule(user.getUserId(), req.getScheduleId());
		
		if(count <=0){
			LOGGER.error(STUDENT_SERVICE + Constants.strChar.VERTICAL_LINE + ORDER_COUNSELOR_MODIFY
					+ Constants.strChar.VERTICAL_LINE + "order counselor Schedule failed."); //$NON-NLS-1$
			throw new CmsException("系统异常,请稍后再试.", ORDER_COUNSELOR_SCHEDULE_FAILED);  //$NON-NLS-1$
		}
	}
	
	
}
