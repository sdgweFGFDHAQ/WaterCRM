package com.whut.springboot.service.impl;

import com.whut.springboot.entities.SendWaterInfo;
import com.whut.springboot.mapper.SendWaterInfoMapper;
import com.whut.springboot.service.SendWaterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Service
public class SendWaterInfoServiceImpl implements SendWaterInfoService {
    @Autowired
    private SendWaterInfoMapper sendWaterInfoMapper;


    @Override
    public List<SendWaterInfo> listsendWaterInfo() {
        return sendWaterInfoMapper.listsendWaterInfo();
    }
}
