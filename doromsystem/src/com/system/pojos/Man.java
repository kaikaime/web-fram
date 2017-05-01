package com.system.pojos;

import java.util.Date;

/**
 * Man entity. @author MyEclipse Persistence Tools
 */

public class Man implements java.io.Serializable {

	// Fields

	private Integer manId;
	private String manNick;
	private String manSex;
	private String manTel;
	private String manIdCard;
	private Date manTime;
	private String manshen;
	private String shi;
	private String xian;
	private String xiangzheng;

	// Constructors

	/** default constructor */
	public Man() {
	}

	/** full constructor */
	public Man(String manNick, String manSex, String manTel, String manIdCard,
			Date manTime, String manshen, String shi, String xian,
			String xiangzheng) {
		this.manNick = manNick;
		this.manSex = manSex;
		this.manTel = manTel;
		this.manIdCard = manIdCard;
		this.manTime = manTime;
		this.manshen = manshen;
		this.shi = shi;
		this.xian = xian;
		this.xiangzheng = xiangzheng;
	}

	// Property accessors

	public Integer getManId() {
		return this.manId;
	}

	public void setManId(Integer manId) {
		this.manId = manId;
	}

	public String getManNick() {
		return this.manNick;
	}

	public void setManNick(String manNick) {
		this.manNick = manNick;
	}

	public String getManSex() {
		return this.manSex;
	}

	public void setManSex(String manSex) {
		this.manSex = manSex;
	}

	public String getManTel() {
		return this.manTel;
	}

	public void setManTel(String manTel) {
		this.manTel = manTel;
	}

	public String getManIdCard() {
		return this.manIdCard;
	}

	public void setManIdCard(String manIdCard) {
		this.manIdCard = manIdCard;
	}

	public Date getManTime() {
		return this.manTime;
	}

	public void setManTime(Date manTime) {
		this.manTime = manTime;
	}

	public String getManshen() {
		return this.manshen;
	}

	public void setManshen(String manshen) {
		this.manshen = manshen;
	}

	public String getShi() {
		return this.shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getXian() {
		return this.xian;
	}

	public void setXian(String xian) {
		this.xian = xian;
	}

	public String getXiangzheng() {
		return this.xiangzheng;
	}

	public void setXiangzheng(String xiangzheng) {
		this.xiangzheng = xiangzheng;
	}

}