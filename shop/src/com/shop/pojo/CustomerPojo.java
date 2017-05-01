package com.shop.pojo;

public class CustomerPojo {
	private Integer customerId ;
	private String customerTel;
	private RaddressPojo reRaddress;
	private String customerNick;
	
	public String getCustomerNick() {
		return customerNick;
	}
	public void setCustomerNick(String customerNick) {
		this.customerNick = customerNick;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public RaddressPojo getReRaddress() {
		return reRaddress;
	}
	public void setReRaddress(RaddressPojo reRaddress) {
		this.reRaddress = reRaddress;
	}
	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", customerTel="
				+ customerTel + ", reRaddress=" + reRaddress
				+ ", customerNick=" + customerNick + "]";
	}
	
	
	
	
}
