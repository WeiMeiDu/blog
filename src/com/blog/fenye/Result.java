package com.blog.fenye;

import java.util.List;

import com.blog.po.Article;

public class Result
{
	private Page page;
	private List<Article> list;
	public Page getPage()
	{
		return page;
	}
	public void setPage(Page page)
	{
		this.page = page;
	}
	public List<Article> getList()
	{
		return list;
	}
	public void setList(List list)
	{
		this.list = list;
	}
	
	
}
