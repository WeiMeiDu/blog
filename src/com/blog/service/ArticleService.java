package com.blog.service;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;

public interface ArticleService
{
	//�������µı���
	public void addArticle(Article article);
	//ȡ���û����е�����
	public List<Article> showUserAllArticle(String username);
	//��ҳ��ʾ�û�����
	public Result showUserArticlePage(String username,Page page);
	//��ҳ��ʾȫ������
	public Result showArticleByPage(Page page);
	//��id��ʾ��������
	public Article showArticle(int id);
	//���������
	public int getCritiqueCount(int AId);
}
