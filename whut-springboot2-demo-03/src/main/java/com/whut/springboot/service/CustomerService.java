package com.whut.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.Worker;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
public interface CustomerService extends PageNav{
    List<Customer> listCustomer();

    List<Customer> searchCustomerByName(String custName);

    Integer saveCustomer(Customer customer);

    Customer getCustomerById(Integer cid);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomerById(Integer cid);

    @Override
     default PageInfo<Customer> listObjectForPage(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Customer> list = this.listCustomer();
        // 分页Bean，封装了分页查询的数据，将查询结果注入到分页对象(Bean)
        PageInfo<Customer> pageInfo =  new PageInfo<>(list);
        return pageInfo;
    }

    @Override
     default PageInfo<Customer> searchObject(Integer pageNum, String custName) {
        PageHelper.startPage(pageNum,3);
        List<Customer> custList = this.searchCustomerByName(custName);
        PageInfo<Customer> pageInfo = new PageInfo<>(custList);
        return pageInfo;
    }
}
