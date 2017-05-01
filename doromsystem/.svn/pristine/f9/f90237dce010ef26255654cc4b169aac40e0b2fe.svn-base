package com.system.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Mark entity. @author MyEclipse Persistence Tools
 */

public class Mark implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Mark [markId=" + markId + ", markNumber=" + markNumber
				+ ", markDesc=" + markDesc + ", markTime=" + markTime
				+ ", roommarks=" + roommarks + "]";
	}

	private Integer markId;
	private String markNumber;
	private String markDesc;
	private Date markTime;
	private Set roommarks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Mark() {
	}

	/** full constructor */
	public Mark(String markNumber, String markDesc, Date markTime, Set roommarks) {
		this.markNumber = markNumber;
		this.markDesc = markDesc;
		this.markTime = markTime;
		this.roommarks = roommarks;
	}

	// Property accessors

	public Integer getMarkId() {
		return this.markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public String getMarkNumber() {
		return this.markNumber;
	}

	public void setMarkNumber(String markNumber) {
		this.markNumber = markNumber;
	}

	public String getMarkDesc() {
		return this.markDesc;
	}

	public void setMarkDesc(String markDesc) {
		this.markDesc = markDesc;
	}

	public Date getMarkTime() {
		return this.markTime;
	}

	public void setMarkTime(Date markTime) {
		this.markTime = markTime;
	}

	public Set getRoommarks() {
		return this.roommarks;
	}

	public void setRoommarks(Set roommarks) {
		this.roommarks = roommarks;
	}

}