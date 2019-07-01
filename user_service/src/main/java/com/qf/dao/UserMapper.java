package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @userzhangliang
 * @date2019/6/29 14:10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    User getUser(String username,String password);
    User getUserByName(String username);
}
