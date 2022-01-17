package com.whut.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer cid;

    private String custName;

    private String custMobile;

    private String custAddress;

    private Integer custTicket;
}
