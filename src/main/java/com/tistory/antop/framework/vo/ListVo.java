package com.tistory.antop.framework.vo;

import java.util.ArrayList;
import java.util.List;

public class ListVo<T> {

	private List<T> list = new ArrayList<T>();
	private long total = 0;

	public ListVo() {

	}

	public ListVo(List<T> list, long total) {
		this.list = list;
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ListVo [list=" + list.size() + ", total=" + total + "]";
	}

}
