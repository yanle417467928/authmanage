/*
package com.yanle.config;

import com.yanle.entity.ShiroDBRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

*/
/**
 * shiro配置类
 *
 * @author yanle
 * @create 2017-02-22 15:13
 **//*

@Configuration
public class ShiroConfig {

    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

    */
/**
     * FilterRegistrationBean
     * @return
     *//*

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("*/
/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

    */
/**
     * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
     * @return
     *//*

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauth");
        filterChainDefinitionMap.put("/captcha.jpg","anon");
        filterChainDefinitionMap.put("/commons*/
/**", "anon");
        filterChainDefinitionMap.put("/bootstrap*/
/**", "anon");
        filterChainDefinitionMap.put("/dist*/
/**", "anon");
        filterChainDefinitionMap.put("/font-awesome*/
/**", "anon");
        filterChainDefinitionMap.put("/img*/
/**", "anon");
        filterChainDefinitionMap.put("/ionicons*/
/**", "anon");
        filterChainDefinitionMap.put("/plugins*/
/**", "anon");
        filterChainDefinitionMap.put("/static*/
/**", "anon");
        filterChainDefinitionMap.put("/webhooks","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("*/
/**","user");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factoryBean;
    }

    */
/**
     * @see org.apache.shiro.mgt.SecurityManager
     * @return
     *//*

    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroDBRealm());
        manager.setCacheManager(cacheManager());
        manager.setSessionManager(defaultWebSessionManager());
        return manager;
    }

    */
/**
     * @see DefaultWebSessionManager
     * @return
     *//*

    @Bean(name="sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager());
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    */
/**
     * @see ShiroDBRealm--->AuthorizingRealm
     * @return
     *//*

    @Bean
    @DependsOn(value="lifecycleBeanPostProcessor")
    public ShiroDBRealm shiroDBRealm() {
        ShiroDBRealm shiroDBRealm = new ShiroDBRealm(cacheManager(),getHashedCredentialsMatcher());
        return shiroDBRealm;
    }

    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
*/
