package com.daniu.nz.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.daniu.nz.entity.Account;

/**
 * Web工具类.
 * @author Daniel Liu
 * @createTime 2014-5-4
 * @version V1.0
 */
public class WebUtil {

    private static String PRESENTUSER = "user_session_key";

    private static int HASHITERATION = 1024;

    /**
     * 获取当前登录用户.
     * @return {@linkplain Account}
     */
    public static Account present() {
        Session session = SecurityUtils.getSubject().getSession();
        Object o = session.getAttribute(PRESENTUSER);
        Account user = null;
        if (o instanceof Account) {
            user = (Account) o;
        }
        return user;
    }

    /**
     * 登录成功后记录用户信息
     * @param subject subject
     * @param user 用户信息
     */
    public static void login(Subject subject, Account user) {
        subject.getSession().setAttribute(PRESENTUSER, user);
    }

    /**
     * 退出登录时销毁用户资源.
     * @param subject subject
     */
    public static void logout(Subject subject) {
        subject.getSession().stop();
    }

    /**
     * 哈希加密.
     * @param plainText 明文
     * @param salt 盐值
     * @return {@linkplain String} - 密文
     */
    public static String encrypt(String plainText, String salt) {
        return new Sha512Hash(plainText, salt, HASHITERATION).toBase64();
    }

    public static void main(String[] args) {
        System.err.println(encrypt("123456", "a0"));
    }
}