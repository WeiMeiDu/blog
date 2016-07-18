package com.blog.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.fenye.Page;
import com.blog.po.Article;

public class ArticleDAOImpl extends HibernateDaoSupport implements ArticleDAO
{

	@Override
	public void add(Article article)
	{
		this.getHibernateTemplate().saveOrUpdate(article);;
	}

	@Override
	public List<Article> queryUserAll(String username)
	{
		String sql = "select art from Article art where art.username=?";
		List<Article> list = this.getHibernateTemplate().find(sql,username);
		return list;
	}

	@Override
	public int queryUserAllCount(String username)
	{
		String sql = "select count(*) from Article art where art.username=?";
		List list = this.getHibernateTemplate().find(sql,username);
		return ((Long)list.get(0)).intValue();
	}

	@Override
	public List<Article> queryByPage(String username, Page page)
	{
		return this.getHibernateTemplate().executeFind(new HibernateCallback()
		{
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException
			{
				String sql = "select art from Article art where art.username=? order by art.date desc";
				Query query = session.createQuery(sql);
				//设置参数
				query.setParameter(0, username);
				//设置每页显示多少个，设置最大结果
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				
				return query.list();
			}
		});
	}

	@Override
	public int queryAllCount()
	{
		String sql = "select count(*) from Article art";
		List list = this.getHibernateTemplate().find(sql);
		return ((Long)list.get(0)).intValue();
	}

	@Override
	public List<Article> queryAllByPage(Page page)
	{
		return this.getHibernateTemplate().executeFind(new HibernateCallback()
		{
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException
			{
				String sql = "select art from Article art order by art.date desc";
				Query query = session.createQuery(sql);
				
				//设置每页显示多少个，设置最大结果
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				
				return query.list();
			}
		});
	}

	@Override
	public Article queryById(int id)
	{
		String sql = "select art from Article art where art.id=?";
		List<Article> list = this.getHibernateTemplate().find(sql,id);
		return list.get(0);
		
	}
	
}
