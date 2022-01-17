package com.whut.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 被@Configuration注解修饰的类可以替换xml配置文件
 * @Configuration用于构建Spring，启动Spring容器
 * @Author 1
 * @Date 2021/7/29
 * @Description IntelliJ IDEA
 **/
@Configuration
@Slf4j
public class DruidConfig {
    /**
     * Druid数据源注入到Spring容器
     * @ConfigurationProperties(prefix = "spring.datasource")表示获取yml配置文件
     * 前缀为spring.datasource的所有属性值
     * 被@Bean注解的方法被AnnotationConfigWebApplicationContext类扫描，将方法
     * 返回的对象注入到Spring容器
     * @return 数据源对象
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource createDruidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 向Spring容器注入Druid监控。通过StatViewServlet通过ServletRegistrationBean注入
     * 到Spring容器。
     * StatViewServlet用于Druid监控，展示的统计信息
     * @return ServletRegistrationBean表示Servlet的注册类
     */
    @Bean
    public ServletRegistrationBean createStatViewServlet() {
        if (log.isInfoEnabled()) {
            log.info("create StatViewServlet");
        }
        ServletRegistrationBean<StatViewServlet> servlet =
                new ServletRegistrationBean<>(
                        new StatViewServlet(), "/druid/*");
        // 设置初始化参数，登录的key都是固定的
        Map<String,String> initParamsMap =  new HashMap<>();
        initParamsMap.put("loginUsername","admin");
        initParamsMap.put("loginPassword","123456");
        // 白名单，允许所有ip地址登录
        initParamsMap.put("allow","");

        servlet.setInitParameters(initParamsMap);
        return servlet;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js, *.css, /druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Collections.singletonList("/*"));

        return bean;
    }
}
