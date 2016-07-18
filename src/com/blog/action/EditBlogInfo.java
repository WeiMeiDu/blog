package com.blog.action;

import java.util.Map;



import com.blog.po.BlogInfo;
import com.blog.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditBlogInfo extends ActionSupport
{
	// 字段名与页面中的名称相同
	private String blogtitle;
	private String idiograph;

	// 添加业务逻辑组件类型属性
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService()
	{
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService)
	{
		this.blogInfoService = blogInfoService;
	}

	public String getBlogtitle()
	{
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle)
	{
		this.blogtitle = blogtitle;
	}

	public String getIdiograph()
	{
		return idiograph;
	}

	public void setIdiograph(String idiograph)
	{
		this.idiograph = idiograph;
	}

	@Override
	public String execute() throws Exception
	{

		// * 通过获取request再获取session
		// * 获得request
		// * HttpServletRequest request = ServletActionContext.getRequest();
		// * 获得session
		// * HttpSession session = request.getSession();
		// * 获得username
		// String username = (String) session.getAttribute("username");

		// 直接获取session
		Map session = ActionContext.getContext().getSession();
		// 获得username
		String username = (String) session.get("username");

		BlogInfo blogInfo = new BlogInfo();
		// 设置用户名
		blogInfo.setUsername(username);
		// 设置博客标题
		blogInfo.setBlogtitle(blogtitle);
		// 设置博客签名
		blogInfo.setIdiograph(idiograph);
		// 调用业务逻辑组件来完成个性化设置
		blogInfoService.setBlogInfo(blogInfo);

		return SUCCESS;
	}

}
