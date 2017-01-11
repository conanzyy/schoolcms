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
import com.cuckoo.cms.teacher.dao.IOrderRecordManagerDao;
import com.cuckoo.cms.teacher.pojo.OrderRecord;
import com.cuckoo.cms.teacher.pojo.req.OrderRecordAddReq;
import com.cuckoo.cms.teacher.pojo.resp.OrderRecordInfoResp;


/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class OrderRecordManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderRecordManagerService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	
	@Autowired
	private IOrderRecordManagerDao iorderRecordManagerDao;
	
	public 	List<OrderRecord> getOrderRecordList(String tenantId){
		return iorderRecordManagerDao.getOrderRecordList(tenantId);
	}
	
	
	public OrderRecordInfoResp getOrderRecordInfo(String orderRecordId) {
		OrderRecord orderRecordInfo  = iorderRecordManagerDao.getOrderRecordInfo(orderRecordId);
		if (orderRecordInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get getOrderRecordInfo failed.");
			throw new CmsException("get getOrderRecordInfo failed.", INSERT_FAILED);
		}
		OrderRecordInfoResp resp = new OrderRecordInfoResp();
		resp.setOrderRecordInfo(orderRecordInfo);
		return resp;
	}
	
	@Transactional
	public void createOrderRecord(OrderRecordAddReq orderrecordreq) {
		OrderRecord orderRecord = new OrderRecord(orderrecordreq.getStuNum(),orderrecordreq.getTalkBackground(),
				orderrecordreq.getPrombleType(),orderrecordreq.getTalkCount(),orderrecordreq.getAlkEffect());
		iorderRecordManagerDao.createOrderRecord(orderRecord);
//		String practiceId = practice.getPracticeId();
//		if (StringUtils.isBlank(practiceId)) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "insert practice failed.");
//			throw new CmsException("insert practice failed.", INSERT_FAILED);
//		}
	}

	public void deleteOrderRecord(String orderRecordId) {
		int delCount = iorderRecordManagerDao.deleteOrderRecord(orderRecordId);
		if (delCount <= 0) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "delete OrderRecord failed.");
			throw new CmsException("delete OrderRecord  failed.", INSERT_FAILED);
		}
	}

}
