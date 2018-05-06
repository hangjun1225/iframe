package com.hr.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.hr.domain.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper//不会扫描到,所以不写配置文件也没有问题
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
