//package com.asule.blog.security.handler;
//
//import com.asule.blog.base.lang.Consts;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.Session;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@Slf4j
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,
//                                        HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//
//        log.info("authentication：{}",authentication);
//
//        HttpSession session = request.getSession(true);
//        session.setAttribute(Consts.PROFILE,authentication);
//
//        response.sendRedirect("/index");
//    }
//}
