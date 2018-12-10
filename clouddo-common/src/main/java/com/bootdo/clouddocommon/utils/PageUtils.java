package com.bootdo.clouddocommon.utils;

import com.bootdo.clouddocommon.constants.CommonConstants;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;
	private List<?> rows;

	public PageUtils(List<?> list, int total) {
		this.rows = list;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	/**
	 *
	 * @param params 请求参数
	 * @return 页码起始位置
	 */
	public static int getOffset (Map<String, Object> params) {
		if (null == params || params.isEmpty() || !params.containsKey(CommonConstants.OFFSET)){
			return 1 ;
		}else{
			 return Integer.valueOf(String.valueOf(params.get(CommonConstants.OFFSET)));
		}
	}

	/**
	 *
	 * @param params 请求参数
	 * @return 返回页码大小  不传 默认 20 条
	 */
	public static int getLimit(Map<String, Object> params) {
		if (null == params || params.isEmpty() || !params.containsKey(CommonConstants.LIMIT)){
			return CommonConstants.LIMITSIZE ;
		}else{
			return Integer.valueOf(String.valueOf(params.get(CommonConstants.LIMIT)));
		}



	}

}
