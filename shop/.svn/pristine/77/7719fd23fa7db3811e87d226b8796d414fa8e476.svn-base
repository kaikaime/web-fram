package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.UserPojo;

public class JurisdictionFilter implements Filter{
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req =(HttpServletRequest) request;
			HttpServletResponse res= (HttpServletResponse) response;
			String url = req.getRequestURI();	
			if(url.contains("/shop/index.jsp")||url.contains("/shop/login.jsp")||
					url.contains(".css")||url.contains(".js")||url.contains(".jpg")||
					url.contains(".png")||url.contains(".gif")||url.contains(".do")||url.contains(".jpeg")){
					chain.doFilter(req, res);
			}else{
				UserPojo user = (UserPojo) req.getSession().getAttribute("user");
				if(user!=null){
					chain.doFilter(req, res);
				}else{
					System.out.println("=====================");
					res.sendRedirect("login.jsp");
				}
			}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
