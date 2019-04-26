package com.naka.test.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 11:36
 * @description：登陆参数实体
 * @modified By：
 * @version: 1.0
 */
@Data
public class LoginParam implements Serializable {

    private static final long serialVersionUID = -4652951108851917778L;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 验证码 */
    private String captchaCode;

    /** 记住账号 */
    private boolean rememberMe;

    private String CSRFToken;

}
