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
			
			//��ʾ�û��Ѿ��������
			return true;
		}else {
			//�û�û�е����
			DianJiLiang djl = new DianJiLiang();
			djl.setAId(AId);
			djl.setIp(ip);
			djl.setTime(time);
			//�����¼
			dianJiLiangDAO.addJiLu(djl);
			return false;
		}
	}
	
}
