package com.whut.springboot.service;

import com.whut.springboot.entities.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
public interface AccountService {
    boolean login(String userName, String userPwd);

    Integer updatePassword(String userName, String userPwd);

    boolean regist(String userName, String userPwd);
}
