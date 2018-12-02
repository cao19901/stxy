package com.bootdo.clouddoadmin.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 曹晓维
 */
@Data
public class   FlowPackageDTO implements Serializable {

    private String packageId;
    private String packageName;
    private String type;
    private String flowSize;
    private String carrierOperator;
    private String operatorName;
    private String typeName;
    private BigDecimal sellPrice;
    private BigDecimal accessPrice;
    private String packageStatus;
    private String supplierId;
    private Integer discount;


}