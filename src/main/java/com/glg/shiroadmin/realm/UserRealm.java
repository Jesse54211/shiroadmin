package com.glg.shiroadmin.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.glg.shiroadmin.entity.Menu;
import com.glg.shiroadmin.entity.Role;
import com.glg.shiroadmin.entity.User;
import com.glg.shiroadmin.mapper.MenuMapper;
import com.glg.shiroadmin.mapper.RoleMapper;
import com.glg.shiroadmin.mapper.UserMapper;
import com.glg.shiroadmin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //1.获取当前用户信息，
        Subject subject = SecurityUtils.getSubject();
        //获取用户信息
        User user = (User) subject.getPrincipal();
        //设置角色
        Set<String> roles = new HashSet<>();
        //根据用户查询角色
        List<Role> roleList =  roleMapper.findRoleByUser(user);
        System.out.println(user.getUsername()+"拥有的角色有"+roleList.toString());
        for (Role role : roleList){
            if (role != null){
                //添加用户角色
                simpleAuthorizationInfo.addRole(role.getRoleName());
                //根据用户角色查询权限
                List<Menu> menuList = menuMapper.findPermissionByRole(role);
                System.out.println(role.getRoleName()+"角色拥有的权限有"+menuList.toString());
                for(Menu menu : menuList){
                    if(menu!=null){
                        simpleAuthorizationInfo.addStringPermission(menu.getMenuName());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.先认证
        /**客户端传来的账号密码封装在token里，根据用户名进行查询，如果不存在return null，shiro自动抛出账户不存在的异常。
         * 不为空，返回SimpleAuthenticationInfo对象，对象里传入数据库查询的密码和token的得到的密码。自动验证，如果密码不对，市容也会抛出异常
         * 我们只需要捕获这两个异常
         */
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",token.getUsername());
        User user = userMapper.selectOne(wrapper);
        if(user != null){
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        return null;
    }
}
