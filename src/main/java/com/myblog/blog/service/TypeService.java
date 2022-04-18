package com.myblog.blog.service;

import com.myblog.blog.model.Pager;
import com.myblog.blog.model.Type;

import java.util.List;

/**
 * ClassName:TypeService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/27 13:42
 * @com.chuangmei
 */
public interface TypeService {
	int setType(Type type);

	int queryTypeBynameCount(String typename);

	List<Type> queryAllType();

	Type queryTypeById(String id);

	int updateTypeByType(Type type);

	int deleteTypeById(String id);

	List<Type> queryTypeAndNumber();

	int queryAllCount();

	List<Type> queryAllTypePage(Pager typePager);
}
