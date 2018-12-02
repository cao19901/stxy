package com.bootdo.clouddoadmin.service;

import com.bootdo.clouddoadmin.domain.MenuDO;
import com.bootdo.clouddoadmin.domain.Tree;
import com.bootdo.clouddocommon.dto.RouterDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(Long id);


	List<MenuDO> userMenus(Long userId);

	List<Tree<MenuDO>> listMenuTree(Long id);

	Tree<MenuDO> getTree();

	Tree<MenuDO> getTree(Long id);

	@CacheEvict(value = "permission",key = "#userId")
	boolean clearCache(Long userId);

	List<MenuDO> list(Map<String, Object> params);

	int remove(Long id);

	int save(MenuDO menu);

	int update(MenuDO menu);

	MenuDO get(Long id);

	Set<String> listPerms(Long userId);


	List<Long> MenuIdsByRoleId(Long roleId);


	List<RouterDTO> RouterDTOsByUserId(Long userId);

	List<String> PermsByUserId(Long userId);
}
