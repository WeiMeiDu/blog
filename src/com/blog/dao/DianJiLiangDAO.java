package com.blog.dao;

import java.util.Date;
import java.util.List;

import com.blog.po.DianJiLiang;

public interface DianJiLiangDAO
{
	//���ظ�ip����ʱ��ķ��ʼ�¼
	public List queryById(int AId,String ip,Date time);
	//��ӷ��ʼ�¼
	public  void addJiLu(DianJiLiang dianJiLiang);
}
