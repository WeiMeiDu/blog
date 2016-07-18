package com.blog.service;

import com.blog.po.BlogInfo;

public interface BlogInfoService
{
	//设置博客个性化
	public void setBlogInfo(BlogInfo blogInfo);
	
	//获取博客个性化内容
	public BlogInfo getBlogInfo(String username);
}
