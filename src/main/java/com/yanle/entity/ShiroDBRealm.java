package com.yanle.entity;

import com.yanle.service.IRoleService;
import com.yanle.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * shiro作用域
 *
 * @author yanle
 * @create 2017-02-13 17:07
 **/
@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm{

    private static final Logger LOGGER = LogManager.getLogger(ShiroDBRealm.class);

    public ShiroDBRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(shiroUser.getUrlSet());
        info.setRoles(shiroUser.getRoles());
        return info;
    }

    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserVo userVo = new UserVo();
        userVo.setLoginName(token.getUsername());
        List<User> list = userService.selectByLoginName(userVo);
        //账号不存在
        if(null == list || list.isEmpty() ){
            return null;
        }
        User user = list.get(0);
        //账号未启用
        if (user.getStatus()==1){
            return null;
        }
        //读取用户的url和角色
        Map<String,Set<String>> resourceMap = roleService.selectResourceMapByUserId(user.getId());
        Set<String> urls = resourceMap.get("urls");
        Set<String> roles = resourceMap.get("roles");
        ShiroUser shiroUser = new ShiroUser(user.getId(),user.getLoginName(),user.getName(),urls);
        shiroUser.setRoles(roles);
        //认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser,user.getPassword().toCharArray(),getName());
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
        principalCollection.add(shiroUser,super.getName());
        super.clearCachedAuthorizationInfo(principalCollection);
        super.clearCachedAuthenticationInfo(principalCollection);
    }

    public void removeUserCache(String loginName){
        SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
        principalCollection.add(new ShiroUser(loginName),super.getName());
        super.clearCachedAuthorizationInfo(principalCollection);
        super.clearCachedAuthenticationInfo(principalCollection);
    }
}
