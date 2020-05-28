package com.asule.blog.modules.repository;


import com.asule.blog.modules.domain.entity.PostResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;

/**
 */
public interface PostResourceRepository extends JpaRepository<PostResource, Long>, JpaSpecificationExecutor<PostResource> {

    int deleteByPostId(long postId);

    int deleteByPostIdAndResourceIdIn(long postId, Collection<Long> resourceId);

    List<PostResource> findByResourceId(long resourceId);

    List<PostResource> findByPostId(long postId);

}
