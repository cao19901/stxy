package com.bootdo.clouddoadmin.vo;

import com.bootdo.clouddoadmin.domain.UserDO;
import lombok.Data;


/**
 * @author 曹晓维
 */
@Data
public class UserVO {

    private UserDO userDO = new UserDO();

    private String pwdOld;

    private String pwdNew;

}
