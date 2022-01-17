package com.whut.springboot.service;

import com.whut.springboot.entities.History;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/24
 * @Description IntelliJ IDEA
 **/
public interface HistoryService {
    List<History> listHistory();

    List<History> searchHistoryByTime(String startswTime, String endswTime);

    Integer saveHistory(History history, Integer custId, Integer workerId);

    History getHistoryById(Integer hid);

    int updateHistory(History history, Integer custId, Integer workerId);

    Integer deleteHistoryById(int hid);
}
