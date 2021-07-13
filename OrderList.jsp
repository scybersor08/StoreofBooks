<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			import="in.Coder.bookstore.pojo.Order,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
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
	List<Order> orderList=(List<Order>)session.getAttribute("orderList");
%>

<div align="center">
<table border="1">
<tr>
<th>ID</th>
<th>USERNAME</th>
<th>TOTAL BILL</th>
<th>DATE</th>
</tr>
<% 
for(Order order:orderList)
{
%>
<tr>
<td><%out.println(order.getOrderId()); %></td>
<td><%=order.getCustUserName()%></td>
<td><%=order.getTotalBill() %></td>
<td><%=order.getDate()%></td>
</tr>
<%
}
%>
</table>
</div>
</div>
</body>
</html>