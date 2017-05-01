package com.system.hqldao;

import java.util.List;



public interface IHqlFenYeDAO {
	/**
	 * 宿舍卫生分页查询
	 */
	public <T> List<T> findHealthAllDao(String pageId,Class<T> mClass);
	
	/**
	 *宿舍评比分页查询
	 */
	public <T> List<T> findRoomAllDao(String pageId);
	/**
	 * 根据宿舍Id进行分页查询
	 */
	public <T> List<T> findByRoomId(Integer roomId,String pageId);
	
	
	

}
