package com.myblog.blog.service;

import com.myblog.blog.model.Blog;
import com.myblog.blog.model.Pager;
import com.myblog.blog.model.SearchBlog;

import java.util.List;

/**
 * ClassName:BlogService
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/26 1:29
 * @com.chuangmei
 */
public interface BlogService {

	//插入blog接口
	Integer setBlogInsert(Blog blog);

	List<Blog> getAllBlog(Pager pager);

	List<Blog> getAllBlog();

	Blog getBlogByIdAndConvert(String id);

	Blog getBlogById(String id);

	Integer setBlogUpdate(Blog blog);

	int deleteBlogById(Long id);

	List queryBlogByTitle(String searchtitle, boolean enlargeRange);

	List<Blog> queryBlogByTypeId(String searchtypeid, Pager pager);

	List<Blog> queryBlogByTypeId(String searchtypeid);

	List<Blog> queryBlogByRecommend(String searchrecommend);

	int queryBlogCount();

	List<Blog> queryBlogOrderByCreateTime();

	int setBlogUpdateNoDefault(Blog blog);

	int changeDeleteStateById(Long id);

	List<Blog> queryBlogByrecycle();

	int queryBlogByrecycle(Long id);

	int modifyBlogRecover(Long id);

	int queryBlogCountByTypeId(int id);

	List<Blog> queryBlogOrderByCreateTimeLimit(Integer range);

	List<Blog> queryBlogBySql(String sql);

	int deleteMultipleBlogById(Long[] ids);

	List<Blog> queryBlogByRecordLife();

	List<Blog> queryBlogByTitleFromRecycle(SearchBlog searh);

	String queryBlogOriginalContent(Integer id);

	int modifySortById(Integer id, Integer sort);

	List<Blog> queryAllBlogOnlySort(Pager pager);

	List<Blog> queryAllBlogByTypeId(String id);

	int addAdmire(Long blogid);
}
