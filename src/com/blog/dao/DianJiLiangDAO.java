package com.blog.dao;

import java.util.Date;
import java.util.List;

import com.blog.po.DianJiLiang;

public interface DianJiLiangDAO
{
	//返回该ip，该时间的访问记录
	public List queryById(int AId,String ip,Date time);
	//添加访问记录
	public  void addJiLu(DianJiLiang dianJiLiang);
}
