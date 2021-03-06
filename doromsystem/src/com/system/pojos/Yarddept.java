package com.system.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * Yarddept entity. @author MyEclipse Persistence Tools
 */

public class Yarddept implements java.io.Serializable {

	// Fields

	private Integer yardId;
	private String yardNick;
	private Set students = new HashSet(0);
	private Set classts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Yarddept() {
	}

	/** minimal constructor */
	public Yarddept(String yardNick) {
		this.yardNick = yardNick;
	}

	/** full constructor */
	public Yarddept(String yardNick, Set students, Set classts) {
		this.yardNick = yardNick;
		this.students = students;
		this.classts = classts;
	}

	// Property accessors

	public Integer getYardId() {
		return this.yardId;
	}

	public void setYardId(Integer yardId) {
		this.yardId = yardId;
	}

	public String getYardNick() {
		return this.yardNick;
	}

	public void setYardNick(String yardNick) {
		this.yardNick = yardNick;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getClassts() {
		return this.classts;
	}

	public void setClassts(Set classts) {
		this.classts = classts;
	}

	@Override
	public String toString() {
		return "Yarddept [yardId=" + yardId + ", yardNick=" + yardNick + "]";
	}

}