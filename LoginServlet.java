package in.Coder.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.Coder.bookstore.dao.CustomerDaoImpl;
import in.Coder.bookstore.dao.LoginDao;
import in.Coder.bookstore.dao.LoginDaoImpl;
import in.Coder.bookstore.pojo.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		System.out.println(operation);
		LoginDao ldao=new LoginDaoImpl();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String newPassword=request.getParameter("newPassword");
		HttpSession session=request.getSession();
		
		if(operation!=null && operation.equals("Login"))
		{
			String type=request.getParameter("type");
			System.out.println(type);
			
			if(type!=null && type.equals("Admin"))
			{
				boolean status=ldao.login(userName,password, type);
				if(status==true)
				{
					session.setAttribute("UserName", userName);
					session.setAttribute("Admin",type);
					session.setAttribute("type", type);
					request.setAttribute("status", "<b style='color:green;'>You have successfully Logged in as admin..</b>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<b style='color:red;'>Login failed</b>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
			else if(type!=null && type.equals("Customer"))
			{
				boolean status=ldao.login(userName, password, type);
				if(status==true)
				{
					session.setAttribute("userName",userName);
					Customer c=new Customer();
					CustomerDaoImpl custdao=new CustomerDaoImpl();
					
					c=custdao.getCustByUsername(userName);
					session.setAttribute("CustomerPOJO",c);//show profile
					session.setAttribute("Customer",type);
					session.setAttribute("type", type);
					request.setAttribute("status", "<b style='color:green;'>You have successfully Logged in as customer..</b>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<b style='color:red;'>Login failed</b>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
		}
		else if(operation!=null && operation.equals("forgetPassword"))
		{
			String type=request.getParameter("type");
			System.out.println("in servlet " +type);
			
			if(type!=null && type.equals("Admin"))
			{
				boolean status=ldao.changePassword(userName, newPassword, type);
				if(status==true)
				{
					session.invalidate();
					request.setAttribute("status", "<b style='color:green;'>Password changed Successfully.</b>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<b style='color:red;'>Password not changed</b>");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				}
		}
			else if(type!=null && type.equals("Customer"))
			{
				boolean status=ldao.changePassword(userName, newPassword, type);
				if(status==true)
				{
					session.invalidate();//log out
					request.setAttribute("status", "<b style='color:green;'>Password changed Successfully.</b>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status", "<b style='color:red;'>Password not changed</b>");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				}
		}
		}
	}
}


