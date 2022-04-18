package com.myblog.blog.model;

public class Project {
	private Long id;

	private String pPictureUrl;

	private String pDescription;

	private String pLinkUrl;

	private String pTitle;

	private String pTag;

	private String pOnlineLink;

	public Project() {
	}

	public Project(Long id, String pPictureUrl, String pDescription, String pLinkUrl, String pTitle, String pTag, String pOnlineLink) {
		this.id = id;
		this.pPictureUrl = pPictureUrl;
		this.pDescription = pDescription;
		this.pLinkUrl = pLinkUrl;
		this.pTitle = pTitle;
		this.pTag = pTag;
		this.pOnlineLink = pOnlineLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getpPictureUrl() {
		return pPictureUrl;
	}

	public void setpPictureUrl(String pPictureUrl) {
		this.pPictureUrl = pPictureUrl;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpLinkUrl() {
		return pLinkUrl;
	}

	public void setpLinkUrl(String pLinkUrl) {
		this.pLinkUrl = pLinkUrl;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpTag() {
		return pTag;
	}

	public void setpTag(String pTag) {
		this.pTag = pTag;
	}

	public String getpOnlineLink() {
		return pOnlineLink;
	}

	public void setpOnlineLink(String pOnlineLink) {
		this.pOnlineLink = pOnlineLink;
	}

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", pPictureUrl='" + pPictureUrl + '\'' +
				", pDescription='" + pDescription + '\'' +
				", pLinkUrl='" + pLinkUrl + '\'' +
				", pTitle='" + pTitle + '\'' +
				", pTag='" + pTag + '\'' +
				", pOnlineLink='" + pOnlineLink + '\'' +
				'}';
	}
}
