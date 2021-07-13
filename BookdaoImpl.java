package in.Coder.bookstore.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.utility.DBUtility;
public class BookdaoImpl implements Bookdao{
	int x=0;
	Book book;
	List<Book> bookList;
	boolean status=false;
	Connection con=null;
	@Override
	public boolean insertBook(Book book) {
		con=DBUtility.getDBConnection();
		try {
		String sql="insert into book494(bookName,authorName,bookCategory,description,publisher,quantity,price)values(?,?,?,?,?,?,?)";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthorName());
			pstmt.setString(3, book.getBookCategory());
			pstmt.setString(4, book.getDescription());
			pstmt.setString(5,book.getPublisher());
			pstmt.setInt(6,book.getQuantity());
			pstmt.setDouble(7, book.getBookprice());
			
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
	public List<Book> getAllBoooks() {
		try {
		
		bookList=new ArrayList<Book>();
		
		con=DBUtility.getDBConnection();
		String sql="select * from book494";
		
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setBookName(rs.getNString("bookName"));
			book.setAuthorName(rs.getString("authorName"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setQuantity(rs.getInt("quantity"));
			book.setBookprice(rs.getDouble("price"));
			bookList.add(book);
		}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}
	@Override
	public boolean updateBook(Book book) {
		try {
			con=DBUtility.getDBConnection();
			String sql="update book494 "
					+ "set bookName=?,authorName=?,publisher=?,description=?,bookCategory=?,quantity=?,price=? "
					+ "where bookId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthorName());
			pstmt.setString(3,book.getPublisher());
			pstmt.setString(4, book.getDescription());
			pstmt.setNString(5, book.getBookCategory());
			pstmt.setInt(6, book.getQuantity());
			pstmt.setDouble(7, book.getBookprice());
			pstmt.setInt(8, book.getBookId());
			x=pstmt.executeUpdate();
			
			if(x>0)
			{
				status=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public boolean deleteBook(int bookId) {
		
		try
		{
			con=DBUtility.getDBConnection();
			String sql="delete  from book494 where bookId=? ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			x=pstmt.executeUpdate();
			if(x>0)
			{
			status=true;	
			}
			else 
			{
				status=false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<Book> getBookByName(String bookName) {
		con=DBUtility.getDBConnection();
		try {
			bookList=new ArrayList<Book>();
		String sql="select * from book494 where bookName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bookName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setDescription(rs.getString("description"));
				book.setBookCategory(rs.getNString("bookCategory"));
				book.setPublisher(rs.getString("publisher"));
				book.setBookprice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  bookList;
	}
	@Override
	public List<Book> getBookByAuthorName(String authorName) {
		con=DBUtility.getDBConnection();
		try {
			bookList=new ArrayList<Book>();
			String sql="select * from book494 where authorName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, authorName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setDescription(rs.getString("description"));
				book.setBookCategory(rs.getNString("bookCategory"));
				book.setPublisher(rs.getString("publisher"));
				book.setBookprice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				bookList.add(book);
			}
	
		} 
		catch (SQLException e) {
					e.printStackTrace();
		}
		
		return bookList;
	}
	@Override
	public List<Book> getBookByPublisher(String publisher) {
		con=DBUtility.getDBConnection();
		try {
			bookList=new ArrayList<Book>();
		String sql="select * from book494 where publisher=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setNString(1,publisher);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setDescription(rs.getString("description"));
				book.setBookCategory(rs.getNString("bookCategory"));
				book.setPublisher(rs.getString("publisher"));
				book.setBookprice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public List<Book> getBookByBookCategory(String bookCategory) {
		con=DBUtility.getDBConnection();
		try {
			bookList=new ArrayList<Book>();
		String sql="select * from book494 where bookCategory=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setNString(1,bookCategory);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setDescription(rs.getString("description"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setPublisher(rs.getString("publisher"));
				book.setBookprice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public Book getBookById(int bookId) {
		con=DBUtility.getDBConnection();
		try {
			bookList=new ArrayList<Book>();
		String sql="select * from book494 where bookId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bookId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setDescription(rs.getString("description"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setPublisher(rs.getString("publisher"));
				book.setBookprice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  book;
	}
}
