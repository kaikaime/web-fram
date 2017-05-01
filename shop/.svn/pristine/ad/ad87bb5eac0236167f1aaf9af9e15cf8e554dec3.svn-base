package com.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.UserMapper;
import com.shop.pojo.PagePojo;
import com.shop.pojo.UserPojo;
import com.shop.service.UserMaService;

@Service
public class UserMaServiceImpl implements UserMaService{
	
	@Autowired
	private UserMapper userMapper;
	

	/**
	 * 添加用户
	 */
	@Transactional
	@Override
	public int addUser(UserPojo userPojo) {
		//添加用户
		this.userMapper.addUser(userPojo);
		//获取用户Id
		return userPojo.getUserId();
	}


	/**
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PagePojo<UserPojo> findAll(int currentPage, int pageSize) {
		//获取数据总数
		PagePojo<UserPojo> pagePojo = userMapper.findAllUserCount();	
		//设置页面的条目数和当前的页面
		pagePojo.setPageSizeAndCurrentPage(pageSize, currentPage);
		//开始进行分页计算
		pagePojo.jiSuanFenYe();
		//获取所有的数据
		List<UserPojo> allUser = userMapper.findAllUserList(pagePojo);
		//存放数据
		pagePojo.setList(allUser);
		
		return pagePojo;
	}


	/**
	 * 通过用户的Id查询用户
	 */
	@Override
	public UserPojo findByIdUser(int userId) {
		return userMapper.findByIdUser(userId);
	}


	/**
	 * 更新用户
	 */
	@Transactional
	@Override
	public void updateByIdUser(UserPojo userPojo) {
		this.userMapper.updateByIdUser(userPojo);
		
	}


	/**
	 * 删除用户
	 */
	@Transactional
	@Override
	public void deleteByIdUser(int userId) {
		userMapper.deleteByIdUser(userId);
	}


	
}
