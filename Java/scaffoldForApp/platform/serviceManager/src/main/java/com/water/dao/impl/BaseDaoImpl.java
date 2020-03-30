package com.water.dao.impl;

import com.github.pagehelper.PageInfo;
import com.water.dao.BaseDao;
import com.water.entitys.AbstractEntity;
import com.water.mappers.BaseMapper;

import java.util.List;
import java.util.Map;

public abstract
class BaseDaoImpl<T extends AbstractEntity> implements BaseDao<T> {

    protected abstract
    BaseMapper<T> getBaseMapper();

    @Override
    public
    Integer add(T entity) {
        return getBaseMapper().add(entity);
    }

    @Override
    public
    Integer update(T entity) {
        return getBaseMapper().update(entity);
    }

    @Override
    public
    Integer delete(String uuid) {
        return getBaseMapper().delete(uuid);
    }

    @Override
    public
    T get(String uuid) {
        return getBaseMapper().get(uuid);
    }

    @Override
    public
    Integer batchAdd(List<T> entitys) {
        return null;
    }

    @Override
    public
    Integer batchUpdate(List<T> entitys) {
        return null;
    }

    @Override
    public
    Integer batchDelete(List<T> entitys) {
        return null;
    }

    @Override
    public
    List<T> list(Map<String, Object> params) {
        return getBaseMapper().list(params);
    }

    @Override
    public PageInfo<T> page(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
