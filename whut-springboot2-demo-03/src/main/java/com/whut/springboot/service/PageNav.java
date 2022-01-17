package com.whut.springboot.service;

import com.github.pagehelper.PageInfo;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public interface PageNav {
    public final static int PAGE_SiZE = 3;
    public <T> PageInfo<T> listObjectForPage(Integer pageNum );
    <T> PageInfo<T> searchObject(Integer pageNum, String Name);
}
