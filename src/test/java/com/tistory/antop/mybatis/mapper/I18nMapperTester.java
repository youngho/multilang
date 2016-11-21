package com.tistory.antop.mybatis.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tistory.antop.BaseTestCase;
import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.I18n;

public class I18nMapperTester extends BaseTestCase {

	@Autowired
	private I18nMapper mapper;

	@Test
	public void selectById() {
		I18n i18n = mapper.selectById("location.title.street.address");

		System.out.println("--");
		System.out.println(i18n);
		System.out.println("--");
	}

	@Test
	public void selectByMap() {
		MapVo map = new MapVo();
		map.put("code", "location");
		map.put("desc", "아이디");

		List<I18n> list = mapper.selectByMap(map);

		System.out.println("--");
		for (I18n i18n : list) {
			System.out.println(i18n);
		}
		System.out.println("--");
	}

}
