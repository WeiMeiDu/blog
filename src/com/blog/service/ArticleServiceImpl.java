package com.blog.service;

import java.util.List;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.fenye.Page;
import com.blog.fenye.PageUtil;
import com.blog.fenye.Result;
import com.blog.po.Article;

public class ArticleServiceImpl implements ArticleService
{
	private ArticleDAO articleDAO;
	private CritiqueDAO critiqueDAO;
	
	
	public CritiqueDAO getCritiqueDAO()
	{
		return critiqueDAO;
	}
	public void setCritiqueDAO(CritiqueDAO critiqueDAO)
	{
		this.critiqueDAO = critiqueDAO;
	}
	public ArticleDAO getArticleDAO()
	{
		return articleDAO;
	}
	public void setArticleDAO(ArticleDAO articleDAO)
	{
		this.articleDAO = articleDAO;
	}
	@Override
	public void addArticle(Article article)
	{
		articleDAO.add(article);
	}
	@Override
	public List<Article> showUserAllArticle(String username)
	{
		System.out.println(articleDAO.queryUserAllCount(username));
		return articleDAO.queryUserAll(username);
	}
	@Override
	public Result showUserArticlePage(String username, Page page)
	{
		page = PageUtil.createPage(page,articleDAO.queryUserAllCount(username));
		List<Article> all = articleDAO.queryByPage(username, page);
		/*≤‚ ‘
		 * for (Article art:all)
		{
			System.out.println(art.getId());
			System.out.println(art.getTitle());
			System.out.println(art.getUsername());
			System.out.println("--------------");
		}*/
		Result result = new Result();
		result.setList(all);
		result.setPage(page);
		return result;
	}
	@Override
	public Result showArticleByPage(Page page)
	{
		page = PageUtil.createPage(page,articleDAO.queryAllCount());
		List<Article> all = articleDAO.queryAllByPage(page);
		Result result = new Result();
		result.setList(all);
		result.setPage(page);
		return result;
	}
	@Override
	public Article showArticle(int id)
	{
		return articleDAO.queryById(id);
	}
	@Override
	public int getCritiqueCount(int AId)
	{
		return critiqueDAO.queryCritiqueCount(AId);
	}
	
}
