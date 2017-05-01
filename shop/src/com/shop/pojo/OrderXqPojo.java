package com.shop.pojo;

import java.util.Date;

public class OrderXqPojo {
	private Integer infoId ;
	private Date infoTime;
	private CustomerPojo customerPojo; 
	private String orderStatus;
	private RaddressPojo raddressPojo;
	private String orderPrice;
	private String orderdesc;

	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public Date getInfoTime() {
		return infoTime;
	}
	public void setInfoTime(Date infoTime) {
		this.infoTime = infoTime;
	}
	public CustomerPojo getCustomerPojo() {
		return customerPojo;
	}
	public void setCustomerPojo(CustomerPojo customerPojo) {
		this.customerPojo = customerPojo;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public RaddressPojo getRaddressPojo() {
		return raddressPojo;
	}
	public void setRaddressPojo(RaddressPojo raddressPojo) {
		this.raddressPojo = raddressPojo;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderdesc() {
		return orderdesc;
	}
	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}
	
	
}
