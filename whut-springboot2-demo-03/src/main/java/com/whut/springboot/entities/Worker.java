package com.whut.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 1
 * @Date 2021/7/23
 * @Description IntelliJ IDEA
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private Integer wid;

    private String workerName;

    private String workerSalary;

    private String workerMoney;

    private String workerImage;
}
