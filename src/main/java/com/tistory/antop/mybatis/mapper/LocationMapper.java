package com.tistory.antop.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.Location;

public interface LocationMapper {

	List<Location> select(@Param("map") MapVo map);

	long count(@Param("map") MapVo map);

}
