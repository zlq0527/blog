package com.myblog.blog.service;

import com.myblog.blog.model.Comment;

import java.util.List;

/**
 * ClassName:CommentService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2021/4/17 17:11
 * @com.chuangmei
 */
public interface CommentService {
	List<Comment> queryComments();

	int deleteCommentById(Long id);

	Object querySonComment(Long id, String type);
}
