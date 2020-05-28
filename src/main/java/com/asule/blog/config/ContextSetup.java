package com.asule.blog.config;


import com.asule.blog.base.lang.Consts;
import com.asule.blog.modules.domain.entity.Options;
import com.asule.blog.modules.service.ChannelService;
import com.asule.blog.modules.service.OptionsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by asule on 2020-04-25 16:14
 */
@Slf4j
@Configuration
public class ContextSetup implements ApplicationRunner, ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    private OptionsService optionsService;


    @Autowired
    private ChannelService channelService;

    @Autowired
    private SiteOptions siteOptions;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("initialization ...");
        reloadOptions(true);
        resetChannels();
        log.info("OK, completed");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }

    public void reloadOptions(boolean startup) {
        List<Options> options = optionsService.findAll();

        log.info("find options ({})...", options==null?"null":options.size());
        if (startup && CollectionUtils.isEmpty(options)) {
            try {
                log.info("init options...");
                Resource resource = new ClassPathResource("/scripts/schema.sql");
                optionsService.initSettings(resource);
                options = optionsService.findAll();
            } catch (Exception e) {
                log.error("------------------------------------------------------------");
                log.error("-          ERROR: The database is not initialized          -");
                log.error("------------------------------------------------------------");
                log.error(e.getMessage(), e);
                System.exit(1);
            }
        }

        Map<String, String> map = new HashMap<>();

        options.forEach(opt -> {
            if (StringUtils.isNoneBlank(opt.getKey(), opt.getValue())) {
                map.put(opt.getKey(), opt.getValue());
            }
        });

        servletContext.setAttribute("options", map);

        servletContext.setAttribute("site", siteOptions);
        System.setProperty("site.location", siteOptions.getLocation());
    }

    private void resetChannels() {
        servletContext.setAttribute("channels", channelService.findAll(Consts.STATUS_NORMAL));
    }

}
