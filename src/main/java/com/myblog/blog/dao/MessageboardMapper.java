package com.myblog.blog.dao;

import com.myblog.blog.model.Messageboard;

import java.util.List;

public interface MessageboardMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Messageboard record);

	int insertSelective(Messageboard record);

	Messageboard selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Messageboard record);

	int updateByPrimaryKey(Messageboard record);

	List<Messageboard> selectMessageBoard();

	List<Messageboard> selectAllMessageBoard();
}
