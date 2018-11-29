package com.bootdo.clouddoadmin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * @author cxw
 * @email 337619617@qq.com
 * @date 2017-10-03 15:35:39
 */
@Mapper
public interface CardDao {
	List<Map<String , Object>> list();
}
