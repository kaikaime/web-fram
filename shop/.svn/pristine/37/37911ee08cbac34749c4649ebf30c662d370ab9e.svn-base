package com.shop.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PagePojo<T> {
	private int totalNumber=-1;//当前表中总条目数量  
    private int currentPage;//当前页的位置  
    private int totalPage;//总页数  
    private int pageSize;//页面大小  
    private int startIndex;//检索的起始位置  
    private int totalSelect;//检索的总数目  
    private int isLimit = 1;
    private List<T> list;
    private String with;
    private String nick;
    
    public String getNick() {
		return nick;
	}
    public void setNick(String nick) {
		this.nick = nick;
	}
    public String getWith() {
		return with;
	}
    public void setWith(String with) {
		this.with = with;
	}
    public void setIsLimit(int isLimit) {
		this.isLimit = isLimit;
	}
    public int getIsLimit() {
		return isLimit;
	}
   
    
    public List<T> getList() {
		return list;
	}
    public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalSelect() {
		return totalSelect;
	}
	public void setTotalSelect(int totalSelect) {
		this.totalSelect = totalSelect;
	}
	
   public void setPageSizeAndCurrentPage(int pageSize,int currentPage){
	   this.setPageSize(pageSize);
	   this.setCurrentPage(currentPage);
	   //this.count();
	  
   }
   public void count() {
		//計算出頁面總數
		int totalPages = totalNumber%pageSize==0?totalNumber/pageSize:totalNumber/pageSize+1;
		//沒有查詢出一條數據
		if(totalPages<=0){
			totalPages = 1;
			currentPage=1;
		}
		//最小邊界判斷
		if(currentPage<1){
			currentPage=1;
		}
		//最大邊界判斷
		if(currentPage>totalPages){
			currentPage=totalPages;
		}
		totalPage = totalPages;
		//起始位置
		startIndex=(currentPage-1)*pageSize;
		totalSelect = totalNumber;
	}

   /*
    * 开始进行分页计算
    */
   public void jiSuanFenYe(){
	   this.count();
   }
    
}
