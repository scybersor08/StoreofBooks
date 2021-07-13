package in.Coder.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Cart;
import in.Coder.bookstore.pojo.Order;
import in.Coder.bookstore.utility.DBUtility;

public class OrderDaoImpl implements OrderDao {

String query;
String custUserName;
PreparedStatement pstmt;
ResultSet rs;
Date orderDate=Date.valueOf(LocalDate.now());
double totalBill=0.0;
Connection con=DBUtility.getDBConnection();
Cart cart;
Book book=new Book();
List<Order> orderList;
List<Cart> cartList=new ArrayList<Cart>();
Order order=new Order();
int x; 
boolean status,status1;
cartDaoImpl cartdao=new cartDaoImpl();

@Override
public boolean placeOrder(String custUserName) {
	
	try {
		String sql="select sum(price) from cart494 where Username=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,custUserName);
		rs=pstmt.executeQuery();
		while (rs.next())
		{
			totalBill=rs.getDouble(1);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	if(totalBill>0)
	{
		
		
		query="insert into order494(totalBill,orderDate,Username)values(?,?,?)";
	
	try {
		pstmt=con.prepareStatement(query);
		pstmt.setDouble(1, totalBill);
		pstmt.setDate(2, orderDate);
		pstmt.setString(3,custUserName);
		x=pstmt.executeUpdate();
	status1=cartdao.clearCart(custUserName);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
	if(x>0 && status1==true)
	{
		status=true;
	}
	else
	{
		status=false;
	}
	return status ;
}

@Override
public List<Order> getAllOrders(){
	orderList=new ArrayList<Order>();
	
	try{
		con=DBUtility.getDBConnection();
	String sql="select * from order494";
	
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			order=new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setTotalBill(rs.getDouble("totalBill"));
			order.setCustUserName(rs.getString("Username"));
			order.setDate(rs.getDate("orderDate").toLocalDate());
			orderList.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return orderList;
}

@Override

public List<Order> getOrderByCustUserName(String custUserName) {
	orderList=new ArrayList<Order>();
	 
	try{
		con=DBUtility.getDBConnection();
	String sql="select * from order494 where Username=?";
	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,custUserName);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			order=new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setTotalBill(rs.getDouble("totalBill"));
			order.setCustUserName(rs.getString("Username"));
			order.setDate(rs.getDate("orderDate").toLocalDate());
			orderList.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return orderList;
}

@Override
public long placeOrder(Order order) {
	long orderId=0;
	System.out.println(order.getCustUserName());
	Connection con=null;

	try {
		con=DBUtility.getDBConnection();
		String sql="insert into order494(totalBill,orderDate,Username) values(?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1, order.getTotalBill());
		Date date=Date.valueOf(order.getDate());
		pstmt.setDate(2, date);
		pstmt.setString(3,order.getCustUserName());
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			String sql1="select orderId from order494 where Username=? and orderDate=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,order.getCustUserName());
			pstmt.setDate(2, date);
			 rs=pstmt.executeQuery();
			while(rs.next())
			{
				orderId=rs.getLong("orderId");
			}
		}
	} catch (Exception e) {
		
		e.printStackTrace();
		// TODO: handle exception
	}
	return orderId;
}

@Override
public int updateQuantity(int bookId,int newQuantity) {
	try {
		String sql="update book494 set quantity=? where bookId=?";	
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,newQuantity);
		pstmt.setInt(2,bookId);
		x=pstmt.executeUpdate();
		if(x>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	
	return newQuantity;
}

}