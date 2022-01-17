package com.whut.springboot.controller;

import com.whut.springboot.entities.History;
import com.whut.springboot.entities.Salary;
import com.whut.springboot.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/salaryList")
    public  String salaryList(Model model){
        List<Salary> salaryList = salaryService.listSalary();
        model.addAttribute("salaryList", salaryList);
        return "salaryList";
    }

    @RequestMapping("/searchSalaryByTime")
    public String searchSalaryByTime(String startTime, String endTime, Model model){
        List<Salary> salaryList = salaryService.searchSalaryByTime(startTime,endTime);
        List<Salary> salaryList1 = salaryService.searchSalaryByTime1(startTime,endTime);
        model.addAttribute("salaryList", salaryList);
        model.addAttribute("salaryList1",salaryList1);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        return "salaryList";
    }
}
