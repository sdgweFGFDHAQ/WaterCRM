package com.whut.springboot.mapper;

import com.whut.springboot.entities.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
public interface CustomerMapper {
    List<Customer> listCustomer();

    List<Customer> searchCustomerByName(@Param("custName") String custName);

    Integer saveCustomer(Customer customer);

    Customer getCustomerById(Integer cid);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomerById(Integer cid);
}
