package com.system.daos.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.daos.IAcctDAO;
import com.system.pojos.Acct;
import com.system.pojos.Man;

@Transactional
public class IAcctDAOImpl implements IAcctDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Acct isLogin(String userName, String md5Pass) {
		String hql = "FROM Acct as acct  WHERE acct.accNumber=? and acct.accPass=?";
		Query query =getCurrentSession().createQuery(hql);
		query.setParameter(0, userName);
		query.setParameter(1, md5Pass);
		Acct acct =  (Acct) query.uniqueResult();
		return  acct;
	}

	@Override
	public boolean rigister(Acct acct) {
		//注册直线先检查当前的账号是否已经存在
		String hql = "From Acct as acct where acct.accNumber=:accNumber";
		Query createQuery = getCurrentSession().createQuery(hql);
		createQuery.setParameter("accNumber", acct.getAccNumber());
		List list = createQuery.list();
		if(list!=null&&list.size()>0){
			//账号存在
			return false;
		}
		//如果当前的账号不存在，就注册
		getCurrentSession().persist(acct);
		return true;
	}

	@Override
	public boolean rigisterUser(Man man) {
		getCurrentSession().persist(man);
		return true;
	}
	
	
	 
}
