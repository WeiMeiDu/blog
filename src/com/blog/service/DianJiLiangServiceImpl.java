package com.blog.service;

import java.util.Date;

import com.blog.dao.DianJiLiangDAO;
import com.blog.po.DianJiLiang;

public class DianJiLiangServiceImpl implements DianJiLiangService
{
	private DianJiLiangDAO dianJiLiangDAO;
	
	
	public DianJiLiangDAO getDianJiLiangDAO()
	{
		return dianJiLiangDAO;
	}


	public void setDianJiLiangDAO(DianJiLiangDAO dianJiLiangDAO)
	{
		this.dianJiLiangDAO = dianJiLiangDAO;
	}


	@Override
	public boolean isVisitor(int AId, String ip, Date time)
	{
		if (dianJiLiangDAO.queryById(AId, ip, time).size()!=0)
		{
			
			//表示用户已经点击过了
			return true;
		}else {
			//用户没有点击过
			DianJiLiang djl = new DianJiLiang();
			djl.setAId(AId);
			djl.setIp(ip);
			djl.setTime(time);
			//保存记录
			dianJiLiangDAO.addJiLu(djl);
			return false;
		}
	}
	
}
