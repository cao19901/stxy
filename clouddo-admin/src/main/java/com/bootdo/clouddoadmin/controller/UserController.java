package com.bootdo.clouddoadmin.controller;

import com.bootdo.clouddoadmin.domain.UserDO;
import com.bootdo.clouddoadmin.dto.UserDTO;
import com.bootdo.clouddoadmin.dto.do2dto.UserConvert;
import com.bootdo.clouddoadmin.service.RoleService;
import com.bootdo.clouddoadmin.service.UserService;
import com.bootdo.clouddoadmin.utils.MD5Utils;
import com.bootdo.clouddocommon.annotation.Log;
import com.bootdo.clouddocommon.context.FilterContextHandler;
import com.bootdo.clouddocommon.dto.LoginUserDTO;
import com.bootdo.clouddocommon.utils.PageUtils;
import com.bootdo.clouddocommon.utils.Query;
import com.bootdo.clouddocommon.utils.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/user")
@RestController
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @GetMapping("/currentUser")
	LoginUserDTO currentUser(){
		LoginUserDTO loginUserDTO = new LoginUserDTO();
		loginUserDTO.setUserId(FilterContextHandler.getUserID());
		loginUserDTO.setUsername(FilterContextHandler.getUsername());
		loginUserDTO.setName(FilterContextHandler.getName());
		return loginUserDTO;
	}


    @GetMapping("{id}")
    ResultVO get(@PathVariable("id") Long id ){
		UserDTO userDTO = UserConvert.MAPPER.do2dto(userService.get(id));
    	return ResultVO.ok().put("data",userDTO);
	}


	@Log("获取用户列表")
    @GetMapping()
    ResultVO listByPage(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<UserDTO> userDTOS = UserConvert.MAPPER.dos2dtos((userService.list(query)));
        int total = userService.count(query);
        PageUtils pageUtil = new PageUtils(userDTOS, total);
        return ResultVO.ok().put("page",pageUtil);
    }


	@PostMapping()
    ResultVO save(@RequestBody UserDO user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		return ResultVO.operate(userService.save(user) > 0);
	}


	@PutMapping()
    ResultVO update(@RequestBody UserDO user) {
		return ResultVO.operate(userService.update(user) > 0);
	}



	@DeleteMapping()
    ResultVO remove(Long id) {
		return ResultVO.operate (userService.remove(id) > 0);
	}

	@PostMapping("/batchRemove")
	@ResponseBody
    ResultVO batchRemove(@RequestParam("ids[]") Long[] userIds) {
		int r = userService.batchremove(userIds);
		if (r > 0) {
			return ResultVO.ok();
		}
		return ResultVO.error();
	}

	@PostMapping("/exits")
	@ResponseBody
	boolean exits(@RequestParam Map<String, Object> params) {

		return !userService.exits(params);
	}
}
