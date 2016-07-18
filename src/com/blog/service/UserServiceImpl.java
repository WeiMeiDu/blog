package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.po.User;

public class UserServiceImpl implements UserService
{
	private UserDAO userDAO;


	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	@Override
	public boolean registerUser(User user)
	{
		//�ж��û��Ƿ����
		if (userDAO.queryByID(user.getUsername())!=null)
		{
			return false;
		}else {
			userDAO.add(user);
			return true;
		}
	}
	@Override
	public boolean loginUser(User user)
	{
		//�ж��û��Ƿ����
		if (userDAO.queryByID(user.getUsername())==null)
		{
			return false;
		}else {
			User queryUser = userDAO.queryByID(user.getUsername());
			if(queryUser.getPassword().equals(user.getPassword()))
			{
				return true;
			}else {
				return false;
			}
			
		}
			
		
	}

	
}
