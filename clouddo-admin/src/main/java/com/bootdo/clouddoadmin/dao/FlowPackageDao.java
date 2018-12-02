package com.bootdo.clouddoadmin.dao;

import com.bootdo.clouddoadmin.dto.FlowPackageDTO;
import java.util.List;

/**
 * 流量产品
 * @author 曹晓维
 */
public interface FlowPackageDao {

    /**
     * 查询流量产品列表
     * @return
     */
    List<FlowPackageDTO> list();


}