package com.shop.dao;

import java.util.List;
import java.util.Set;

import com.shop.pojo.PagePojo;
import com.shop.pojo.UserPojo;

public interface UserMapper {
	
	UserPojo findUser(UserPojo userPojo);

	void addUser(UserPojo userPojo);

	int findUserId(String userName);

	@SuppressWarnings("rawtypes")
	PagePojo findAllUserCount();

	@SuppressWarnings("rawtypes")
	List<UserPojo> findAllUserList(PagePojo pagePojo);

	UserPojo findByIdUser(int userId);

	void updateByIdUser(UserPojo userPojo);

	void deleteByIdUser(int userId);

	UserPojo findAllUserAdd(int userId);
	
	

}
