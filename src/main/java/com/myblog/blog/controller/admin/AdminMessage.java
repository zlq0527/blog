package com.myblog.blog.controller.admin;

import com.myblog.blog.service.MessageBoardService;
import com.myblog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:AdminMessage
 * Package:com.myblog.blog.controller.admin
 * Description:
 *
 * @Date:2021/11/6 20:04
 * @com.chuangmei
 */
@Controller
@RequestMapping("/admin")
public class AdminMessage {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageBoardService messageBoardService;


	@RequestMapping("/messages")
	public String messages(Model model) {

		model.addAttribute("user", userService.queryUser());
		model.addAttribute("messages", messageBoardService.queryMessageAllBoard());

		return "admin/messages";
	}

	@RequestMapping("/messages/delete")
	public String deleteMessage(Long id, Model model) {

		int count = messageBoardService.deleteMessage(id);

		if (count > 0) {
			model.addAttribute("user", userService.queryUser());
			model.addAttribute("messages", messageBoardService.queryMessageAllBoard());
		} else {
			model.addAttribute("message", "删除失败!!");
		}

		return count > 0 ? "admin/messages :: messagesfragments" : "error/error";

	}

}
