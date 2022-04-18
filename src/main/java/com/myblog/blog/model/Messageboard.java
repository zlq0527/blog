package com.myblog.blog.model;

import java.util.List;

public class Messageboard {
	private Long id;

	private String avatar;

	private String content;

	private String createtime;

	private String email;

	private String nickname;

	private Integer parentid;

	private boolean admin;

	private String parentname;

	//子回复
	private List<Messageboard> sonMessage;

	//parent
	Messageboard parentMessage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public List<Messageboard> getSonMessage() {
		return sonMessage;
	}

	public void setSonMessage(List<Messageboard> sonMessage) {
		this.sonMessage = sonMessage;
	}

	public Messageboard getParentMessage() {
		return parentMessage;
	}

	public void setParentMessage(Messageboard parentMessage) {
		this.parentMessage = parentMessage;
	}

	@Override
	public String toString() {
		return "Messageboard{" +
				"id=" + id +
				", avatar='" + avatar + '\'' +
				", content='" + content + '\'' +
				", createtime='" + createtime + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", parentid=" + parentid +
				", admin='" + admin + '\'' +
				", parentname='" + parentname + '\'' +
				", sonMessage=" + sonMessage +
				", parentMessage=" + parentMessage +
				'}';
	}
}
