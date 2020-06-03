package com.water.dao.impl;

import com.water.dao.BaseDao;
import com.water.entity.AbstractEntity;
import com.water.mapper.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T extends AbstractEntity> implements BaseDao {

    abstract BaseMapper getMapper();

    @Override
    public Integer add(AbstractEntity entity) {
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(new Date());
        }
        return getMapper().add(entity);
    }

    @Override
    public Integer update(AbstractEntity entity) {
        if (entity.getUpdateTime() == null) {
            entity.setUpdateTime(new Date());
        }
        return getMapper().update(entity);
    }

    @Override
    public Integer delete(String uuid) {
        return getMapper().delete(uuid);
    }

    @Override
    public AbstractEntity selectOne(String uuid) {
        return getMapper().selectOne(uuid);
    }

    @Override
    public List list(Map params) {
        return getMapper().list(params);
    }

    @Override
    public Integer batchAdd(List entities) {
        return getMapper().batchAdd(entities);
    }
}
