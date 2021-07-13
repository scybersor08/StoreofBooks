package in.Coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Customer;
import in.Coder.bookstore.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao {
      Connection con=null;
      List<Customer> custList;
      Customer cust;
	int x=0;
	boolean status=false;
	@Override
	public boolean addCustomer(Customer cust) {
		
		try{
			con=DBUtility.getDBConnection();
		String sql="insert into customer494(custName,address,emailId,userName,phoneNumber,password) values(?,?,?,?,?,?);";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, cust.getCustName());
			pstmt.setString(2, cust.getAddress());
			pstmt.setString(3, cust.getEmailId());
			pstmt.setString(4, cust.getUserName());
			pstmt.setString(5,cust.getPhoneNumber());
			pstmt.setString(6, cust.getPassword());
			x=pstmt.executeUpdate();//this helps to check whether the record is inserted or not
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
	public boolean updateCustomer(Customer cust) {
		
		try{
			con=DBUtility.getDBConnection();
		String sql="update customer494 "
				+ "set custName=?,address=?,emailId=?,userName=?,phoneNumber=?,password=?  "
				+ "where custId=?";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cust.getCustName());
			pstmt.setString(2, cust.getAddress());
			pstmt.setString(3, cust.getEmailId());
			pstmt.setString(4, cust.getUserName());
			pstmt.setString(5,cust.getPhoneNumber());
			pstmt.setString(6, cust.getPassword());
			pstmt.setInt(7, cust.getCustId());
			x=pstmt.executeUpdate();//this helps to check whether the record is inserted or not
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
	public boolean deleteCustomer(String UserName) {
try {
	con=DBUtility.getDBConnection(); 
	String sql="delete from customer494 where UserName=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	
	pstmt.setString(1,UserName);
	
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
		}
		
		return status;
	}

@Override
	public List<Customer> getAllCustomer() {
	try {
		custList=new ArrayList<Customer>();
		con=DBUtility.getDBConnection();
		String sql="select * from customer494";
		
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
		cust=new Customer();
		cust.setCustId(rs.getInt("custId"));
		cust.setCustName(rs.getString("custName"));
		cust.setAddress(rs.getString("address"));
		cust.setEmailId(rs.getString("emailId"));
		cust.setUserName(rs.getString("UserName"));
		cust.setPhoneNumber(rs.getString("phoneNumber"));
		cust.setPassword(rs.getString("password"));
		custList.add(cust);
	}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
		return custList;
	}

	@Override
	public Customer getCustById(int custId) {
		con=DBUtility.getDBConnection();
		try {
			custList=new ArrayList<Customer>();
		String sql="select * from customer494 where custId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,custId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cust=new Customer();
				cust.setCustId(rs.getInt("custId"));
				cust.setCustName(rs.getString("custName"));
				cust.setAddress(rs.getString("address"));
				cust.setEmailId(rs.getString("emailId"));
				cust.setUserName(rs.getString("UserName"));
				cust.setPhoneNumber(rs.getString("phoneNumber"));
				cust.setPassword(rs.getString("password"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  cust;
	}

	@Override
	public List<Customer> getByUsername(String UserName) {
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Customer getCustByUsername(String UserName) {
		con=DBUtility.getDBConnection();
		try {
		custList=new ArrayList<Customer>();
		String sql="select * from customer494 where userName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,UserName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cust=new Customer();
				cust.setCustId(rs.getInt("custId"));
				cust.setCustName(rs.getString("custName"));
				cust.setAddress(rs.getString("address"));
				cust.setUserName(rs.getString("UserName"));
				cust.setEmailId(rs.getString("emailId"));
				cust.setPhoneNumber(rs.getString("phoneNumber"));
				cust.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  cust;
	}
}
