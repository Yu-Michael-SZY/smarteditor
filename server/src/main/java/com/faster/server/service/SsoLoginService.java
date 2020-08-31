package com.faster.server.service;

import com.faster.server.bean.User;

public interface SsoLoginService {

    User login(String name, String password);
}
