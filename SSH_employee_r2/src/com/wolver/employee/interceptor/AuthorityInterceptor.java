package com.wolver.employee.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("----------权限过滤器---------");
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("existEmployee") != null) {
			System.out.println("existEmployee = " + session.get("existEmployee"));
			String result = invocation.invoke();
			return result;
		} else {
			System.out.println("existEmployee = " + session.get("existEmployee"));
			return Action.INPUT;
		}
	}
}
