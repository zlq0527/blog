package com.myblog.blog.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ClassName:MyAspect
 * Package:com.myblog.blog.aspectJ
 * Description:
 *
 * @Date:2020/7/25 20:46
 * @com.chuangmei
 */
/*@Aspect
@Component*/
public class MyAspect {

	//日志对象
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.myblog.blog.controller..*(..))")
	private void point() {
	}

	//Before
	@Before("point()")
	public void before(JoinPoint joinPoint) {

		//获取request
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();

		//获取信息
		String url = request.getRequestURL().toString();
		String ip = request.getRemoteAddr();
		String classandmethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		Object args[] = joinPoint.getArgs();

		//封装数据
		LoggerInformation info = new LoggerInformation(url, ip, classandmethod, args);

		logger.info("Request: {}", info);
	}

	//After
	@After("point()")
	public void after() {
		logger.info("------------After------------");
	}

	//AfterReurning
	@AfterReturning(returning = "result", pointcut = "point()")
	public void afterreturning(Object result) {
		logger.info("result: {}", result);
	}

	//私有化类部类
	private class LoggerInformation {

		//Filed
		private String url;
		private String ip;
		private String classandmethod;
		private Object[] args;

		//constructor
		public LoggerInformation() {
		}

		public LoggerInformation(String url, String ip, String classandmethod, Object[] args) {
			this.url = url;
			this.ip = ip;
			this.classandmethod = classandmethod;
			this.args = args;
		}

		@Override
		public String toString() {
			return "LoggerInformation{" +
					"url='" + url + '\'' +
					", ip='" + ip + '\'' +
					", classandmethod='" + classandmethod + '\'' +
					", args=" + Arrays.toString(args) +
					'}';
		}
	}
}
