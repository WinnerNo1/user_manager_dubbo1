package com.qf.service;

import com.qf.entity.Email;
import com.qf.entity.User;

public interface IEmailService {
    int getcode(Email email);
    void find(User user);
}
