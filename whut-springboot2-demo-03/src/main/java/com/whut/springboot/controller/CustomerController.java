package com.whut.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Customer;
import com.whut.springboot.service.CustomerService;
import com.whut.springboot.service.PageNav;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Controller
@RequestMapping("/cust")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/custList")
    public String listCust(Model model) {
        List<Customer> custList = customerService.listCustomer();
        model.addAttribute("custList", custList);
        return "custList";
    }

    @RequestMapping("/searchCust")
    public String searchCustomerByName(String custName, Model model) {
        List<Customer> custList = customerService.searchCustomerByName(custName);
        model.addAttribute("custList", custList);
        model.addAttribute("data", custName);
//        log.info("data:{}",model.getAttribute("data"));
        return "custList";
    }

    @RequestMapping("/saveCustomerPre")
    public String saveCustomerPre() {
        return "saveCustomerPre";
    }

    @RequestMapping("/saveCustomer")
    public String saveCostomer(Customer customer) {
        Integer rows = customerService.saveCustomer(customer);
        System.out.println("rows = " + rows);
        System.out.println("worker =" + customer);
        return "redirect:/cust/custListPage";
    }

    @RequestMapping("/updateCustomerPre/{cid}")
    public String updateCustomerPre(@PathVariable("cid") Integer cid, Model model) {
        Customer customer = customerService.getCustomerById(cid);
        if (log.isInfoEnabled()) {
            log.info("customer:{}", customer);
        }
        model.addAttribute("customer", customer);
        return "updateCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(Customer customer) {
        Integer rows = customerService.updateCustomer(customer);
        System.out.println("rows = " + rows);
        return "redirect:/cust/custListPage";

    }

    @RequestMapping("/deleteCustomer/{cid}")
    public String deleteCustomerById(@PathVariable("cid") Integer cid) {
        Integer rows = customerService.deleteCustomerById(cid);
        if (log.isInfoEnabled()) {
            log.info("rows:{}", rows);
        }
        return "redirect:/cust/custListPage";
    }

    @RequestMapping("/custListPage")
    public String listCustomerForPage(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        // ??????????????????????????????????????????
        PageInfo<Customer> pageInfo = customerService.listObjectForPage(pageNum);
        // ??????????????????????????????
        List<Customer> custList = pageInfo.getList();
        // ?????????????????????????????????????????????
        model.addAttribute("custList", custList);
        model.addAttribute("pageInfo", pageInfo);
        // ??????????????????????????????????????????????????????
        model.addAttribute("pageData", "listCustomer");
        return "custList";
    }

    /**
     * ????????????
     * ?????????
     * 1 ???  ???????????????????????????
     * 2 ???
     * ???????????????????????????????????????(????????????)
     * ???????????????????????????
     *
     * @param custName
     * @param model
     * @return
     */
    @RequestMapping("/searchCustByPage")
    public String searchCustomer(
            String custName,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            Model model) {
        if (log.isInfoEnabled()) {
            log.info("searchCustomer name = " + custName);
        }
        PageInfo<Customer> pageInfo = customerService.searchObject(pageNum, custName);
        // ?????????????????????
        model.addAttribute("custList", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        // ???????????????????????????
        model.addAttribute("pageData", "searchData");
        model.addAttribute("data", custName);

        // ???????????????????????????
        return "custList";
    }
}
