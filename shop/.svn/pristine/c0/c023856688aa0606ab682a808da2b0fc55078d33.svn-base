package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.enums.OrderStateImpl;
import com.shop.pojo.OrderPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.RaddressPojo;
import com.shop.service.GoShopService;
import com.shop.service.RaddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Tests {
	@Autowired
	private RaddressService addressServiceImpl;
	@Autowired
	private GoShopService goShopServiceImpl;
	
	
	@Test
	public void test1(){
		List<RaddressPojo> raddressPojo = addressServiceImpl.findUserOrderAddress(2);
		for (int i = 0; i < raddressPojo.size(); i++) {
			System.out.println("raddressPojo"+raddressPojo.size());
		}

	}
	
	@Test
	public void test2() {
		/*String orderStatus = new OrderState() {
			@Override
			public String getName() {
				return "";
			};
		}.getName();
		System.out.println(orderStatus);*/
		for (OrderStateImpl.OrderState orderStatus : OrderStateImpl.OrderState.values()) {
			System.out.println(orderStatus.getName());
			
		}
	}
	
	//订单提交
	@Test
	public void test3(){
		String [] orderInfo = {"11","6","7","2","4"};
		goShopServiceImpl.saveOrder(orderInfo);
	}
	
	@Test
	public void test4(){
		//PagePojo findAllOrder = goShopServiceImpl.findAllOrder(1, 10);
		PagePojo findAllOrder = goShopServiceImpl.findOrderById(1,1,10);
		/*List<OrderPojo> list = findAllOrder.getList();
		for (OrderPojo order : list) {
			String id = order.getOrderXqPojo().getCustomerPojo().getReRaddress().getRad();
			System.out.println(id);
		}*/
	}
	@Test
	public void test5(){
		PagePojo findAllOrder = goShopServiceImpl.findOrderByUser("sdf",1,10);
		List<OrderPojo> list = findAllOrder.getList();
		System.out.println("chang"+list.size());
	}
}
