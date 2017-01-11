package com.cuckoo.cms.teacher.pojo;

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
public class TNotice extends BasePojo{
      private String  noticeId;
      private String title;
      private String content;
      private String createTime;
      private String createBy;
      private String tenantId;
      private String status;
      
      public TNotice(String title,String content,String createBy,String tenantId){
    	  setTitle(title);
    	  setContent(content);
    	  setCreateBy(createBy);
    	  setTenantId(tenantId);
      }
      
      public TNotice(){
    	  
      }
}






