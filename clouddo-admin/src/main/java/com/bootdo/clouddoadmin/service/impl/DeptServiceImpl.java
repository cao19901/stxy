package com.bootdo.clouddoadmin.service.impl;

import com.bootdo.clouddoadmin.domain.Tree;
import com.bootdo.clouddoadmin.utils.BuildTree;
import com.bootdo.clouddoadmin.dao.DeptDao;
import com.bootdo.clouddoadmin.domain.DeptDO;
import com.bootdo.clouddoadmin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao sysDeptMapper;

	@Override
	public DeptDO get(Long deptId){
		return sysDeptMapper.get(deptId);
	}

	@Override
	public List<DeptDO> list(Map<String, Object> map){
		return sysDeptMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return sysDeptMapper.count(map);
	}

	@Override
	public int save(DeptDO sysDept){
		return sysDeptMapper.save(sysDept);
	}

	@Override
	public int update(DeptDO sysDept){
		return sysDeptMapper.update(sysDept);
	}

	@Override
	public int remove(Long deptId){
		return sysDeptMapper.remove(deptId);
	}

	@Override
	public int batchRemove(Long[] deptIds){
		return sysDeptMapper.batchRemove(deptIds);
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> sysDepts = sysDeptMapper.list(new HashMap<String,Object>(16));
		for (DeptDO sysDept : sysDepts) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}

		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkDeptHasUser(Long deptId) {


		int result = sysDeptMapper.getDeptUserNumber(deptId);
		return result==0?true:false;
	}

}
