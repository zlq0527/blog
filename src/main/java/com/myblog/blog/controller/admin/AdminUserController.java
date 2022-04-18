package com.myblog.blog.controller.admin;

import com.myblog.blog.model.User;
import com.myblog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:AdminUserController
 * Package:com.myblog.blog.controller.admin
 * Description:
 *
 * @Date:2020/7/29 19:35
 * @com.chuangmei
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private UserService userService;

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		//session置空
		request.getSession().setAttribute("user", null);

		return "redirect:/";
	}


	@GetMapping("/editouser")
	public String editor(Model model) {

		//user
		User user = userService.queryUser();

		model.addAttribute("user", user);

		return "admin/editoruser";
	}

	@PostMapping("/updateuser")
	public String updateUser(User user) {

		//修改
		int count = userService.updateUserSelective(user);

		return count > 0 ? "redirect:/admin/index" : "error/error";
	}

	@GetMapping("/changepassword")
	public String changePass(Model model) {

		//user
		User user = userService.queryUser();
		model.addAttribute("user", user);

		return "admin/editorpass";
	}

	@PostMapping("/ediPass")
	public String ediPass(String originalPass, String newPass, String question, HttpServletRequest request, Model model) {

		int count = userService.updatePassword(originalPass, newPass, question);

		if (count > 0) {
			request.getSession().setAttribute("user", null);
		} else {
			model.addAttribute("errorMessage", "信息错误!");
		}

		return count > 0 ? "redirect:/" : "admin/editorpass";
	}

}
