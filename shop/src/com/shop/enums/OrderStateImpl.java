package com.shop.enums;

public final class OrderStateImpl {
	public static String CANCEL="已取消";
	public static String WAITONFIRM="待审核";
	public static String WAITPAYMENT="等待付款";
	public static String ADMEASUREPRODUCT="正在配货";
	public static String WAITDELIVER="等待发货";
	public static String DELIVERED="已发货";
	public static String RECEIVED="已收货";
	
	public enum OrderState {
		//已取消
		CANCEL{public String getName(){return "已取消";}},
		//待审核
		WAITONFIRM{public String getName(){return "待审核";}},
		//等待付款
		WAITPAYMENT{public String getName(){return "等待付款";}},
		//正在配货
		ADMEASUREPRODUCT{public String getName(){return "正在配货";}},
		//等待发货
		WAITDELIVER{public String getName(){return "等待发货";}},
		//已发货
		DELIVERED{public String getName(){return "已发货";}},
		//已收货
		RECEIVED{public String getName(){return "已收货";}};
		//订单状态返回
		public abstract String getName();
	}
}
