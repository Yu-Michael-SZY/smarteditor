package com.faster.server.controller;

import com.faster.server.bean.User;
import com.faster.server.model.sso.LoginVO;
import com.faster.server.service.SsoLoginService;
import com.faster.server.utils.SwaggerResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统登录接口")
@RestController
@RequestMapping("/smarteditor/sso")
public class SsoLoginController {

    @Autowired
    private SsoLoginService ssoLoginService;

    @PostMapping("/login")
    @ApiOperation(value = "系统登录接口", httpMethod = "POST", notes = "系统登录接口")
    public SwaggerResultUtil<User> login(@RequestBody LoginVO loginVO) {
        return SwaggerResultUtil.resultSuccess(ssoLoginService.login(loginVO.getUserName(), loginVO.getPassword()));
    }
}
