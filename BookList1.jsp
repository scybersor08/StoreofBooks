<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="in.Coder.bookstore.pojo.Book,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Book> bookList=(List<Book>)session.getAttribute("bookList");
%>
<div align="center">
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>AUTHOR</th>
<th>PUBLISHER</th>
<th>CATEGORY</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th colspan="3">ACTION</th>
</tr>
<% 
for(Book book:bookList)
{
%>
<tr>
<td><%out.println(book.getBookId()); %></td>
<td><%=book.getBookName() %></td>
<td><%=book.getAuthorName() %></td>
<td><%=book.getPublisher() %></td>
<td><%=book.getBookCategory() %></td>
<td><%=book.getDescription() %></td>
<td><%=book.getBookprice() %></td>
<td><%=book.getQuantity() %></td>
<td><a href="BookServlet?operation=editBook&bookId=<%=book.getBookId() %>">EDIT</a></td>
<td><a href="BookServlet?operation=deleteBook&bookId=<%=book.getBookId() %>">DELETE</a></td>
<td><a href=" CartServlet?operation=addToCart&bookId=<%=book.getBookId() %>">ADD TO CART</a></td>
</tr>
<%
}
%>
</table>
</div>
</body>
</html>