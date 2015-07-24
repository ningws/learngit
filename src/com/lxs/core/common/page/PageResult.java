package com.lxs.core.common.page;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 一页数据
	 */
	private List<?> result;
	/**
	 * 总行数
	 */
	private long rowCount;
	
	public List<?> getResult() {
		return result;
	}
	public void setResult(List<?> result) {
		this.result = result;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

}
