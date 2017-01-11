package com.cuckoo.cms.student.pojo;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends BasePojo{
	private String userId;
	private String stuNum;
	private String stuName;
	private String sex;
	private String collegeId;
	private String departId;
	private String proId;
	private String classId;
	private String enterTime;
	private int status;
	private String national;
	private String dateBirth;
	private String dormitory;
	private String studentType;
	private String oneChild;
	private String medical;
	private String address;
	private String phone;
	private String familyName1;
	private String familySex1;
	private String familyRelation1;
	private String familyAddress1;
	private String familyZipCode1;
	private String familyPhone1;
	private String familyMarriage1;
	private String familyName2;
	private String familySex2;
	private String familyRelation2;
	private String familyAddress2;
	private String familyZipCode2;
	private String familyPhone2;
	private String familyMarriage2;
	private String prizeInfo;
}
