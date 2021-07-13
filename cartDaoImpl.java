package in.Coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Cart;
import in.Coder.bookstore.utility.DBUtility;

public class cartDaoImpl implements cartDao{
boolean status=false;
Cart cart;
Book book;
List<Cart> cartList;
int x=0;
Connection con=null;
	@Override
	public boolean addToCart(Cart cart) {
		try{
			con=DBUtility.getDBConnection();
		String sql="insert into cart494(bookId,quantity,Username,price)values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cart.getBookId());
			pstmt.setInt(2,cart.getQuantity());
			pstmt.setString(3, cart.getUserName());
			pstmt.setDouble(4,cart.getPrice());
			x=pstmt.executeUpdate();
			if (x>0)
			{
				status=true;
			}
			else {
				status=false;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
 		return status;
	}
	@Override
	public boolean deleteCart(int cartId,String UserName) {
		try{
			con=DBUtility.getDBConnection();
		String sql="delete  from cart494 where cartId=? and Username=?;";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cartId);
			pstmt.setString(2, UserName);
			x=pstmt.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean clearCart(String UserName) {
	
		try{
			con=DBUtility.getDBConnection();
		String sql="delete  from cart494 where UserName=?;";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, UserName);
			x=pstmt.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean clearCart(int cartId) {
		
		return false;
	}

	@Override
	public List<Cart> getCart(String UserName) {
		try {
			cartList=new ArrayList<Cart>();
		con=DBUtility.getDBConnection();
	String sql="Select * from cart494 where Username =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, UserName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			cart=new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setBookId(rs.getInt("bookId"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setUserName(rs.getString("Username"));
			cart.setPrice(rs.getDouble("price"));
			cartList.add(cart);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cartList;
	}
	@Override
	public List<Cart> getAllCarts() {
		try {
			cartList=new ArrayList<Cart>();
		con=DBUtility.getDBConnection();
	String sql="Select * from cart494";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			cart=new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setBookId(rs.getInt("bookId"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setUserName(rs.getString("UserName"));
			cart.setPrice(rs.getInt("price"));
			cartList.add(cart);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cartList;
	}
	
}
