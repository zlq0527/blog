package com.myblog.blog.interceptor;

import com.myblog.blog.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MyInterceptor
 * Package:com.myblog.blog.interceptor
 * Description:
 *
 * @Date:2020/7/25 19:55
 * @com.chuangmei
 */
public class MyInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		///请求路径
		String uri = request.getRequestURI();

		// 如果请求中带有 admin , 判断是否有user对象
		if (uri.indexOf("admin") != -1) {
			boolean result = false;

			User user = (User) request.getSession().getAttribute("user");
			//System.out.println("进入拦截器,此时的User = " + user);
			//判断user
			if (user != null)
				result = true;
			else
				/*此处不能写/admin/ 因为这样还会被继续拦截,如果要这样写,可以在config中添加不拦截/admin/请求*/
				response.sendRedirect("/admin");

			return result;
		} else if (uri.indexOf("projects") != -1) {
			// 取出code
			String code = (String) request.getSession().getAttribute("code");
			if (code != null)
				return true;
			else {
				response.sendRedirect("/messageboard");
				return false;
			}

		} else {
			return true;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
