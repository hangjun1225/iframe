package com.hr.enums;
/**
 * 错误码信息
 * @author hangjun
 *
 */
public enum DbankErrorCode {
	UC000000("000000","成功"),
	UC999999("999999","失败");
	
	private String code;
	
	private String msg;

	DbankErrorCode(String code, String msg) {
		this.code=code;
		this.msg=msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
