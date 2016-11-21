package com.tistory.antop.service.impl;

import java.util.List;

import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.mapper.LocationMapper;
import com.tistory.antop.mybatis.model.Location;
import com.tistory.antop.service.LocationSo;

public class LocationSoImpl implements LocationSo {

	private LocationMapper locationMappr;

	public void setLocationMappr(LocationMapper locationMappr) {
		this.locationMappr = locationMappr;
	}

	public ListVo<Location> inquire(int page) {

		int limit = 10;
		int offset = (page - 1) * 10;

		MapVo map = new MapVo();
		map.put("offset", offset);
		map.put("limit", limit);

		List<Location> list = locationMappr.select(map);
		long total = locationMappr.count(map);

		ListVo<Location> listVo = new ListVo<Location>(list, total);

		return listVo;
	}

}
