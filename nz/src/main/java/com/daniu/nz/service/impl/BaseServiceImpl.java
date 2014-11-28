/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.daniu.nz.dao.BaseDao;
import com.daniu.nz.service.BaseService;
import com.daniu.nz.utils.Pagination;

/**
 * 基础Service实现.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Resource
    protected BaseDao<T> baseDao;

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#save(java.lang.Object)
     */
    @Override
    @Transactional
    public boolean save(T t) {
        try {
            baseDao.save(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#delete(java.lang.Object)
     */
    @Override
    @Transactional
    public boolean delete(T t) {
        try {
            baseDao.delete(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#deleteById(long)
     */
    @Override
    @Transactional
    public boolean deleteById(long id) {
        try {
            baseDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#deleteByIds(long[])
     */
    @Override
    @Transactional
    public boolean deleteByIds(Long[] ids) {
        try {
            baseDao.deleteByIds(Arrays.asList(ids));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#update(java.lang.Object)
     */
    @Override
    @Transactional
    public boolean update(T t) {
        try {
            baseDao.update(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#update(long, java.util.Map)
     */
    @Override
    @Transactional
    public boolean update(long id, Map<String, Object> params) {
        try {
            baseDao.update(id, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#update(long[], java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean update(Long[] ids, String field, String value) {
        try {
            baseDao.update(Arrays.asList(ids), field, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#findById(long)
     */
    @Override
    public T findById(long id) {
        return baseDao.findById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#find(java.util.Map)
     */
    @Override
    public T find(Map<String, Object> params) {
        return baseDao.find(params);
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#count(java.util.Map)
     */
    @Override
    public long count(Map<String, Object> params) {
        return baseDao.count(params);
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#list(java.util.Map, int, int)
     */
    @Override
    public List<T> list(Map<String, Object> params, int index, int size) {
        return baseDao.list(params, null, index, size);
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#list()
     */
    @Override
    public List<T> list() {
        return baseDao.list(null, null, 0, 0);
    }

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.BaseService#page(java.util.Map, int, int)
     */
    @Override
    public Pagination<T> page(Map<String, Object> params, int pageNo, int pageSize) {
        int sum = baseDao.count(params);
        Pagination<T> page = new Pagination<>(sum, pageNo, pageSize);
        if (sum > 0) {
            List<T> datas = baseDao.list(params, null, page.getIndex(), page.getPageSize());
            page.setDatas(datas);
        }
        return page;
    }
}