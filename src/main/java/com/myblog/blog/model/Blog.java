package com.myblog.blog.model;

import java.util.Date;
import java.util.Objects;

public class Blog {
	private Long id;

	private String firstpicture;

	private String createtime;

	private String updatetime;

	private Integer typeid;

	private Integer tagid;

	private String nature;

	private String title;

	private Integer view;

	private String description;

	private Boolean stick;

	private Boolean recommend;

	private Boolean reprint;

	private Boolean supportreview;

	private Boolean admire;

	private String content;

	private Boolean recycle;

	private Boolean recordlife;

	private Integer sort;

	//Type
	private Type type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstpicture() {
		return firstpicture;
	}

	public void setFirstpicture(String firstpicture) {
		this.firstpicture = firstpicture;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStick() {
		return stick;
	}

	public void setStick(Boolean stick) {
		this.stick = stick;
	}

	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

	public Boolean getReprint() {
		return reprint;
	}

	public void setReprint(Boolean reprint) {
		this.reprint = reprint;
	}

	public Boolean getSupportreview() {
		return supportreview;
	}

	public void setSupportreview(Boolean supportreview) {
		this.supportreview = supportreview;
	}

	public Boolean getAdmire() {
		return admire;
	}

	public void setAdmire(Boolean admire) {
		this.admire = admire;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Boolean getRecycle() {
		return recycle;
	}

	public void setRecycle(Boolean recycle) {
		this.recycle = recycle;
	}

	public Boolean getRecordlife() {
		return recordlife;
	}

	public void setRecordlife(Boolean recordlife) {
		this.recordlife = recordlife;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Blog blog = (Blog) o;
		return Objects.equals(id, blog.id) &&
				Objects.equals(firstpicture, blog.firstpicture) &&
				Objects.equals(createtime, blog.createtime) &&
				Objects.equals(updatetime, blog.updatetime) &&
				Objects.equals(typeid, blog.typeid) &&
				Objects.equals(tagid, blog.tagid) &&
				Objects.equals(nature, blog.nature) &&
				Objects.equals(title, blog.title) &&
				Objects.equals(view, blog.view) &&
				Objects.equals(description, blog.description) &&
				Objects.equals(stick, blog.stick) &&
				Objects.equals(recommend, blog.recommend) &&
				Objects.equals(reprint, blog.reprint) &&
				Objects.equals(supportreview, blog.supportreview) &&
				Objects.equals(admire, blog.admire) &&
				Objects.equals(content, blog.content) &&
				Objects.equals(recycle, blog.recycle) &&
				Objects.equals(recordlife, blog.recordlife) &&
				Objects.equals(sort, blog.sort) &&
				Objects.equals(type, blog.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstpicture, createtime, updatetime, typeid, tagid, nature, title, view, description, stick, recommend, reprint, supportreview, admire, content, recycle, recordlife, sort, type);
	}

	@Override
	public String toString() {
		return "Blog{" +
				"id=" + id +
				", firstpicture='" + firstpicture + '\'' +
				", createtime='" + createtime + '\'' +
				", updatetime='" + updatetime + '\'' +
				", typeid=" + typeid +
				", tagid=" + tagid +
				", nature='" + nature + '\'' +
				", title='" + title + '\'' +
				", view=" + view +
				", description='" + description + '\'' +
				", stick=" + stick +
				", recommend=" + recommend +
				", reprint=" + reprint +
				", supportreview=" + supportreview +
				", admire=" + admire +
				", content='" + content + '\'' +
				", recycle=" + recycle +
				", recordlife=" + recordlife +
				", sort=" + sort +
				", type=" + type +
				'}';
	}
}
