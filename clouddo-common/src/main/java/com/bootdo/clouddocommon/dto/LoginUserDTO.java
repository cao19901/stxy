package com.bootdo.clouddocommon.dto;

import lombok.Data;

@Data
public class LoginUserDTO {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;

}
