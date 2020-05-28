package com.asule.blog.config;

import com.asule.blog.modules.template.TemplateDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
public class SiteConfiguration {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private ApplicationContext applicationContext;

    //在创建SiteConfiguration-bean时，会执行此方法，此时spring正在加载bean到容器中。
    @PostConstruct
    public void setSharedVariable() {
        Map<String, TemplateDirective> map = applicationContext.getBeansOfType(TemplateDirective.class);
        //添加该自定义指令为共享变量，自定义指令在根root上可见。在模板上通过变量名来可以来使用。
        map.forEach((k, v) -> configuration.setSharedVariable(v.getName(), v));
//        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
//        configuration.setSharedVariable("shiro", new ShiroTags());
    }


}
