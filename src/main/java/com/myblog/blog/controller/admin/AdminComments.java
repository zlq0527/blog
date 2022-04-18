package com.myblog.blog.controller.admin;

import com.myblog.blog.service.CommentService;
import com.myblog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:AdminComments
 * Package:com.myblog.blog.controller.admin
 * Description:
 *
 * @Date:2021/4/17 16:58
 * @com.chuangmei
 */
@Controller
@RequestMapping("/admin")
public class AdminComments {

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@RequestMapping("/comments")
	public String index(Model model) {


		model.addAttribute("comments", commentService.queryComments());
		model.addAttribute("user", userService.queryUser());

		return "admin/comments";
	}

	@RequestMapping("/comment/delete")
	public String deleteComment(@RequestParam("id") Long id, Model model) {

		// 查询此评论是否有子评论
		Integer parentcount = (Integer) commentService.querySonComment(id, "Integer");

		if (parentcount == 0) {
			// 删除
			int count = commentService.deleteCommentById(id);
		}
		model.addAttribute("comments", commentService.queryComments());

		return "admin/comments :: comments_fragment";
	}

}
