package com.bootdo.clouddocms.domain;

import java.io.Serializable;
import java.util.Date;




public class FileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Long id;

	private Integer type;

	private String url;

	private Date createDate;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
