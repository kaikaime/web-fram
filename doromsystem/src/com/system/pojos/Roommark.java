package com.system.pojos;

/**
 * Roommark entity. @author MyEclipse Persistence Tools
 */

public class Roommark implements java.io.Serializable {

	// Fields

	private Integer rmId;
	private Room room;
	private Mark mark;

	// Constructors

	/** default constructor */
	public Roommark() {
	}

	/** full constructor */
	public Roommark(Room room, Mark mark) {
		this.room = room;
		this.mark = mark;
	}

	// Property accessors

	public Integer getRmId() {
		return this.rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Mark getMark() {
		return this.mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

}