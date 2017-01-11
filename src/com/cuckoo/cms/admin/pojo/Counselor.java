package com.cuckoo.cms.admin.pojo;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class Counselor extends BasePojo {
private String counselorId;
private String userId;
private String teaNum;
private String teaName;
private String researchArea;
private String consultingArea;
private String image;
private String status;
}
