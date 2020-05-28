package com.asule.blog.modules.service.impl;


import com.asule.blog.base.lang.Consts;
import com.asule.blog.modules.domain.entity.Channel;
import com.asule.blog.modules.repository.ChannelRepository;
import com.asule.blog.modules.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * created by asule on 2020-04-25 18:19
 */
@Service
public class ChannelServiceImpl implements ChannelService {


    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> findAll(int status) {
        Sort sort = Sort.by(Sort.Direction.DESC, "weight", "id");
        List<Channel> list;
        if (status > Consts.IGNORE) {
            list = channelRepository.findAllByStatus(status, sort);
        } else {
            list = channelRepository.findAll(sort);
        }
        return list;
    }

    @Override
    public Map<Integer, Channel> findMapByIds(Collection<Integer> ids) {
        return null;
    }

    @Override
    public Channel getById(int id) {
        return null;
    }

    @Override
    public void update(Channel channel) {

    }

    @Override
    public void updateWeight(int id, int weighted) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public long count() {
        return 0;
    }
}
