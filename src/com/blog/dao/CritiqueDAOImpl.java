package com.blog.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.fenye.Page;
import com.blog.po.Critique;

public class CritiqueDAOImpl extends HibernateDaoSupport implements CritiqueDAO
{

	@Override
	public void addCritique(Critique critique)
	{
		this.getHibernateTemplate().save(critique);
	}

	@Override
	public int queryCritiqueCount(int AId)
	{
		String sql = "select count(*) from Critique criti where criti.AId=?";
		List list = this.getHibernateTemplate().find(sql,AId);
		return ((Long)list.get(0)).intValue();
	}

	@Override
	public List<Critique> queryByPage(int AId, Page page)
	{
		return this.getHibernateTemplate().executeFind(new HibernateCallback()
		{
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException
			{
				String sql = "select cri from Critique cri where cri.AId=?";
				Query query = session.createQuery(sql);
				query.setParameter(0, AId);
				//设置每页显示多少个，设置最大结果
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				
				return query.list();
			}
		});
	}

}
