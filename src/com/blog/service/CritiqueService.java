package com.blog.service;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Critique;

public interface CritiqueService
{
	//添加评论
	public void addCritique(Critique critique);
	//分页显示评论
	public Result showCritiqueByPage(int AId,Page page);
	
	
}
