/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.service;

import java.util.List;
import java.util.Map;

import com.daniu.nz.utils.Pagination;

/**
 * 基础Service接口.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
public interface BaseService<T> {

    /**
     * 保存.
     * @param t
     * @return {@linkplain Boolean}
     */
    boolean save(T t);

    /**
     * 删除.
     * @param t
     * @return {@linkplain Boolean}
     */
    boolean delete(T t);

    /**
     * 通过Id删除.
     * @param id
     * @return {@linkplain Boolean}
     */
    boolean deleteById(long id);

    /**
     * 通过Id批量删除.
     * @param id
     * @return {@linkplain Boolean}
     */
    boolean deleteByIds(Long[] id);

    /**
     * 更新.
     * @param t
     * @return {@linkplain Boolean}
     */
    boolean update(T t);

    /**
     * 更新某条记录的多个字段.
     * @param id
     * @param params
     * @return {@linkplain Boolean}
     */
    boolean update(long id, Map<String, Object> params);

    /**
     * 更新多条记录同一字段.
     * @param ids
     * @param field
     * @param value
     * @return {@linkplain Boolean}
     */
    boolean update(Long[] ids, String field, String value);

    /**
     * 通过Id查询.
     * @param id
     * @return {@linkplain T}
     */
    T findById(long id);

    /**
     * 多条件查询.
     * @param params
     * @return {@linkplain T}
     */
    T find(Map<String, Object> params);

    /**
     * 多条件查询数据条数.
     * @param params
     * @return {@linkplain Long}
     */
    long count(Map<String, Object> params);

    /**
     * 多条件查询结果集.
     * @param params
     * @param index
     * @param size
     * @return {@linkplain List} of {@linkplain T}
     */
    List<T> list(Map<String, Object> params, int index, int size);

    /**
     * 查询所有数据.
     * @return {@linkplain List} of {@linkplain T}
     */
    List<T> list();

    /**
     * 分页查询.
     * @param params
     * @param index
     * @param size
     * @return {@linkplain Pagination} of {@linkplain T}
     */
    Pagination<T> page(Map<String, Object> params, int index, int size);
}