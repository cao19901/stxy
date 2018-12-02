package com.bootdo.clouddoadmin.service;

import com.bootdo.clouddoadmin.domain.ImportCardInfoDO;
import com.bootdo.clouddoadmin.dto.IotcardDTO;

import java.util.List;
import java.util.Map;


public interface CardService {

    /**
     * 查询列表
     * @return
     */
    List<Map<String ,Object>> list( Map<String , Object> params);


    /**
     *
     * @param collect  excel 中读取的卡信息 和 拼接好的其他信息参数
     * @param importCardInfoDO 前台传递的参数列表
     */
    void saveCards(List<IotcardDTO> collect , ImportCardInfoDO importCardInfoDO );


}
