package com.bootdo.clouddocommon.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuDTO implements Serializable{
    private Long menuId;

    private Long parentId;

    private String name;

    private String url;

    private String perms;

    private Integer type;


}
