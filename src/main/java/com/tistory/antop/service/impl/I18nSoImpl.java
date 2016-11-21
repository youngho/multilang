package com.tistory.antop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import com.tistory.antop.framework.support.MessageSource;
import com.tistory.antop.framework.util.StringUtil;
import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.mapper.I18nDtlMapper;
import com.tistory.antop.mybatis.mapper.I18nLangMapper;
import com.tistory.antop.mybatis.mapper.I18nMapper;
import com.tistory.antop.mybatis.model.I18n;
import com.tistory.antop.mybatis.model.I18nDtl;
import com.tistory.antop.mybatis.model.I18nLang;
import com.tistory.antop.service.I18nSo;

public class I18nSoImpl implements I18nSo, MessageSource {

	private I18nLangMapper i18nLangMapper;
	private I18nMapper i18nMapper;
	private I18nDtlMapper i18nDtlMapper;

	public void setI18nMapper(I18nMapper i18nMapper) {
		this.i18nMapper = i18nMapper;
	}

	public void setI18nDtlMapper(I18nDtlMapper i18nDtlMapper) {
		this.i18nDtlMapper = i18nDtlMapper;
	}

	public void setI18nLangMapper(I18nLangMapper i18nLangMapper) {
		this.i18nLangMapper = i18nLangMapper;
	}

	/**
	 * Message Source
	 */
	public String getMessage(String code, String locale) {
		I18nDtl i18nDtl = inquireDetail(code, locale);
		if (i18nDtl == null) {
			return null;
		}

		return i18nDtl.getMessage();
	}
	
	public void remove(String code) {
		i18nMapper.delete(code);
	}

	public void remove(String code, String language) {
		i18nDtlMapper.delete(code, language);
	}

	public I18n inquire(String code) {
		return i18nMapper.selectById(code);
	}

	public I18nDtl inquireDetail(String code, String language) {

		I18nDtl i18nDtl = i18nDtlMapper.selectById(code, language, false);

		if (i18nDtl == null) {
			return null;
		}

		if (i18nDtl.getLanguage() != null) {
			Locale locale = findLocale(i18nDtl.getLanguage());
			i18nDtl.setLanguageName(getLanguageName(locale));
		}

		return i18nDtl;
	}

	public ListVo<I18n> inquireList(MapVo map) {

		int page = map.getInt("page");

		int limit = 10;
		if (map.getInt("limit") == null) {
			map.put("limit", limit);
		}

		int offset = (page - 1) * 10;

		map.put("offset", offset);
		map.put("limit", limit);

		List<I18n> list = i18nMapper.selectByMap(map);
		long total = i18nMapper.countByMap(map);

		return new ListVo<I18n>(list, total);
	}

	public List<I18nDtl> inquireDetailList() {
		return inquireDetailList(new MapVo());
	}

	public List<I18nDtl> inquireDetailList(MapVo map) {
		List<I18nDtl> list = i18nDtlMapper.selectByMap(map);

		for (I18nDtl i18nDtl : list) {
			Locale locale = findLocale(i18nDtl.getLanguage());
			i18nDtl.setLanguageName(getLanguageName(locale));
		}

		return list;
	}

	public void save(String code, String desc, String message, String oldCode) {
		if (StringUtil.isNotEmpty(oldCode)) { // 수정
			i18nMapper.update(oldCode, code, desc, message);
		} else { // 등록
			i18nMapper.insert(code, desc, message);
		}
	}

	public void save(String code, String language, String message) {

		I18nDtl i18nDtl = i18nDtlMapper.selectById(code, language, true);

		if (i18nDtl == null) { // 등록
			i18nDtl = new I18nDtl(code, language);
			i18nDtl.setMessage(message);

			i18nDtlMapper.insert(i18nDtl);
		} else { // 수정
			i18nDtl.setMessage(message);
			i18nDtlMapper.update(i18nDtl);
		}
	}

	/**
	 * 사용 가능한 언어 가져오기
	 */
	public List<Locale> getUsableLocale() {
		List<Locale> locales = new ArrayList<Locale>();

		List<I18nLang> list = i18nLangMapper.select();

		for (I18nLang i18nLang : list) {
			Locale locale = findLocale(i18nLang.getLanguage());

			if (locale != null) {
				locales.add(locale);
			}

		}

		return locales;
	}

	private Locale findLocale(String language) {

		for (Locale locale : Locale.getAvailableLocales()) {
			if (locale.getLanguage().equals(language)) {
				return locale;
			}
		}

		return null;
	}

	/**
	 * 언어 코드로 언어명을 찾는다
	 * 
	 * @param language
	 *            언어 코드
	 * @return
	 */
	private String getLanguageName(Locale locale) {
		return locale.getDisplayLanguage(LocaleContextHolder.getLocale());
	}

}
