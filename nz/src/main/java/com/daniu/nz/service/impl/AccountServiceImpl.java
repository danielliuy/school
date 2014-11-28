/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.daniu.nz.entity.Account;
import com.daniu.nz.service.AccountService;

/**
 * 账户Service实现.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    /*
     * (non-Javadoc)
     * @see com.daniu.nz.service.AccountService#findByUsername(java.lang.String)
     */
    @Override
    public Account findByUsername(String username) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        return find(params);
    }
}