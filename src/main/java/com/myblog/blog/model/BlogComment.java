package com.myblog.blog.model;

import javax.xml.stream.events.Comment;
import java.util.List;

public class BlogComment {
	private Long id;

	private String content;

	private String avatar;

	private String createtime;

	private String email;

	private String nickname;

	private Long blogid;

	private Long parentid;

	private Boolean admincomment;

	List<BlogComment> sonComment;

	//父级评论
	private BlogComment parentComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getBlogid() {
		return blogid;
	}

	public void setBlogid(Long blogid) {
		this.blogid = blogid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Boolean getAdmincomment() {
		return admincomment;
	}

	public void setAdmincomment(Boolean admincomment) {
		this.admincomment = admincomment;
	}

	public List<BlogComment> getSonComment() {
		return sonComment;
	}

	public void setSonComment(List<BlogComment> sonComment) {
		this.sonComment = sonComment;
	}

	public BlogComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(BlogComment parentComment) {
		this.parentComment = parentComment;
	}

	@Override
	public String toString() {
		return "BlogComment{" +
				"id=" + id +
				", content='" + content + '\'' +
				", avatar='" + avatar + '\'' +
				", createtime='" + createtime + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", blogid=" + blogid +
				", parentid=" + parentid +
				", admincomment=" + admincomment +
				", sonComment=" + sonComment +
				'}';
	}
}
