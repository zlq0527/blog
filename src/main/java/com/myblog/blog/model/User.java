package com.myblog.blog.model;

import java.util.Date;

public class User {
	private Long id;

	private String avatar;

	private Date creatTime;

	private String email;

	private String nickName;

	private String password;

	private Integer type;

	private Date updateTime;

	private String username;

	private String description;

	private String pagetitle;

	private String cardtitle;

	private String firstPicture;

	private String theme;

	private String searchBg;

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

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPagetitle() {
		return pagetitle;
	}

	public void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}

	public String getCardtitle() {
		return cardtitle;
	}

	public void setCardtitle(String cardtitle) {
		this.cardtitle = cardtitle;
	}

	public String getFirstPicture() {
		return firstPicture;
	}

	public void setFirstPicture(String firstPicture) {
		this.firstPicture = firstPicture;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSearchBg() {
		return searchBg;
	}

	public void setSearchBg(String searchBg) {
		this.searchBg = searchBg;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", avatar='" + avatar + '\'' +
				", creatTime=" + creatTime +
				", email='" + email + '\'' +
				", nickName='" + nickName + '\'' +
				", password='" + password + '\'' +
				", type=" + type +
				", updateTime=" + updateTime +
				", username='" + username + '\'' +
				", description='" + description + '\'' +
				", pagetitle='" + pagetitle + '\'' +
				", cardtitle='" + cardtitle + '\'' +
				", firstPicture='" + firstPicture + '\'' +
				", theme='" + theme + '\'' +
				", searchBg='" + searchBg + '\'' +
				'}';
	}
}
