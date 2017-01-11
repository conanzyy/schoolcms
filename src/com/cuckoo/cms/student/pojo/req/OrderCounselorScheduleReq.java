package com.cuckoo.cms.student.pojo.req;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class OrderCounselorScheduleReq {
	@NotBlank
private String scheduleId;
}
