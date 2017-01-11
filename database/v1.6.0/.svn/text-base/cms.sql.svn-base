
-- 导出  表 hiad.t_authorities 结构
DROP TABLE IF EXISTS `t_authorities`;
CREATE TABLE IF NOT EXISTS `t_authorities` (
  `authId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `authName` varchar(64) NOT NULL COMMENT '权限名称',
  `parentId` int(11) DEFAULT NULL COMMENT '父权限ID',
  `path` varchar(256) DEFAULT NULL COMMENT '静态资源目标',
  `authValue` varchar(1024) DEFAULT NULL COMMENT '操作动作',
  `tenantId` int(11) NOT NULL COMMENT '租户ID',
  `style` varchar(128) NOT NULL COMMENT '功能图标',
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hiad.t_authorities 的数据：~35 rows (大约)
DELETE FROM `t_authorities`;
/*!40000 ALTER TABLE `t_authorities` DISABLE KEYS */;
INSERT INTO `t_authorities` (`authId`, `authName`, `parentId`, `path`, `authValue`, `tenantId`, `style`) VALUES
	(1, '权限控制', NULL, NULL, NULL, 1, ''),
	(2, '角色管理', 1, 'views/admin/accessMgr.html', NULL, 1, ''),
	(3, '操作员管理', 1, NULL, NULL, 1, ''),
	(4, '公告通知管理', NULL, NULL, NULL, 1, ''),
	(5, '学生基础信息', NULL, NULL, NULL, 1, ''),
	(6, '个人信息', 5, NULL, NULL, 1, ''),
	(7, '学习成绩', 5, NULL, NULL, 1, ''),
	(8, '实习信息', 5, NULL, NULL, 1, ''),
	(9, '心理健康信息', 5, NULL, NULL, 1, ''),
	(10, '请假管理', NULL, NULL, NULL, 1, ''),
	(11, '奖助管理', NULL, NULL, NULL, 1, ''),
	(12, '项目管理', NULL, NULL, NULL, 1, ''),
	(13, '活动管理', NULL, NULL, NULL, 1, ''),
	(14, '预约管理', NULL, NULL, NULL, 1, ''),
	(15, '咨询师管理', 14, NULL, NULL, 1, ''),
	(16, '档期管理', 14, NULL, NULL, 1, ''),
	(17, '咨询档案', 14, NULL, NULL, 1, ''),
	(18, '约谈管理', NULL, NULL, NULL, 1, ''),
	(19, '学生成绩表', NULL, NULL, NULL, 1, ''),
	(20, '数据查询统计', NULL, NULL, NULL, 1, ''),
	(21, '就业信息管理', NULL, NULL, NULL, 1, ''),
	(22, '公告通知', NULL, NULL, NULL, 1, ''),
	(23, '基础信息', NULL, NULL, NULL, 1, ''),
	(24, '个人信息', 23, NULL, NULL, 1, ''),
	(25, '学习成绩', 23, NULL, NULL, 1, ''),
	(26, '实习信息', 23, NULL, NULL, 1, ''),
	(27, '请假', NULL, NULL, NULL, 1, ''),
	(28, '奖助', NULL, NULL, NULL, 1, ''),
	(29, '项目', NULL, NULL, NULL, 1, ''),
	(30, '活动', NULL, NULL, NULL, 1, ''),
	(31, '预约', NULL, NULL, NULL, 1, ''),
	(32, '预约咨询', 31, NULL, NULL, 1, ''),
	(33, '我的预约', 31, NULL, NULL, 1, ''),
	(34, '咨询反馈', 31, NULL, NULL, 1, ''),
	(35, '职业生涯报告',NULL, NULL, NULL, 1, '');
/*!40000 ALTER TABLE `t_authorities` ENABLE KEYS */;

-- 导出  表 hiad.t_roles 结构
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE IF NOT EXISTS `t_roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleName` varchar(128) NOT NULL COMMENT '角色名称',
  `createBy` varchar(128) NOT NULL COMMENT '创建人',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '角色状态0/正常1/删除',
  `tenantId` int(11) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 导出  表 hiad.t_role_auth 结构
DROP TABLE IF EXISTS `t_role_auth`;
CREATE TABLE IF NOT EXISTS `t_role_auth` (
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  `authId` int(11) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_tenant 结构
DROP TABLE IF EXISTS `t_tenant`;
CREATE TABLE IF NOT EXISTS `t_tenant` (
  `tenantId` int(11) NOT NULL AUTO_INCREMENT COMMENT '租户ID',
  `tenantName` varchar(50) DEFAULT NULL COMMENT '租户名称',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` char(1) DEFAULT '0' COMMENT '租户状态0/正常1/删除',
  PRIMARY KEY (`tenantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hiad.t_tenant 的数据：~0 rows (大约)
DELETE FROM `t_tenant`;
/*!40000 ALTER TABLE `t_tenant` DISABLE KEYS */;
INSERT INTO `t_tenant` (`tenantId`, `tenantName`, `createTime`, `status`) VALUES
	(1, '南京师范大学', '2016-12-03 15:33:54', '0');
/*!40000 ALTER TABLE `t_tenant` ENABLE KEYS */;


-- 导出  表 hiad.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(128) NOT NULL COMMENT '登录名称',
  `passWord` varchar(512) NOT NULL COMMENT '登录密码',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `isSys` char(1) DEFAULT '0' COMMENT '是否为超级管理员0/正常用户1/超级用户',
  `status` char(1) DEFAULT '0' COMMENT '用户状态0/正常1/删除',
  `isChangePwd` char(1) DEFAULT '1' COMMENT '是否修改过密码0/不需要更改密码1/需要更改密码',
  `userType` char(1) DEFAULT '0' COMMENT '用户类型0/学生1/老师',
  `tenantId` int(11) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 正在导出表  hiad.t_user 的数据：~1 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`userId`, `userName`, `passWord`, `createTime`, `modifyTime`, `isSys`, `status`, `isChangePwd`, `userType`, `tenantId`) VALUES
	(1, 'admin', 'admin', '2016-12-03 15:35:40', '2016-12-03 15:35:40', '1', '0', '0', NULL, 1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- 导出  表 hiad.t_user_role 结构
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `userId` int(11) DEFAULT NULL COMMENT '用户iD',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 导出  表 hiad.t_class 结构
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE IF NOT EXISTS `t_class` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `classNum` varchar(20) DEFAULT NULL,
  `className` varchar(100) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 导出  表 hiad.t_college 结构
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE IF NOT EXISTS `t_college` (
  `collegeId` int(11) NOT NULL AUTO_INCREMENT,
  `collegeNum` varchar(20) DEFAULT NULL,
  `collegeName` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`collegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 导出  表 hiad.t_college_depart 结构
DROP TABLE IF EXISTS `t_college_depart`;
CREATE TABLE IF NOT EXISTS `t_college_depart` (
  `collegeDepartId` int(11) NOT NULL AUTO_INCREMENT,
  `collegeId` int(11) DEFAULT NULL,
  `departId` int(11) DEFAULT NULL,
  PRIMARY KEY (`collegeDepartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_course 结构
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE IF NOT EXISTS `t_course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseCode` varchar(20) DEFAULT NULL,
  `courseName` varchar(50) DEFAULT NULL,
  `hours` varchar(10) DEFAULT NULL,
  `credit` varchar(2) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  `courseType` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_department 结构
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE IF NOT EXISTS `t_department` (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departNum` varchar(20) DEFAULT NULL,
  `departName` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_depart_pro 结构
DROP TABLE IF EXISTS `t_depart_pro`;
CREATE TABLE IF NOT EXISTS `t_depart_pro` (
  `departProId` int(11) NOT NULL AUTO_INCREMENT,
  `departId` int(11) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  PRIMARY KEY (`departProId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 导出  表 hiad.t_job 结构
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE IF NOT EXISTS `t_job` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `jobType` char(1) DEFAULT NULL,
  `companyNature` char(1) DEFAULT NULL,
  `companyName` varchar(128) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_master_class 结构
DROP TABLE IF EXISTS `t_master_class`;
CREATE TABLE IF NOT EXISTS `t_master_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 导出  表 hiad.t_mental_health 结构
DROP TABLE IF EXISTS `t_mental_health`;
CREATE TABLE IF NOT EXISTS `t_mental_health` (
  `healthId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `result` varchar(256) DEFAULT NULL COMMENT '心理普查结果',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '排查时间',
  `way` varchar(128) DEFAULT NULL COMMENT '排查方式',
  `record` varchar(512) DEFAULT NULL COMMENT '信息记录',
  `step` varchar(200) DEFAULT NULL COMMENT '采取措施',
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`healthId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_message 结构
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE IF NOT EXISTS `t_message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `receiveId` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_practice 结构
DROP TABLE IF EXISTS `t_practice`;
CREATE TABLE `t_practice` (
  `practiceId` int(11) NOT NULL AUTO_INCREMENT COMMENT '实习信息Id',
  `userId` int(11) DEFAULT NULL  COMMENT '实习用户Id',
  `emType` char(128) DEFAULT NULL COMMENT '就业类别',
  `workCompany` varchar(128) DEFAULT NULL COMMENT '工作(升学)'单位名称,
  `companyNature` char(128) DEFAULT NULL COMMENT ''单位性质,
  `status` char(1) DEFAULT '0' COMMENT '0/存在1/删除',
  `workphone` char(128) DEFAULT NULL COMMENT '单位电话',
  `superName` varchar(128) DEFAULT NULL COMMENT '主管姓名',
  `workAddress` varchar(256) DEFAULT NULL COMMENT '公司地址',
  `superPhone` varchar(128) DEFAULT NULL COMMENT '主管电话',
  `practiceRecord` varchar(512) DEFAULT NULL COMMENT '实习记录',
  PRIMARY KEY (`practiceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- 导出  表 hiad.t_profession 结构
DROP TABLE IF EXISTS `t_profession`;
CREATE TABLE IF NOT EXISTS `t_profession` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `proNum` varchar(20) DEFAULT NULL,
  `proName` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_score 结构
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE IF NOT EXISTS `t_score` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `score` varchar(3) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_student 结构
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE IF NOT EXISTS `t_student` (
  `userId` int(11) NOT NULL,
  `stuNum` varchar(128) DEFAULT NULL,
  `stuName` varchar(128) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `collegeId` int(11) DEFAULT NULL,
  `departId` int(11) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `enterTime` timestamp NULL DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_stu_course 结构
DROP TABLE IF EXISTS `t_stu_course`;
CREATE TABLE IF NOT EXISTS `t_stu_course` (
  `stuCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuCourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_teacher 结构
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE IF NOT EXISTS `t_teacher` (
  `userId` int(11) NOT NULL,
  `teaNum` varchar(128) DEFAULT NULL,
  `teaName` varchar(128) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `teaLevel` char(1) DEFAULT NULL,
  `teaType` char(1) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_teaching 结构
DROP TABLE IF EXISTS `t_teaching`;
CREATE TABLE IF NOT EXISTS `t_teaching` (
  `teachingId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`teachingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 导出  表 hiad.t_activity 结构
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE IF NOT EXISTS `t_activity` (
  `activityId` int(11) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(50) DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `activityType` char(1) DEFAULT NULL,
  `template` mediumtext,
  `enterEndTime` timestamp NULL DEFAULT NULL,
  `peopleNum` int(11) DEFAULT NULL,
  `activityScore` int(11) DEFAULT NULL,
  `creatBy` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` char(1) DEFAULT '0',
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`activityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_activity_param 结构
DROP TABLE IF EXISTS `t_activity_param`;
CREATE TABLE IF NOT EXISTS `t_activity_param` (
  `enterId` int(11) NOT NULL AUTO_INCREMENT,
  `activityId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `keyId` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`enterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_notice 结构
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE IF NOT EXISTS `t_notice` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告Id',
  `title` varchar(100) DEFAULT NULL COMMENT '公告标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '公告内容',
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatBy` int(11) DEFAULT NULL COMMENT '创建人',
  `tenantId` int(11) DEFAULT NULL COMMENT '租户Id',
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_project 结构
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE IF NOT EXISTS `t_project` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectNum` varchar(20) DEFAULT NULL,
  `projectName` varchar(50) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `description` varchar(500) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_leave 结构
DROP TABLE IF EXISTS `t_leave`;
CREATE TABLE IF NOT EXISTS `t_leave` (
  `leaveId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `applyTime` timestamp NULL DEFAULT NULL,
  `cause` varchar(100) DEFAULT NULL,
  `leaveTime` timestamp NULL DEFAULT NULL,
  `comeTime` timestamp NULL DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `type` char(1) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_grant 结构
DROP TABLE IF EXISTS `t_grant`;
CREATE TABLE IF NOT EXISTS `t_grant` (
  `grantId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `grantType` char(1) DEFAULT NULL,
  `applyTime` timestamp NULL DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `tenantId` int(11) DEFAULT NULL,
  `departId` int(11) DEFAULT NULL,
  PRIMARY KEY (`grantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- 导出  表 hiad.t_grant_apply 结构
DROP TABLE IF EXISTS `t_grant_apply`;
CREATE TABLE IF NOT EXISTS `t_grant_apply` (
  `applyId` int(11) NOT NULL AUTO_INCREMENT,
  `grantId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` char(1) DEFAULT '0',
  PRIMARY KEY (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 导出  表 hiad.t_counselor 结构
DROP TABLE IF EXISTS `t_counselor`;
CREATE TABLE `t_counselor` (
    `counselorId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '咨询师id',
    `userId` INT(11) NULL DEFAULT NULL COMMENT '用户id',
    `researchArea` VARCHAR(50) NULL DEFAULT NULL COMMENT '研究方向',
    `consultingArea` VARCHAR(50) NULL DEFAULT NULL COMMENT '咨询领域',
    `image` VARCHAR(500) NULL DEFAULT NULL COMMENT '照片',
    `status` CHAR(1) NULL DEFAULT '0' COMMENT '状态',
    `tenantId` INT(11) NULL DEFAULT NULL COMMENT '租户id',
    PRIMARY KEY (`counselorId`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;






-- 导出  表 hiad.t_order 结构
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
    `orderId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '预约id',
    `userId` INT(11) NULL DEFAULT NULL COMMENT '用户id',
    `scheduleId` INT(11) NULL DEFAULT NULL COMMENT '咨询档期id',
    `createTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
    `description` VARCHAR(500) NULL DEFAULT NULL COMMENT '问题描述',
    `consultTime` TIMESTAMP NULL DEFAULT NULL COMMENT '咨询时间',
    `solveProblem` VARCHAR(500) NULL DEFAULT NULL COMMENT '解决问题',
    `processReport` VARCHAR(500) NULL DEFAULT NULL COMMENT '咨询过程记录',
    `advice` VARCHAR(500) NULL DEFAULT NULL COMMENT '咨询建议及用户总结',
    `isFinish` CHAR(1) NULL DEFAULT '0' COMMENT '是否一件完结0/一件完结1/建立档案2/查看档案',
    `status` CHAR(1) NULL DEFAULT '0' COMMENT '0/正常1/删除',
    PRIMARY KEY (`orderId`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;








-- 导出  表 hiad.t_order_feedback 结构
DROP TABLE IF EXISTS `t_order_feedback`;
CREATE TABLE IF NOT EXISTS `t_order_feedback` (
  `feedbackId` int(11) NOT NULL AUTO_INCREMENT,
  `scheduleId` int(11) DEFAULT NULL,
  `evaluate` varchar(500) DEFAULT NULL,
  `advice` varchar(500) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 导出  表 hiad.t_order_schedule 结构
DROP TABLE IF EXISTS `t_order_schedule`;
CREATE TABLE `t_order_schedule` (
    `scheduleId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '档期ID',
    `startTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
    `endTime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
    `place` VARCHAR(100) NULL DEFAULT NULL COMMENT '地点',
    `counselorId` INT(11) NULL DEFAULT NULL COMMENT '咨询师id',
    `status` CHAR(1) NULL DEFAULT '0' COMMENT '0/正常1/取消',
    `cancleRemark` VARCHAR(100) NULL DEFAULT NULL COMMENT '取消事由',
    `isOrder` CHAR(1) NULL DEFAULT '0' COMMENT '是否约谈0/否1/是',
    PRIMARY KEY (`scheduleId`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


-- Table structure for t_order_record
-- ----------------------------
DROP TABLE IF EXISTS `t_order_record`;
CREATE TABLE `t_order_record` (
  `orderRecordId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(128) NOT NULL COMMENT '学号',
  `talkTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '谈话时间',
  `talkBackground` varchar(256) DEFAULT NULL COMMENT '谈话背景',
  `prombleType` varchar(128) DEFAULT NULL COMMENT '问题类型',
  `talkCount` int(11) DEFAULT NULL COMMENT '约谈次数',
  `talkEffect` varchar(512) DEFAULT NULL COMMENT '谈话效果',
  `status` char(1) DEFAULT '0' COMMENT '状态0/存在1/删除',
  PRIMARY KEY (`orderRecordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

