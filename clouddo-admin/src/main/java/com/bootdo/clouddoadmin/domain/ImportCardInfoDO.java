package com.bootdo.clouddoadmin.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 曹晓维
 */
@Data
public class ImportCardInfoDO implements Serializable {

    @NotNull
    private String excelPath;
    @NotNull
    private String supplierId;
    @NotNull
    private String packageId;

    /**'0 消费卡 1 机械卡'*/
    @NotNull
    private String cardType;
    private String clientId ;


}
