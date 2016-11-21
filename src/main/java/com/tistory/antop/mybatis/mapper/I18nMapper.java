package com.tistory.antop.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.I18n;

public interface I18nMapper {

	public void insert(@Param("code") String code, @Param("desc") String desc,
			@Param("message") String message);

	public void update(@Param("oldCode") String oldCode,
			@Param("code") String code, @Param("desc") String desc,
			@Param("message") String message);

	public void delete(String code);

	public I18n selectById(String code);

	public List<I18n> selectByMap(@Param("map") MapVo map);

	public long countByMap(@Param("map") MapVo map);

}
