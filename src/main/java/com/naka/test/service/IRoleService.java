package com.naka.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naka.test.domain.entity.Role;
import com.naka.test.domain.entity.User;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuanLong Wei
 * @since 2019-04-26
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据用户获取角色
     *
     * @param user
     * @return
     */
    List<Role> findRoleByUser(User user);

}
