package com.myblog.blog.service;

import com.myblog.blog.dao.BackgroundMapper;
import com.myblog.blog.model.Background;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:BackgroundServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/8/24 13:34
 * @com.chuangmei
 */
@Service
public class BackgroundServiceImp implements BackgroundService {

	@Resource
	private BackgroundMapper backgroundMapper;

	@Override
	public int checkurlRepitition(String url) {

		return backgroundMapper.selectByUrl(url);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int addSelective(Background background) {

		return backgroundMapper.insertSelective(background);
	}

	/*查询所有*/
	@Override
	public List<Background> queryAll() {

		return backgroundMapper.selectAll();
	}

	/*删除*/
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteUrl(Long id) {

		return backgroundMapper.deleteByPrimaryKey(id);
	}

	//加载更多图片-局部刷新
	@Override
	public List<Background> queryAllLimit(int count) {

		return backgroundMapper.selectAllLimit(count);
	}

	//查询图片个数
	@Override
	public int queryCount() {
		return backgroundMapper.selectCount();
	}
}
