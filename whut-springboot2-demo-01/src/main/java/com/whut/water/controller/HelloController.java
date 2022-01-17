package com.whut.water.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello..汉字";
    }

    @GetMapping("/good")
    public int good(){
        System.out.println("语句输出");
        return 123;
    }
}
