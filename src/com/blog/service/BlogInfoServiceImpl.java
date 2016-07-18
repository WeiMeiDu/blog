package com.blog.service;

import com.blog.dao.BlogInfoDAO;
import com.blog.po.BlogInfo;

public  class BlogInfoServiceImpl implements BlogInfoService
{
	private BlogInfoDAO blogInfoDAO;

	
	public BlogInfoDAO getBlogInfoDAO()
	{
		return blogInfoDAO;
	}

	public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO)
	{
		this.blogInfoDAO = blogInfoDAO;
	}

	@Override
	public void setBlogInfo(BlogInfo blogInfo)
	{
		//ͨ������DAO��������
		blogInfoDAO.save(blogInfo);
	}

	@Override
	public BlogInfo getBlogInfo(String username)
	{
		return blogInfoDAO.get(username);
	}
	
}
