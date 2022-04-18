package com.myblog.blog.service;

import com.myblog.blog.dao.BlogMapper;
import com.myblog.blog.model.Blog;
import com.myblog.blog.model.Pager;
import com.myblog.blog.model.SearchBlog;
import com.myblog.blog.utility.MarkdownUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName:BlogServiceImp
 * Package:com.myblog.blog.service
 * Description:
 *
 * @Date:2020/7/26 1:30
 * @com.chuangmei
 */
@Service
public class BlogServiceImp implements BlogService {

	@Resource
	private BlogMapper blogDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer setBlogInsert(Blog blog) {

		//给博客插入创建时间和更新时间
		if (blog != null) {
			blog.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			blog.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()));
			//是否在回收站的状态为假
			blog.setRecycle(false);
			//没选中默认值
			this.defaultvalue(blog);
			blog.setView(0);
		}

		//调用dao层插入
		Integer count = blogDao.insertSelective(blog);

		return count;
	}

	//查询出所有的博客
	@Override
	public List<Blog> getAllBlog(Pager pager) {

		//分页查询
		List<Blog> blogs = blogDao.selectAll((pager.getStartpage() - 1) * pager.getDATA_NUMBER(), pager.getDATA_NUMBER());

		return blogs;
	}

	public List<Blog> getAllBlog() {

		List<Blog> blogs = blogDao.getAllSimpleBlog();

		return blogs;
	}


	/*直接把content转换成html*/
	@Override
	public Blog getBlogByIdAndConvert(String id) {

		//修改view
		blogDao.addView(Long.valueOf(id));
		//查询blog
		Blog blog = blogDao.selectByPrimaryKey(Long.valueOf(id));
		//设置view
		blog.setView(blog.getView());

		//转换成html
		if (blog != null) {
			blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
		}

		return blog;
	}

	/*以markdown的格式content*/
	@Override
	public Blog getBlogById(String id) {
		//查询blog
		Blog blog = blogDao.selectByPrimaryKey(Long.valueOf(id));

		return blog;
	}

	//修改博客
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer setBlogUpdate(Blog blog) {

		//给博客插入创建时间和更新时间
		if (blog != null) {
			blog.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			//没选中默认值
			defaultvalue(blog);
		}

		int count = blogDao.updateByPrimaryKeySelective(blog);

		return count;
	}

	private Blog defaultvalue(Blog blog) {
		if (blog.getRecommend() == null)
			blog.setRecommend(false);
		if (blog.getReprint() == null)
			blog.setReprint(false);
		if (blog.getStick() == null)
			blog.setStick(false);
		if (blog.getSupportreview() == null)
			blog.setSupportreview(false);
		if (blog.getAdmire() == null)
			blog.setAdmire(false);
		if (blog.getRecordlife() == null)
			blog.setRecordlife(false);
		return blog;
	}

	//删除博客通过id
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteBlogById(Long id) {

		int count = blogDao.deleteByPrimaryKey(id);

		return count;
	}

	//通过title查询blog
	@Override
	public List queryBlogByTitle(String searchtitle, boolean enlargeRange) {

		//创建list集合
		List<Blog> blogs = null;

		//查询
		if (enlargeRange)
			blogs = blogDao.selectBlogByTitleEnlargeRange(searchtitle);
		else
			blogs = blogDao.selectBlogByTitle(searchtitle);

		return blogs;
	}

	//通过typeid查询
	@Override
	public List<Blog> queryBlogByTypeId(String searchtypeid, Pager pager) {

		//查询
		List<Blog> blogs = blogDao.selectBlogByTypeId(searchtypeid, (pager.getStartpage() - 1) * pager.getDATA_NUMBER(), pager.getDATA_NUMBER());

		return blogs;
	}

	@Override
	public List<Blog> queryAllBlogByTypeId(String searchtypeid) {


		return blogDao.selectAllBlogByTypeId(searchtypeid);
	}

	@Override
	public int addAdmire(Long blogid) {

		return blogDao.addAdmire(blogid);
	}

	@Override
	public List<Blog> queryBlogByTypeId(String searchtypeid) {
		//查询
		List<Blog> blogs = blogDao.selectBlogByTypeIdNoPage(searchtypeid);
		return blogs;
	}

	//通过recommend查询
	@Override
	public List<Blog> queryBlogByRecommend(String searchrecommend) {

		//查询
		List<Blog> blogs = blogDao.selectBlogByRecommend(searchrecommend);

		return blogs;
	}

	//查询博客总数
	@Override
	public int queryBlogCount() {
		int count = blogDao.selectBlogCount();
		return count;
	}

	//查询通过创建日期排序
	@Override
	public List<Blog> queryBlogOrderByCreateTime() {

		//查询
		List<Blog> blogs = blogDao.selectBlogOrderByCreateTime();

		return blogs;
	}

	//编辑博客的保存功能
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int setBlogUpdateNoDefault(Blog blog) {

		//修改
		int count = blogDao.updateByPrimaryKeySelective(blog);

		return count;
	}

	//放入回收站
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int changeDeleteStateById(Long id) {
		//修改存在状态
		int count = blogDao.UpdateDeleteStateById(id);
		return count;
	}

	//跳转到回收站,查询出博客
	@Override
	public List<Blog> queryBlogByrecycle() {

		//查询出在回收站的博客
		List<Blog> blogs = blogDao.selectBlogByrecycle();

		return blogs;
	}

	@Override
	public int queryBlogByrecycle(Long id) {
		return blogDao.selectBlogByrecycleId(id);
	}

	//恢复博客
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int modifyBlogRecover(Long id) {

		return blogDao.UpdateRecoverStateById(id);
	}

	/*根据typeid查询博客数量,用于分类页面分页*/
	@Override
	public int queryBlogCountByTypeId(int id) {

		return blogDao.selectBlogCountByTypeId(id);
	}

	/*限定范围查询*/
	@Override
	public List<Blog> queryBlogOrderByCreateTimeLimit(Integer range) {
		return blogDao.selectBlogOrderByCreateTimeLimit(range);
	}

	//自定义查询
	@Override
	public List<Blog> queryBlogBySql(String sql) {
		return blogDao.selectBlogBySql(sql);
	}

	/*批量删除博客*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int deleteMultipleBlogById(Long[] ids) {
		return blogDao.UpdateMultipleDeleteStateById(ids);
	}

	/*记录生活*/
	@Override
	public List<Blog> queryBlogByRecordLife() {

		//blogs
		List<Blog> blogs = blogDao.selectBlogByRecordLife();

		for (Blog blog : blogs) {
			blog.setCreatetime(blog.getCreatetime().replace('-', ' '));
		}

		return blogs;
	}

	/*查询回收站*/
	public List queryBlogByTitleFromRecycle(SearchBlog search) {
		if ("on".equals(search.getSearchrecommend())) search.setSearchrecommend("1");
		else search.setSearchrecommend("0");
		return blogDao.selectBlogByTitleFromRecycle(search.getSearchtitle(), search.getSearchtypeid(), search.getSearchrecommend());
	}

	@Override
	public String queryBlogOriginalContent(Integer id) {

		return blogDao.selectBlogOriginalContent(id);
	}

	@Override
	public int modifySortById(Integer id, Integer sort) {

		return blogDao.updateSortById(id, sort);
	}

	@Override
	public List<Blog> queryAllBlogOnlySort(Pager pager) {
		//分页查询
		List<Blog> blogs = blogDao.selectAllBlogOnlySort((pager.getStartpage() - 1) * pager.getDATA_NUMBER(), pager.getDATA_NUMBER());
		return blogs;
	}

}
