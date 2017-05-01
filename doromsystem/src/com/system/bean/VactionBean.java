package com.system.bean;

import java.util.Arrays;
import java.util.Date;

public class VactionBean {
	private Integer [] vactionsId;
	private String studentNick;
	private String yardNick;
	private String classNick;
	private String roomNick;
	private String studentTel;
	private String startTime;
	private String endTime;
	private String vactionDesc;
	/*private Integer vactionId;
	private Integer studentId;
	private Integer classId;
	private Integer yardId;
	private Integer roomId;
	private Integer ridgId;*/
	public Integer[] getVactionsId() {
		return vactionsId;
	}
	public void setVactionsId(Integer[] vactionsId) {
		this.vactionsId = vactionsId;
	}
	public String getStudentNick() {
		return studentNick;
	}
	public void setStudentNick(String studentNick) {
		this.studentNick = studentNick;
	}
	public String getYardNick() {
		return yardNick;
	}
	public void setYardNick(String yardNick) {
		this.yardNick = yardNick;
	}
	public String getClassNick() {
		return classNick;
	}
	public void setClassNick(String classNick) {
		this.classNick = classNick;
	}
	public String getRoomNick() {
		return roomNick;
	}
	public void setRoomNick(String roomNick) {
		this.roomNick = roomNick;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getVactionDesc() {
		return vactionDesc;
	}
	public void setVactionDesc(String vactionDesc) {
		this.vactionDesc = vactionDesc;
	}
	@Override
	public String toString() {
		return "VactionBean [vactionsId=" + Arrays.toString(vactionsId)
				+ ", studentNick=" + studentNick + ", yardNick=" + yardNick
				+ ", classNick=" + classNick + ", roomNick=" + roomNick
				+ ", studentTel=" + studentTel + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", vactionDesc=" + vactionDesc + "]";
	}
	

}
