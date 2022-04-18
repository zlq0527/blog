package com.myblog.blog.service;

import com.myblog.blog.model.Messageboard;

import java.util.List;

/**
 * ClassName:MessageBoardService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/8/14 15:30
 * @com.chuangmei
 */
public interface MessageBoardService {

	int addMessage(Messageboard messageboard);

	List<Messageboard> queryMessageBoard();

	List<Messageboard> queryMessageAllBoard();

	int deleteMessage(Long id);
}
