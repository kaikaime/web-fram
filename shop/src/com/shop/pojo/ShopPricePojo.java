package com.shop.pojo;

public class ShopPricePojo {
	private Integer shopPriceId;
	private ShopPojo shop;
	private PricePojo price;
	
	public PricePojo getPrice() {
		return price;
	}
	public void setPrice(PricePojo price) {
		this.price = price;
	}
	public ShopPojo getShop() {
		return shop;
	}
	public void setShop(ShopPojo shop) {
		this.shop = shop;
	}
	public void setShopPriceId(Integer shopPriceId) {
		this.shopPriceId = shopPriceId;
	}
	public Integer getShopPriceId() {
		return shopPriceId;
	}
}
