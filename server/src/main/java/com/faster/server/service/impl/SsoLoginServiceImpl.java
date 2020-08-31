package com.faster.server.service.impl;

import com.faster.server.bean.User;
import com.faster.server.service.SsoLoginService;
import org.springframework.stereotype.Service;

@Service
public class SsoLoginServiceImpl implements SsoLoginService {
    @Override
    public User login(String name, String password) {
        System.out.println("name is:" + name + "password is:" + password);
        return new User("admin", "aaa", "admin123", "admin");
    }
}
