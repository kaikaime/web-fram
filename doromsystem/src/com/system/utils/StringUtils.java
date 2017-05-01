package com.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;












import org.omg.CORBA.MARSHAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.system.bean.ExcellentBean;
import com.system.bean.HealthBean;
import com.system.service.impl.RoomExcellentServiceImpl;

public class StringUtils {

	public static String formatDefaultPageId(){
		return "1";
	}
	public static <T> Logger log(Object o,String str){
		 Logger log = LoggerFactory.getLogger(o.getClass());
		 log.debug(o.getClass().getSimpleName(), str);
		return log;
		
	}
	public static int formatPageId(String pageId){
		//页面编号处理，防止用户输入非数字
		if(!pageId.matches("^[0-9]{1,20}$")){
			return 1;
		}
		return Integer.parseInt(pageId);
	}
	
	public static int formatDeleteId(String pageId){
		//删除编号处理，防止用户输入非数字
		if(!pageId.matches("^[0-9]{0,20}$")){
			return -1;
		}
		return Integer.parseInt(pageId);
	}
	public static long formatDate(){
		return new Date().getTime();
	}
	
	public static Date parseDate(String time) throws Exception{
		return new SimpleDateFormat("yyyy-MM-dd").parse(time);
	}
	public static <T> T formatJson(String json,Class<T> mClass){
		return new Gson().fromJson(json, mClass);
	}
	
	public static <T> String formatString(T t){
		return new Gson().toJson(t);
	}
	
	public static boolean formatLong(long date){
		return formatDate()-date > Constant.maxInactiveInterval? true:false;
	}
	
	public static int[] getPageId(String pageid,int pageItemCount,int allObjCount){
		int pageId = Integer.parseInt(pageid);
		int page=allObjCount%pageItemCount;
		int pageCount =  (page==0?allObjCount/pageItemCount:allObjCount/pageItemCount+1);
		if(pageId<1){
			pageId = 1;
		}
		if(pageId*pageItemCount>allObjCount){
			pageId = pageCount;
		}
		int arry[] ={pageCount,pageId};
		return arry;
	}
	
	
	
	public static <T> String formatMap(Map<String,T> map){
		return new GsonBuilder().enableComplexMapKeySerialization().create().toJson(map);
		
	}
	
	public static <T> String formatList(List<T> list){
		return new Gson().toJson(list);
		
	}
	
	public static <T> String formatPack(Class<T> mClass){
		return  mClass.getCanonicalName();
	}
	
	//格式化宿舍名称
	public static String formateRoomNick(String roomNick){
		String subNick = "%";
		for(int i = 0;i<roomNick.length();i++){
			subNick+=roomNick.substring(i, i+1)+"%";
		}
		return subNick;
	}
	
	
	
	
}
