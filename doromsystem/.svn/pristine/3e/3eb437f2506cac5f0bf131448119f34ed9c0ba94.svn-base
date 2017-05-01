package com.system.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.pojos.Mark;

@Transactional
public class IMarkDAOImpl implements com.system.daos.IMarkDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void update(Mark mark) {
		getCurrentSession().update(mark);
		
	}
}
