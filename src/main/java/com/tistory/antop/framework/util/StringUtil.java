package com.tistory.antop.framework.util;

public class StringUtil {

	public static boolean isNotEmpty(String s) {

		if (s == null)
			return false;

		if (s.trim().length() == 0)
			return false;

		return true;
	}

	public static boolean isEmpty(String s) {

		if (s == null)
			return true;

		if (s.trim().length() == 0)
			return true;

		return false;
	}
}
