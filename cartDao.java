package in.Coder.bookstore.dao;

import java.util.List;

import in.Coder.bookstore.pojo.Cart;

public interface cartDao {
	public  boolean addToCart(Cart cart) ;
	public boolean deleteCart(int CartId,String UserName);  
	public boolean clearCart(String UserName);
	public boolean clearCart(int cartId);
	List<Cart> getCart(String Username);
	List<Cart> getAllCarts();

}
