/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.asule.blog.modules.service;

import com.asule.blog.base.lang.Consts;
import com.asule.blog.modules.domain.AccountProfile;
import com.asule.blog.modules.domain.vo.UserVO;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;
import java.util.Map;

public interface UserService {

	UserVO register(UserVO user);

	AccountProfile login(String username, String password);

    Map<Long,UserVO> findMapByIds(List<Long> uids);

}
