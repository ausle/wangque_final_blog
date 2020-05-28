package com.asule.blog.modules.repository;


import com.asule.blog.modules.domain.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * created by asule on 2020-04-25 18:22
 */
public interface ResourceRepository extends JpaRepository<Resource,Long> {

    Resource findByMd5(String md5);

    List<Resource> findByMd5In(List<String> md5s);

    @Modifying
    @Transactional
    @Query("update Resource set amount = amount + :increment where md5 in (:md5s)")
    int updateAmount(@Param("md5s") Collection<String> md5s, @Param("increment") long increment);

}
