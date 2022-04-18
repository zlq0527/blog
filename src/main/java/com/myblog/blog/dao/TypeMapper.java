package com.myblog.blog.dao;

import com.myblog.blog.model.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Type record);

	int insertSelective(Type record);

	Type selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Type record);

	int updateByPrimaryKey(Type record);

	//通过name查询type接口
	Type selctTypeByname(String typename);

	//查询所有类型接口
	List<Type> selectAllType();

	List<Type> selectTypeAndNumber();

	int selectAllCount();

	List<Type> selectAllTypePage(@Param("startpage") int startpage, @Param("datanumber") Integer datanumber);
}
