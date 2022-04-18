package com.myblog.blog.controller;

import com.myblog.blog.model.Project;
import com.myblog.blog.model.User;
import com.myblog.blog.service.CodeService;
import com.myblog.blog.service.ProjectService;
import com.myblog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:ProjectsController
 * Package:com.myblog.blog.controller
 * Description:
 *
 * @Date:2021/9/10 16:25
 * @com.chuangmei
 */
@Controller
@RequestMapping("/projects")
public class ProjectsController {

	// userService
	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private CodeService codeService;

	@GetMapping("/index")
	public String index(Model model) {

		//ModelAndView modelAndView = new ModelAndView("/myprojects");

		// 查询项目
		Project[] projects = projectService.queryProjects();

		User user = userService.queryUser();

		model.addAttribute("user", user);
		model.addAttribute("projects", projects);


		return "myprojects";
	}

	@PostMapping("/code")
	@ResponseBody
	public String code(@RequestParam("code") String code, HttpServletRequest request) {

		// 验证code
		Integer count = codeService.verificationCode(code);

		if (count == null) {
			return "验证码错误";
		}

		if (count > 0) {
			request.getSession().setAttribute("code", code);
			//60分钟未操作销毁
			request.getSession().setMaxInactiveInterval(2 * 30 * 60);

			return "success";
		} else {
			return "验证码错误";
		}
	}

}
