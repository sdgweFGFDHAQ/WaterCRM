package com.whut.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendWaterInfo {
    private String workerName;

    private String custNameList;

    private Integer sendWaterCount;
}
