package org.advanceit.calcv2.template.common.exception;

/**
 * NotEnoughFieldsReceivedException class
 * 
 * <P>Example of the generic custom exception
 *    
 * @author MPyvovarov
 */
public class NotEnoughFieldsReceivedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	 
	private String errCode;
	private String errMsg;
 
	public String getErrCode() {
		return errCode;
	}
 
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
 
	public String getErrMsg() {
		return errMsg;
	}
 
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
 
	public NotEnoughFieldsReceivedException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
}
