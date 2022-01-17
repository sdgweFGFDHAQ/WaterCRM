package com.whut.springboot.controller;

import cn.hutool.http.HttpResponse;
import com.whut.springboot.entities.Account;
import com.whut.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Controller()
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String userPwd, Model model, HttpSession session) {
        boolean loginResult = accountService.login(userName, userPwd);

        // 条件成立：登录成功，跳转到主页面
        if(loginResult){
            session.setAttribute("userName",userName);
            return "waterMainMenu";
        } else {
            model.addAttribute("loginFail","用户名或者密码错误");
            return "index";
        }
    }

    @RequestMapping("/update")
    public String update(){
        return "updatePasswordPre";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String userName, String userPwd, String newUserPwd, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset = gb2312");
        PrintWriter out = resp.getWriter();
        if(accountService.login(userName,userPwd)){
            System.out.println("accountService"+newUserPwd);
            int rows = accountService.updatePassword(userName, newUserPwd);
            out.print("<script>alert('修改成功！');location.href='http://localhost:8090'</script>");
            return "index";
        }
        out.print("<script>alert('修改失败！');location.href='http://localhost:8090'</script>");
        return "index";
    }
}
