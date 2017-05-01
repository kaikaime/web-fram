package com.utils;

import com.google.gson.Gson;

public class StringUtil {
	
	public static int regCurrentPage(String pageId){
		int currentPage = 1;
		if(pageId.trim()!=null && !"".equals(pageId.trim())&&pageId.matches("^[0-9]{1,}$")){
			//正则校验，防止输入的pageId为中文字符
			currentPage = Integer.parseInt(pageId);
		}
		return currentPage;
	}
	
	public static <T> String toJson(T t){
		return new Gson().toJson(t);
	}

	public static boolean isNull(String text) {
		if(text!=null&&!"".equals(text)){
			return false;
		}
		return true;
	}

	public static boolean isNullEnd(String text) {
		if("".equals(text)){
			return true;
		}
		return false;
	}

}
