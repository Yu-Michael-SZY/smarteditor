package com.faster.server.controller;

import com.faster.server.bean.User;
import com.faster.server.utils.SwaggerResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/smarteditor/user")
public class UserController {

    @GetMapping("getUserInfo")
    @ApiOperation(value = "用户信息", httpMethod = "GET", notes = "获取用户信息")
    public SwaggerResultUtil<User> getUserInfo(@RequestParam String token) {
        System.out.println("getUserInfo");
        return SwaggerResultUtil.resultSuccess(new User("admin", "aaaa", "admin123", "admin"));
    }

}
