package com.myblog.blog.model;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:Pager
 * Package:com.myblog.blog.model
 * Description:
 *
 * @Date:2020/7/28 19:12
 * @com.chuangmei
 */
public class Pager {

	//每页展示条数,默认5
	private Integer DATA_NUMBER = 5;

	private Integer totalpage;

	private Integer startpage;

	private Integer pagequantity;

	private List<Integer> pages;

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public Integer getStartpage() {
		return startpage;
	}

	public void setStartpage(Integer startpage) {
		this.startpage = startpage;
	}

	public Integer getPagequantity() {
		return pagequantity;
	}

	public void setPagequantity(Integer pagequantity) {
		this.pagequantity = pagequantity;
	}

	public Integer getDATA_NUMBER() {
		return DATA_NUMBER;
	}

	public void setDATA_NUMBER(Integer DATA_NUMBER) {
		this.DATA_NUMBER = DATA_NUMBER;
	}

	public Pager() {
	}

	public Pager(Integer DATA_NUMBER, Integer totalpage, Integer startpage, Integer pagequantity, List<Integer> pages) {
		this.DATA_NUMBER = DATA_NUMBER;
		this.totalpage = totalpage;
		this.startpage = startpage;
		this.pagequantity = pagequantity;
		this.pages = pages;
	}


	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Pager{" +
				"DATA_NUMBER=" + DATA_NUMBER +
				", totalpage=" + totalpage +
				", startpage=" + startpage +
				", pagequantity=" + pagequantity +
				", pages=" + pages +
				'}';
	}
}
