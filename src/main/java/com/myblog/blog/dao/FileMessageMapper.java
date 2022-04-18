package com.myblog.blog.dao;

import com.myblog.blog.model.FileMessage;

public interface FileMessageMapper {
	int deleteByPrimaryKey(Long id);

	int insert(FileMessage record);

	int insertSelective(FileMessage record);

	FileMessage selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(FileMessage record);

	int updateByPrimaryKey(FileMessage record);
}
