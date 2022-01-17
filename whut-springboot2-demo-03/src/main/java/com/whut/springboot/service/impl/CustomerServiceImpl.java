package com.whut.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Customer;
import com.whut.springboot.mapper.CustomerMapper;
import com.whut.springboot.service.CustomerService;
import com.whut.springboot.service.PageNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomer() {
        return customerMapper.listCustomer();
    }

    @Override
    public List<Customer> searchCustomerByName(String custName) {
        return customerMapper.searchCustomerByName(custName);
    }

    @Override
    public Integer saveCustomer(Customer customer) {
        return customerMapper.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer cid) {
        return customerMapper.getCustomerById(cid);
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public Integer deleteCustomerById(Integer cid) {
        return customerMapper.deleteCustomerById(cid);
    }

}
