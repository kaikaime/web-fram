package com.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.system.bean.ExcellentBean;
import com.system.bean.HealthBean;

public class FormatUtils {
	public static final SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");//用于时间的处理

	//获取上一个月的最后一天
		public static Date getLastMonth(){
			  Calendar calendar2=Calendar.getInstance();
			  calendar2.add(Calendar.MONTH, -1);
			  calendar2.set(Calendar.DAY_OF_MONTH, 1);
			  Calendar calendar=Calendar.getInstance();
			  int year=calendar2.get(Calendar.YEAR);
			  int day=calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
			  int month=calendar2.get(Calendar.MONTH);
			  calendar.set(year, month, day);
			  return  calendar.getTime();
		}
		
		
		//处理宿舍评比时间，从数据库中查询出来的时间个是为：2014-02-25 00:00:00.0,将当期那的格式化为2014-02-25
		public static List<ExcellentBean> formatExcellentTime(List<ExcellentBean> findExcellentList) throws Exception {
					for(int index = 0;index<findExcellentList.size();index++){
						 ExcellentBean excellentBean = findExcellentList.get(index);
						 String dealWithTime = simple.format(excellentBean.getExcellentTime());		 
						 excellentBean.setFormatDate(dealWithTime);
						 findExcellentList.set(index, excellentBean);
					}
					return findExcellentList;
		}


		public static List<HealthBean> fomatHealthTime(
				List<HealthBean> findHealthAllDao)throws Exception {
				for(int index = 0;index<findHealthAllDao.size();index++){
					 HealthBean excellentBean = findHealthAllDao.get(index);
					 String dealWithTime = simple.format(excellentBean.getStateTime());		 
					 excellentBean.setFormatDate(dealWithTime);
					 System.out.println("===================="+excellentBean.getFormatDate());
					 findHealthAllDao.set(index, excellentBean);
				}
			return findHealthAllDao;
		}
		
		public static Date formatDate(String time ) throws Exception{
			if(time!=null){
				Date date = simple.parse(time);
				return date;
			}
			return null;
			
		}
}
