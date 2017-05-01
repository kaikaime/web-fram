package com.system.pojos;

/**
 * AbstractAcct entity provides the base persistence definition of the Acct
 * entity. @author MyEclipse Persistence Tools
 */

public  class Acct implements java.io.Serializable {

	// Fields

	private Integer accId;
	private String accNumber;
	private String accPass;

	// Constructors

	/** default constructor */
	public Acct() {
	}

	/** full constructor */
	public Acct(String accNumber, String accPass) {
		this.accNumber = accNumber;
		this.accPass = accPass;
	}

	// Property accessors

	public Integer getAccId() {
		return this.accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getAccNumber() {
		return this.accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccPass() {
		return this.accPass;
	}

	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}

}