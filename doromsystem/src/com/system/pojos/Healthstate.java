package com.system.pojos;

import java.util.Date;

/**
 * Healthstate entity. @author MyEclipse Persistence Tools
 */

public class Healthstate implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private Room room;
	private String state;
	private String stateDesc;
	private Date stateTime;

	// Constructors

	/** default constructor */
	public Healthstate() {
	}

	/** full constructor */
	public Healthstate(Room room, String state, String stateDesc, Date stateTime) {
		this.room = room;
		this.state = state;
		this.stateDesc = stateDesc;
		this.stateTime = stateTime;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateDesc() {
		return this.stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public Date getStateTime() {
		return this.stateTime;
	}

	public void setStateTime(Date stateTime) {
		this.stateTime = stateTime;
	}

	@Override
	public String toString() {
		return "Healthstate [stateId=" + stateId + ", room=" + room
				+ ", state=" + state + ", stateDesc=" + stateDesc
				+ ", stateTime=" + stateTime + "]";
	}

}