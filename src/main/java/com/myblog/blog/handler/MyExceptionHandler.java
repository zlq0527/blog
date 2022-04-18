package com.myblog.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:MyExceptionHandler
 * Package:com.myblog.blog.handler
 * Description:
 *
 * @Date:2020/7/25 21:35
 * @com.chuangmei
 */
@ControllerAdvice   //该注解定义全局异常处理类
public class MyExceptionHandler {

	//日志对象
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHnadler(HttpServletRequest request, Exception exception) throws Exception {

		//打印出url和异常
		logger.info("Request Url: {},Exception: {}", request.getRequestURL(), exception);

		//如果状态码不为null,抛出异常,交给springboot处理,否则,跳转到自定义的error界面
		if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
			throw exception;
		}

		//ModelAndView,跳转到自定义的error界面
		ModelAndView modelAndView = new ModelAndView();

		//StringBuild
		StringBuilder sb = new StringBuilder(120);

		sb.append("错误路径: ");
		sb.append(request.getRequestURL());
		sb.append("\t");
		sb.append("异常信息: ");
		sb.append(exception.toString());

		//加入异常信息
        /*modelAndView.addObject
                ("message","url: " + request.getRequestURL() + "   " + "exception: " + exception.toString());*/
		modelAndView.addObject("message", sb.toString());
		modelAndView.setViewName("/error/error");
		return modelAndView;
	}
}
