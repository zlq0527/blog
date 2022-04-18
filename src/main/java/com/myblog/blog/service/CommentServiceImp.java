package com.myblog.blog.service;

import com.myblog.blog.dao.CommentMapper;
import com.myblog.blog.model.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:CommentServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2021/4/17 17:16
 * @com.chuangmei
 */
@Service
public class CommentServiceImp implements CommentService {

	@Resource
	private CommentMapper dao;

	@Override
	public List<Comment> queryComments() {
		List<Comment> comments = dao.selectComments();
		System.out.println(comments);
		return comments;
	}

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	@Override
	public int deleteCommentById(Long id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public Object querySonComment(Long id, String type) {
		List<Comment> comments = dao.selectSonByPrimaryKey(id);
		if (type.equals("Integer")) {
			return comments.size();
		} else {
			return comments;
		}
	}
}
