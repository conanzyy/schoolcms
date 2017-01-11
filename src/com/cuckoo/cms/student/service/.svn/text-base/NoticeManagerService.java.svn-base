package com.cuckoo.cms.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cuckoo.cms.common.constants.Constants;
import com.cuckoo.cms.common.exception.CmsException;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.student.dao.INoticeManagerDao;
import com.cuckoo.cms.student.pojo.Notice;
import com.cuckoo.cms.student.pojo.req.NoticeIdReq;
import com.cuckoo.cms.student.pojo.resp.NoticeInfoResp;

/**
 * 
 * @author chenxuefeng
 *
 */
@Service
public class NoticeManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeManagerService.class);

	private static final String CMSADMIN_SERVICE = Constants.ServiceType.CMSADMIN_SERVICE;

	private static final String CMSAUTH_MODULE_DEFINE = Constants.CMSAUTH_MODULE_DEFINE.AUTHORITY_INFO_MODIFY;

	private static final int INSERT_FAILED = 10000;
	@Autowired
	private INoticeManagerDao iNoticeManagerDao;
	//学生端公告列表
	public List<Notice> getNoticeList(String tenantId) {
		return iNoticeManagerDao.getNoticeList(tenantId);
	}
    //学生端首页公告
	public List<Notice> getIndexNoticeList(String tenantId) {
		return iNoticeManagerDao.getIndexNoticeList(tenantId);
	}
	public NoticeInfoResp getNoticeInfo(String noticeId, User user) {
		Notice noticeInfo= iNoticeManagerDao.getNoticeInfo(noticeId, user.getTenantId());
		if (noticeInfo==null) {
			LOGGER.error(CMSADMIN_SERVICE + Constants.strChar.VERTICAL_LINE + CMSAUTH_MODULE_DEFINE
					+ Constants.strChar.VERTICAL_LINE + "get noticeInfo failed.");
			throw new CmsException("delete notice failed.", INSERT_FAILED);
		}
		NoticeInfoResp resp = new NoticeInfoResp();
		resp.setNoticeInfo(noticeInfo);
		//resp.setAuthIds(iUserDao.getResourceByRole(roleInfo));
		return resp;
	}

}









