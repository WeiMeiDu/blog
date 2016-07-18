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
 * 从数据库中获得文章信息
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
		// 通过调用业务逻辑组件来完成查询
		Page page = new Page();
		page.setCurrentPage(0);
		page.setEveryPage(5);
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		//获得文章结果集
		List<Article> all = result.getList();
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/rss.xml");
		CreateRss.publishRss(all, filePath);
		return this.SUCCESS;
	}

}
