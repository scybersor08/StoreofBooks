<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		import ="in.Coder.bookstore.pojo.Book"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE BOOK PAGE</title>
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
Book book=(Book) session.getAttribute("bookPojo");

%>
<fieldset>
<Legend>UpdatebOOK</Legend>
<form method="post" action="BookServlet">
<input type="hidden" name="operation" value="updatebook">
<div  align="center">
<table>
<tr>
<th>BookID:</th>
<td><input type="text" name="bid" value="<%=book.getBookId()%>"readonly="readonly"></td>
</tr>
<tr>
<th>BookName:</th>
<td><input type="text" name="bname" value="<%=book.getBookName()%>"></td>
</tr>
<tr>
<th>BookAuthor:</th>
<td><input type="text" name="bauth" value="<%=book.getAuthorName()%>"></td>
</tr>
<tr>
<th>Book Publisher:</th>
<td><input type="text" name="bpub" value="<%=book.getPublisher()%>"></td>
</tr>
<tr>
<th>BookCategory:</th>
<td><input type="text" name="bcat" value="<%=book.getBookCategory()%>"></td>
</tr>
<tr>
<th>BookDescription:</th>
<td><input type="text" name="bdesc" value="<%=book.getDescription()%>"></td>
</tr>
<tr>
<th>BookQuantity:</th>
<td><input type="text" name="bquan" value="<%=book.getQuantity()%>"></td>
</tr>
<tr>
<th>BookPrice:</th>
<td><input type="text" name="bprice" value="<%=book.getBookprice()%>"></td>
</tr>
</table>
<input type="submit" value="update" class="submit">
<input type="reset" value="clear" class="submit">
</div>
</form>
</fieldset>
</div>
</body>
</html>