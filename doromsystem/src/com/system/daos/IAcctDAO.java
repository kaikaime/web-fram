package com.system.daos;

import com.system.daos.impl.IAcctDAOImpl;
import com.system.pojos.Acct;
import com.system.pojos.Man;

public interface IAcctDAO {

	Acct isLogin(String userName, String md5Pass);

	boolean rigister(Acct acct);

	boolean rigisterUser(Man man);

}
