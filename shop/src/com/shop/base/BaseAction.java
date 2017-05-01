package com.shop.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@SuppressWarnings("serial")
public abstract class BaseAction extends HttpServlet {
	public static String json="json";
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try{
				String path = request.getContextPath();
				String pathUrl = request.getRequestURI();
				//用户没有输入正确的url地址,直接跳转到首界面去
				if(pathUrl.split(path)[1]==null||"".equals(pathUrl.split(path)[1])){
					log("path: "+path+" pathUrl: "+pathUrl);
					log("首页为准!");
					response.sendRedirect("index.jsp");
					return;
				}
				//获取执行的方法
				String requestMethod=request.getParameter("method");
				if(requestMethod!=null&&!"".equals(requestMethod)){
					//利用反射实现动态的方法请求
					Class mClass = this.getClass();
					Method method = mClass.getMethod(requestMethod, HttpServletRequest.class,HttpServletResponse.class);
					String	invokeUrl = (String) method.invoke(this, request,response);
					if(invokeUrl!=null &&!"".equals(invokeUrl)){
						if(invokeUrl.equals(json)){
							return;
						}
						else if(invokeUrl.contains("redirect:/")){
							String urlHead = invokeUrl.split("redirect:/")[1];
							response.sendRedirect(urlHead+".jsp");
						}
						else if(invokeUrl.contains("redirect:/manage")){
							String urlHead = invokeUrl.split("redirect:/manage")[1];
							response.sendRedirect("/manage"+urlHead+".jsp");
						}
						else if(invokeUrl.contains("/manage")){
							String urlHead = invokeUrl.split("/manage")[1];
							request.getRequestDispatcher("/manage"+urlHead+".jsp").forward(request, response);
						}
						//表示转发
						else if(invokeUrl.contains("/")){
							String urlHead = invokeUrl.split("/")[1];
							request.getRequestDispatcher(urlHead+".jsp").forward(request, response);
						}
					}else{
						//如果不执行该方法，表示直接返回到首页
						log("使用的viod方法，自定义转发路径");
						//response.sendRedirect("index.jsp");
					}
				}else{
					//如果不执行该方法，表示直接返回到首页
					log("没有所要执行的方法，直接跳转到index.jsp");
					response.sendRedirect("index.jsp");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	//关闭流
	public void closePrintWriter(Writer out){
		if(out!=null){
			try {
				out.close();
			} catch (IOException e) {
				log("輸出流不存在!");
			}
		}
	}
}
