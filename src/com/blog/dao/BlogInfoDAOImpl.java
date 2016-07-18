package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO
{
	/**
	 * HibernateDaoSupport这个类包含了一个HibernateTemplate的一个引用，
	 * 所有可以使用this.getHibernateTemplate()来获得HibernateTemplate的实例
	 * 
	 * 需要在applicationContext.xml文件中进行注入，将HibernateTemplate实例注入到DAO中
	 * 
	 */
	
	@Override
	public void save(BlogInfo info)
	{
		this.getHibernateTemplate().saveOrUpdate(info);
	}

	@Override
	public BlogInfo get(String username)
	{
		
		String sql = "select bloginfo from BlogInfo bloginfo where username=?";
		List list = this.getHibernateTemplate().find(sql,username);
		if (list.size()==0)
		{
			return null;
		}else {
			return (BlogInfo) list.get(0);
		}
		
	}
	
	
	
	
}
