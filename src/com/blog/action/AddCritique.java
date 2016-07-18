package com.blog.action;

import java.util.Date;
import java.util.Map;

import com.blog.po.Critique;
import com.blog.service.CritiqueService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddCritique extends ActionSupport
{
	private CritiqueService critiqueService;
	private int id;
	private String content;

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public CritiqueService getCritiqueService()
	{
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService)
	{
		this.critiqueService = critiqueService;
	}

	@Override
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");

		if (username == null || "".equals(username))
		{
			username = "ÄäÃû";
		}
		Critique critique = new Critique();
		critique.setUsername(username);

		critique.setAId(id);
		critique.setContent(content);
		critique.setDate(new Date());
		// ±£´æÆÀÂÛ
		this.critiqueService.addCritique(critique);
		return this.SUCCESS;
	}

}
