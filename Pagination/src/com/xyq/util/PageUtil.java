package com.xyq.util;

import java.util.List;

public class PageUtil {

	/**
	 * 1、总行数
	 */
	private int rowcount;
	/**
	 * 2、每页多少行
	 */
	private int pageSize;
	/**
	 * 3、当前页
	 */
	private int currentPage;
	/**
	 * 4、(每页的)导航个数
	 */
	private int navigationNumber;
	/**
	 * 5、每页的起始行
	 */
	private int startRow;
	/**
	 * 6、总页数
	 */
	private int navCount;
	/**
	 * 7、首页
	 */
	private int first;
	/**
	 * 8、上一页
	 */
	private int prev;
	/**
	 * 9、下一页
	 */
	private int next;
	/**
	 * 10、尾页
	 */
	private int last;
	/**
	 * 11、导航栏的起始数
	 */
	private int begin;
	/**
	 * 12、导航的结束数
	 */
	private int end;
	/**
	 * 13、分页的数据
	 */
	private List pageData;
	
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNavigationNumber() {
		return navigationNumber;
	}
	public void setNavigationNumber(int navigationNumber) {
		this.navigationNumber = navigationNumber;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getNavCount() {
		return navCount;
	}
	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List getPageData() {
		return pageData;
	}
	public void setPageData(List pageData) {
		this.pageData = pageData;
	}
	public PageUtil(int rowcount, int pageSize, int currentPage,
			int navigationNumber, int startRow, int navCount, int first,
			int prev, int next, int last, int begin, int end, List pageData) {
		this.rowcount = rowcount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.navigationNumber = navigationNumber;
		this.startRow = startRow;
		this.navCount = navCount;
		this.first = first;
		this.prev = prev;
		this.next = next;
		this.last = last;
		this.begin = begin;
		this.end = end;
		this.pageData = pageData;
	}
	public PageUtil() {}
	public PageUtil(int rowcount, int pageSize, int currentPage,
			int navigationNumber) {
		this.rowcount = rowcount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.navigationNumber = navigationNumber;
		
		//通过传过来的数据计算其他数据
		//1、每页的起始行
		this.startRow = (this.currentPage - 1) * this.pageSize;
		//2、总页数
		this.navCount = (int) Math.ceil(this.rowcount*1.0 / this.pageSize);
		//3、首页
		this.first = 1;
		//4、尾页
		this.last = this.navCount;
		//5、上一页
		this.prev = Math.max(this.currentPage - 1, 1);
		//6、下一页
		this.next = Math.min(this.currentPage + 1, this.last);
		//7、导航栏第一个位置的数(begin)
		this.begin = Math.max(this.currentPage - (this.navigationNumber/2), 1);
		//8、导航栏最后一个位置的数(end)
		this.end = Math.min(this.begin + this.navigationNumber - 1, this.last);
		//特殊情况处理
		if(this.end - this.begin < 9){
			this.begin = Math.max(this.end - 9, 1);
		}
	}
	
	
	
}
