package com.whut.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.WebFilter;

/**
 * TODO:送水工管理系统
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@SpringBootApplication
@MapperScan("com.whut.springboot.mapper")
@ServletComponentScan
public class WaterSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterSpringBootApplication.class,args);
    }
}
