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
import in.Coder.bookstore.dao.CustomerDao;
import in.Coder.bookstore.dao.CustomerDaoImpl;
import in.Coder.bookstore.pojo.Book;
import in.Coder.bookstore.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int custId;
	String custName,address,emailId,UserName,phoneNumber,password;
	String operation;
	
	boolean status;
	Customer cust=null;
	List<Customer> custList;
	CustomerDao custdao=new CustomerDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		
		if(operation!=null && operation.equals("getcust"))
		{
			custList=new ArrayList<Customer>();
			custList=custdao.getAllCustomer();
			System.out.println(custList);
			if(custList!=null)
			{
				session.setAttribute("custList", custList);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("status","<p style='color:red;'>Something went wrong..</p>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equals("editCust"))
		{
			custId=Integer.parseInt(request.getParameter("custId"));
			cust=new Customer();
			cust=custdao.getCustById(custId);
			if(cust!=null)
			{
				session.setAttribute("customer", cust);
				RequestDispatcher rd=request.getRequestDispatcher("UpdateCustomer.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operation");
		if(operation!=null && operation.equals("AddCustomer"))
		{
		
		custName=request.getParameter("custName");
		address=request.getParameter("address");
		emailId=request.getParameter("emailId");
		UserName=request.getParameter("UserName");
		phoneNumber=request.getParameter("phoneNumber");
		password=request.getParameter("password");
		
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
			request.setAttribute("status","<p style='color:green;'>Registered Successfully..</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
	else
	{
		request.setAttribute("status", "<p style='color:red;'>unable to register....</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
}
		else if(operation!=null && operation.equals("UpdateCustomer"))
		{
			custId = Integer.parseInt(request.getParameter("custId"));			
			custName=request.getParameter("custName");
			address=request.getParameter("address");
			emailId=request.getParameter("emailId");
			UserName=request.getParameter("UserName");
			phoneNumber=request.getParameter("phoneNumber");
			password=request.getParameter("password");
			
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
			request.setAttribute("status","<p style='color:green;'>Customer Updated Successfully..</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
	else
	{
		request.setAttribute("status", "<p style='color:red;'>unable to update....</p>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
	}
	}
	}


