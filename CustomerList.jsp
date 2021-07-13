<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			import="in.Coder.bookstore.pojo.Customer,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List page</title>
</head>
<body>
<div id="header"><jsp:include page="Header.jsp"></jsp:include>
</div>
<%
	List<Customer> custList=(List<Customer>)session.getAttribute("custList");
%>
<div align="center">
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>ADDRESS</th>
<th>EMAIL ID</th>
<th>USERNAME</th>
<th>PHONE NO.</th>
<th>PASSWORD</th>

<th colspan="1">ACTION</th>
</tr>
<% 
for(Customer cust:custList)
{
%>
<tr>
<td><%out.println(cust.getCustId()); %></td>
<td><%=cust.getCustName()%></td>
<td><%=cust.getAddress() %></td>
<td><%=cust.getEmailId() %></td>
<td><%=cust.getUserName() %></td>
<td><%=cust.getPhoneNumber() %></td>
<td><input type="password" value="<%=cust.getPassword()%>"readonly="readonly"></td>
<td><a href="CustomerServlet?operation=editCust&custId=<%=cust.getCustId() %>">EDIT</a></td>
</tr>
<%
}
%>
</table>
</div>
</body>
</html>