package com.blog.service;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Critique;

public interface CritiqueService
{
	//�������
	public void addCritique(Critique critique);
	//��ҳ��ʾ����
	public Result showCritiqueByPage(int AId,Page page);
	
	
}
