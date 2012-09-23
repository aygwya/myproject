package com.blog.common.util;
public abstract class PageBean {
	
	public static final int DEFAULT_PAGESIZE = 20;
	protected int pagesize=20;
	protected int pageno;
	protected long totalCount;
	protected long totalPage;
	
	public PageBean(int pageno) {
		//Assert.isTrue(pageno>0,"pageno must be greater than zero");
		this.pageno=pageno<1?1:pageno;
	}
	
	public PageBean(int pageno,int pagesize) {
		//Assert.isTrue(pageno>0,"pageno must be greater than zero");
		//Assert.isTrue(pagesize>0,"pagesize must be greater than zero");
		this(pageno);
		this.pagesize=pagesize<1?DEFAULT_PAGESIZE:pagesize;
	}
	
	public int getPageno() {
		return pageno;
	}
		
	public int getPagesize() {
		return pagesize;
	}

	public long getTotalPage() {			
		return totalPage;
	}
	
	public int getNextPage() {
		if (hasNextPage()) {
			return pageno + 1;
		}
		return pageno;
	}
	
	public int getPrevPage(){
		if(hasPrevPage()){
			return pageno-1;
		}
		return pageno;
	}

	public boolean hasPrevPage(){
		return pageno>1;
	}

	public boolean hasNextPage() {
		return pageno < totalPage;
	}

	
	public long getTotalCount(){
		return totalCount;
	}
	
	public void setTotalCount(long totalCount){
		if(totalCount%this.pagesize==0) {
			this.totalPage=totalCount/this.pagesize;
		}else{
			this.totalPage=(totalCount-totalCount%this.pagesize)/this.pagesize+1;
		}
		this.totalCount=totalCount;
	}
	
	public int getStartIndex(){
		return pagesize*(pageno-1);
	}
	
	public int getEndIndex(){
		return pageno*pagesize;
	}
	
	public abstract String getPageInfo();
	public abstract void setPageNum(String url);
	public abstract String getPageNum();
}
