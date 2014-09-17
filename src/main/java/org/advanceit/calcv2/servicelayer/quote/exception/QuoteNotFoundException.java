package org.advanceit.calcv2.template.quote.exception;

/**
 * QuoteNotFoundException class
 * 
 * <P>Example of the generic exception if there is no specific quote found in the system
 *    
 * @author MPyvovarov
 */

public class QuoteNotFoundException extends RuntimeException {
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
 
	public QuoteNotFoundException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
}
