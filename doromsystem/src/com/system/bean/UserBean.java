package com.system.bean;

public class UserBean {
	private String accNumber;
	private String accPass;
	private String manNick;
	private String manSex;
	private String manTel;
	private String manIdCard;
	private String regiterTime;
	private String manShen;
	private String shi;
	private String xian;
	private String xiangzheng;
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccPass() {
		return accPass;
	}
	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}
	public String getManNick() {
		return manNick;
	}
	public void setManNick(String manNick) {
		this.manNick = manNick;
	}
	public String getManSex() {
		return manSex;
	}
	public void setManSex(String manSex) {
		this.manSex = manSex;
	}
	public String getManTel() {
		return manTel;
	}
	public void setManTel(String manTel) {
		this.manTel = manTel;
	}
	public String getManIdCard() {
		return manIdCard;
	}
	public void setManIdCard(String manIdCard) {
		this.manIdCard = manIdCard;
	}
	public String getRegiterTime() {
		return regiterTime;
	}
	public void setRegiterTime(String regiterTime) {
		this.regiterTime = regiterTime;
	}
	public String getManShen() {
		return manShen;
	}
	public void setManShen(String manShen) {
		this.manShen = manShen;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getXian() {
		return xian;
	}
	public void setXian(String xian) {
		this.xian = xian;
	}
	public String getXiangzheng() {
		return xiangzheng;
	}
	public void setXiangzheng(String xiangzheng) {
		this.xiangzheng = xiangzheng;
	}
	@Override
	public String toString() {
		return "UserBean [accNumber=" + accNumber + ", accPass=" + accPass
				+ ", manNick=" + manNick + ", manSex=" + manSex + ", manTel="
				+ manTel + ", manIdCard=" + manIdCard + ", regiterTime="
				+ regiterTime + ", manShen=" + manShen + ", shi=" + shi
				+ ", xian=" + xian + ", xiangzheng=" + xiangzheng + "]";
	}
	
	
}
