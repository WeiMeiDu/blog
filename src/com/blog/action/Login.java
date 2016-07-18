package com.blog.action;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.po.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
{
	private String username;
	private String password;
	// 注册业务逻辑属性
	private UserService userService;

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String execute() throws Exception
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 获得request
		HttpServletRequest request = ServletActionContext.getRequest();
		if (userService.loginUser(user))
		{
			request.setAttribute("url", "user/getBlogInfo.action");
			request.setAttribute("info", "登录成功");
			// 将username保存到session范围中
			/*
			 * 通过request获得session HttpSession session = request.getSession();
			 * session.setAttribute("username", username);
			 */
			// 直接获得session
			Map session = ActionContext.getContext().getSession();
			
			session.put("username", username);
			return SUCCESS;
		} else
		{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "登录失败");
			return ERROR;
		}
	}

}
