package com.bootdo.clouddoadmin.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class ClientCardRelationDTO implements Serializable {

    private String relationId;
    private String clientId;
    private String cardId;
    private String ownClientId;
    private String type;
    private Date createTime;
    private Date updateTime;


}