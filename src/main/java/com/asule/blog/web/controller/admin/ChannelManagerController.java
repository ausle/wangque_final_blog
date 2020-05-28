package com.asule.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/channel")
public class ChannelManagerController {

    @RequestMapping("/")
    public String list(String title, ModelMap model, HttpServletRequest request) {
        return "/admin/channel";
    }

}
