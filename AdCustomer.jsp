<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add customer</title>
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
<Legend>REGISTARTION</Legend>
<form method="post" action="CustomerServlet">
<input type="hidden" name="operation" value="AddCustomer">
<div  align="center">
<table>
<tr>
<th>custName:</th>
<td><input type="text" name="custName"></td>
</tr>
<tr>
<th>Address:</th>
<td><input type="text"name="address"></td>
</tr>
<tr>
<th>emailId:</th>
<td><input type="text"name="emailId"></td>
</tr>
<tr>
<th>Username:</th>
<td><input type="text"name="UserName"></td>
</tr>
<tr>
<th>phone number:</th>
<td><input type="text"name="phoneNumber"></td>
</tr>
<tr>
<th>Password:</th>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit"value="REGISTER" class="submit">
<input type="reset"value="CLEAR" class="submit"/>
</div>
</form>
</fieldset>
</div>
</body>
</html>