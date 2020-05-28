package com.asule.blog.modules.repository;


import com.asule.blog.modules.domain.entity.Channel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by asule on 2020-04-25 18:22
 */
public interface ChannelRepository extends JpaRepository<Channel,Integer> {

    List<Channel> findAllByStatus(int status, Sort sort);
}
