package com.faster.server.model.sso;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "loginVO", description = "登录模型")
public class LoginVO {
    @ApiModelProperty(value = "用户名", name = "userName", example = "admin")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;
}
