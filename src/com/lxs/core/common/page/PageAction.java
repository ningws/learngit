package com.lxs.core.common.page;

import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分页起始下标
	 */
	protected Integer start = 0;
	/**
	 * 每页行数
	 */
	protected Integer pageSize = 10;
	
	public Integer getStart() {
		return start;
	}
	
	public void setStart(Integer start) {
		this.start = start;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
