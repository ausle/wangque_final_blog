package com.asule.blog.config;

import com.asule.blog.shiro.AccountRealm;
import com.asule.blog.shiro.AuthenticatedFilter;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.util.Password;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.shiro.authc.credential.DefaultPasswordService.DEFAULT_HASH_ALGORITHM;

@Configuration
public class ShiroConfiguration {

    @Bean
    public SubjectFactory subjectFactory() {
        DefaultWebSubjectFactory subjectFactory = new DefaultWebSubjectFactory();
        return subjectFactory;
    }


    @Bean
    public SecurityManager securityManager(RememberMeManager rememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm());
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }


    @Bean
    public Realm accountRealm() {
        AccountRealm accountRealm = new AccountRealm();
        return accountRealm;
    }


    /*
       shrio对容器的过滤器链进行了代理，在继续servlet的filterchain执行之前，
       会通过ProxiedFilterChain对servlet的filter-chain进行代理。

       先执行shiro自己的过滤器链，再执行servlet容器的过滤器链。
     */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/do/login");
        shiroFilter.setUnauthorizedUrl("/");
        shiroFilter.setSuccessUrl("/");
        shiroFilter.setUnauthorizedUrl("/denied/error");

        HashMap<String, Filter> filters = new HashMap<>();
        filters.put("authc", new FormAuthenticationFilter());
        shiroFilter.setFilters(filters);
        Map<String, String> hashMap = new LinkedHashMap<>();

        hashMap.put("/static/**", "anon");  //静态资源可以访问
        hashMap.put("/login", "anon");
        hashMap.put("/do/login", "anon");
        hashMap.put("/register", "anon");
        hashMap.put("/", "anon");
        hashMap.put("/index", "anon");

        hashMap.put("/admin", "authc");
        hashMap.put("/admin/**", "authc");
//        hashMap.put("/**","authc");
        shiroFilter.setFilterChainDefinitionMap(hashMap);
        return shiroFilter;
    }

//    @Bean
//    public SessionManager sessionManager(Cookie cookie){
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionIdCookie(cookie);
//        return sessionManager;
//    }

    @Bean
    public RememberMeManager rememberMeManager(Cookie cookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(cookie);
        return rememberMeManager;
    }

    @Bean
    public Cookie cookie(){
        SimpleCookie cookie = new SimpleCookie();
        cookie.setHttpOnly(true);
        //7*24*3600
        cookie.setMaxAge(86400);
        cookie.setName("asule-blog");
        return cookie;
    }
}
