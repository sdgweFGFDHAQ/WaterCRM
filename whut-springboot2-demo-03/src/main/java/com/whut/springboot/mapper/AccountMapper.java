package com.whut.springboot.mapper;

import com.whut.springboot.entities.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
public interface AccountMapper {
    Account login(@Param("userName") String userName, @Param("userPwd") String userPwd);

    Integer updatePassword(@Param("userName")String userName,@Param("newUserPwd") String newUserPwd);

    Account regist(@Param("userName") String userName, @Param("userPwd") String userPwd);
}
