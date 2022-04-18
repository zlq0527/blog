package com.myblog.blog.service;

import com.myblog.blog.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:UserService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/25 20:24
 * @com.chuangmei
 */
public interface UserService {

	/*登录查询接口*/
	User queryUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	User queryUser();

	int updateUserSelective(User user);

	int updatePassword(@Param("originalPass") String originalPass, @Param("newPass") String newPass, @Param("question") String question);

	int updateFirstPicture(String url);

	int updateUserTheme(String theme);
}
