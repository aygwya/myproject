package com.blog.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 表单重复拦截器
 * @author gaosongdi
 *2012-6-29
 */
public class FromDupInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(FromDupInterceptor.class);
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 log.info("==============执行顺序: afterCompletion================");  
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		log.info("==============执行顺序: postHandle================");  
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		log.info("==============执行顺序: preHandle================");  
		return true;  
	}

}
