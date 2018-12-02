package com.bootdo.clouddoadmin.dao;

import com.bootdo.clouddoadmin.dto.ClientCardRelationDTO;

import java.util.List;

public interface ClientCardRelationDao {
    /**
     * 批量插入关系表
     * @param list
     * @return
     */
    int  insertList(List<ClientCardRelationDTO> list);



}