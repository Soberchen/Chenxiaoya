package com.chen.entity;

import java.util.List;

public class Page<T> {
	private int totalPageCount=0;
	
	private int baseSize=5;
	private int pageSize=baseSize;//页面大小，每页显示记录数
	public int getBaseSize() {
		return baseSize;
	}
	public void setBaseSize(int baseSize) {
		this.baseSize = baseSize;
	}
	private int totalCount=0;
	private int currPageNo=1;
	private List<T> newlist;
	private boolean ifFirst;
	private boolean ifLast;
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0){
		this.pageSize = pageSize;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		
		if(totalCount<=0){
			this.totalCount =0;
			this.totalPageCount=0;
			ifFirst=false;
			ifLast=false;
			
		}else {
			//计算总页数
			this.totalCount = totalCount;
			totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
			ifFirst=this.currPageNo==1;
		    ifLast=this.currPageNo==this.totalPageCount;
		    
		}
		
	}
	public boolean getIfFirst() {
		return ifFirst;
	}
	public void setIfFirst(boolean ifFirst) {
		this.ifFirst = ifFirst;
	}
	public boolean getIfLast() {
		return ifLast;
	}
	public void setIfLast(boolean ifLast) {
		this.ifLast = ifLast;
	}
	public int getCurrPageNo() {
		if(totalPageCount==0){
			return 0;
		}
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		if(currPageNo>0){
			this.currPageNo = currPageNo;
		}
		
	}
	public List<T> getNewlist() {
		return newlist;
	}
	public void setNewlist(List<T> newlist) {
		this.newlist = newlist;
	}

}
