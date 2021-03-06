package com.system.pojos;

import java.util.Date;

/**
 * Vaction entity. @author MyEclipse Persistence Tools
 */

public class Vaction implements java.io.Serializable {

	// Fields

	private Integer vactionId;
	private Student student;
	private String vactionDesc;
	private Date startTime;
	private Date endTime;

	// Constructors

	/** default constructor */
	public Vaction() {
	}

	/** full constructor */
	public Vaction(Student student, String vactionDesc, Date startTime,
			Date endTime) {
		this.student = student;
		this.vactionDesc = vactionDesc;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Property accessors

	public Integer getVactionId() {
		return this.vactionId;
	}

	public void setVactionId(Integer vactionId) {
		this.vactionId = vactionId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getVactionDesc() {
		return this.vactionDesc;
	}

	public void setVactionDesc(String vactionDesc) {
		this.vactionDesc = vactionDesc;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Vaction [vactionId=" + vactionId + ", student=" + student
				+ ", vactionDesc=" + vactionDesc + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	

}