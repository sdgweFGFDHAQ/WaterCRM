package com.whut.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.whut.springboot.entities.Worker;
import com.whut.springboot.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 1
 * @Date 2021/7/23
 * @Description IntelliJ IDEA
 **/
@Controller
@RequestMapping("/worker")
@Slf4j
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @Value("${location}")
    private String location;

    private String saveFile(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        // 条件成立：上传文件
        if (StrUtil.isNotEmpty(multipartFile.getOriginalFilename())) {
            int suffixIndex = originalFilename.lastIndexOf(".");
            long prefix = System.currentTimeMillis();
            // 设置上传的文件在服务器端的路径
            String suffix = originalFilename.substring(suffixIndex);
            String fullFileName = prefix + suffix;
            File parentPath = new File(location);
            // 条件成立：服务器路径不存在创建路径
            if (!parentPath.exists()) {
                parentPath.mkdirs();
            }
            File destPath = new File(parentPath, fullFileName);
            multipartFile.transferTo(destPath);
            return fullFileName;
        }
        return originalFilename;
    }

    @RequestMapping("/workerList")
    public String listWorker(Model model) {
        List<Worker> workerList = workerService.listWorker();
        model.addAttribute("workerList", workerList);
        return "workerList";
    }

    @RequestMapping("/searchWorker")
    public String searchWorkerByName(String workerName, Model model) {
        List<Worker> workerList = workerService.searchWorkerByName(workerName);
        model.addAttribute("workerList", workerList);
        return "workerList";
    }

    @RequestMapping("/saveWorkerPre")
    public String saveWorkerPre() {
        return "saveWorkerPre";
    }

    @PostMapping(value = "/saveWorker")
    public String saveWorker(Worker worker, MultipartFile fileUpload) throws IOException {
        if (log.isInfoEnabled()) {
            log.info("save worker " + worker);
            log.info(fileUpload.getOriginalFilename());
        }
        String fullFileName = saveFile(fileUpload);
        worker.setWorkerImage(fullFileName);
        workerService.saveWorker(worker);

        return "redirect:/worker/workerListPage";
    }

    @RequestMapping("/updateWorkerPre/{wid}")
    public String updateWorkerPre(@PathVariable("wid") Integer wid, Model model) {
        Worker worker = workerService.getWorkerById(wid);
        if (log.isInfoEnabled()) {
            log.info("worker:{}", worker);
        }
        model.addAttribute("worker", worker);
        return "updateWorker";
    }

    @PostMapping("/updateWorker")
    public String updateWorker(Worker worker, MultipartFile workerImageFile) throws IOException {
        System.out.println(workerImageFile + "----------------------");
        String fullFileName = saveFile(workerImageFile);
        worker.setWorkerImage(fullFileName);
        Integer rows = workerService.updateWorker(worker);
        System.out.println("rows = " + rows);
        return "redirect:/worker/workerListPage";

    }

    @RequestMapping("/deleteWorker/{wid}")
    @ResponseBody
    public String deleteWorkerById(@PathVariable("wid") Integer wid) throws IOException {
        Map<String, Object> map = new HashMap<>();
//        try {
//            Integer rows = workerService.deleteWorkerById(wid);
//            return "redirect:/worker/workerListPage";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "redirect:/worker/workerListPage";
//        }
        try {
            Integer rows = workerService.deleteWorkerById(wid);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "删除失败");
            return "fail";
        }
    }

    /*  @ResponseBody的作用其实是将java对象转为json格式的数据。
        @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
        注意：在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
        @ResponseBody是作用在方法上的，@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，一般在异步获取数据时使用【也就是AJAX】。
        注意：在使用 @RequestMapping后，返回值通常解析为跳转路径，但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。
        比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据。
        @RequestBody 将 HTTP 请求正文插入方法中，使用适合的 HttpMessageConverter 将请求体写入某个对象。
    */
    @PostMapping(value = "/adjustSalary")
    @ResponseBody
    public String adjustSalary(@RequestParam("wid") Integer wid, @RequestParam("workerSalary") Integer workerSalary) {
        if (log.isInfoEnabled()) {
            log.info("adjustSalary wid ===" + wid + " workerSalary = " + workerSalary);
        }
        int rows = workerService.adjustSalary(wid, workerSalary);
        if (log.isInfoEnabled()) {
            log.info("adjustSalary rows = " + rows);
        }
        if (rows > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/workerListPage")
    public String listWorkerForPage(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        // 调用业务逻辑层，获取分页数据
        PageInfo<Worker> pageInfo = workerService.listObjectForPage(pageNum);
        // 获取当前页的客户列表
        List<Worker> workerList = pageInfo.getList();
        // 客户列表、分页对象传入前端页面
        model.addAttribute("workerList", workerList);
        model.addAttribute("pageInfo", pageInfo);
        // 表示普通的分页查询，不是根据条件搜索
        model.addAttribute("pageData", "listWorker");
        return "workerList";
    }


    @RequestMapping("/searchWorkerByPage")
    public String searchWorker(
            String workerName,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            Model model) {
        if (log.isInfoEnabled()) {
            log.info("searchCustomer name = " + workerName);
        }
        PageInfo<Worker> pageInfo = workerService.searchObject(pageNum, workerName);
        // 数据传入到前端
        model.addAttribute("workerList", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        // 按条件搜索分页查询
        model.addAttribute("pageData", "searchData");
        model.addAttribute("data", workerName);

        // 跳转到客户列表页面
        return "workerList";
    }
}
