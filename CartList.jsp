<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		import="in.Coder.bookstore.pojo.Cart,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CartList page</title>
</head>
<body>
<!--main div start -->
	<div id="main">
		<!--header -->
		<div id="footer">
			<jsp:include page="Header.jsp"></jsp:include>
		</div>
<%
List<Cart> cartList=(List<Cart>)session.getAttribute("cartList");
%>
<div align="center">
<fieldset>
<Legend>MY CART</Legend>
<form action="OrderServlet" method="post">
<input type="hidden" name="operation" value="PlaceOrder">
<table border="2">
<tr>
<th>ID</th>
<th>BOOK ID</th>
<th>USERNAME</th>
<th>QUANTITY</th>
<th>PRICE</th>
<th colspan="3">ACTION</th>
</tr>
<%
for(Cart cart:cartList)
{
%>
<tr>
<td><%=cart.getCartId() %></td>
<td><input type="text" name="bookId" value="<%=cart.getBookId()%>" readonly="readonly"></td>
<td><%=cart.getUserName() %></td>
<td><input type="number" name="quantity" value="<%=cart.getQuantity() %>"></td>
<td><input type="text" name="price" value="<%=cart.getPrice() %>" readonly="readonly"></td>
<td><a href="CartServlet?operation=deleteCart&cartId=<%=cart.getCartId() %>">DELETE</a></td>
</tr>
<%} %>
</table>
<input type="submit" value="PlaceOrder" class="submit" >
</form>
</fieldset>
</div>
</div>
</body>
</html>