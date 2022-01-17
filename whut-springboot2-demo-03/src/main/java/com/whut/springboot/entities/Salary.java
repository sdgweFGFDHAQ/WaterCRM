package com.whut.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private String workerName;

    private Integer workerSalary;

    private Double workerMoney;

    private Integer waterCount;

    private Double realSalary;
}
