package com.system.daos.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.daos.IAllStudentInforDAO;
import com.system.pojos.Student;

@Transactional
public class IAllStudentInforDAOImpl implements IAllStudentInforDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Student> findAllStudentInfor(Integer roomId) {
		String ls ="From Student as student where student.room.roomId=:roomId";
		Query querys = getCurrentSession().createQuery(ls);
		querys.setParameter("roomId", roomId);
		List<Student> list = querys.list();
		return list;
		
	}
}
