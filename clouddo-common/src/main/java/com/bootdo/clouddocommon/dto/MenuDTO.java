package com.bootdo.clouddocommon.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuDTO implements Serializable{
    private static final long SerializableId = 0l;
    private Long menuId;
    // 父菜单ID，一级菜单为0
    private Long parentId;
    // 菜单名称
    private String name;
    // 菜单URL
    private String url;
    // 授权(多个用逗号分隔，如：user:list,user:create)
    private String perms;
    // 类型 0：目录 1：菜单 2：按钮
    private Integer type;


}
