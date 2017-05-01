package com.shop.pojo;

public class OrderPojo {
	private Integer orderId;
	private OrderXqPojo orderXqPojo;
	private ShopPojo shopPojo;
	private UserPojo userPojo;
	private String number;
	
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}
	public UserPojo getUserPojo() {
		return userPojo;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public OrderXqPojo getOrderXqPojo() {
		return orderXqPojo;
	}
	public void setOrderXqPojo(OrderXqPojo orderXqPojo) {
		this.orderXqPojo = orderXqPojo;
	}
	public ShopPojo getShopPojo() {
		return shopPojo;
	}
	public void setShopPojo(ShopPojo shopPojo) {
		this.shopPojo = shopPojo;
	}
	
	
}
