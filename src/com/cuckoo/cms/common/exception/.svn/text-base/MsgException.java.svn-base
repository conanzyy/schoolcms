package com.cuckoo.cms.common.exception;
/**
 * 
 * @author tsx270129
 *
 */
public class MsgException extends Exception {

	private static final long serialVersionUID = 3170362025035472567L;
private String errMsg;
private Integer rtnCode;
public MsgException(String message){
	super(message);
}

public MsgException(){
	
	super();
}
public MsgException(String message,Integer rtnCode){
	super(message);
	this.rtnCode=rtnCode;
}

public String getErrMsg() {
	return errMsg;
}

public void setErrMsg(String errMsg) {
	this.errMsg = errMsg;
}

public Integer getRtnCode() {
	return rtnCode;
}

public void setRtnCode(Integer rtnCode) {
	this.rtnCode = rtnCode;
}

}
