package com.whut.springboot.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 1
 * @Date 2021/7/30
 * @Description IntelliJ IDEA
 **/
@WebFilter
public class SessionFilter implements Filter {
    String[] includeUrls = new String[]{"/", "/css/style2.css", "/images/user.png", "/login"};
//    //免登录就可访问的路径(比如:注册,登录,注册页面上的一些获取数据等)
//    String[] includeUrls = new String[]{"/organ/organInfoByName","/user/register","/user/login","/user/getSessionUserInfo"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String uri = request.getRequestURI();
        //System.out.println("-----------------" + uri);
        boolean needFilter = isNeedFilter(uri);
        if (needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            //session中包含user对象, 则是登录状态
            if (null != session && session.getAttribute("userName") != null) {
                filterChain.doFilter(request, response);
            } else {
//                response.setContentType("text/html; charset=utf-8");
//                response.getWriter().write("<script>alert('需要登录!')</script>");
                response.sendRedirect(request.getContextPath() + "/");
            }
        }
    }

    @Override
    public void destroy() {

    }

    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return true;
            }
        }
        return false;
    }


}
