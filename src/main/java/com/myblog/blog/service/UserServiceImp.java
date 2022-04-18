package com.myblog.blog.service;

import com.myblog.blog.dao.UserMapper;
import com.myblog.blog.model.User;
import com.myblog.blog.utility.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName:UserServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/25 20:25
 * @com.chuangmei
 */
@Service
public class UserServiceImp implements UserService {

	@Resource
	private UserMapper userDao;

	@Override
	public User queryUserByUsernameAndPassword(String username, String password) {

		//调用Dao层进行查询
		User user = userDao.selectByUsernameAndPassword(username, password);

		return user;
	}

	@Override
	public User queryUser() {
		User user = userDao.selectUser();
		return user;
	}

	//修改user
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateUserSelective(User user) {
		int count = userDao.updateByPrimaryKeySelective(user);
		return count;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updatePassword(String originalPass, String newPass, String question) {
		int count = userDao.updatePassword(MD5.getMD5(originalPass), MD5.getMD5(newPass), question);
		return count;
	}

	/*修改首图*/
	@Override
	public int updateFirstPicture(String url) {

		return userDao.updateByFirstPicture(url);
	}

	//更改主题接口
	@Override
	public int updateUserTheme(String theme) {
		int success = userDao.updateByTheme(theme);
		return success;
	}
}
