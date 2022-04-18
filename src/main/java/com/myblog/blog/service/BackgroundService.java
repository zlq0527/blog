package com.myblog.blog.service;

import com.myblog.blog.model.Background;

import java.util.List;

/**
 * ClassName:BackgroundService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/8/24 13:34
 * @com.chuangmei
 */
public interface BackgroundService {

	int checkurlRepitition(String url);

	int addSelective(Background background);

	List<Background> queryAll();

	int deleteUrl(Long id);

	List<Background> queryAllLimit(int count);

	int queryCount();
}
