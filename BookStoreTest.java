package in.Coder.bookstore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.Coder.bookstore.dao.Bookdao;
import in.Coder.bookstore.dao.BookdaoImpl;
import in.Coder.bookstore.dao.CustomerDao;
import in.Coder.bookstore.dao.CustomerDaoImpl;
import in.Coder.bookstore.dao.OrderDao;
import in.Coder.bookstore.dao.OrderDaoImpl;
import in.Coder.bookstore.dao.cartDao;
import in.Coder.bookstore.dao.cartDaoImpl;
import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Cart;
import in.Coder.bookstore.pojo.Customer;

public class BookStoreTest {
	public static void main(String args[])
	{
		Cart cart = new Cart();
		cartDao Cartdao=new cartDaoImpl();
		OrderDao orderdao=new OrderDaoImpl();
		List<Cart> cartList;
	int choice;
	int bookId,quantity,cartId;
	double price;
	String bookName,authorName,bookCategory,description,publisher,Username;
	int custId;
	
	String UserName =" hari";
	boolean status=false;
	String custName,address,emailId,phoneNumber,password;
	List<Customer> custList;
	Scanner sc=new Scanner(System.in);
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	
	System.out.println("1.Add Book\n2.Get Books\n3.Update Book\n4.DeleteBook\n5.Get Book By Name\n6.Get Book By AuthorName"
			+ "\n7.Get Book By PublisherName\n8.GetBookBybookcatgeory\n9.add to cart\n10.Delete from cart"
			+ "\n11.clearCart by username\n12.Add Customer\n13.Update customer\n14.Delete customer"
			+ "\n15.Customers List\n16.Place order\n17.All orders\n18.get order by username\n19:CartList");
	Book book=new Book();
	Customer cust=new Customer();
	List<Book> bookList=new ArrayList<Book>();
	Bookdao bookdao=new BookdaoImpl();
	CustomerDao custdao=new CustomerDaoImpl();
	System.out.println("Enter choice:");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1:
	{
		System.out.println("Inserting Book...");
		try {
		System.out.println("Enter name:");
			bookName=br.readLine();
		 
		
		System.out.println("Enter the author name:");
		authorName=br.readLine();
		
		System.out.println("Enter the book category:");
		bookCategory=br.readLine();
		
		System.out.println("Enter Description:");
		description=br.readLine();
		
		System.out.println("Enter publisher:");
		publisher=br.readLine();
		
		System.out.println("Enter quantity:");
		quantity=sc.nextInt();
		
		System.out.println("Enter price:");
		price=sc.nextDouble();
		
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		book.setBookCategory(bookCategory);
		book.setDescription(description);
		book.setPublisher(publisher);
		book.setQuantity(quantity);
		book.setBookprice(price);
		status=bookdao.insertBook(book);
		if(status==true)
		{
			System.out.println("Record inserted succesfully...");
		}
		else
		{
			System.out.println("Something went wrong...");
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	break;
	case 2:
	{
		System.out.println("All Books...");
		bookList=bookdao.getAllBoooks();
		
		for (Book book3 : bookList) 
		{
		System.out.println(book3);	
		}	
		break;
	}
	case 3:
	{
		System.out.println("Update book..");
		try {
		System.out.println("Enter the existing book id:");
		bookId=sc.nextInt();
		
		System.out.println("Enter name:");
		bookName=br.readLine();
	 
	System.out.println("Enter the author name:");
	authorName=br.readLine();
	
	System.out.println("Enter the book category:");
	bookCategory=br.readLine();
	
	System.out.println("Enter Description:");
	description=br.readLine();
	
	System.out.println("Enter publisher:");
	publisher=br.readLine();
	
	System.out.println("Enter quantity:");
	quantity=sc.nextInt();
	
	System.out.println("Enter price:");
	price=sc.nextDouble();
	
	book.setBookId(bookId);
	book.setBookName(bookName);
	book.setAuthorName(authorName);
	book.setBookCategory(bookCategory);
	book.setDescription(description);
	book.setPublisher(publisher);
	book.setQuantity(quantity);
	book.setBookprice(price);
	status=bookdao.updateBook(book);
	if(status==true)
	{
		System.out.println("Book Updated succesfully...");
	}
	else
	{
		System.out.println("Book Record not found...");
	}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	break;
	case 4:
	{
		System.out.println("Delete Book..");
		try {
		System.out.println("Enter the existing book id:");
		bookId=sc.nextInt();	
		
		book.setBookId(bookId);
		status=bookdao.deleteBook(bookId);
		
		if(status==true)
		{
			System.out.println("Record deleted...");
		}
		else
		{
			System.out.println("Operation failed");
		}
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	break;
	case 5:
	{
		System.out.println("Get Book by Name");
		try {
			System.out.println("Enter Name:");
			bookName=br.readLine();
			
			bookList=bookdao.getBookByName(bookName);
			for (Book book2: bookList)
			{
				System.out.println(book2);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	break;
	case 6:
	{
		System.out.println("Get Book By AuthorName");
		try {
		System.out.println("Enter authorName:");
			authorName=br.readLine();
			bookList=bookdao.getBookByAuthorName(authorName);
			for (Book book2 : bookList) {
				System.out.println(book2);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}break;
	case 7:
	{
		System.out.println("Get Book By publisher");
	try {
	System.out.println("Enter publisher:");
		publisher=br.readLine();
		bookList=bookdao.getBookByPublisher(publisher);
		for (Book book2 : bookList) {
			System.out.println(book2);
		
		}
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	}break;
	case 8:
	{
		System.out.println("Get Book By BookCatgeory");
		try {
		System.out.println("Enter Category:");
			bookCategory=br.readLine();
			bookList=bookdao.getBookByBookCategory(bookCategory);
			for (Book book2 : bookList) {
				System.out.println(book2);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}break;

	case 9:
	{
		System.out.println("Adding to cart....");
		System.out.println("Enter book Id:");
		bookId=sc.nextInt();
		
		System.out.println("Enter username:");
		Username=sc.next();
	

		System.out.println("Enter Quantity:");
		quantity=sc.nextInt();
		
		System.out.println("Enter price:");
		price=sc.nextDouble();
		
		cart.setBookId(bookId);
		cart.setUserName(Username);
		cart.setQuantity(quantity);
		cart.setPrice(price);
		
		status=Cartdao.addToCart(cart);
		if(status==true)
		{
			System.out.println("Book added to cart..");
		}
		else
		{
			System.out.println(" Unable to add book...");
		}
	}break;
	case 10:
	{
		System.out.println("Delete from Cart....");
		System.out.println("Enter  cartID:");
		 cartId = sc.nextInt();
		 
		 System.out.println("Enter  username:");
		 UserName = sc.next();
		 
		 cart.setCartId(cartId);
		 cart.setUserName(UserName);
		 status=Cartdao.deleteCart(cartId, UserName);
		 if(status==true)
		 {
			 System.out.println("Deleted successfully...");
		 }
		 else
		 {
			 System.out.println("Something went wrong...");
		 }
	}
	break;
	case 11:
	{
		try {
			System.out.println("Enter UserName:");
			UserName=br.readLine();
			
			status=Cartdao.clearCart(UserName);
		
		if(status==true)
		{
			System.out.println("Record deleted successfully");
		}
		else
		{
			System.out.println("Something went wrong");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}break;
	case 12:
	{
		System.out.println("Add Customer");
		try {
			System.out.println("Enter Customer name:");
			custName=br.readLine();
			
			System.out.println("Enter Address:");
			address=br.readLine();
			
			System.out.println("Enter emailId:");
			emailId=br.readLine();
			
			System.out.println("Enter Username:");
			UserName=br.readLine();
			
			System.out.println("Enter PhoneNumber:");
			phoneNumber=br.readLine();
			
			System.out.println("Enter Password:");
			password=br.readLine();
			
			cust=new Customer();
			cust.setCustName(custName);
			cust.setAddress(address);
			cust.setEmailId(emailId);
			cust.setUserName(UserName);
			cust.setPhoneNumber(phoneNumber);
			cust.setPassword(password);
			
			status=custdao.addCustomer(cust);
			if(status==true)
			{
				System.out.println("Customer Added successfully");
			}
			else
			{
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}break;
	case 13:
	{System.out.println("Update Customer");
	try {
		System.out.println("Enter existing  Customer Id:");
		custId=sc.nextInt();
		
		System.out.println("Enter Customer name:");
		custName=br.readLine();
		
		System.out.println("Enter Address:");
		address=br.readLine();
		
		System.out.println("Enter emailId:");
		emailId=br.readLine();
		
		System.out.println("Enter Username:");
		UserName=br.readLine();
		
		System.out.println("Enter PhoneNumber:");
		phoneNumber=br.readLine();
		
		System.out.println("Enter Password:");
		password=br.readLine();
		
		cust=new Customer();
		cust.setCustId(custId);
		cust.setCustName(custName);
		cust.setAddress(address);
		cust.setEmailId(emailId);
		cust.setUserName(UserName);
		cust.setPhoneNumber(phoneNumber);
		cust.setPassword(password);
		
		status=custdao.updateCustomer(cust);
		if(status==true)
		{
			System.out.println("Customer updated successfully");
		}
		else
		{
			System.out.println("Something went wrong");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}break;
	case 14:
	{
		try {
		System.out.println("Delete Customer...");
		System.out.println("Enter Username:");
			UserName=br.readLine();
			status=custdao.deleteCustomer(UserName);
			if (status==true)
			{
				System.out.println("Customer deleted successfully");
			}
			else
			{
				System.out.println("Something went wrong");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}break;
	case 15:
	{
		System.out.println("Customers List..");
		custList=custdao.getAllCustomer();
		for(Customer cust1:custList)
		{
			System.out.println(cust1);
		}
	}break;
	case 16:
	{
		System.out.println("PlaceOrder");
		try {
		System.out.println("Enter Username:");
			UserName=br.readLine();
			status=orderdao.placeOrder(UserName);
			if(status==true)
			{
				System.out.println("Order placed successfully");
			}
			else
			{
				System.out.println("Something went wrong");
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}break;
	case 19:
	{
		System.out.println("Cart List..");
	cartList=Cartdao.getAllCarts();
		for(Cart cart1: cartList)
		{
			System.out.println(cart1);
		}
	}
	break;
	default:
	{
		System.out.println("Invalid choice");
	}
	}
}
}