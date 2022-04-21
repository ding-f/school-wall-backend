package com.schoolwall.config;

import com.schoolwall.shiro.AccountRealm;
import com.schoolwall.shiro.JwtFilter;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.Filter;
import java.util.Map;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/4/10 17:11
 */

@Configuration
public class ShiroConfig {

    @Autowired
    JwtFilter jwtFilter;        //自定义


    @Bean       //redisSessionDAO:shrio-redis实现redis进行CRUD 处理 Session的方式
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        //sessionManager: Shiro 做了一个自己的 sessionManager 来管理Session
        // inject redisSessionDAO
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }


    /**
     * Shiro核心（SecurityManager）
     * @param accountRealm      自己定义的Realm类(项目内包含的类)
     * @param sessionManager
     * @param redisCacheManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(AccountRealm accountRealm,
                                                     SessionManager sessionManager,
                                                     RedisCacheManager redisCacheManager) {

        //SecurityManager是一定要有的，但是Shiro中读取shiro返回的是 DefaultSecurityManager，因为是Web应用我们需要的是 DefaultWebSecurityManager，所以把 DefaultSecurityManager的Realms 提出来给 DefaultWebSecurityManager
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(accountRealm);

        //inject sessionManager
        securityManager.setSessionManager(sessionManager);

        // inject redisCacheManager
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }

    //定义哪些链接需要经过哪些过滤器（可定义多个不同的过滤器对链接进行一个分类过滤处理）
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {

        //过滤器链接定义器赋值链接（Spring Boot 配置过滤链接方式省去了Shiro官方写配置文件方式）
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/**", "jwt");        // 自定义了一个JWT专属的过滤器,拦截所有请求
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }


    //将shiroFilterChainDefinition()里某个过滤器设置SecurityManager、ShiroFilterChainDefinition过滤的链接、设置自定义的过滤器
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager, ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        //给链接工厂Bean设置安全管理者
        shiroFilter.setSecurityManager(securityManager);

        /**
         * 设置自定义的JWT过滤器
         * **关键步骤**
         * 如果没有会使用Shiro默认的Session方式进行处理
         */
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", jwtFilter);
        shiroFilter.setFilters(filters);

        Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();

        //2.将链接定义器的链接赋值给链接工厂Bean
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

}
