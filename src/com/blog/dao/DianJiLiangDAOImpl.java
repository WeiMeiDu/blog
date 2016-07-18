package com.blog.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.DianJiLiang;

public class DianJiLiangDAOImpl extends HibernateDaoSupport implements DianJiLiangDAO
{

	

	@Override
	public void addJiLu(DianJiLiang dianJiLiang)
	{
		this.getHibernateTemplate().save(dianJiLiang);
	}

	@Override
	public List queryById(int AId, String ip, Date time)
	{
		return this.getHibernateTemplate().executeFind(new HibernateCallback()
		{
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException
			{
				String sql = "select djl from DianJiLiang djl where djl.AId=? and djl.ip=? and djl.time=?";
				Query query = session.createQuery(sql);
				//…Ë÷√≤Œ ˝
				query.setParameter(0, AId);
				query.setParameter(1, ip);
				query.setParameter(2, time);
				
				
				return query.list();
			}
		});
	}
	
}
