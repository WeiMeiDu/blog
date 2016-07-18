package com.blog.service;

import java.util.List;

import com.blog.dao.CritiqueDAO;
import com.blog.fenye.Page;
import com.blog.fenye.PageUtil;
import com.blog.fenye.Result;
import com.blog.po.Critique;

public class CritiqueServiceImpl implements CritiqueService
{
	private CritiqueDAO critiqueDAO;
	
	
	public CritiqueDAO getCritiqueDAO()
	{
		return critiqueDAO;
	}


	public void setCritiqueDAO(CritiqueDAO critiqueDAO)
	{
		this.critiqueDAO = critiqueDAO;
	}


	@Override
	public void addCritique(Critique critique)
	{
		critiqueDAO.addCritique(critique);
	}


	@Override
	public Result showCritiqueByPage(int AId, Page page)
	{
		page = PageUtil.createPage(page,critiqueDAO.queryCritiqueCount(AId));
		List<Critique> all = critiqueDAO.queryByPage(AId, page);
		Result result = new Result();
		result.setList(all);
		result.setPage(page);
		return result;
	}
	
}
