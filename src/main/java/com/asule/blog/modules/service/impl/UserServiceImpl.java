package com.asule.blog.modules.service.impl;

import com.asule.blog.base.lang.Consts;
import com.asule.blog.base.utils.BeanMapUtils;
import com.asule.blog.modules.domain.AccountProfile;
import com.asule.blog.modules.domain.entity.User;
import com.asule.blog.modules.domain.vo.UserVO;
import com.asule.blog.modules.repository.UserRepository;
import com.asule.blog.modules.service.UserService;
import com.asule.utils.MD5;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserVO register(UserVO user) {
        Assert.notNull(user, "用户参数为空!");
        Assert.hasLength(user.getUsername(), "用户名不能为空!");
        Assert.hasLength(user.getPassword(), "密码不能为空!");

        User check = userRepository.findByUsername(user.getUsername());
        Assert.isNull(check, "用户名已经存在!");
        User po = new User();
        BeanUtils.copyProperties(user, po);
        if (StringUtils.isBlank(po.getName())) {        // username和name一致
            po.setName(user.getUsername());
        }
        Date now = Calendar.getInstance().getTime();
        po.setStatus(Consts.EntityStatus.ENABLED);

        po.setPassword(MD5.md5(user.getPassword()));
        po.setCreated(now);
        userRepository.save(po);
        return BeanMapUtils.copy(po);
    }

    @Override
    public AccountProfile login(String username, String password) {
        User po = userRepository.findByUsername(username);
        if (null == po) {
            return null;
        }
        Assert.state(StringUtils.equals(po.getPassword(), password), "密码错误");
        po.setLastLogin(Calendar.getInstance().getTime());
        userRepository.save(po);        //更新下登录时间

        AccountProfile u = BeanMapUtils.copyPassport(po);
//        BadgesCount badgesCount = new BadgesCount();
//        badgesCount.setMessages(messageService.unread4Me(u.getId()));
//        u.setBadgesCount(badgesCount);
        return u;
    }

    @Override
    public Map<Long, UserVO> findMapByIds(List<Long> uids) {
        if (uids == null || uids.isEmpty()) {
            return Collections.emptyMap();
        }
        List<User> userList = userRepository.findByIdIn(uids);

        Map<Long, UserVO> rets=new HashMap<>();

        userList.forEach(user -> rets.put(user.getId(),BeanMapUtils.copy(user)));

        return rets;
    }
}
