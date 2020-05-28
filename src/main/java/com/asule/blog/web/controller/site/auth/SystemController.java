package com.asule.blog.web.controller.site.auth;
import com.asule.blog.web.controller.BaseController;
import com.asule.blog.web.controller.site.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SystemController extends BaseController {

    @GetMapping(value = "/login/error")
    public String loginError(HttpServletRequest request, HttpServletResponse response) {


        return view(Views.LOGIN);
    }

    @GetMapping(value = "/denied/error")
    public String deniedError() {
        return view(Views.ERROR_PAGE);
    }
}
