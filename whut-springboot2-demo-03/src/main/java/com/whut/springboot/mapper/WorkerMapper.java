package com.whut.springboot.mapper;

import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/23
 * @Description IntelliJ IDEA
 **/
public interface WorkerMapper {
    List<Worker> listWorker();

    List<Worker> searchWorkerByName(@Param("workerName") String workerName);

    Integer saveWorker(Worker worker);

    Worker getWorkerById(Integer wid);

    Integer updateWorker(Worker worker);

    Integer deleteWorkerById(Integer wid);

    int adjustSalary(@Param("wid") Integer wid, @Param("workerSalary") Integer workerSalary);
}
