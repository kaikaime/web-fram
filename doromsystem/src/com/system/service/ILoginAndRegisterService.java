package com.system.service;

import com.system.pojos.Acct;
import com.system.pojos.Man;

public interface ILoginAndRegisterService {

	Acct login(String userName, String md5Pass);

	boolean registerPass(Acct acct);

	boolean register(Man man);

}
