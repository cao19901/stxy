package com.bootdo.clouddoadmin.controller;

import com.bootdo.clouddoadmin.domain.MenuDO;
import com.bootdo.clouddoadmin.domain.Tree;
import com.bootdo.clouddoadmin.service.MenuService;
import com.bootdo.clouddocommon.annotation.Log;
import com.bootdo.clouddocommon.context.FilterContextHandler;
import com.bootdo.clouddocommon.dto.MenuDTO;
import com.bootdo.clouddocommon.utils.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("/menu")
@RestController()
public class MenuController {
    @Autowired
    MenuService menuService;

    @Log("访问菜单")
    @GetMapping("tree")
    Tree<MenuDO>  tree(){
        return menuService.getTree();
    }
    @GetMapping
    List<Tree<MenuDO>>  list(){
        return menuService.getTree().getChildren();
    }

    @GetMapping("{id}")
    MenuDO get(@PathVariable("id") Long id) {
        MenuDO menu = menuService.get(id);
        return menu;
    }

    @GetMapping("list")
    List<MenuDO> list(@RequestParam Map<String, Object> params) {
        List<MenuDO> menus = menuService.list(params);
        return menus;
    }

    @PutMapping()
    ResultVO update(@RequestBody MenuDO menuDO){
        if(menuService.update(menuDO)>0){
            return ResultVO.ok();
        }
        return  ResultVO.error();
    }
    @PostMapping
    ResultVO save(@RequestBody MenuDO menuDO){
        return ResultVO.operate(menuService.save(menuDO)>0);
    }

    @DeleteMapping()
    ResultVO remove(Long id){
        if(menuService.remove(id)>0){
            return ResultVO.ok();
        }
        return ResultVO.error();
    }

    @GetMapping("userMenus")
    List<MenuDTO> userMenus(){
        List<MenuDO> menuDOS = menuService.userMenus(Long.parseLong(FilterContextHandler.getUserID()));
        List<MenuDTO> menuDTOS = new ArrayList<>();
        for (MenuDO menuDO:menuDOS){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenuId(menuDO.getMenuId());
            menuDTO.setUrl(menuDO.getUrl());
            menuDTO.setPerms(menuDO.getPerms());
            menuDTOS.add(menuDTO);
        }
        return menuDTOS;
    }

    @GetMapping("clearCache")
    ResultVO clearCache(){
        Boolean flag = menuService.clearCache(Long.parseLong(FilterContextHandler.getUserID()));
        if (flag){
            return  ResultVO.ok();
        }
        return ResultVO.error();
    }


    @RequestMapping("/currentUserMenus")
    List<Tree<MenuDO>> currentUserMenus() {
        List<Tree<MenuDO>> menus = menuService.listMenuTree(Long.parseLong(FilterContextHandler.getUserID()));
        return menus;
    }

    @GetMapping("/roleId")
    List<Long> menuIdsByRoleId(Long roleId){
        return menuService.MenuIdsByRoleId(roleId);
    }
}
