package com.blog.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor
{
	public String intercept(ActionInvocation invocation) throws Exception
	{
		ActionContext context = invocation.getInvocationContext();
		//���session
		Map session = context.getContext().getSession();
		String username = (String) session.get("username");
		//�ж��û��Ϸ���
		if (username==null ||"".equals(username))
		{
			//�������أ������û���¼ҳ��
			return Action.LOGIN;
		}else {
			//������һ��������û�н�������
			return invocation.invoke();
		}
		
	}
}
