package com.water.dao;

import com.github.pagehelper.PageInfo;
import com.water.entitys.AbstractEntity;

import java.util.List;
import java.util.Map;

/**
 * 公用DAO
 *
 * @param <T>
 */
public
interface BaseDao<T extends AbstractEntity> {

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    Integer add(T entity);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 删除
     *
     * @param uuid
     * @return
     */
    Integer delete(String uuid);

    /**
     * 查询一个
     *
     * @param uuid
     * @return
     */
    T get(String uuid);

    /**
     * 批量添加
     *
     * @param entitys
     * @return
     */
    Integer batchAdd(List<T> entitys);

    /**
     * 批量修改
     *
     * @param entitys
     * @return
     */
    Integer batchUpdate(List<T> entitys);

    /**
     * 批量删除
     *
     * @param entitys
     * @return
     */
    Integer batchDelete(List<T> entitys);

    /**
     * 按照条件查询
     *
     * @param params
     * @return
     */
    List<T> list(Map<String, Object> params);

    /**
     * 按照条件查询，支持分页
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    PageInfo<T> page(Integer pageNum, Integer pageSize, Map<String, Object> params);

}
