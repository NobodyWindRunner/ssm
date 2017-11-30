package com.zjr.dao;

import com.zjr.entity.MenuInfo;

import java.util.List;

public interface MenuDao {
    /**
     * 分页列表
     */
    public List<MenuInfo> query();
}
