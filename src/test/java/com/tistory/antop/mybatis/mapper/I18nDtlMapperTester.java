package com.tistory.antop.mybatis.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tistory.antop.BaseTestCase;
import com.tistory.antop.mybatis.model.I18nDtl;

public class I18nDtlMapperTester extends BaseTestCase {

	@Autowired
	private I18nDtlMapper i18nDtlMapper;

	@Test
	public void selectById() {
		String code = "button.reset";
		String locale = "en";

		I18nDtl i18nDtl = i18nDtlMapper.selectById(code, locale, false);

		System.out.println("--");
		System.out.println(i18nDtl);
		System.out.println("--");
	}

	@Test
	public void update() {
		I18nDtl i18nDtl = new I18nDtl();
		i18nDtl.setCode("antop.jjang");
		i18nDtl.setLanguage("ko");
		i18nDtl.setMessage("안탑짱");

		i18nDtlMapper.update(i18nDtl);
	}

	@Test
	public void delete() {
		String code = "antop.jjang";
		String locale = "Ko";

		i18nDtlMapper.delete(code, locale);
	}

}
