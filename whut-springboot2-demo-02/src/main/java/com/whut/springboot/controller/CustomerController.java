package com.whut.springboot.controller;

import com.whut.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/listCustomer")
    public String listCustomer(){
        return customerService.listCustomer().toString();
    }
}
