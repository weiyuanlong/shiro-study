package com.naka.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naka.test.domain.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuanLong Wei
 * @since 2019-04-26
 */
public interface IUserService extends IService<User> {

    User getUserByUsername(String username);

}
