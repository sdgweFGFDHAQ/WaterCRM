package com.whut.springboot.service.impl;

import com.whut.springboot.entities.Salary;
import com.whut.springboot.mapper.SalaryMapper;
import com.whut.springboot.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> listSalary() {
        return salaryMapper.listSalary();
    }

    @Override
    public List<Salary> searchSalaryByTime(String startTime, String endTime) {
        return salaryMapper.searchSalaryByTime(startTime, endTime);
    }

    @Override
    public List<Salary> searchSalaryByTime1(String startTime, String endTime) {
        return salaryMapper.searchSalaryByTime1(startTime,endTime);
    }
}
