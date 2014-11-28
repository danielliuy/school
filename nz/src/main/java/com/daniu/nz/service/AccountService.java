/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.service;

import com.daniu.nz.entity.Account;

/**
 * 账户Service接口.
 * @author Daniel Liu
 * @createTime 2014-11-28
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-28
 * @version V1.0
 */
public interface AccountService extends BaseService<Account> {

    Account findByUsername(String username);
}