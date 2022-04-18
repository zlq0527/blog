package com.myblog.blog.controller;

import com.myblog.blog.model.BlogComment;
import com.myblog.blog.model.User;
import com.myblog.blog.service.BlogCommentService;
import com.myblog.blog.service.UserService;
import com.myblog.blog.utility.EmojiUtility;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:BlogCommentController
 * Package:com.myblog.blog.controller.admin
 * Description:
 *
 * @Date:2020/7/29 10:52
 * @com.chuangmei
 */
@Controller
@RequestMapping("/blogcomment")
public class BlogCommentController {

	@Autowired
	private BlogCommentService blogCommentService;

	@Autowired
	private UserService userService;

	//comments
	@GetMapping("/comments/{blogid}")
	public String comments(@PathVariable Long blogid, Model model) {

		//user
		User user = userService.queryUser();

		//comments
		List<BlogComment> comments = blogCommentService.queryCommentsByBlogId(blogid);
		for (BlogComment comment : comments) {
			comment.setContent(EmojiParser.parseToUnicode(comment.getContent()));
			//如果有子评论
			if (comment.getSonComment().size() > 0) {
				//遍历子评论解析表情
				for (BlogComment soncomment : comment.getSonComment())
					soncomment.setContent(EmojiParser.parseToUnicode(soncomment.getContent()));
			}
		}

		model.addAttribute("comments", comments);
		model.addAttribute("user", user);

		return "blog :: commentContent";
	}

	@PostMapping("/comment")
	public String comment(BlogComment blogComment, HttpServletRequest request) {

		//查询出管理员的nickname
		User user = userService.queryUser();

		//判断是否为管理员评论
		if (user.getNickName().equals(blogComment.getNickname()) && request.getSession().getAttribute("user") != null)
			blogComment.setAdmincomment(true);
		else
			blogComment.setAdmincomment(false);

		//将评论的表情转换
		blogComment.setContent(EmojiUtility.convertEmojiToStr(blogComment.getContent()));

		int count = blogCommentService.addBlogComment(blogComment);

		//获取blogid
		Long blogid = blogComment.getBlogid();

		return count > 0 ? "redirect:/blogcomment/comments/" + blogid : "error/error";
	}


}
