package com.asule.blog.config;


import com.asule.blog.modules.service.OptionsService;
import com.asule.blog.web.interceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private BaseInterceptor baseInterceptor;

    @Autowired
    private SiteOptions siteOptions;

    /**
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/dist/**", "/store/**", "/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String location = "file:///" + siteOptions.getLocation();
        registry.addResourceHandler("/dist/**")
                .addResourceLocations("classpath:/static/dist/");

//        registry.addResourceHandler("/dist/img/**")
//                .addResourceLocations("classpath:/static/dist/img/");

        registry.addResourceHandler("/static/dist/**")
                .addResourceLocations("classpath:/static/dist/");

//        registry.addResourceHandler("/dist/vendors/**")
//                .addResourceLocations("classpath:/static/dist/vendors/editormd/");

//        registry.addResourceHandler("/dist/vendors/editormd/plugins/**")
//                .addResourceLocations("classpath:/static/dist/vendors/editormd/plugins/");

        registry.addResourceHandler("/storage/avatars/**")
                .addResourceLocations(location + "/storage/avatars/");

        registry.addResourceHandler("/storage/thumbnails/**")
                .addResourceLocations(location + "/storage/thumbnails/");
    }


}
