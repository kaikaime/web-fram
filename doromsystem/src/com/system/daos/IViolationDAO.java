package com.system.daos;

import java.util.List;

import org.hibernate.SessionFactory;

import com.system.bean.ViolationBean;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.pojos.Violation;

public interface IViolationDAO {

	Violation findByIdIViolation(String vioId);

	void update(Violation violation);

	List<Violation> findByNickQueryViolation(String findByNick);

	
	
	
	

}
