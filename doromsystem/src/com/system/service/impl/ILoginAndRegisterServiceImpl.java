package com.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.dao.AcctDAO;
import com.system.dao.ManDAO;
import com.system.daos.IAcctDAO;
import com.system.daos.impl.IAcctDAOImpl;
import com.system.pojos.Acct;
import com.system.pojos.Man;
import com.system.service.ILoginAndRegisterService;

@Service
public class ILoginAndRegisterServiceImpl implements ILoginAndRegisterService {

	@Autowired
	private IAcctDAO iAcctDAOImpl;
	
	
	

	@Override
	public Acct login(String userName, String md5Pass) {
		return iAcctDAOImpl.isLogin(userName,md5Pass);
	
	}

	@Transactional
	@Override
	public boolean registerPass(Acct acct) {
		return iAcctDAOImpl.rigister(acct);
	}

	@Transactional
	@Override
	public boolean register(Man man) {
		return iAcctDAOImpl.rigisterUser(man);
	}
	
	

}
