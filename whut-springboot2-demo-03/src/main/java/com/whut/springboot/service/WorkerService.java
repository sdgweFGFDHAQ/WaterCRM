package com.whut.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/23
 * @Description IntelliJ IDEA
 **/
public interface WorkerService extends PageNav{
    List<Worker> listWorker();

    List<Worker> searchWorkerByName(String workerName);

    Integer saveWorker(Worker worker);

    Worker getWorkerById(Integer wid);

    Integer updateWorker(Worker worker);

    Integer deleteWorkerById(Integer wid);

    int adjustSalary( Integer wid, Integer workerSalary);

    @Override
     default PageInfo<Worker> listObjectForPage(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Worker> list = this.listWorker();
        // 分页Bean，封装了分页查询的数据，将查询结果注入到分页对象(Bean)
        PageInfo<Worker> pageInfo =  new PageInfo<>(list);
        return pageInfo;
    }

    @Override
     default PageInfo<Worker> searchObject(Integer pageNum, String workerName) {
        PageHelper.startPage(pageNum,3);
        List<Worker> workerList = this.searchWorkerByName(workerName);
        PageInfo<Worker> pageInfo = new PageInfo<>(workerList);
        return pageInfo;
    }
}
