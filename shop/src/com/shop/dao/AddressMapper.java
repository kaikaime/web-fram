package com.shop.dao;

import java.util.List;

import com.shop.pojo.UserPojo;

public interface AddressMapper {

	List<UserPojo> findAll(int userId);

}
