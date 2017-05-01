package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
/**
 * 文件上传工具类
 * @author Administrator
 *
 */
public class FileUploadUtil {	
	private String imgPath;
	private String imgUrl;
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getImgPath() {
		return imgPath;
	}
	//对文件重命名
	public class FileRenameUtil  implements  FileRenamePolicy {
		private String filePath;
		public FileRenameUtil(String filePath){
			this.filePath = filePath;
		}
		@Override
		public File rename(File file) {
			 String body = "";  
		        String ext = "";  
		        Date date = new Date();  
		        int pot = file.getName().lastIndexOf(".");//取得文件名和后缀分割点  
		        if (pot != -1) {//说明后缀存在  
		            body = date.getTime() + "";//采用时间的形式命名  
		            ext = file.getName().substring(pot);//截取后缀名  
		        } else {  
		            body = (new Date()).getTime() + "";  
		            ext = "";  
		        }  
		        String newName = body + ext;  
		        file = new File(file.getParent(), newName);//对文件进行重命名  
		        FileUploadUtil.this.imgPath = newName;
		        return file;  
		}
	};
	
	public  MultipartRequest upload(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//开始上传文件
		MultipartRequest multi = null;
		//获取相对的路径
		String path = request.getServletContext().getRealPath("/");
		if(imgUrl==null){
			imgUrl="images/product";
		}
		File uploadFile = new File(path,imgUrl);
		System.out.println("uploadFile: "+uploadFile.getPath());
		//判断当前的文件夹是否存在，如果不存在就直接创建，如果存在就使用原始的文件夹
		
		//设置文件容量大小3M
		int fileSize = 3*1024*1024;	
		try {
			multi = new MultipartRequest(request,uploadFile.getPath(), fileSize, "utf-8",new FileRenameUtil(uploadFile.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multi;
	}
}
