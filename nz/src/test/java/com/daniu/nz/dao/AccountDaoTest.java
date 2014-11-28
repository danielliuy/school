/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.dao;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniu.nz.BaseTest;
import com.daniu.nz.entity.Account;

/**
 * 账户DAO测试.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
public class AccountDaoTest extends BaseTest {

    @Resource
    private AccountDao accountDao;

    private Date date;

    /**
     * 一句话描述该方法.
     * @throws java.lang.Exception {@linkplain String}
     */
    @Before
    public void setUp() throws Exception {
        date = new Date();
    }

    /**
     * 一句话描述该方法.
     * @throws java.lang.Exception {@linkplain String}
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#save(java.lang.Object)}.
     */
    @Test
    public void testSave() {
        Account t = new Account();
        t.setUsername("daniel");
        t.setPassword("123456");
        t.setCreateTime(date);
        t.setUpdateTime(date);
        accountDao.save(t);
        t = new Account();
        t.setUsername("liner");
        t.setPassword("123456");
        t.setCreateTime(date);
        t.setUpdateTime(date);
        accountDao.save(t);
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#delete(java.lang.Object)}.
     */
    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#deleteById(int)}.
     */
    @Test
    public void testDeleteById() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#deleteByIds(java.util.List)}.
     */
    @Test
    public void testDeleteByIds() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#update(java.lang.Object)}.
     */
    @Test
    public void testUpdateT() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#update(long, java.util.Map)}.
     */
    @Test
    public void testUpdateLongMapOfStringObject() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.daniu.nz.dao.impl.BaseDaoImpl#update(long[], java.lang.String, java.lang.String)}.
     */
    @Test
    public void testUpdateLongArrayStringString() {
        Long[] ids = {1L, 2L};
        String field = "password";
        String value = "000000";
        accountDao.update(Arrays.asList(ids), field, value);
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#findById(int)}.
     */
    @Test
    public void testFindById() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#find(java.util.Map)}.
     */
    @Test
    public void testFind() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.dao.impl.BaseDaoImpl#count(java.util.Map)}.
     */
    @Test
    public void testCount() {
        System.out.println(accountDao.count(null));
    }

    /**
     * Test method for
     * {@link com.daniu.nz.dao.impl.BaseDaoImpl#list(java.util.Map, org.hibernate.criterion.Order, int, int)}
     * .
     */
    @Test
    public void testList() {
        fail("Not yet implemented");
    }
}
