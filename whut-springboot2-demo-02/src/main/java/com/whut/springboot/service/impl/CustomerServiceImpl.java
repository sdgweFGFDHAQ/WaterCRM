package com.whut.springboot.service.impl;

import com.whut.springboot.entities.Customer;
import com.whut.springboot.mapper.CustomerMapper;
import com.whut.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomer(){
        return customerMapper.listCustomer();
    }
}
