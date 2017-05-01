package com.shop.pojo;

public class ShopPojo {
	private Integer shopId;
	private String shopName;
	private ShopChildCategoryPojo shopChildCategoryPojo;
	private String shopPinpai;
	private String shopTxm ;
	private ImgShopPojo imgShopPojo;
	public ImgShopPojo getImgShopPojo() {
		return imgShopPojo;
	}
	public void setImgShopPojo(ImgShopPojo imgShopPojo) {
		this.imgShopPojo = imgShopPojo;
	}
	public String getShopTxm() {
		return shopTxm;
	}
	public void setShopTxm(String shopTxm) {
		this.shopTxm = shopTxm;
	}
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopChildCategoryPojo getShopChildCategoryPojo() {
		return shopChildCategoryPojo;
	}
	public void setShopChildCategoryPojo(ShopChildCategoryPojo shopChildCategoryPojo) {
		this.shopChildCategoryPojo = shopChildCategoryPojo;
	}
	
	public String getShopPinpai() {
		return shopPinpai;
	}
	public void setShopPinpai(String shopPinpai) {
		this.shopPinpai = shopPinpai;
	}
	@Override
	public String toString() {
		return "ShopPojo [shopId=" + shopId + ", shopName=" + shopName
				+ ", shopChildCategoryPojo=" + shopChildCategoryPojo
				+ ", shopPinpai=" + shopPinpai + ", shopTxm=" + shopTxm + "]";
	}
	
	
}
