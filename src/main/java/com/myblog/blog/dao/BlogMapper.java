package com.myblog.blog.dao;

import com.myblog.blog.model.Blog;
import com.myblog.blog.model.SearchBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Blog record);

	int insertSelective(Blog record);

	Blog selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Blog record);

	int updateByPrimaryKeyWithBLOBs(Blog record);

	int updateByPrimaryKey(Blog record);

	List<Blog> selectAll(@Param("startpage") Integer startpage, @Param("number") Integer number);

	List<Blog> selectBlogByTitle(String searchtitle);

	List<Blog> selectBlogByTypeId(@Param("searchtypeid") String searchtypeid, @Param("startpage") Integer startpage, @Param("number") Integer number);

	List<Blog> selectBlogByRecommend(@Param("searchrecommend") String searchrecommend);

	int selectBlogCount();

	List<Blog> getAllBlog();

	List<Blog> getAllSimpleBlog();

	List<Blog> selectBlogOrderByCreateTime();

	int addView(Long id);

	int addAdmire(Long id);

	int UpdateDeleteStateById(Long id);

	List<Blog> selectBlogByrecycle();

	int selectBlogByrecycleId(@Param("id") Long id);

	int UpdateRecoverStateById(Long id);

	List<Blog> selectBlogByTypeIdNoPage(String searchtypeid);

	int selectBlogCountByTypeId(int id);

	List<Blog> selectBlogOrderByCreateTimeLimit(@Param("range") Integer range);

	List<Blog> selectBlogByTitleEnlargeRange(String searchtitle);

	List<Blog> selectBlogBySql(String sql);

	int UpdateMultipleDeleteStateById(@Param("ids") Long[] ids);

	List<Blog> selectBlogByRecordLife();

	//回收站的查询功能
	List selectBlogByTitleFromRecycle(@Param("searchtitle") String searchtitle, @Param("typeid") String typeid, @Param("recommend") String recommend);

	String selectBlogOriginalContent(Integer id);

	int updateSortById(@Param("id") Integer id, @Param("sort") Integer sort);

	List<Blog> selectAllBlogOnlySort(@Param("startpage") Integer startpage, @Param("number") Integer number);

	List<Blog> selectAllBlogByTypeId(String searchtypeid);
}
