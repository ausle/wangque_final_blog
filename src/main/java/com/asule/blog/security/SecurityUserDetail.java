//package com.asule.blog.security;
//
//import com.asule.blog.modules.domain.AccountProfile;
//import com.asule.blog.modules.repository.UserRepository;
//import com.asule.exception.LoginFailedException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Service("account")
//public class SecurityUserDetail implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    //从数据库用户表加载出指定用户，返回用户信息给security。那么登录时，security会拿着该信息和登录信息进行比对。
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.asule.blog.modules.domain.entity.User user = userRepository.findByUsername(username);
//        if (user==null){
//            throw new LoginFailedException("登录失败");
//        }
//        List<GrantedAuthority> authorities=new ArrayList<>();
//        return new AccountProfile(user,authorities);
//    }
//}
