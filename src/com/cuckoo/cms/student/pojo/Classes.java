package com.cuckoo.cms.student.pojo;

import lombok.Data;

@Data
public class Classes {
	
	private int classId;//班级序号
	private String classNum;//编辑编号
	private String className;// 班级名称
	private int tenantId;//租户id
	private int proId;//专业id

}
