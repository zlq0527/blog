package com.myblog.blog.dao;

import com.myblog.blog.model.Comment;

import java.util.List;

public interface CommentMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Comment record);

	int insertSelective(Comment record);

	Comment selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Comment record);

	int updateByPrimaryKey(Comment record);

	List<Comment> selectComments();

	List<Comment> selectSonByPrimaryKey(Long id);
}
