package com.myblog.blog.service;

import com.myblog.blog.dao.BlogCommentMapper;
import com.myblog.blog.model.BlogComment;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName:BlogCommentServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/29 11:09
 * @com.chuangmei
 */
@Service
public class BlogCommentServiceImp implements BlogCommentService {

	@Resource
	private BlogCommentMapper blogCommentDao;

	//发布评论
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int addBlogComment(BlogComment blogComment) {

		//设置父级id
		if (blogComment.getParentid() == null) {
			blogComment.setParentid(Long.valueOf(0));
		}
		//设置创建时间
		blogComment.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//设置头像

		//插入评论
		int count = blogCommentDao.insertSelective(blogComment);

		return count;
	}

	//id查询评论
	@Override
	public List<BlogComment> queryCommentsByBlogId(Long id) {

		//查询
		List<BlogComment> comments = blogCommentDao.selectCommentsByBlogId(id);

		//表情处理
		EmojiConver(comments);

		//创建父级评论
		BuildCommentName(comments);

		return eachComment(comments);
	}

	@Override
	public int queryCommentCount() {
		int count = blogCommentDao.selectCommentsCount();
		return count;
	}

	private void EmojiConver(List<BlogComment> comments) {
		//特殊字符处理
		for (BlogComment comment : comments) {
			comment.setContent(EmojiParser.parseToUnicode(comment.getContent()));
			//如果有子评论
			if (comment.getSonComment().size() > 0) {
				//遍历子评论解析表情
				for (BlogComment soncomment : comment.getSonComment()) {
					soncomment.setContent(EmojiParser.parseToUnicode(soncomment.getContent()));
					//递归
					if (soncomment.getSonComment().size() > 0)
						EmojiConver(soncomment.getSonComment());
				}
			}
		}
	}

	//构建评论
	private void BuildCommentName(List<BlogComment> comments) {
		//迭代,如果有子评论,那么将此评论放入createName进行创建父级评论
		for (BlogComment comment : comments) {
			if (comment.getSonComment().size() > 0) {
				creatName(comment);
			}
		}
	}

	private void creatName(BlogComment comment) {
		//迭代comment集合,如果有子评论
		if (comment.getSonComment().size() > 0) {
			//遍历子评论
			for (BlogComment sonComment : comment.getSonComment()) {
				//创建父级评论
				BlogComment parent = new BlogComment();
				parent.setNickname(comment.getNickname());
				parent.setId(comment.getId());
				//将父级评论存入子评论
				sonComment.setParentComment(parent);
				//如果子评论中还有子评论,那麽递归
				if (sonComment.getSonComment().size() > 0) {
					creatName(sonComment);
				}
			}
		}
	}

	private List<BlogComment> eachComment(List<BlogComment> comments) {
		List<BlogComment> commentsView = new ArrayList<>();
		for (BlogComment comment : comments) {
			commentsView.add(comment);
		}
		combineChildren(commentsView);
		return commentsView;
	}


	private void combineChildren(List<BlogComment> comments) {

		for (BlogComment comment : comments) {
			List<BlogComment> sonComment = comment.getSonComment();
			for (BlogComment soncomment : sonComment) {
				able = true;
				recursively(soncomment);
			}
			comment.setSonComment(saveComment);
			//清除临时存放区
			saveComment = new ArrayList<>();
		}
	}

	//存放迭代找出的所有子级的集合
	private List<BlogComment> saveComment = new ArrayList<>();

	//是否添加到saveComment(存储子评论的)
	private boolean able;

	/*
		递归迭代
	 */
	private void recursively(BlogComment comment) {
		if (able) {
			saveComment.add(comment);
		}
		if (comment.getSonComment().size() > 0) {
			List<BlogComment> replys = comment.getSonComment();
			for (BlogComment reply : replys) {
				saveComment.add(reply);
				if (reply.getSonComment().size() > 0) {
					able = false;
					// 标记 able为false , 因为这个不能直接添加
					recursively(reply);
				}
			}
		}
	}
}
