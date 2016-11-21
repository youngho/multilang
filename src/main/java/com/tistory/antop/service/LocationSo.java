package com.tistory.antop.service;

import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.mybatis.model.Location;

public interface LocationSo {

	ListVo<Location> inquire(int page);

}
