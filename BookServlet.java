package in.Coder.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.Coder.bookstore.dao.Bookdao;
import in.Coder.bookstore.dao.BookdaoImpl;
import in.Coder.bookstore.pojo.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int bookQuantity,bookId;
	String BookName,BookPublisher,BookCategory,BookDescription,authorName;
	String operation;
	double bookPrice;
	boolean status;
	Book book=null;
	List<Book> bookList;
	Bookdao bookdao=new BookdaoImpl();
       

    public BookServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		
		if(operation!=null && operation.equals("getAllBooks"))
		{
			bookList=new ArrayList<Book>();
			bookList=bookdao.getAllBoooks();
			System.out.println(bookList);
			if(bookList!=null)
			{
				session.setAttribute("bookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("editBook"))
		{
			bookId=Integer.parseInt(request.getParameter("bookId"));
			book=new Book();
			book=bookdao.getBookById(bookId);
			if(book!=null)
			{
				session.setAttribute("bookPojo", book);
				RequestDispatcher rd=request.getRequestDispatcher("updatebook.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("deleteBook"))
		{
			bookId=Integer.parseInt(request.getParameter("bookId"));
			status=bookdao.deleteBook(bookId);
			if(status==true)
			{
				request.setAttribute("status","<p style='color:green;'>Book deleted Successfully..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("status", "<p style='color:red;'>unable to delete....</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				}
		}
		
		else if(operation!=null && operation.equals("searchByName"))
		{
			String bookName=request.getParameter("bookName");
			bookList=new ArrayList<Book>();
			bookList=bookdao.getBookByName(bookName);
			System.out.println(bookList);
			if(bookList!=null)
			{
				session.setAttribute("bookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(operation!=null && operation.equals("searchByAuthor"))
		{
			authorName=request.getParameter("authorName");
			bookList=new ArrayList<Book>();
			bookList=bookdao.getBookByAuthorName(authorName);
			System.out.println(bookList);
			if(bookList!=null)
			{
				session.setAttribute("bookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(operation!=null && operation.equals("searchByCategory"))
		{
			
			String bookCategory=request.getParameter("bookCategory");
			bookList=new ArrayList<Book>();
			bookList=bookdao.getBookByBookCategory(bookCategory);
			System.out.println(bookList);
			if(bookList!=null)
			{
				session.setAttribute("bookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(operation!=null && operation.equals("searchByPublisher"))
		{
			
			String bookPublisher=request.getParameter("bookPublisher");
			bookList=new ArrayList<Book>();
			bookList=bookdao.getBookByBookCategory(bookPublisher);
			System.out.println(bookList);
			if(bookList!=null)
			{
				session.setAttribute("bookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operation");
		if(operation!=null && operation.equals("AddBook"))
		{
		
		BookName=request.getParameter("bname");
		authorName=request.getParameter("bauth");
		BookCategory=request.getParameter("bcat");
		BookDescription=request.getParameter("bdesc");
		BookPublisher=request.getParameter("bpub");
		bookQuantity=Integer.parseInt(request.getParameter("bquan"));
		bookPrice=Double.parseDouble(request.getParameter("bprice"));

		//response.sendRedirect("Success1.html");
		book=new Book();
		book.setBookName(BookName);
		book.setAuthorName(authorName);
		book.setBookCategory(BookCategory);
		book.setDescription(BookDescription);
		book.setPublisher(BookPublisher);
		book.setQuantity(bookQuantity);
		book.setBookprice(bookPrice);
		status=bookdao.insertBook(book);
		
if(status==true)
{
		request.setAttribute("addBookSuccess","<p style='color:green;'>Book added Successfully..</p>");
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	}
else
{
	request.setAttribute("addBookFailure", "<p style='color:red;'>unable to add....</p>");
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	}
}
		else if(operation!=null && operation.equals("updatebook"))
		{
			bookId = Integer.parseInt(request.getParameter("bid"));	
			BookName=request.getParameter("bname");
			authorName=request.getParameter("bauth");
			BookCategory=request.getParameter("bcat");
			BookDescription=request.getParameter("bdesc");
			BookPublisher=request.getParameter("bpub");
			bookQuantity=Integer.parseInt(request.getParameter("bquan"));
			bookPrice=Double.parseDouble(request.getParameter("bprice"));

			//response.sendRedirect("Success1.html");
			book=new Book();
			book.setBookId(bookId);
			book.setBookName(BookName);
			book.setAuthorName(authorName);
			book.setBookCategory(BookCategory);
			book.setDescription(BookDescription);
			book.setPublisher(BookPublisher);
			book.setQuantity(bookQuantity);
			book.setBookprice(bookPrice);
			status=bookdao.updateBook(book);
			
	if(status==true)
	{
			request.setAttribute("status", "<p style='color:green;'>Book updated Successfully..</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
	else
	{
		request.setAttribute("status", "<p style='color:red;'>unable to update...</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
		}
	}
}