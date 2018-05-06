package com.hr.dto;
/**
 * 请求响应的返回信息
 * @author hangjun
 *
 * @param <T>
 */
public class Result<T> {
	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String msg;
	/**
	 * 数据
	 */
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
