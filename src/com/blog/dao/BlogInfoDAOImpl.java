package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO
{
	/**
	 * HibernateDaoSupport����������һ��HibernateTemplate��һ�����ã�
	 * ���п���ʹ��this.getHibernateTemplate()�����HibernateTemplate��ʵ��
	 * 
	 * ��Ҫ��applicationContext.xml�ļ��н���ע�룬��HibernateTemplateʵ��ע�뵽DAO��
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
