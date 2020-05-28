//package com.asule.blog.security;
//
//import com.asule.blog.security.handler.LoginSuccessHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import java.io.IOException;
//
////@Configuration
////@EnableWebSecurity
//public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    @Qualifier(value = "account")
//    private UserDetailsService service;
//
////    @Autowired
////    private MyPasswordEncoder passwordEncoder;
//
//    //带有盐值得密码加密，对密码的每次encode的结果不一致。但却可以验证密码。
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()   //在内存中完成账号密码的认证，下面指定了两个认证账号
////                .withUser("asule")
////                .password("qwerty")
////                .roles("manager")
////                .and()
////                .withUser("wcx")
////                .password("qwerty")
////                .authorities("create");
//        auth.userDetailsService(service)
//             .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity security) throws Exception {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//
//        tokenRepository.setCreateTableOnStartup(true);
//
//        security
//                .authorizeRequests()			// 对请求进行授权
//                .antMatchers("/index")
//                .permitAll()
//                .antMatchers("/static/**")
//                .permitAll()
//                .antMatchers("/dist/**")
//                .permitAll()
//                .antMatchers("/do/login")       //去登录的页面也需要授权可以访问
//                .permitAll()
//                .antMatchers("/register")
//                .permitAll()
//                .antMatchers("/login/error")          //发生错误跳转的页面不需要登录
//                .permitAll()
//                .antMatchers("/denied/error")          //发生错误跳转的页面不需要登录
//                .permitAll()
//
//                //特定角色和权限可以访问
////                .antMatchers("/level1/**")
////                .hasRole("level1")
////                .antMatchers("/level2/**")
////                .hasAuthority("create")
//
//
//                //任何请求都需要认证。以表单的形式
//                .and()
//                .authorizeRequests()			// 对请求进行授权
//                .anyRequest()					// 任意请求
//                .authenticated()				// 需要登录以后才可以访问
//                .and()
//                .formLogin()					// 使用表单形式登录
//                // 指定登录页的同时会影响到：“提交登录表单的地址”、“退出登录地址”、“登录失败地址”。这些地址都要是该登录页
//                .loginPage("/do/login")		// 指定登录页面（如果没有指定会访问SpringSecurity自带的登录页）
//                //指定了登录地址，就会覆盖loginPage()方法中设置的默认值
//                .loginProcessingUrl("/login")	// 指定提交登录表单的地址，它提交表单的数据会交由security去进行验证
////                .permitAll()                            //指定提交登录表单的地址，允许通过，不进行验证。如果一个提交登录信息也要验证，那怎么登录。
////                .defaultSuccessUrl("/index")
//                .successHandler(new LoginSuccessHandler())
//                .failureUrl("/login/error")        //登录form验证异常，重定向的页面。
//
//                //自定义登录表单的账号-密码，若不处理，要写成与security要求的账号-密码。
//                .usernameParameter("username")
//                .passwordParameter("password")
//
//
//
//                //处理退出
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/index")
//
//                //定制403页面
//                .and()
//                .exceptionHandling()
////                .accessDeniedPage("/to/no/auth/page.html")            //单纯的指定一个页面替换默认的403
//                .accessDeniedHandler(new AccessDeniedHandler() {        //可以添加denied内容
//                    @Override
//                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//                        httpServletRequest.setAttribute("SPRING_SECURITY_LAST_EXCEPTION","403页面，因没权限访问被阻止");
//                        httpServletRequest.getRequestDispatcher("/denied/error").forward(httpServletRequest,httpServletResponse);
//                    }
//                })
//
//                //记住我，写到数据库
//                .and()
//                .rememberMe()
//                .rememberMeParameter("rememberMe")
//                .tokenRepository(tokenRepository);//传入tokenRepository
//
//        //关闭跨域请求伪装，不关闭的话，无法支持post请求
//        security.csrf().disable();
////        security.anonymous().disable();
//
//        /*
//        会导致使用iframe模式上传图片或者iframe嵌套页面时，会报如下异常信息：
//        Refused to display in a frame because it set 'X-Frame-Options' to 'DENY'
//
//        security为我们设置为deny，不光跨域无法访问，同域名下页无法加载的到。
//        这里需禁止掉。
//         */
//        security.headers().frameOptions().disable();
//    }
//}
