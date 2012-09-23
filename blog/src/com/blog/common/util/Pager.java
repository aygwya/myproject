package com.blog.common.util;


public class Pager extends PageBean{
	
	private String pageNum;
	
	public Pager(int pageno) {
		super(pageno);
	}
	
	public Pager(int pageno,int pagesize) {
		super(pageno,pagesize);
	}
	
	public String getPageInfo(){
		StringBuilder sb=new StringBuilder();
		sb.append("共有 <b>").append(totalCount).append("</b> 记录  &nbsp; 分 <b>");
		sb.append(totalPage).append("</b> 页   &nbsp; 每页显示 <b>");
		sb.append(pagesize).append("</b> 条  &nbsp; 当前为第 <b><font color=#FF9900>");
		sb.append(pageno).append("</font></b> 页 ");
		return sb.toString();
	}
	
	@Override
	public void setPageNum(String url){
		StringBuilder sb=new StringBuilder();
		
		int p=0,i=0;
		
		if((pageno-1)%10==0){
			p=(pageno-1)/10;
		}else{
			p=(((pageno-1)-(pageno-1)%10)/10);
		}

		if (totalPage>1){
			sb.append("<div class=\"pager\">");
			sb.append("<a href=\""+url+"1\">&#171;</a>");
			
			if (p*10 > 0){
				sb.append("<a href=\""+url+(p*10)+"\">&#139;</a>");
			}else{
				sb.append("<a href=\""+url+((pageno-1)==0?1:(pageno-1))+"\">&#139;</a>");
			}
			for (i=p*10+1;i<p*10+11;i++){
				if (i==pageno){
					sb.append("<a href=\""+url+i+"\" class=\"active\">"+i+"</a>");
				}else{
					sb.append("<a href=\""+url+i+"\">"+i+"</a>");
				}
				if (i==totalPage) break;
			}

			if (i<totalPage){
				sb.append("<a href=\""+url+i+"\">&#155;</a>");
			}else{
				sb.append("<a href=\""+url+((pageno+1)>totalPage?totalPage:(pageno+1))+"\">&#155;</a>");
			}
			
			sb.append("<a href=\""+url+totalPage+"\">&#187;</a>");
			sb.append("</div>");
		}
		this.pageNum=sb.toString();
	}


	@Override
	public String getPageNum() {
		return this.pageNum;
	}
}
