package in.Coder.bookstore.pojo;

public class Cart {
	private int cartId,bookId,quantity;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String UserName;
	private  double price;
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", quantity=" + quantity + ", UserName=" + UserName
				+ ", price=" + price + "]";
	}

}
