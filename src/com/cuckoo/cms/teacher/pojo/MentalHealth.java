package com.cuckoo.cms.teacher.pojo;

import com.cuckoo.cms.common.BasePojo;

/**
 * @chenxuefeng
 */
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
public class MentalHealth {
	private String stuName;
	private String stuNum;
	private String proName;
	private String className;
	private String healthId;
	private String userId;
	private String result;
	private String createTime;//记录时间
	private String way;
	private String record;
	private String step;
	private String status;
	public MentalHealth() {
		super();
	}
	public MentalHealth(String result, String createTime, String way, String record, String step) {
		super();
		this.result = result;
		this.createTime = createTime;
		this.way = way;
		this.record = record;
		this.step = step;
	}

}
