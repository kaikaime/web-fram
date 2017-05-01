package com.system.pojos;

/**
 * Classt entity. @author MyEclipse Persistence Tools
 */

public class Classt implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Yarddept yarddept;
	private String classNick;

	// Constructors

	/** default constructor */
	public Classt() {
	}

	/** minimal constructor */
	public Classt(String classNick) {
		this.classNick = classNick;
	}

	/** full constructor */
	public Classt(Yarddept yarddept, String classNick) {
		this.yarddept = yarddept;
		this.classNick = classNick;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Yarddept getYarddept() {
		return this.yarddept;
	}

	public void setYarddept(Yarddept yarddept) {
		this.yarddept = yarddept;
	}

	public String getClassNick() {
		return this.classNick;
	}

	public void setClassNick(String classNick) {
		this.classNick = classNick;
	}

}