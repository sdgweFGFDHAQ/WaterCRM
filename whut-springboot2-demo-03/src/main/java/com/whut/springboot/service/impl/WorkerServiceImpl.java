package com.whut.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.Worker;
import com.whut.springboot.mapper.WorkerMapper;
import com.whut.springboot.service.PageNav;
import com.whut.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/23
 * @Description IntelliJ IDEA
 **/
@Service
public class WorkerServiceImpl implements WorkerService{
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public List<Worker> listWorker() {
        return workerMapper.listWorker();
    }

    @Override
    public List<Worker> searchWorkerByName(String workerName) {
        return workerMapper.searchWorkerByName(workerName);
    }

    @Override
    public Integer saveWorker(Worker worker) {
        return workerMapper.saveWorker(worker);
    }

    @Override
    public Worker getWorkerById(Integer wid) {
        return workerMapper.getWorkerById(wid);
    }

    @Override
    public Integer updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public Integer deleteWorkerById(Integer wid) {
        return workerMapper.deleteWorkerById(wid);
    }

    @Override
    public int adjustSalary(Integer wid, Integer workerSalary) {
        return workerMapper.adjustSalary(wid,workerSalary);
    }
}
