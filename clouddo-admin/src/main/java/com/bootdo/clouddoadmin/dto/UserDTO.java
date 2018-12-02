package com.bootdo.clouddoadmin.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {

    private Long userId;

    private String username;

    private String name;


    private Long deptId;

    private String deptName;

    private String email;

    private String mobile;

    private Integer status;

    private Long userIdCreate;

    private Date gmtCreate;

    private Date gmtModified;

    private List<Long> roleIds;

    private Long sex;

    private Date birth;

    private Long picId;

    private String liveAddress;

    private String hobby;

    private String province;

    private String city;

    private String district;




}
