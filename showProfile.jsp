<%@page import="in.Coder.bookstore.pojo.Customer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile page</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
</head>
<body>
	<!--main div start -->
	<div id="main">
		<!--header -->
		<div id="footer">
			<jsp:include page="Header.jsp"></jsp:include>
		</div>
<%
	String userName=(String)session.getAttribute("userName");
if(userName!=null){
%>
<% 
}
%>
<div align="center">
<p>
<a href="showProfile.jsp">
<%=userName
%></a></p>&nbsp;&nbsp;
</div>
<%
Customer c=(Customer)session.getAttribute("CustomerPOJO");
%>
<fieldset>
<Legend>Profile</Legend>
<div align="center">
<table border="1">
<tr>
<th>ID</th>
<td><%=c.getCustId() %></td>
</tr>

<tr>
<th>NAME</th>
<td><%=c.getCustName() %></td>
</tr>
<tr>
<th>ADDRESS</th>
<td><%=c.getAddress() %></td>
</tr>
<tr>
<th>EMAIL ID</th>
<td><%=c.getEmailId() %></td>
</tr>
<tr>
<th>USERNAME</th>
<td><%=c.getUserName() %></td></tr>
<tr>
<th>PHONE NO.</th>
<td><%=c.getPhoneNumber() %></td>
</tr>
<tr>
<th>PASSWORD</th>
<td><%=c.getPassword() %></td>
</tr>

</table>
<a href="CustomerServlet?operation=editCust&custId=<%=c.getCustId()%>">EDIT</a>
</div>
</fieldset>
</div>
</body>
</html>

