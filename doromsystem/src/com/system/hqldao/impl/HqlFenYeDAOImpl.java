package com.system.hqldao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ExcellentBean;
import com.system.bean.HealthBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.hqldao.IHqlFenYeDAO;
import com.system.pojos.Excellent;
import com.system.pojos.Vaction;
import com.system.utils.Constant;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

@Transactional
public class HqlFenYeDAOImpl {
	private static int LastMonth = 0;

	private static int RoomId = 1;

	private int Defualt = -1;

	private Object object;// 动态赋值

	private int allCountObj;// 所有的量

	private int currentPageId;// 当前页面id

	private int pageCount;// 页面总数

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public int getCurrentPageId() {
		return currentPageId;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getAllCountObj() {
		return allCountObj;
	}

	
	/**
	 * 获取宿舍所有学生的信息
	 * @param pageId
	 */
	public <T>List<T> findAllRoomStudentInfo(String pageId) {
		String allObjHql = "From Room as room join fetch room.student join fetch room.ridgepole as rid";
		String countHql="select count(*) from Room ";
		this.Defualt = -1;
		return findAll(countHql, allObjHql, pageId);
	}
	
	
	
	/**
	 * 查询学生请假
	 * @param pageId
	 * @return
	 */
	public <T> List<T> findVactionAllDao(String pageId) {
		String allObjHql = "From Vaction as vt join fetch vt.student as stu join fetch stu.classt as ct join "
				+ "fetch ct.yarddept join fetch stu.room as room join fetch room.ridgepole";
		String countHql = "SELECT COUNT(*) From Vaction";
		this.Defualt=-1;
		return findAll(countHql, allObjHql, pageId);
	}

	
	
	
	/**
	 * 学生违规分页查询
	 * 
	 * @param pageId
	 */
	public <T> List<T> findViolationAllDao(String pageId) {
		String allObjHql = " FROM Violation as vi join fetch vi.student as stu join fetch stu.classt as cla "
				+ "join fetch cla.yarddept join fetch stu.room as rm join fetch rm.ridgepole as rid where "
				+ "vi.violationTime>:lastMonthTime";
		String countHql = "SELECT COUNT(*) FROM Violation as vi WHERE vi.violationTime>:lastMonthTime ";
		this.Defualt = this.LastMonth;
		return findAll(countHql, allObjHql, pageId);
	}
	
	
	
	/**
	 * 宿舍卫生分页查询
	 */
	public <T> List<T> findHealthAllDao(String pageId, Class<T> mClass) {
		String allObjHql = "select new "
				+ StringUtils.formatPack(HealthBean.class)
				+ "(rid.ridgId, rid.ridgNick,"
				+ "room.roomId,room.roomNick,hls.stateId,hls.state,hls.stateDesc ,"
				+ "hls.stateTime,hl.healthId,hl.healthDesc,hl.healthTime,mk.rmId,"
				+ "mark.markId,mark.markNumber,mark.markDesc,mark.markTime) from "
				+ "Ridgepole as rid,Room as room ,Healthstate as hls,Health as hl,"
				+ "Roommark as mk,Mark as mark where rid.ridgId=room.ridgepole.ridgId "
				+ "and room.roomId=hls.room.roomId and room.roomId = hl.room.roomId "
				+ "and mk.room.roomId=room.roomId and mk.mark.markId=mark.markId and hls.stateTime>:lastMonthTime";

		String countHql = "SELECT COUNT(*)  from "
				+ "Ridgepole as rid,Room as room ,Healthstate as hls,Health as hl,"
				+ "Roommark as mk,Mark as mark where rid.ridgId=room.ridgepole.ridgId "
				+ "and room.roomId=room.roomId and room.roomId = hl.room.roomId "
				+ "and mk.room.roomId=room.roomId and mk.mark.markId=mark.markId and hls.stateTime>:lastMonthTime";

		this.Defualt = this.LastMonth;
		return findAll(countHql, allObjHql, pageId);
	}

	
	
	/**
	 * 宿舍评比分页查询
	 */
	public <T> List<T> findRoomAllDao( String pageId) {
		String allObjHql = "From Excellent as exce join fetch exce.room as rooms join fetch rooms.ridgepole where exce.excellentTime>:lastMonthTime";
		String countHql = "SELECT COUNT(*) FROM Excellent as  exce where exce.excellentTime>:lastMonthTime";
		this.Defualt = this.LastMonth;
		return findAll(countHql, allObjHql, pageId);
	}

	
	
	
	
	
	
	/**
	 * 根据宿舍Id进行分页查询
	 */
	public <T> List<T> findByRoomId(Integer roomId, String pageId) {
		String allObjHql = "select new "
				+ StringUtils.formatPack(ExcellentBean.class)
				+ "(rid.ridgNick,rid.ridgId,"
				+ "room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,"
				+ "exce.excellentDesc,exce.excellentLack) from  Room as room, Excellent as exce,"
				+ "Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId "
				+ "and  exce.room.roomId=:roomId";
		String countHql = "SELECT COUNT(*) FROM Excellent as  exce WHERE exce.room.roomId=:roomId";
		this.Defualt = this.RoomId;
		return findAll(countHql, allObjHql, pageId, roomId);
	}

	
	
	/**
	 * @param countHql
	 *            查询数据所有对象的总条数
	 * @param allObjHql
	 *            查询数据对象的hql语句
	 * @param pageId
	 *            页面编号
	 * @return List<T>
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	private <T> List<T> findAll(String countHql, String allObjHql,
			String pageId, Object... p) {
		int pageItemCount = 0;
		Query allCount = null;
		Query allObj = null;

		// 处理数据总数
		pageItemCount = Constant.pageItemSize;
		allCount = getCurrentSession().createQuery(countHql);
		if (this.Defualt == this.LastMonth) {
			allCount.setParameter("lastMonthTime", FormatUtils.getLastMonth());
		} else if (this.Defualt == this.RoomId) {
			allCount.setParameter("roomId", p[0]);
		}
		long allCountLong = (Long) allCount.uniqueResult();
		this.allCountObj = (int) allCountLong;
		int page = allCountObj % pageItemCount;
		this.pageCount = (page == 0 ? allCountObj / pageItemCount : allCountObj
				/ pageItemCount + 1);

		// 最小边界判断 //StringUtils.formatPageId(pageId)将字符类型的pageId格式化为int类型的pageId
		this.currentPageId = StringUtils.formatPageId(pageId);
		if (currentPageId < 1) {
			this.currentPageId = 1;
		}
		// 最大边界判断
		if (currentPageId * pageItemCount > allCountObj) {
			this.currentPageId = pageCount;
		}

		// 设置参数
		allObj = getCurrentSession().createQuery(allObjHql);
		if (this.Defualt == this.LastMonth) {
			allObj.setParameter("lastMonthTime", FormatUtils.getLastMonth());
		} else if (this.Defualt == this.RoomId) {
			allObj.setParameter("roomId", p[0]);
		}
		allObj.setFirstResult((currentPageId - 1) * pageItemCount);
		allObj.setMaxResults(pageItemCount);
		List<T> list = allObj.list();
		return list != null ? list : new ArrayList<T>();
	}

	

	
}
