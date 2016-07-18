package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;
import com.blog.po.BlogInfo;
import com.blog.service.ArticleService;
import com.blog.service.BlogInfoService;
import com.blog.service.CritiqueService;
import com.blog.service.DianJiLiangService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowArticle extends ActionSupport
{
	// ҵ���߼��������
	private ArticleService articleService;
	// �����ҵ���߼�����
	private DianJiLiangService dianJiLiangService;
	// ���۵�ҵ���߼�����
	private CritiqueService critiqueService;
	// ���õ�ǰҳ
	private int currentPage;
	// id����
	private int id;
	// username
	private String username;

	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService()
	{
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService)
	{
		this.blogInfoService = blogInfoService;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public CritiqueService getCritiqueService()
	{
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService)
	{
		this.critiqueService = critiqueService;
	}

	public DianJiLiangService getDianJiLiangService()
	{
		return dianJiLiangService;
	}

	public void setDianJiLiangService(DianJiLiangService dianJiLiangService)
	{
		this.dianJiLiangService = dianJiLiangService;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public ArticleService getArticleService()
	{
		return articleService;
	}

	public void setArticleService(ArticleService articleService)
	{
		this.articleService = articleService;
	}

	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();

		// ��id��ѯ��¼
		Article article = articleService.showArticle(id);
		// ����û�ip
		String ip = request.getRemoteAddr();
		// ��õ�ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);
		if (!dianJiLiangService.isVisitor(id, ip, time))
		{
			// ���������
			article.setHasRead(article.getHasRead() + 1);
		}

		// �����µ�article���浽���ݿ���
		articleService.addArticle(article);

		// ��ʾ����
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);

		Result result = critiqueService.showCritiqueByPage(id, page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("allCri", result.getList());

		request.setAttribute("article", article);

		// ȡ�ø��Ի�����
		// ͨ��ҵ���߼��������ѯusername
		Map session = ActionContext.getContext().getSession();
		if (username!=null || !"".equals(username))
		{
			BlogInfo blogInfo = blogInfoService.getBlogInfo(username);

			if (blogInfo != null)
			{
				session.put("blogtitle", blogInfo.getBlogtitle());
				session.put("idiograph", blogInfo.getIdiograph());

			}
		}
		
		return this.SUCCESS;
	}

}
