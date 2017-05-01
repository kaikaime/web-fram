package com.system.daos.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ViolationBean;
import com.system.daos.IViolationDAO;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.pojos.Violation;

@Transactional
public class IViolationDAOImpl implements IViolationDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	
	

	/**
	 * 查询与违规记录相关的数据
	 * @return 
	 */
	@Override
	public Violation findByIdIViolation(String vioId) {
		String hql = " FROM Violation as vi join fetch vi.student as stu join fetch stu.classt as cla "
				+ "join fetch cla.yarddept join fetch stu.room as rm join fetch rm.ridgepole as rid where "
				+ "vi.violationId=:violationId";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("violationId", Integer.parseInt(vioId));
		Violation violation = (Violation) query.uniqueResult();
		return violation!=null?violation:new Violation();
	}

	/**
	 * 更新违规的信息
	 */
	@Override
	public void update(Violation violation) {
		getCurrentSession().update(violation);
	}

	/**
	 * 通過學生的姓名查詢數據
	 */
	@Override
	public List<Violation> findByNickQueryViolation(String findByNick) {
		String hql = "From Violation as vio join fetch vio.student as stu where stu.studentNick=:studentNick";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("studentNick",findByNick);
		List<Violation> list = query.list();
		for (Violation violation : list) {
			System.out.println("violation============="+violation.toString());
		}
		
		
		return list!=null?list:new ArrayList<Violation>();
	}
}
