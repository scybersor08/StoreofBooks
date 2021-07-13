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
import in.Coder.bookstore.dao.cartDao;
import in.Coder.bookstore.dao.cartDaoImpl;
import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cartId,bookId,quantity;
	String Username;
	double price;
	boolean status;
	String operation; 
	List<Cart> cartList=new ArrayList<Cart>();
	Cart cart=new Cart();
	Book book=new Book();
	cartDao Cartdao=new cartDaoImpl();
	Bookdao bookdao=new BookdaoImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operation");
		HttpSession session=request.getSession(); 
		String user=(String)session.getAttribute("userName");
		System.out.println(user);
		if(operation!=null && operation.equals("addToCart"))
		{

			bookId=Integer.parseInt(request.getParameter("bookId"));
			System.out.println(bookId);
			book=bookdao.getBookById(bookId);
			int availQuantity=book.getQuantity();//stock quantity
			if(availQuantity>0)
			{
				cart.setBookId(bookId);
				cart.setQuantity(1);//manually set as we see there is default quantity.ordered quantity
				cart.setUserName(user);
				cart.setPrice(book.getBookprice());
				status=Cartdao.addToCart(cart);
				if(status==true)
				{
					request.setAttribute("status","<p style='color:green;'>Added to Cart Successfully..</p>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<p style='color:red;'>unable to add....</p>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}	
			}
			else
			{
				request.setAttribute("status", "<p style='color:red;'>something went wrong....</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("getMyCart"))
		{
			String Username=(String)session.getAttribute("userName");
			cartList=Cartdao.getCart(Username);
			System.out.println(cartList);
			if(cartList!=null)
			{
				session.setAttribute("cartList", cartList);
				RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("deleteCart"))
		{

			System.out.println(Username);
			cartId=Integer.parseInt(request.getParameter("cartId"));
			status=Cartdao.deleteCart(cartId, Username);
			if(status==true)
			{
				request.setAttribute("status","<p style='color:green;'>Deleted from Cart Successfully..</p>");
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
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}


