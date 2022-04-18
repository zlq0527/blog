package com.myblog.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:IndexController
 * Package:com.myblog.blog.controller.admin
 * Description:
 *
 * @Date:2020/7/24 16:18
 * @com.chuangmei
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}


}
