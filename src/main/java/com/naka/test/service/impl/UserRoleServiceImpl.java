package com.naka.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.naka.test.domain.entity.UserRole;
import com.naka.test.mapper.UserRoleMapper;
import com.naka.test.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuanLong Wei
 * @since 2019-04-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
