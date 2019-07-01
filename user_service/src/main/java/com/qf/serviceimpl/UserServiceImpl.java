package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.UserMapper;
import com.qf.entity.User;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @userzhangliang
 * @date2019/6/29 14:09
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {

        return userMapper.insert(user);
    }

    @Override
    public User getUser(String username, String password) {

        return userMapper.getUser(username,password);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }
}
