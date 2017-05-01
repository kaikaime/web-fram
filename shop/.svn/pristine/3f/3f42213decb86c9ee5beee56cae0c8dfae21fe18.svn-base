package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.UserMaPojo;
import com.shop.pojo.UserPojo;

public class EncodFilter implements Filter{
	private String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			//post请求方式
			request.setCharacterEncoding(encoding);//设置编码格式
			//输入时的字符编码
			response.setContentType("text/html;charset="+encoding);//设置字符编码
			chain.doFilter(new MyFilter(request), response);
			
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		this.encoding = filter.getInitParameter("encoding");
	}

	class MyFilter extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyFilter(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		@Override
		public String getParameter(String name) {
			String value = request.getParameter(name);
			if("get".equalsIgnoreCase(super.getMethod())){
				try {
					if(value!=null&&!"".equals(value))
					{
						value = new String(value.getBytes("ISO-8859-1"),encoding);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return value;
		}
	}
}
