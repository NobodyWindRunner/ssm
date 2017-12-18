package com.zjr.dao;

import com.zjr.dto.MenuInfoDto;
import com.zjr.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    /**
     * 分页列表
     */
    public List<MenuInfo> query();

    /**
     * 添加菜单
     */
    public boolean save(MenuInfo menuInfo);

    /**
     * 删除菜单
     */
    public boolean delete(int id);

    /**
     * 更新菜单
     */
    public boolean update(MenuInfo menuInfo);

    /**
     * 	根据ID获取菜单信息
     */
    public MenuInfo get(int id);

    /**
     * 数据总量
     */
    public int count();

    /**
     * 	根据parentId获取上级菜单信息
     */
    public List<MenuInfo> queryByParentId(int parentId);

    /**
     * 分页列表
     */
    public List<MenuInfoDto> queryByPage(@Param("page")int page, @Param("size")int size);
}
