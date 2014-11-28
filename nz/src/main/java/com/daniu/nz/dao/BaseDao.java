/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

/**
 * 基础Dao操作接口.
 * @author Daniel Liu
 * @createTime 2014-2-10
 * @version V1.0
 */
public interface BaseDao<T> {

    /**
     * 保存.
     * @param t
     */
    void save(T t);

    /**
     * 通过实体删除.
     * @param t
     */
    void delete(T t);

    /**
     * 通过Id删除.
     * @param id
     */
    void deleteById(long id);

    /**
     * 通过Id批量删除.
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 更新.
     * @param t
     */
    void update(T t);

    /**
     * 更新多个字段.
     * @param id
     * @param params
     */
    void update(long id, Map<String, Object> params);

    /**
     * 更新多个实体的同一字段.
     * @param ids
     * @param field
     * @param value
     */
    void update(List<Long> ids, String field, String value);

    /**
     * 通过Id查询.<br>
     * @param id Id
     * @return {@linkplain T}
     */
    T findById(long id);

    /**
     * 查询一条(多条件).<br>
     * @param params 字段-值Map
     * @return {@linkplain T}
     */
    T find(Map<String, Object> params);

    /**
     * 查询条数(多条件).<br>
     * @param params 字段-值Map
     * @return {@linkplain Integer}
     */
    int count(Map<String, Object> params);

    /**
     * 查询多条数据(多条件).<br>
     * @param params 字段-值Map
     * @param order 排序
     * @param index 查询起点
     * @param size 查询大小
     * @return {@linkplain List} of {@linkplain T}
     */
    List<T> list(Map<String, Object> params, Order order, int index, int size);
}