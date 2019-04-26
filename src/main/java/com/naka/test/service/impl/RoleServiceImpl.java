package com.naka.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.naka.test.domain.entity.Role;
import com.naka.test.domain.entity.User;
import com.naka.test.domain.entity.UserRole;
import com.naka.test.mapper.RoleMapper;
import com.naka.test.mapper.UserRoleMapper;
import com.naka.test.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuanLong Wei
 * @since 2019-04-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findRoleByUser(User user) {
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("user_id",user.getId());
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);

        List<Integer> roleIds = new ArrayList<>();
        for(UserRole userRole : userRoles) {
            roleIds.add(userRole.getRoleId());
        }

        if(roleIds == null || roleIds.isEmpty())
            return null;

        List<Role> roles = (List<Role>) this.listByIds(roleIds);
        return roles;
    }

}
