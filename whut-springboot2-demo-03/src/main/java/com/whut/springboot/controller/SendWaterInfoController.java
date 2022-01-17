package com.whut.springboot.controller;

import com.whut.springboot.entities.SendWaterInfo;
import com.whut.springboot.service.SendWaterInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
@Controller
@Slf4j
@RequestMapping("/Info")
public class SendWaterInfoController {
    @Autowired
    private SendWaterInfoService sendWaterInfoService;

    @RequestMapping("/sendWaterInfo")
    public String SendWaterInfo(Model model){
        List<SendWaterInfo> sendWaterInfoList = sendWaterInfoService.listsendWaterInfo();
        model.addAttribute("infoList",sendWaterInfoList);
        log.info(sendWaterInfoList.toString());
        return "sendWaterInfoList";
    }
}
