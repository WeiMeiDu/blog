package com.blog.dao;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.po.Article;

public interface ArticleDAO
{
	//����һ��add����,�������沩������
	public void add(Article article);
	//����һ��queryUserAll������ȡ���û�����������
	public List<Article> queryUserAll(String username);
	//����û������ܼ�¼��
	public int queryUserAllCount(String username);
	//����ҳ��Ϣ��ѯ��¼
	public List<Article> queryByPage(String username,Page page);
	//����������µ��ܼ�¼��
	public int queryAllCount();
	//����ҳ��Ϣ��ѯ��¼
	public List<Article> queryAllByPage(Page page);
	//��id��ѯ����
	public Article queryById(int id);
}
