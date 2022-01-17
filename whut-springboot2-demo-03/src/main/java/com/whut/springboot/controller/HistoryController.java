package com.whut.springboot.controller;

import com.whut.springboot.entities.Customer;
import com.whut.springboot.entities.History;
import com.whut.springboot.entities.Worker;
import com.whut.springboot.service.CustomerService;
import com.whut.springboot.service.HistoryService;
import com.whut.springboot.service.WorkerService;
import com.whut.springboot.service.impl.CustomerServiceImpl;
import com.whut.springboot.service.impl.WorkerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/24
 * @Description IntelliJ IDEA
 **/
@Controller
@RequestMapping("/history")
@Slf4j
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private WorkerService workerService;

    @RequestMapping("/historyList")
    public String listHistory(Model model) {
        List<History> historyList = historyService.listHistory();
        if (log.isInfoEnabled()) {
            log.info(historyList.toString());
        }
        model.addAttribute("historyList",historyList);
        return "historyList";
    }

    @RequestMapping("/searchHistory")
    public String searchHistoryByTime(String startswTime, String endswTime, Model model) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startTime = simpleDateFormat.parse(startswTime);
//        Date endTime = simpleDateFormat.parse(startswTime);
//        log.info("?{},?{}",startswTime,endswTime);
        List<History> historyList = historyService.searchHistoryByTime(startswTime,endswTime);
        model.addAttribute("historyList", historyList);
        model.addAttribute("startswTime",startswTime);
        model.addAttribute("endswTime",endswTime);
        return "historyList";
    }

    @RequestMapping("/saveHistoryPre")
    public String saveHistoryPre() {
        return "saveHistoryPre";
    }

    @RequestMapping("/saveHistory")
    public String saveHistory(History history,Integer custId,Integer workerId) {
        Integer rows = historyService.saveHistory(history, custId, workerId);
        return "redirect:/history/historyList";
    }

    @RequestMapping("/preUpdateHistory/{hid}")
    public String preUpdateHistory(@PathVariable("hid") Integer hid, Model model) {
        if (log.isInfoEnabled()) {
            log.info("preUpdateHistory hid = "+hid);
        }

        History history = historyService.getHistoryById(hid);
        List<Customer> customerList = customerService.listCustomer();
        List<Worker> workerList = workerService.listWorker();
        model.addAttribute("history",history);
        model.addAttribute("customerList",customerList);
        model.addAttribute("workerList",workerList);
//        for(Customer c:customerList){
//            model.addAttribute("name",c.getCustName());
//        }
        return "historyUpdate";
    }

    @PostMapping(value = "/updateHistory")
    public String updateHistory(History history,Integer custId,Integer workerId) {
        if (log.isInfoEnabled()) {
            log.info("updateHistory "+history);
            log.info("workerId = "+workerId);
            log.info("custId = "+custId);
        }


        int rows = historyService.updateHistory(history, custId, workerId);
        if (log.isInfoEnabled()) {
            log.info("update history rows = "+rows);
        }
        return "redirect:/history/historyList";
    }

    @PostMapping(value = "/deleteMany")
    @ResponseBody
    @Transactional(rollbackFor = {Exception.class,Error.class})
    public String deleteMany( @RequestParam(value="id") Integer[] id) {
        System.out.println(Arrays.toString(id));
        for(int hid: id){
            System.out.println(hid);
            historyService.deleteHistoryById(hid);
        }
        return "success";
    }
}
