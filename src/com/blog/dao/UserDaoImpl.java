package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDAO
{

	@Override
	public void add(User user)
	{
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(User user)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List queryAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryByID(String username)
	{
		List list = this.getHibernateTemplate().find("select user from User user where user.username='"+username+"'");
		if (list.size()==0)
		{
			return null;
		}else {
			return (User) list.get(0);
		}
		
	}

}
