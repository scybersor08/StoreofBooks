package in.Coder.bookstore.servlet;

import java.io.IOException;
import java.time.LocalDate;
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
import in.Coder.bookstore.dao.OrderDao;
import in.Coder.bookstore.dao.OrderDaoImpl;
import in.Coder.bookstore.dao.cartDao;
import in.Coder.bookstore.dao.cartDaoImpl;
import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Order order=new Order();
	Book book=new Book();
	OrderDao orderdao=new OrderDaoImpl();
	cartDao Cartdao=new cartDaoImpl();
	Bookdao bookdao=new BookdaoImpl();

	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String custUserName=(String)session.getAttribute("userName");
		System.out.println(custUserName);

		String operation=request.getParameter("operation");
		System.out.println(operation);
		if(operation!=null && operation.equals("getMyOrder"))
		{
			List<Order> orderList=orderdao.getOrderByCustUserName(custUserName);
			if(orderList!=null && !orderList.isEmpty())
			{
				session.setAttribute("orderList", orderList);
				System.out.println("in servlet "+orderList);
				response.sendRedirect("OrderList.jsp");
			}
			else
			{
				request.setAttribute("status", "<b style='color:red'>Please select book first...</b>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("getAllOrders"))
		{
			List<Order> orderList=orderdao.getAllOrders();
			if(orderList!=null && !orderList.isEmpty())
			{
				session.setAttribute("orderList", orderList);
				System.out.println("in servlet "+orderList);
				response.sendRedirect("OrderList.jsp");
			}
			else
			{
				request.setAttribute("status", "<b style='color:red'>something went wrong...</b>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//session.getAttribute("custUserName");
		String custUserName=(String)session.getAttribute("userName");
		double totalBill=0;
		int x=0;

		LocalDate date=LocalDate.now();
		String operation=request.getParameter("operation");
		System.out.println(operation);
		if(operation!=null && operation.equals("PlaceOrder"))
		{
			String  bookId[]=request.getParameterValues("bookId");
			String price[]=request.getParameterValues("price");
			String quantity[]=request.getParameterValues("quantity");

			Book book[]=new Book[bookId.length];
			for(int i=0;i<price.length;i++)
			{
				totalBill=totalBill+(Double.parseDouble(price[i])*(Integer.parseInt(quantity[i])));
			}
			System.out.println(totalBill);

			order.setCustUserName(custUserName);
			order.setDate(date);
			order.setTotalBill(totalBill);
			for(int i=0;i<bookId.length;i++)
			{
				book[i]=bookdao.getBookById(Integer.parseInt(bookId[i]));
				System.out.println(book[i]);
				int newQuantity=book[i].getQuantity()-Integer.parseInt(quantity[i]);
				System.out.println(newQuantity);
				if(newQuantity>=0)
				{
					//int flag=orderdao.updateQuantity(Integer.parseInt(bookId[i],newQuantity));
					x=1;
				}else 
				{
					x=0;
					break;
				}
			}
			long orderId =orderdao.placeOrder(order);
			System.out.println(orderId);
			if(orderId>0 && x==1)
			{
				boolean b=Cartdao.clearCart(custUserName);
				for(int i=0;i<bookId.length;i++)
				{
					book[i]=bookdao.getBookById(Integer.parseInt(bookId[i]));
					int newQuantity=book[i].getQuantity()-Integer.parseInt(quantity[i]);
					int flag=orderdao.updateQuantity(Integer.parseInt(bookId[i]),newQuantity);
				}
				if(b==true)
				{
					request.setAttribute("status","<b style='color:green;'>Order placed Successfully and orderId:"+orderId+"and totalbill:"+totalBill+"</b>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<p style='color:red;'>unable to place....</p>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}			
			}
			else
			{
				request.setAttribute("status", "<p style='color:red;'>Something went wrong....</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
	}
}