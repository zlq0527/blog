package com.myblog.blog.model;

public class Comment {
	private Long id;

	private String content;

	private String avatar;

	private String createtime;

	private String email;

	private String nickname;

	private Long blogid;

	private Long parentid;

	private Boolean admincomment;

	private Blog blog;

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

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", content='" + content + '\'' +
				", avatar='" + avatar + '\'' +
				", createtime='" + createtime + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", blogid=" + blogid +
				", parentid=" + parentid +
				", admincomment=" + admincomment +
				", blog=" + blog +
				'}';
	}
}
