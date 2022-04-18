package com.myblog.blog.dao;

import com.myblog.blog.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKupdateByThemeey(User record);

	User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	User selectUser();

	int updatePassword(@Param("originalPass") String originalPass, @Param("newPass") String newPass, @Param("question") String question);

	int updateByFirstPicture(String url);

	int updateByTheme(String theme);
}
