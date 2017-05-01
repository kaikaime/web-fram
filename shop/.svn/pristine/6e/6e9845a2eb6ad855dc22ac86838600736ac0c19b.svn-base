package com.shop.service;

import java.util.List;

import com.shop.pojo.PagePojo;
import com.shop.pojo.UserMaPojo;
import com.shop.pojo.UserPojo;


public interface UserMaService {

	int addUser(UserPojo userPojo);
	
	PagePojo<UserPojo> findAll(int currentPage, int pageSize);

	UserPojo findByIdUser(int userId);

	void updateByIdUser(UserPojo userPojo);

	void deleteByIdUser(int userId);

}
