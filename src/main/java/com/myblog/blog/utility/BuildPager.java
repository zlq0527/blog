package com.myblog.blog.utility;

import com.myblog.blog.model.Pager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:BuildPager
 * Package:com.myblog.blog.utility
 * Description:
 *
 * @Date:2020/8/2 22:54
 * @com.chuangmei
 */
public class BuildPager {


	//不指定条数,默认5
	public static Pager biuldPager(int total, Integer startpage) {

		return biuldPager(total, startpage, 5);
	}

	/*自定义每页显示条数 number*/
	public static Pager biuldPager(int total, Integer startpage, int number) {

		//创建pager
		Pager pager = new Pager();
		pager.setTotalpage(total);
		pager.setStartpage(startpage);
		pager.setDATA_NUMBER(number);
		//页数
		//如果每页展示的条数==总条数那么返回1页
		if (total == number)
			pager.setPagequantity(1);
			//如果为0则刚好承载
		else if (total % number == 0)
			pager.setPagequantity(total / number);
			//需要添加一页进行承载
		else
			pager.setPagequantity((total / number) + 1);

		//获取pages
		pager.setPages(getNumber(startpage, pager.getPagequantity()));

		return pager;
	}

	// 生成页
	public static List<Integer> getNumber(Integer startpage, int totalpage) {

		List<Integer> pages = new ArrayList<>(6);
		int totalPage = totalpage;

		int pageNumber = 6;

		// 当前页小于5 先取前(排除首页和当前页) , 再取后
		if (startpage < 5) {
			int prepage = startpage;
			int nextpage = startpage;
			for (int i = 0; i < pageNumber; i++) {
				if ((prepage - 1) > 1) {
					prepage--;
					pages.add(prepage);
				} else {
					nextpage++;
					if (nextpage < totalPage) {
						pages.add(nextpage);
					}
				}
			}
		} else if (startpage >= 5 && startpage <= (totalPage - 5)) {
			// 如果当前页大于4 并且 小于总页数-4 取前三 后三
			int plus = 1;
			int minus = 1;
			for (int i = 1; i <= pageNumber; i++) {
				if (i <= pageNumber / 2) {
					pages.add(startpage - minus);
					minus++;
				} else {
					pages.add(startpage + plus);
					plus++;
				}
			}
		} else {    // 尽量取后(排除最后一页和当前页)
			int prepage = startpage;
			int nextpage = startpage;
			for (int i = 0; i < pageNumber; i++) {
				if (nextpage < totalPage - 1) {
					nextpage++;
					pages.add(nextpage);
				} else {
					if ((prepage - 1) >= 1) {
						prepage--;
						pages.add(prepage);
					}
				}
			}
		}

		//排序
		Collections.sort(pages);

		return pages;
	}

	public static void main(String[] args) {
		//List<Integer> pages = getNumber(21, 21);
//        for (Integer page : pages) {
//            System.out.println(page);
//        }
	}

	/**
	 * Static方法是类方法，先于任何的实例（对象）存在。即Static方法在类加载时就已经存在了（JAVA虚拟机初始化时），
	 * 但是对象是在创建时才在内存中生成。而this指代的是当前的对象。
	 */

}
