/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.web.account;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniu.nz.entity.Account;
import com.daniu.nz.service.AccountService;
import com.daniu.nz.utils.WebUtil;

/**
 * 登陆Controller.
 * @author Daniel Liu
 * @createTime 2014-11-27
 * @reviseDes 修订功能描述
 * @reviser
 * @reviseTime 2014-11-27
 * @version V1.0
 */
@Controller
public class LoginController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/index";
        }
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, String captcha, RedirectAttributes redirect,
            HttpServletRequest req) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            redirect.addFlashAttribute("error", "用户名或密码不能为空");
            return "redirect:login";
        }
        if (req.getSession().getAttribute("captcha") == null) {
            redirect.addFlashAttribute("error", "验证码不能为空");
            return "redirect:login";
        }
        String session_captcha = (String) req.getSession().getAttribute("captcha");
        if (!session_captcha.equalsIgnoreCase(captcha)) {
            redirect.addFlashAttribute("error", "验证码错误");
            return "redirect:login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
        try {
            subject.login(token);
            Account user = accountService.findByUsername(username);
            WebUtil.login(subject, user);
        } catch (LockedAccountException e) {
            redirect.addFlashAttribute("error", "账户被停用或审核状态中");
            return "redirect:login";
        } catch (AuthenticationException e) {
            redirect.addFlashAttribute("error", "用户名或密码错误");
            return "redirect:login";
        }
        return "redirect:index";
    }
}
