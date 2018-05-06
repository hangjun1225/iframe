package com.hr.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.domain.Department;
import com.hr.dto.Result;
import com.hr.dto.ResultStatus;
import com.hr.enums.DbankErrorCode;
import com.hr.zException.DbankException;

@RestController
public class ExampleController {
	private Logger logger =LoggerFactory.getLogger(ExampleController.class);
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@RequestMapping("/home")
    public String home() {
		logger.info("welcome you !");
        return "Hello World!";
    }
	
	@RequestMapping("/test1")
    public Result<Object> test1() {
        Department d=new Department();
        d.setId(11);
        d.setDepartmentName("xxx");
		return ResultStatus.success(d);
    }
	
	@RequestMapping("/err")
    public Result<Object> err(@RequestBody String user) {
		Result<Object> result=new Result<Object>();
		String msg=null;
		try {
			char[] charArray = msg.toCharArray();
		} catch (Exception e) {
			throw new DbankException(DbankErrorCode.UC999999);
		}
        return result;
    }
	
	
	
	
	
	@RequestMapping("/test")
	public Map<String,Object> test() {
		List<Map<String, Object>> list = JdbcTemplate.queryForList("select * from department");
		return list.get(0);
	}

}
