package com.blog.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
	
	protected static final String SUCCESS="success";
	protected static final String ERROR="error";
	protected static final String LOGIN="login";
	
	/**
	 * @param model 数据模型
	 * @param info 数据内容
	 * @return
	 * 2012-8-3 下午2:55:42
	 */
	protected ModelAndView ajax(Model model,String info){
		model.addAttribute("ajaxInfo",info);
		return new ModelAndView("/ajax");
	}
}
