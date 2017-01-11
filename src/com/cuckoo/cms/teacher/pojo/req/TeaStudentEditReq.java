package com.cuckoo.cms.teacher.pojo.req;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaStudentEditReq extends BasePojo{
	private String userId;
	private String stuName;
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
