package com.myblog.blog.dao;

import com.myblog.blog.model.Code;

public interface CodeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Code record);

	int insertSelective(Code record);

	Code selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Code record);

	int updateByPrimaryKey(Code record);

	Integer selectByCode(String code);
}
