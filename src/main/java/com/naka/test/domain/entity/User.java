package com.naka.test.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuanLong Wei
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String password;

    /**
     * 用于登录的账号
     */
    private String username;

    /**
     * 显示的用户名
     */
    private String displayName;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 个人主页
     */
    private String url;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String profile;

    private LocalDateTime createTime;

    private LocalDateTime lastLoginTime;

    /**
     * 正常1，禁止登录0, 已删除-1
     */
    private Boolean status;


}
