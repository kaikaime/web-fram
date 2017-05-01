package com.system.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.callback.FenYeAllDataCallBack;
import com.system.daos.IAllStudentInforDAO;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.service.IAllRoomStudentInforService;

@Service
public class IAllRoomStudentInforServiceImpl implements IAllRoomStudentInforService{

	@Autowired
	private HqlFenYeDAOImpl hqlFenYeDAOImpl;
	
	@Autowired
	private IAllStudentInforDAO iAllStudentInforDAOImpl;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String findAllRoomStudentSerice(String pageId,
			FenYeAllDataCallBack<Room> fenYeAllDataCallBack) {
			List<Room> list = hqlFenYeDAOImpl.findAllRoomStudentInfo(pageId);
			fenYeAllDataCallBack.allObjCount(hqlFenYeDAOImpl.getPageCount(), hqlFenYeDAOImpl.getAllCountObj(), hqlFenYeDAOImpl.getCurrentPageId(), list);
			return fenYeAllDataCallBack.getJumpUrl();
		
	}

}
