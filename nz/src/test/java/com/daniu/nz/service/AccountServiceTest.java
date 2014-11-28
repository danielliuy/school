/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.service;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniu.nz.BaseTest;
import com.daniu.nz.entity.Account;

/**
 * 账户Service测试类.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
public class AccountServiceTest extends BaseTest {

    @Resource
    private AccountService accountService;

    /**
     * 一句话描述该方法.
     * @throws java.lang.Exception {@linkplain String}
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * 一句话描述该方法.
     * @throws java.lang.Exception {@linkplain String}
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for
     * {@link com.daniu.nz.service.impl.AccountServiceImpl#findByUsername(java.lang.String)}.
     */
    @Test
    public void testFindByUsername() {
        String username = "daniel";
        Account account = accountService.findByUsername(username);
        System.err.println(account);
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#save(java.lang.Object)}.
     */
    @Test
    public void testSave() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#delete(java.lang.Object)}.
     */
    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#deleteById(long)}.
     */
    @Test
    public void testDeleteById() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.daniu.nz.service.impl.BaseServiceImpl#deleteByIds(java.lang.Long[])}.
     */
    @Test
    public void testDeleteByIds() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#update(java.lang.Object)}.
     */
    @Test
    public void testUpdateT() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#update(long, java.util.Map)}
     * .
     */
    @Test
    public void testUpdateLongMapOfStringObject() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.daniu.nz.service.impl.BaseServiceImpl#update(java.lang.Long[], java.lang.String, java.lang.String)}
     * .
     */
    @Test
    public void testUpdateLongArrayStringString() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#findById(long)}.
     */
    @Test
    public void testFindById() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#find(java.util.Map)}.
     */
    @Test
    public void testFind() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#count(java.util.Map)}.
     */
    @Test
    public void testCount() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.daniu.nz.service.impl.BaseServiceImpl#list(java.util.Map, int, int)}.
     */
    @Test
    public void testListMapOfStringObjectIntInt() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.daniu.nz.service.impl.BaseServiceImpl#list()}.
     */
    @Test
    public void testList() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.daniu.nz.service.impl.BaseServiceImpl#page(java.util.Map, int, int)}.
     */
    @Test
    public void testPage() {
        fail("Not yet implemented");
    }
}
