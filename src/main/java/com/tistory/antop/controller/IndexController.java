package com.tistory.antop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.antop.framework.BaseController;

@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = { "/", "index.html", "index.jsp", "index" }, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");

		return mav;
	}

	@RequestMapping(value = "/js/context.js", method = RequestMethod.GET)
	public ModelAndView context(ModelAndView mav) {

		return mav;
	}

}
