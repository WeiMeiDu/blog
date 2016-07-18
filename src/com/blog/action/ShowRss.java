package com.blog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;
import com.blog.rss.CreateRss;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

/*
 * �����ݿ��л��������Ϣ
 * 
 */
public class ShowRss extends ActionSupport
{
	private ArticleService articleService;

	public ArticleService getArticleService()
	{
		return articleService;
	}

	public void setArticleService(ArticleService articleService)
	{
		this.articleService = articleService;
	}

	@Override
	public String execute() throws Exception
	{
		// ͨ������ҵ���߼��������ɲ�ѯ
		Page page = new Page();
		page.setCurrentPage(0);
		page.setEveryPage(5);
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		//������½����
		List<Article> all = result.getList();
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/rss.xml");
		CreateRss.publishRss(all, filePath);
		return this.SUCCESS;
	}

}
