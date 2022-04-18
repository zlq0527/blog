package com.myblog.blog.model;

/**
 * ClassName:SearchBlog
 * Package:com.myblog.blog.model
 * Description:
 *
 * @Date:2020/7/27 22:01
 * @com.chuangmei
 */
public class SearchBlog {

	private String searchtitle;
	private String searchtypeid;
	private String searchrecommend;
	private String recognize = "default";

	public String getSearchtitle() {
		return searchtitle;
	}

	public void setSearchtitle(String searchtitle) {
		this.searchtitle = searchtitle;
	}

	public String getSearchtypeid() {
		return searchtypeid;
	}

	public void setSearchtypeid(String searchtypeid) {
		this.searchtypeid = searchtypeid;
	}

	public String getSearchrecommend() {
		return searchrecommend;
	}

	public String getRecognize() {
		return recognize;
	}

	public void setRecognize(String recognize) {
		this.recognize = recognize;
	}

	public void setSearchrecommend(String searchrecommend) {
		this.searchrecommend = searchrecommend;
	}


	@Override
	public String toString() {
		return "SearchBlog{" +
				"searchtitle='" + searchtitle + '\'' +
				", searchtypeid='" + searchtypeid + '\'' +
				", searchrecommend='" + searchrecommend + '\'' +
				", batchOPeration=" + recognize +
				'}';
	}
}
