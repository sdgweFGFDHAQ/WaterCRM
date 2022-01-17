package com.whut.springboot.mapper;

import com.whut.springboot.entities.SendWaterInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public interface SendWaterInfoMapper {

    @Select("select w.worker_name  ,-- 送水工 \n" +
            "ifnull(group_concat(distinct c.cust_name),'-') custNameList, -- 客户列表\n" +
            "ifnull(sum(h.send_water_count),0) sendWaterCount -- 送水数量\n" +
            "from worker w left join history h on w.wid = h.worker_id left join customer c on c.cid = h.cust_id\n" +
            "group by w.worker_name\n" +
            "order by sendWaterCount desc;")
    List<SendWaterInfo> listsendWaterInfo();

}
