package com.cuckoo.cms.teacher.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.teacher.dao.IOrderScheduleDao;
import com.cuckoo.cms.teacher.pojo.OrderSchedule;
import com.cuckoo.cms.teacher.pojo.req.OrderScheduleReq;

@Service
public class OrderScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderScheduleService.class);
	@Autowired
	private IOrderScheduleDao iOrderScheduleDao;
	private static final String TEACHER_SERVICE = Constants.ServiceType.TEACHER_SERVICE;
	private static final String TEACHER_MODULE_DEFINE = Constants.TEACHER_MODULE_DEFINE.ORDER_SCHEDULE_MODIFY;
	private static final int INSERT_FAILED = 10000;
	private static final int UPDATE_FAILED = 10001;
	private static final int CANCLE_FAILED = 10002;
	private static final int COUNSELOR_NOT_EXIST = 10003;
	private static final String isScheduleMeeting = "1"; //$NON-NLS-1$
	private static final int NO_BODY_APPLY = 10004;

	public List<OrderSchedule> getOrderScheduleList(User user) {
		return iOrderScheduleDao.getOrderScheduleList(user);
	}

	@Transactional
	public void cancleOrderSchedule(OrderScheduleReq req) {
		String userId = iOrderScheduleDao.getOrderUser(req.getScheduleId());
		
		if(StringUtils.isBlank(userId)&& isScheduleMeeting.equals(req.getCancleType())){
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "noBody apply so can not schedule meeting"); //$NON-NLS-1$
			throw new CmsException(Messages.getString("OrderScheduleService.1"), NO_BODY_APPLY);  //$NON-NLS-1$
		}
		if (isScheduleMeeting.equals(req.getCancleType())) {
			int cancleCount = iOrderScheduleDao.cancleOrderSchedule(req.getScheduleId(),req.getCancleRemark());
			int insertNormalToOrder = iOrderScheduleDao.insertNomalToOrder(req.getScheduleId());

			if (cancleCount <= 0 || insertNormalToOrder <= 0) {
				LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "cancle OrderSchedule failed."); //$NON-NLS-1$
				throw new CmsException(Messages.getString("OrderScheduleService.2"), CANCLE_FAILED);  //$NON-NLS-1$
			}
		} else {
			int count = iOrderScheduleDao.cancleOrderSchedule(req.getScheduleId(),req.getCancleRemark());
			if (count <= 0) {
				LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
						+ Constants.strChar.VERTICAL_LINE + "cancle OrderSchedule failed."); //$NON-NLS-1$
				throw new CmsException(Messages.getString("OrderScheduleService.3"), CANCLE_FAILED);  //$NON-NLS-1$
			}
		}
	}

	public void updateOrderSchedule(OrderSchedule orderSchedule) {
		int count = iOrderScheduleDao.updateOrderSchedule(orderSchedule);
		if (count <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "update OrderSchedule failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("OrderScheduleService.4"), UPDATE_FAILED);  //$NON-NLS-1$
		}
	}

	public void createOrderSchedule(OrderSchedule orderSchedule, User user) {
		String counselorId = iOrderScheduleDao.getCounselorIdByUserId(user.getUserId());
		if (StringUtils.isBlank(counselorId)) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "counselor not exist."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("OrderScheduleService.5"), COUNSELOR_NOT_EXIST);  //$NON-NLS-1$
		}
		orderSchedule.setCounselorId(counselorId);
		int count = iOrderScheduleDao.createOrderSchedule(orderSchedule);
		if (count <= 0) {
			LOGGER.error(TEACHER_SERVICE + Constants.strChar.VERTICAL_LINE + TEACHER_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "insert OrderSchedule failed."); //$NON-NLS-1$
			throw new CmsException(Messages.getString("OrderScheduleService.6"), INSERT_FAILED);  //$NON-NLS-1$
		}
	}
}
