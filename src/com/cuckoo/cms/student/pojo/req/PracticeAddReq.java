package com.cuckoo.cms.student.pojo.req;

import java.util.List;

import lombok.Data;
/**
 * 
 * @author chenxuefeng
 *
 */
@Data
public class PracticeAddReq {
    private String emType;
    private String workCompany;
    private String companyNature;
    private String workPhone;
    private String superName;
    private String workAddress;
    private String superPhone;
    private String practiceRecord;
}
