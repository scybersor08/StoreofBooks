<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD BOOK</title>
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
<fieldset>
<Legend>ADD bOOK</Legend>
<form method="post" action="BookServlet">
<input type="hidden" name="operation" value="AddBook">
<div  align="center">
<table>
<tr>
<th>BookName:</th>
<td><input type="text" name="bname"></td>
</tr>
<tr>
<th>BookAuthor:</th>
<td><input type="text"name="bauth"></td>
</tr>
<tr>
<th>Book Publisher:</th>
<td><input type="text"name="bpub"></td>
</tr>
<tr>
<th>BookCategory:</th>
<td><input type="text"name="bcat"></td>
</tr>
<tr>
<th>BookDescription:</th>
<td><input type="text"name="bdesc"></td>
</tr>
<tr>
<th>BookQuantity:</th>
<td><input type="text"name="bquan"></td>
</tr>
<tr>
<th>BookPrice:</th>
<td><input type="text"name="bprice"></td>
</tr>
</table>
<input type="submit"value="Add" class="submit">
<input type="reset"value="clear" class="submit">
</div>
</form>
</fieldset>
</div>
</body>
</html>
