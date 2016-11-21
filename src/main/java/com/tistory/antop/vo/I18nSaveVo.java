package com.tistory.antop.vo;

import com.tistory.antop.mybatis.model.I18n;

public class I18nSaveVo extends I18n {
	private static final long serialVersionUID = -1884743989736994748L;
	
	private String oldCode;

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

}
