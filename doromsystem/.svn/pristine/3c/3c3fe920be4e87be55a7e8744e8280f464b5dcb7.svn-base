package com.system.pojos;

import java.util.Date;

/**
 * Violation entity. @author MyEclipse Persistence Tools
 */

public class Violation implements java.io.Serializable {

	// Fields

	private Integer violationId;
	private Student student;
	private String violationDesc;
	private Date violationTime;

	// Constructors

	/** default constructor */
	public Violation() {
	}

	/** full constructor */
	public Violation(Student student, String violationDesc, Date violationTime) {
		this.student = student;
		this.violationDesc = violationDesc;
		this.violationTime = violationTime;
	}

	// Property accessors

	public Integer getViolationId() {
		return this.violationId;
	}

	public void setViolationId(Integer violationId) {
		this.violationId = violationId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getViolationDesc() {
		return this.violationDesc;
	}

	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	public Date getViolationTime() {
		return this.violationTime;
	}

	public void setViolationTime(Date violationTime) {
		this.violationTime = violationTime;
	}

	@Override
	public String toString() {
		return "Violation [violationId=" + violationId + ", student=" + student
				+ ", violationDesc=" + violationDesc + ", violationTime="
				+ violationTime + "]";
	}

}