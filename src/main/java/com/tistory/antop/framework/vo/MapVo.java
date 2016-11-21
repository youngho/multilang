package com.tistory.antop.framework.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class MapVo extends HashMap<String, Object> {

	private static final long serialVersionUID = 5159902564679581736L;

	@Override
	public Object put(String key, Object value) {
		return super.put(key, value);
	}

	@Override
	public Object get(Object key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		if (o instanceof String) {
			String s = (String) o;

			if (s.trim().length() == 0) {
				return null;
			}
		}

		return o;
	}

	public Integer getInt(String key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		try {
			return (Integer) o;
		} catch (ClassCastException e) {
			if(o instanceof String) {
				return Integer.parseInt((String) o);
			} else {
				throw e;
			}
		}
		
	}

	public Double getDouble(String key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		return (Double) o;
	}

	public Long getLong(String key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		return (Long) o;
	}

	public BigDecimal getBigDecimal(String key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		return (BigDecimal) o;
	}

	public Date getDate(String key) {
		Object o = super.get(key);

		if (o == null) {
			return null;
		}

		return (Date) o;
	}

}
