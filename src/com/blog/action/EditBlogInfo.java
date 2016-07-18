package com.blog.action;

import java.util.Map;



import com.blog.po.BlogInfo;
import com.blog.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditBlogInfo extends ActionSupport
{
	// �ֶ�����ҳ���е�������ͬ
	private String blogtitle;
	private String idiograph;

	// ���ҵ���߼������������
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

		// * ͨ����ȡrequest�ٻ�ȡsession
		// * ���request
		// * HttpServletRequest request = ServletActionContext.getRequest();
		// * ���session
		// * HttpSession session = request.getSession();
		// * ���username
		// String username = (String) session.getAttribute("username");

		// ֱ�ӻ�ȡsession
		Map session = ActionContext.getContext().getSession();
		// ���username
		String username = (String) session.get("username");

		BlogInfo blogInfo = new BlogInfo();
		// �����û���
		blogInfo.setUsername(username);
		// ���ò��ͱ���
		blogInfo.setBlogtitle(blogtitle);
		// ���ò���ǩ��
		blogInfo.setIdiograph(idiograph);
		// ����ҵ���߼��������ɸ��Ի�����
		blogInfoService.setBlogInfo(blogInfo);

		return SUCCESS;
	}

}
