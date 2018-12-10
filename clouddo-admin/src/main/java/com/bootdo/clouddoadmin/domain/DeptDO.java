package com.bootdo.clouddoadmin.domain;

import java.io.Serializable;



public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Long deptId;

	private Long parentId;

	private String name;

	private Integer orderNum;

	private Integer delFlag;


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return "DeptDO{" +
				"deptId=" + deptId +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", orderNum=" + orderNum +
				", delFlag=" + delFlag +
				'}';
	}
}
