package com.asule.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test")
@Controller
public class TestController {


    @GetMapping("/go/ftl")
    public ModelAndView testSkipPage(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("test");
        modelAndView.addObject("welcome","asule");

        return modelAndView;
    }




}
