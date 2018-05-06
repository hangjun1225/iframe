package com.hr.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.dto.Result;
import com.hr.zException.DbankException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result<Object> exceptionGet(Exception e) {
		
		Result<Object> result=new Result<Object>();	
		//处理自定义的异常
		if (e instanceof DbankException) {
			logger.error("【异常报错信息:】{}", e);
			DbankException myException = (DbankException) e;
			result.setCode(myException.getCode());
			result.setMsg(myException.getMessage());
			return result;
		}
		//处理系统异常
		logger.error("【系统异常报错信息:】{}", e);
		result.setCode("999999");
		result.setMsg(e.getMessage());
		return result;
	}
}
