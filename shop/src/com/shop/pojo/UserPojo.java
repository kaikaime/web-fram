package com.shop.pojo;

import java.util.Date;
import java.util.List;

public class UserPojo {
	private int userId;
	private String userName;
	private String name;
	private String userPass;
	private String userSex;
	private Date userBithday;
	private String userTel;
	private String userEmail;
	private String headImgPath;
	private RaddressPojo raddressPojo;
	private List<RaddressPojo> list;
	public List<RaddressPojo> getList() {
		return list;
	}
	public void setList(List<RaddressPojo> list) {
		this.list = list;
	}
	
	public RaddressPojo getRaddressPojo() {
		return raddressPojo;
	}
	public void setRaddressPojo(RaddressPojo raddressPojo) {
		this.raddressPojo = raddressPojo;
	}
	
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Date getUserBithday() {
		return userBithday;
	}
	public void setUserBithday(Date userBithday) {
		this.userBithday = userBithday;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userName=" + userName
				+ ", name=" + name + ", userPass=" + userPass + ", userSex="
				+ userSex + ", userBithday=" + userBithday + ", userTel="
				+ userTel + ", userEmail=" + userEmail + ", headImgPath="
				+ headImgPath + "]";
	}
	
	
}
