package com.whut.springboot.service;

import com.whut.springboot.entities.SendWaterInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public interface SendWaterInfoService {
    List<SendWaterInfo> listsendWaterInfo();
}
