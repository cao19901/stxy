package com.bootdo.clouddoadmin.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;


/**
 * 物联网卡 excel 基础信息
 * @author 曹晓维
 */
@Data
public class CardEecelInfo extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String iccid;

    @ExcelProperty(index = 1)
    private String imsi;

    @ExcelProperty(index = 2)
    private String cardCode;

}
