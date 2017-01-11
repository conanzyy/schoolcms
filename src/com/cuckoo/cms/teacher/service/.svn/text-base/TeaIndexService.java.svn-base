package com.cuckoo.cms.teacher.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cuckoo.cms.teacher.dao.TeaGrantDao;
import com.cuckoo.cms.teacher.dao.TeaLeaveDao;
import com.cuckoo.cms.teacher.pojo.TeaGrant;
import com.cuckoo.cms.teacher.pojo.TeaLeave;

@Service
public class TeaIndexService {
		
		//注入Dao对象
		@Autowired
		private TeaLeaveDao teaLeaveDao;
		
		@Autowired
		private TeaGrantDao teaGrantDao;
		
		//获取前八条未处理请假信息列表
		@Transactional
		public List<TeaLeave> getTeaLeaveUntreatedList(String userId,String tenantId) {
			return teaLeaveDao.getTeaLeaveUntreatedList(userId, tenantId);
		}
		
		//获取前八条未处理奖助列表
		@Transactional
		public List<TeaGrant> getTeaGrantUntreatedList(String userId,String tenantId) {
			return teaGrantDao.getTeaGrantUntreatedList(userId, tenantId);
		}
		
		
}
