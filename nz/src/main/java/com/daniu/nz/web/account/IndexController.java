/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页.
 * @author Daniel Liu
 * @createTime 2014-11-27
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-27
 * @version V1.0
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index"})
    public String index() {
        return "index";
    }
}