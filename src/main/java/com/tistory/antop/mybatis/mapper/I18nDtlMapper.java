package com.tistory.antop.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.I18nDtl;

public interface I18nDtlMapper {

	public void insert(I18nDtl i18nDtl);

	public void update(I18nDtl i18nDtl);

	public void delete(@Param("code") String code,
			@Param("language") String language);

	public I18nDtl selectById(@Param("code") String code,
			@Param("language") String language,
			@Param("isDetail") boolean isDetail);

	public List<I18nDtl> selectByMap(@Param("map") MapVo map);

}
