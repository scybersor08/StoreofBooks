package in.Coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.Coder.bookstore.utility.DBUtility;

public class LoginDaoImpl implements LoginDao{
	boolean status;
	Connection con=DBUtility.getDBConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	int x;
	String sql;
	@Override
	public boolean login(String userName, String password, String type) {
		try {

			if(type.equals("Admin"))
			{
				sql="select adminName,Password from admin494 where adminName=?"
						+ " and Password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,userName);
				pstmt.setString(2,password);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					status=true;
				}

			}
			else if(type.equals("Customer"))
			{
				sql="select userName,password from customer494 where userName=?"
						+ " and password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setNString(1, userName);
				pstmt.setNString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					status=true;
				}
			}
			else
			{
				System.out.println("Invalid choice");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

	@Override
	public boolean changePassword(String userName, String newPassword, String type) {
		try {

			if(type.equals("Admin"))
			{
				sql="update admin494 set adminName=?, password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,userName);
				pstmt.setString(2,newPassword);

				x=pstmt.executeUpdate();
				if(x>0)
				{
					status=true;
				}
			}
			else if(type.equals("Customer"))
			{
				sql="update customer494 set password=? where userName=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setNString(1, newPassword);
				pstmt.setNString(2, userName);
			
				x=pstmt.executeUpdate();
				if(x>0)
				{
					status=true;
				}
			}
			else
			{
				System.out.println("Invalid choice");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return status;
	}
}
