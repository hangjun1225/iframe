package com.hr.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hr.dto.Result;
import com.hr.util.JacksonUtil;

/**
 * 日志切面类
 * 
 * @author hangjun
 *
 */
@Aspect
@Component
public class LogsAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Autowired
    private GlobalExceptionHandler globalExceptionHandler;

	@Pointcut("execution(public * com.hr.controller.*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("=======================================================================================================================");
		logger.info("=======================================================================================================================");
		logger.info("==================================1.请求处理开始==================================================");
		logger.info("[URL] : " + request.getRequestURL().toString());
		logger.info("[HTTP_METHOD] : " + request.getMethod());
		logger.info("[IP] : " + request.getRemoteAddr());
		logger.info("[CLASS_METHOD] : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("[REQUEST] : "+  Arrays.toString(joinPoint.getArgs()));
		logger.info("==================================2.业务处理开始==================================================");
	}

	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		try {
			Object proceed = proceedingJoinPoint.proceed();
			return proceed;
		} catch (Exception e) {
			return globalExceptionHandler.exceptionGet(e);
		}
	}
	

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		
		// 处理完返回内容
		logger.info("==================================3.业务处理结束==================================================");
		logger.info("[RESPONSE] : " +ret);
		//如果controller返回的是result对象
		//格式化数据。记录到日志。
		if(ret instanceof Result){
			logger.info("[RESPONSE---result] : " + JacksonUtil.toJSon(ret));//返回的都是Result对象,应当不会报错
		}
		logger.info("[[SPEND TIME]] : "
				+ (System.currentTimeMillis() - startTime.get())+"毫秒");
		logger.info("==================================4.请求处理结束==================================================");
	}

}
