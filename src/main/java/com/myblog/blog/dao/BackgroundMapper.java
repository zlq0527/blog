package com.myblog.blog.dao;

import com.myblog.blog.model.Background;

import java.util.List;

public interface BackgroundMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Background record);

	int insertSelective(Background record);

	Background selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Background record);

	int updateByPrimaryKey(Background record);

	int selectByUrl(String url);

	List<Background> selectAll();

	List<Background> selectAllLimit(int count);

	int selectCount();
}
