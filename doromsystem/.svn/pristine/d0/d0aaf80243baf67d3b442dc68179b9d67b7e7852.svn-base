package com.system.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.daos.IHealthDAO;
import com.system.pojos.Health;

@Transactional
public class IHealthDAOImpl implements IHealthDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void update(Health health) {
		//更新卫生
		getCurrentSession().update(health);
		
	}

}
