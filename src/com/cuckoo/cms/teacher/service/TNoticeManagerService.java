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
import com.cuckoo.cms.teacher.dao.ITNoticeManagerDao;
import com.cuckoo.cms.teacher.pojo.TNotice;
import com.cuckoo.cms.teacher.pojo.req.TNoticeAddReq;
import com.cuckoo.cms.teacher.pojo.resp.TNoticeInfoResp;


/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class TNoticeManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TNoticeManagerService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	@Autowired
	private ITNoticeManagerDao iTNoticeManagerDao;
	
	public List<TNotice> getTNoticeList(String tenantId) {
		return iTNoticeManagerDao.getTNoticeList(tenantId);
	}

	
	public TNoticeInfoResp getTNoticeInfo(String noticeId, User user) {
		TNotice tnoticeInfo= iTNoticeManagerDao.getTNoticeInfo(noticeId, user.getTenantId());
		if (tnoticeInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get tnoticeInfo failed.");
			throw new CmsException("delete notice failed.", INSERT_FAILED);
		}
		TNoticeInfoResp resp = new TNoticeInfoResp();
		resp.setTnoticeInfo(tnoticeInfo);
		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
		return resp;
	}
	
	
	@Transactional
	public void createNotice(TNoticeAddReq noticereq, User user) {
		TNotice notice = new TNotice(noticereq.getTitle(),noticereq.getContent(),
				user.getUserId(),user.getTenantId());
		iTNoticeManagerDao.createTNotice(notice);
//		String practiceId = practice.getPracticeId();
//		if (StringUtils.isBlank(practiceId)) {
//			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
//					+ Constants.strChar.VERTICAL_LINE + "insert practice failed.");
//			throw new CmsException("insert practice failed.", INSERT_FAILED);
//		}

	}

}









