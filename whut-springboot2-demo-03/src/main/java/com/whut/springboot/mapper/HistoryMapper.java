package com.whut.springboot.mapper;

import com.whut.springboot.entities.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/24
 * @Description IntelliJ IDEA
 **/
public interface HistoryMapper {
    List<History> listHistory();

    List<History> searchHistoryByTime(@Param("startswTime") String startswTime, @Param("endswTime")String endswTime);

    Integer saveHistory(History history);

    History getHistoryById(Integer hid);

    int updateHistory(History history);

    public Integer deleteHistoryById(int hid);
}
