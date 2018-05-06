package com.hr.dto;

import com.hr.enums.DbankErrorCode;
/**
 * 请求响应的返回类
 * @author hangjun
 *
 */
public class ResultStatus {
	/**
	 * 响应成功的Result
	 * @param obj
	 * @return
	 */
	public static Result<Object> success(Object obj){
		Result<Object> result=new Result<Object>();
		result.setCode(DbankErrorCode.UC000000.getCode());
		result.setMsg(DbankErrorCode.UC000000.getMsg());
		result.setData(obj);
		return result;
	}
	/**
	 * 响应成功的Result
	 * @param obj
	 * @return
	 */
	public static Result<Object> error(Object obj){
		Result<Object> result=new Result<Object>();
		result.setCode(DbankErrorCode.UC999999.getCode());
		result.setMsg(DbankErrorCode.UC999999.getMsg());
		result.setData(obj);
		return result;
	}
	
	
}
