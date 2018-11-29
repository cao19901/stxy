package com.bootdo.clouddoadmin.dto;

import lombok.Data;

/**
 * 用户角色
 * @author cxw
 */
@Data
public class UserRoleDTO {
    private Long id;
    private String name;
    private boolean checked;

}
