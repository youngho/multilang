package com.tistory.antop.service;

import java.util.List;
import java.util.Locale;

import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.I18n;
import com.tistory.antop.mybatis.model.I18nDtl;

public interface I18nSo {

	public void remove(String code);

	public void remove(String code, String language);

	public I18n inquire(String code);

	public I18nDtl inquireDetail(String code, String language);

	public ListVo<I18n> inquireList(MapVo map);

	public List<I18nDtl> inquireDetailList();

	public List<I18nDtl> inquireDetailList(MapVo map);

	/**
	 * 다국어 마스터 정보를 저장한다.
	 * 
	 * @param code
	 * @param desc
	 * @param message
	 * @param oldCode
	 */
	public void save(String code, String desc, String message, String oldCode);

	/**
	 * 다국어 디테일 정보를 저장한다.
	 * 
	 * @param code
	 * @param language
	 * @param message
	 */
	public void save(String code, String language, String message);

	/**
	 * 사용 가능한 Locale 목록 리턴
	 * 
	 * @return
	 */
	public List<Locale> getUsableLocale();
}
