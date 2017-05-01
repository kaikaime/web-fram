package com.shop.poxy;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletToBeanProxy extends GenericServlet  {
	private String targetBean;
	private Servlet proxy;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			proxy.service(req, res);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.targetBean = this.getServletName();
		 WebApplicationContext wac =   
		            WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()); //��ʼ��Spring����  
		        this.targetBean = getServletName();  
		        this.proxy = (Servlet) wac.getBean(targetBean);
		        proxy.init(getServletConfig());
	}

}
