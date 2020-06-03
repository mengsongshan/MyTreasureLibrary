package com.water.dao;

import com.water.entity.AbstractEntity;

import java.util.List;
import java.util.Map;

public interface BaseDao<T extends AbstractEntity> {

    Integer add(T entity);

    Integer update(T entity);

    Integer delete(String uuid);

    T selectOne(String uuid);

    List<T> list(Map<String, Object> params);

    Integer batchAdd(List<T> entities);
}
