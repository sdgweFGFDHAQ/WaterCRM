package com.whut.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 1
 * @Date 2021/7/24
 * @Description IntelliJ IDEA
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private Integer hid;

    private Worker worker;

    private Customer cust;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sendWaterTime;

    private Integer sendWaterCount;
}
