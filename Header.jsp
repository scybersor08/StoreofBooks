<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header Page</title>
</head>
<body>
<%
String Admin=(String) session.getAttribute("Admin");
String Customer=(String) session.getAttribute("Customer");
%>
<%
if (Admin==null && Customer==null){
%>
<ul class="foot">
<li><a href="index.jsp">HOME</a></li>
<li><a href="AdCustomer.jsp">REGISTRATION</a></li>
<li><a href="Login.jsp">LOG IN</a></li>
<li><a href="BookServlet?operation=getAllBooks">BOOKS</a></li>
<li><a href="ChangePassword.jsp">CHANGE PASSWORD</a><br></li>
</ul>
<%
}
if (Admin!=null && Customer==null){
%>
<ul class="foot">
<li><a href="index.jsp">HOME</a></li>
<li><a href="AddBook.jsp">ADD BOOK</a></li>
<li><a href="CustomerServlet?operation=getcust">CUSTOMERS</a></li>
<li><a href="BookServlet?operation=getAllBooks">BOOKS</a></li>
 <li><a href="ChangePassword.jsp">CHANGE PASSWORD</a><br></li>
 <li><a href ="LoginServlet">LOG OUT</a><br></li>
</ul>
<%
}if(Admin==null && Customer!=null){
%>
<ul class="foot">
<li><a href="index.jsp">HOME</a></li>
 <li><a href="showProfile.jsp">PROFILE</a></li>
 <li><a href="BookServlet?operation=getAllBooks">BOOKS</a></li>
 <li><a href="CartServlet?operation=getMyCart">MY CART</a></li>
 <li><a href="OrderServlet?operation=getMyOrder">MY ORDER</a></li>
 <li><a href="ChangePassword.jsp">CHANGE PASSWORD</a><br></li>
 <li><a href ="LoginServlet">LOG OUT</a><br></li>
</ul>
<%
}
%>

</body>
</html>