package com.system.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private Ridgepole ridgepole;
	private String roomNick;
	private Set healths = new HashSet(0);
	private Set roommarks = new HashSet(0);
	private Set healthstates = new HashSet(0);
	private Set student = new HashSet(0);
	// Constructors

	public Room() {
	}

	public Room(String roomNick) {
		this.roomNick = roomNick;
	}
	public Set getStudent() {
		return student;
	}
	public void setStudent(Set student) {
		this.student = student;
	}

	/** full constructor */
	public Room(Ridgepole ridgepole, String roomNick, Set healths,
			Set roommarks, Set healthstates) {
		this.ridgepole = ridgepole;
		this.roomNick = roomNick;
		this.healths = healths;
		this.roommarks = roommarks;
		this.healthstates = healthstates;
	}


	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Ridgepole getRidgepole() {
		return this.ridgepole;
	}

	public void setRidgepole(Ridgepole ridgepole) {
		this.ridgepole = ridgepole;
	}

	public String getRoomNick() {
		return this.roomNick;
	}

	public void setRoomNick(String roomNick) {
		this.roomNick = roomNick;
	}

	public Set getHealths() {
		return this.healths;
	}

	public void setHealths(Set healths) {
		this.healths = healths;
	}

	public Set getRoommarks() {
		return this.roommarks;
	}

	public void setRoommarks(Set roommarks) {
		this.roommarks = roommarks;
	}

	public Set getHealthstates() {
		return this.healthstates;
	}

	public void setHealthstates(Set healthstates) {
		this.healthstates = healthstates;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", ridgepole=" + ridgepole
				+ ", roomNick=" + roomNick + ", healths=" + healths
				+ ", roommarks=" + roommarks + ", healthstates=" + healthstates
				+ ", student=" + student + "]";
	}
	


}