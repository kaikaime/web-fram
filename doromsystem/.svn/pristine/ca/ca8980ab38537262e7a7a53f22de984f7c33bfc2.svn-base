package com.system.daos.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.daos.IVactionDAO;
import com.system.pojos.Vaction;

@Transactional
public class IVactionDAOImpl implements IVactionDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Vaction findById(int parseInt) {
		String hql = "From Vaction as vt join fetch vt.student as stu join fetch stu.classt as ct join "
				+ "fetch ct.yarddept join fetch stu.room as room join fetch room.ridgepole Where vt.vactionId=:findById";;
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("findById", parseInt);
		Vaction vaction = (Vaction) query.uniqueResult();
		return vaction!=null?vaction:new Vaction();
	}

	@Override
	public void update(Vaction vaction) {
		getCurrentSession().update(vaction);
	}

}
