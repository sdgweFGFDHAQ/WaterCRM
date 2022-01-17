package com.whut.springboot.mapper;

import com.whut.springboot.entities.Salary;
import com.whut.springboot.entities.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public interface SalaryMapper {
    List<Salary> listSalary();

    List<Salary> searchSalaryByTime(@Param("startTime") String startTime,@Param("endTime") String endTime);
    List<Salary> searchSalaryByTime1(@Param("startTime") String startTime,@Param("endTime") String endTime);
}
