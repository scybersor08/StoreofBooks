package in.Coder.bookstore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static Connection getDBConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ct_ol_05","root","Sg627267");
			}
		catch (SQLException e) {
				e.printStackTrace();
			}
		
	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	}
	

