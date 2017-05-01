package com.shop.pojo;

public class ImgShopPojo {
	private Integer imgShopId;
	private String imgshopNick;
	private ShopPojo shop;
	public void setImgshopNick(String imgshopNick) {
		this.imgshopNick = imgshopNick;
	}
	public String getImgshopNick() {
		return imgshopNick;
	}
	public void setShop(ShopPojo shop) {
		this.shop = shop;
	}
	public ShopPojo getShop() {
		return shop;
	}
	public Integer getImgShopId() {
		return imgShopId;
	}
	public void setImgShopId(Integer imgShopId) {
		this.imgShopId = imgShopId;
	}
	
	
}
