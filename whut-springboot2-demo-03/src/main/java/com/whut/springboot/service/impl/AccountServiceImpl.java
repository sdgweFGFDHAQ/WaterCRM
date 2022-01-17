package com.whut.springboot.service.impl;

import cn.hutool.core.convert.NumberChineseFormater;
import com.whut.springboot.entities.Account;
import com.whut.springboot.mapper.AccountMapper;
import com.whut.springboot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean login(String userName, String userPwd) {
        System.out.println("-----------------------------------------------------");
        Account account = accountMapper.login(userName, userPwd);
        // 条件成立：表示数据库中没有对应的用户名，登录失败
        if (null == account) {
            return false;
        }

        //String s = DigestUtils.md5DigestAsHex(account.getUserPwd().getBytes(StandardCharsets.UTF_8));

        // 比较密码是否一致
        // 条件成立：参数的用户名密码和数据库用户名密码一致登录成功
        if (Objects.equals(userPwd, account.getUserPwd())) {
            return true;
        }
        return false;
    }

    @Override
    public Integer updatePassword(String userName, String userPwd) {
        System.out.println("accountMapper"+userPwd);
        return accountMapper.updatePassword(userName,userPwd);
    }

    @Override
    public boolean regist(String userName, String userPwd) {
        return false;
    }
}
