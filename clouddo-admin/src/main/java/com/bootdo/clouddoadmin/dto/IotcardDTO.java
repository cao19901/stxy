package com.bootdo.clouddoadmin.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class IotcardDTO implements Serializable {

    private String cardId;
    private String cardCode;
    private String iccid;
    private String clienIccid;
    private String imsi;
    private String supplierId;
    private String flowPoolId;
    private String saleState;
    private String packageId;
    private String cardType;
    private Date createTime;
    private Date updateTime;


}