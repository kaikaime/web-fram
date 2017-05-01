package com.shop.pojo;

public class ShopRepositoryPojo {
	private Integer shopRepositoryId ;
	private ShopPojo shop;
	private RepositoryPojo repository;
	
	public ShopPojo getShop() {
		return shop;
	}
	public void setShop(ShopPojo shop) {
		this.shop = shop;
	}
	public RepositoryPojo getRepository() {
		return repository;
	}
	public void setRepository(RepositoryPojo repository) {
		this.repository = repository;
	}
	public void setShopRepositoryId(Integer shopRepositoryId) {
		this.shopRepositoryId = shopRepositoryId;
	}
	public Integer getShopRepositoryId() {
		return shopRepositoryId;
	}
}
