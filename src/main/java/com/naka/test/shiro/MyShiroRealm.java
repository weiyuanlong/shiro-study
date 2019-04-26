package com.naka.test.shiro;

import com.naka.test.domain.entity.Role;
import com.naka.test.domain.entity.User;
import com.naka.test.service.IRoleService;
import com.naka.test.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 9:41
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("授权管理 doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();

        List<Role> roleList = roleService.findRoleByUser(user);
        if (roleList == null)
            return authorizationInfo;

        for (Role role : roleList) {
            authorizationInfo.addRole(role.getRole());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("登陆认证管理 doGetAuthenticationInfo");
        String username = (String) token.getPrincipal();
        System.out.println(username);

        User user = userService.getUserByUsername(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return authenticationInfo;
    }

}
