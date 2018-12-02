package com.bootdo.clouddocms.service;

import com.bootdo.clouddocms.domain.FileDO;

import java.util.List;
import java.util.Map;


public interface FileService {
	
	FileDO get(Long id);
	
	List<FileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FileDO file);
	
	int update(FileDO file);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
