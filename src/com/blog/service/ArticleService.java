package com.blog.service;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;

public interface ArticleService
{
	//进行文章的保存
	public void addArticle(Article article);
	//取出用户所有的文章
	public List<Article> showUserAllArticle(String username);
	//分页显示用户文章
	public Result showUserArticlePage(String username,Page page);
	//分页显示全部文章
	public Result showArticleByPage(Page page);
	//按id显示文章内容
	public Article showArticle(int id);
	//获得评论数
	public int getCritiqueCount(int AId);
}
