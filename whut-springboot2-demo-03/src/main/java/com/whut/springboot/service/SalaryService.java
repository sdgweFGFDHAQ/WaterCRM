package com.whut.springboot.service;

import com.whut.springboot.entities.History;
import com.whut.springboot.entities.Salary;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public interface SalaryService {
    List<Salary> listSalary();

    List<Salary> searchSalaryByTime(String startTime, String endTime);
    List<Salary> searchSalaryByTime1(String startTime, String endTime);
}
