package in.Coder.bookstore.dao;

import java.util.List;

import in.Coder.bookstore.pojo.Order;



public interface OrderDao {
	public boolean placeOrder(String custUserName);
	List<Order> getAllOrders();
	List<Order> getOrderByCustUserName(String custUserName);
	long placeOrder(Order order);
	public int updateQuantity(int parseInt, int newQuantity);
	
	
	
}
