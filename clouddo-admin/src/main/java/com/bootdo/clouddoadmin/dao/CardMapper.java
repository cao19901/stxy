package com.bootdo.clouddoadmin.dao;

import com.bootdo.clouddoadmin.dto.IotcardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CardMapper {
	List<Map<String , Object>> list();

	/**
	 * 批量插入卡信息
	 * @param list
	 * @return
	 */
	int  insertList(List<IotcardDTO> list);


}
