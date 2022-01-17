package com.whut.springboot.service.impl;

import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.History;
import com.whut.springboot.entities.Worker;
import com.whut.springboot.mapper.HistoryMapper;
import com.whut.springboot.service.CustomerService;
import com.whut.springboot.service.HistoryService;
import com.whut.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/24
 * @Description IntelliJ IDEA
 **/
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    CustomerService customerService;
    @Autowired
    WorkerService workerService;

    @Override
    public List<History> listHistory() {
        return historyMapper.listHistory();
    }

    @Override
    public List<History> searchHistoryByTime(String startswTime, String endswTime) {
        return historyMapper.searchHistoryByTime(startswTime,endswTime);
    }

    @Override
    public Integer saveHistory(History history,Integer custId,Integer workerId) {

        Customer customer = customerService.getCustomerById(custId);
        Worker worker = workerService.getWorkerById(workerId);

        history.setCust(customer);
        history.setWorker(worker);

        return historyMapper.saveHistory(history);
    }

    @Override
    public History getHistoryById(Integer hid) {
        return historyMapper.getHistoryById(hid);
    }

    @Override
    public int updateHistory(History history,Integer custId,Integer workerId) {
        Customer customer = new Customer();
        customer.setCid(custId);
        Worker worker = new Worker();
        worker.setWid(workerId);

        history.setWorker(worker);
        history.setCust(customer);
        return historyMapper.updateHistory(history);
    }

    @Override
    public Integer deleteHistoryById(int hid) {
        return historyMapper.deleteHistoryById(hid);
    }
}
