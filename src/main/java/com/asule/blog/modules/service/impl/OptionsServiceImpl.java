package com.asule.blog.modules.service.impl;


import com.asule.blog.modules.domain.entity.Options;
import com.asule.blog.modules.repository.OptionsRepository;
import com.asule.blog.modules.service.OptionsService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * created by asule on 2020-04-25 16:55
 */
@Service
public class OptionsServiceImpl implements OptionsService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OptionsRepository optionsRepository;

    @Override
    public List<Options> findAll() {
        return optionsRepository.findAll();
    }

    @Override
    public void update(Map<String, String> options) {

    }

    @Transactional
    @Override
    public void initSettings(final Resource resource) {
        /*
            获取本地hibernate的session。
            使用Spring提供的脚本工具执行sql脚本。
            里面的大概逻辑是：读取该sql文件内容，把sql文件的每条sql单独添加List<String>，
            遍历集合，通过connection创建statement执行每一条sql。
         */
        Session session=entityManager.unwrap(Session.class);
        session.doWork((connection -> {
            ScriptUtils.executeSqlScript(connection,resource);
        }));
    }
}
