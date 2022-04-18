package com.myblog.blog.controller;

import com.myblog.blog.model.Blog;
import com.myblog.blog.model.BlogComment;
import com.myblog.blog.model.Pager;
import com.myblog.blog.model.User;
import com.myblog.blog.service.BlogCommentService;
import com.myblog.blog.service.BlogService;
import com.myblog.blog.service.UserService;
import com.myblog.blog.utility.BuildPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ClassName:BlogController
 * Package:com.myblog.blog.controller
 * Description:
 *
 * @Date:2020/7/23 16:47
 * @com.chuangmei
 */
@EnableSwagger2
@Controller
//@RestController
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private UserService userService;

	@Autowired
	private BlogCommentService blogCommentService;


//	@ResponseBody
//	@RequestMapping("/test")
//	public List<Blog> blog() {
//		List<Blog> blog=blogService.getAllBlog();
//		return blog;
//	}

	@GetMapping("/blogs/{id}")
	public String blog(@PathVariable String id, Model model, HttpServletResponse response) {
		//查询User
		User user = userService.queryUser();
		//在回收站中查询
		int count = blogService.queryBlogByrecycle(Long.valueOf(id));
		//已经在回收站的博客不提供访问
		if (count > 0) {
			model.addAttribute("user", user);
			return "error/404.html";
		}
		//通过id查询blog
		Blog blog = blogService.getBlogByIdAndConvert(id);
		//查询评论
		List<BlogComment> comments = blogCommentService.queryCommentsByBlogId(Long.valueOf(id));

		//将查询的blog加入到request
		model.addAttribute("blog", blog);
		model.addAttribute("comments", comments);
		model.addAttribute("user", user);
		model.addAttribute("originalBlogcontent", blogService.queryBlogOriginalContent(Integer.parseInt(id)));

		return "blog";
	}

	//用于从博客详情页面返回到搜索页面,避免不支持Post请求导致500
	@GetMapping("/search")
	public String search() {
		return "redirect:/";
	}

	@PostMapping("/search")
	public String search(@RequestParam(defaultValue = "") String articletitle, Model model) {

		boolean enlargeRange = false;
		//如果搜索内容包括指定值那么开启扩大匹配范围
		if (articletitle.contains("^扩大匹配 ")) {
			articletitle = articletitle.replace("^扩大匹配 ", "");
			enlargeRange = true;
		}

		//通过title查询
		List<Blog> blogs = blogService.queryBlogByTitle(articletitle, enlargeRange);
		//查询出User
		User user = userService.queryUser();

		//加入
		model.addAttribute("blogs", blogs);
		model.addAttribute("user", user);
		model.addAttribute("searchcount", blogs.size());

		return "search";
	}

	//分页
	@PostMapping("/paging")
	public String paging(Integer pagestart, Model model, HttpServletRequest request) {

		//查询出博客数量
		Integer blogcount = blogService.queryBlogCount();

		//构建pager
		Pager pager = BuildPager.biuldPager(blogcount, pagestart);

		//查询出User
		User user = userService.queryUser();

		//System.out.println(pager);

		//查询出所有博客
		List<Blog> blogs = blogService.getAllBlog(pager);

		//当前页
		//request.getSession().setAttribute("currentPage",pagestart);

		//System.out.println("设置的页数" + pagestart);
		//System.out.println("得到的页数" + request.getSession().getAttribute("currentPage"));

		//加入
		model.addAttribute("blogs", blogs);
		model.addAttribute("pager", pager);
		model.addAttribute("user", user);

		return "index :: panelbodyContent";
	}

	@GetMapping("/blog/admire")
	public String getAdmire(@PathVariable Long blogid, Model model) {

		int count = blogService.addAdmire(blogid);


		return count > 0 ? "blog :: admire" : "error";
	}

}
