package com.tistory.antop.mybatis.model;

import java.io.Serializable;

public class I18n implements Serializable {

	private static final long serialVersionUID = -7991591472377954525L;

	private String code;
	private String desc;
	private String message;

	public I18n() {

	}

	public I18n(String code) {
		this.code = code;
	}
	
	public I18n(String code, String desc, String message) {
		this.code = code;
		this.desc = desc;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		I18n other = (I18n) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "I18n [code=" + code + ", desc=" + desc + ", message=" + message
				+ "]";
	}

}
