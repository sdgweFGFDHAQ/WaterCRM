package com.whut.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO:送水工管理系统
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@SpringBootApplication
@MapperScan("com.whut.springboot.mapper")
public class CustomSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomSpringBootApplication.class,args);
    }
}
