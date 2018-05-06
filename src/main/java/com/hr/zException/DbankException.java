package com.hr.zException;

import com.hr.enums.DbankErrorCode;

/**
 * 自定义异常
 * @author hangjun
 *
 */
public class DbankException extends RuntimeException{
	private static final long serialVersionUID = 8449226597820277451L;
	/**
	 * 错误码
	 */
	private String code;
	/**
	 * @param DbankErrorCode 错误码	
	 */
	public DbankException(DbankErrorCode erroCode) {
		super(erroCode.getMsg());
		this.code=erroCode.getCode();
	}
	
	/**
	 * 
	 * @param code 错误码	
	 * @param message	错误信息
	 */
	public DbankException(String code,String message) {
		super(message);
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
}
