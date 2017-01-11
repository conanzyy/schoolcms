package com.cuckoo.cms.teacher.pojo.req;

import com.cuckoo.cms.common.BasePojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author chenxuefeng
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TNoticeAddReq extends BasePojo{
      private String title;
      private String content;
}






