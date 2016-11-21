package com.tistory.antop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.antop.framework.BaseController;
import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.mybatis.model.Location;
import com.tistory.antop.service.LocationSo;

@Controller
public class LocationController extends BaseController {

	@Autowired
	private LocationSo locationSo;

	@RequestMapping(value = "/location/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@RequestParam(defaultValue = "1") int page) {

		ListVo<Location> listVo = locationSo.inquire(page);

		mav.addObject("list", listVo.getList());
		mav.addObject("total", listVo.getTotal());

		return mav;
	}

}
