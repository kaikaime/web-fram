package com.shop.verycode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码
 * @author Administrator
 *
 */
public class VeryCode extends HttpServlet {
	private static String[] veryEncoding=null;
	private static int veryLength=4;
	private static Random random=null;
	
	@Override
	public void init() throws ServletException {
		veryEncoding=new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","o","r","s","t","u","v","w","x","y","z"};
		random = new Random();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			log("验证码");
			String veryCode = request.getParameter("veryCode");
			if("veryCode".equals(veryCode)){
				BufferedImage bufferedImage = new BufferedImage(100, 20, BufferedImage.TYPE_INT_RGB);
				Graphics graphics = bufferedImage.getGraphics();
				graphics.setColor(Color.YELLOW);
				graphics.fillRect(0, 0, 100, 20);
				graphics.setColor(Color.blue);
				graphics.setFont(new Font("隶书",Font.BOLD,25));
				StringBuffer stringBuffer = new StringBuffer();
				for(int i= 0;i<veryLength;i++){
					String veryCodeValue = veryEncoding[random.nextInt(5)];
					graphics.drawString(veryCodeValue, 20*i+10, 20);
					graphics.drawLine(random.nextInt(100), random.nextInt(20), random.nextInt(100), random.nextInt(20));
					stringBuffer.append(veryCodeValue);
				}
				//将验证码放入session中
				HttpSession session = request.getSession();
				session.setAttribute("veryCode", stringBuffer.toString());
				OutputStream out = response.getOutputStream();
				ImageIO.write(bufferedImage, "JPEG",out);
				out.close();
			}
		}
	

}
