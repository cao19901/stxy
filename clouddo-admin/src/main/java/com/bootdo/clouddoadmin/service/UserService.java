package com.bootdo.clouddoadmin.service;

import com.bootdo.clouddoadmin.domain.Tree;
import com.bootdo.clouddoadmin.domain.DeptDO;
import com.bootdo.clouddoadmin.domain.UserDO;
import com.bootdo.clouddoadmin.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
	UserDO get(Long id);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);

	int update(UserDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exits(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserVO userVO, UserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();


	int updatePersonal(UserDO userDO);


    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
