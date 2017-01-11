package com.cuckoo.cms.common.exception;
/**
 * 
 * @author tsx270129
 *
 */
public class CmsException extends RuntimeException {

	private String tips;
	private Integer rtnCode;
	private static final long serialVersionUID = 1276258006468940269L;

	public CmsException(String message, Integer rtnCode) {
		super(message);
		this.rtnCode = rtnCode;
	}

	public CmsException(String message, Throwable e, Integer rtnCode) {
		super(message, new Throwable(e.getMessage()));
		this.rtnCode = rtnCode;
	}

	public CmsException(String message, Throwable e, Integer rtnCode,String tips) {
		super(message, new Throwable(e.getMessage()));
		this.rtnCode = rtnCode;
		this.tips=tips;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(Integer rtnCode) {
		this.rtnCode = rtnCode;
	}
	@Override
	public String toString(){
		
		StringBuilder builder =new StringBuilder();
		builder.append("CmsException[rtnCode=");
		builder.append(rtnCode);
		builder.append(",tips=");
		builder.append(tips);
		builder.append(",toSring()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
		
		
	}
}
