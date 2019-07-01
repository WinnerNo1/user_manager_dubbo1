package com.qf.service;

import com.qf.entity.User;

public interface IUserService {
    int register(User user);
    User getUser(String username,String password);
    User getUserByName(String username);

}
