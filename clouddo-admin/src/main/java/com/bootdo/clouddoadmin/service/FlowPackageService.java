package com.bootdo.clouddoadmin.service;

import com.bootdo.clouddoadmin.dto.FlowPackageDTO;
import java.util.List;


/**
 * @author 曹晓维
 */
public interface FlowPackageService {

    /**
     *查询流量包列表
     * @return
     */
    List<FlowPackageDTO> list();


    /**
     * 新增流量包
     * @param flowPackageDTO
     */
    int save(FlowPackageDTO flowPackageDTO);


}
