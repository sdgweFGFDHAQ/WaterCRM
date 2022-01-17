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
public class Account {
    private Integer id;

    private String userName;

    private String userPwd;
}
