package com.tistory.antop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.antop.framework.BaseController;
import com.tistory.antop.framework.vo.ListVo;
import com.tistory.antop.framework.vo.MapVo;
import com.tistory.antop.mybatis.model.I18n;
import com.tistory.antop.mybatis.model.I18nDtl;
import com.tistory.antop.service.I18nSo;

@Controller
public class I18nController extends BaseController {

	@Autowired
	private I18nSo i18nSo;

	@RequestMapping(value = "/js/locale.js", method = RequestMethod.GET)
	public ModelAndView javascript(ModelAndView mav) {

		MapVo map = new MapVo();
		map.put("language", LocaleContextHolder.getLocale().getLanguage());

		List<I18nDtl> list = i18nSo.inquireDetailList(map);

		mav.addObject("list", list);
		
		return mav;
	}

	@RequestMapping(value = { "/i18n", "/i18n/list" }, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@RequestParam(defaultValue = "1") int page) {

		MapVo map = new MapVo();
		map.put("page", page);

		ListVo<I18n> listVo = i18nSo.inquireList(map);

		mav.addObject("list", listVo.getList());
		mav.addObject("total", listVo.getTotal());

		mav.setViewName("i18n/list");

		return mav;
	}

	@RequestMapping(value = "/i18n/form", method = RequestMethod.GET)
	public ModelAndView form(ModelAndView mav,
			@RequestParam(value = "code", required = false) String code) {

		if (code != null) {
			I18n i18n = i18nSo.inquire(code);
			mav.addObject("i18n", i18n);
		}

		return mav;
	}

	@RequestMapping(value = "/i18n/save", method = RequestMethod.POST)
	public ModelAndView save(ModelAndView mav,
			@RequestParam(value = "oldCode", required = false) String oldCode,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "desc", required = false) String desc,
			@RequestParam(value = "message", required = true) String message) {
		// save
		i18nSo.save(code, desc, message, oldCode);
		// redirect
		mav.setViewName("redirect:/i18n/list");

		return mav;
	}

	@RequestMapping(value = "/i18n/remove", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav,
			@RequestParam(value = "code") String code) {
		i18nSo.remove(code);

		mav.setViewName("redirect:/i18n");

		return mav;
	}

	@RequestMapping(value = { "/i18n/detail", "/i18n/detail/list" }, method = RequestMethod.GET)
	public ModelAndView listDetail(ModelAndView mav,
			@RequestParam(value = "code", required = true) String code) {

		MapVo map = new MapVo();
		map.put("code", code);
		map.put("isDetail", true);

		List<I18nDtl> list = i18nSo.inquireDetailList(map);

		mav.addObject("list", list);

		mav.setViewName("/i18n/detail/list");

		return mav;
	}

	@RequestMapping(value = "/i18n/detail/form", method = RequestMethod.GET)
	public ModelAndView formDetail(ModelAndView mav,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "language", required = false) String language) {

		I18nDtl i18nDtl = null;

		// language 파라미터가 없으면 등록이다.
		if (language != null) {

			i18nDtl = i18nSo.inquireDetail(code, language);

		} else {
			MapVo map = new MapVo();
			map.put("code", code);
			// 등록되어있지 않은 코드를 조회
			map.put("isDetail", false);

			List<I18nDtl> i18nList = i18nSo.inquireDetailList(map);
			mav.addObject("i18nList", i18nList);

			i18nDtl = new I18nDtl();
			i18nDtl.setCode(code);
		}

		mav.addObject("i18nDetail", i18nDtl);

		return mav;
	}

	@RequestMapping(value = "/i18n/detail/save", method = RequestMethod.POST)
	public ModelAndView saveDetail(
			ModelAndView mav,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "message", required = true) String message) {

		i18nSo.save(code, language, message);

		mav.setViewName("redirect:/i18n/detail/list?code=" + code);

		return mav;
	}

	@RequestMapping(value = "/i18n/detail/remove", method = RequestMethod.GET)
	public ModelAndView removeDetail(ModelAndView mav,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "language", required = true) String language) {

		i18nSo.remove(code, language);

		mav.setViewName("redirect:/i18n/detail/list?code=" + code);

		return mav;
	}

}
