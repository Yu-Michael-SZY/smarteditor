package com.faster.server.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "user", description = "用户信息")
public class User {
    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "描述")
    private String userDesc;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "role")
    private String role;

}
