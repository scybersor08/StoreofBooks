<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			import ="in.Coder.bookstore.pojo.Customer"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update customer page</title>
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
<% Customer cust=(Customer) session.getAttribute("customer");%>
<fieldset>
<Legend>UPDATE CUSTOMER</Legend>
<form method="post" action="CustomerServlet">
<input type="hidden" name="operation" value="UpdateCustomer">
<div  align="center">
<table>
<tr>
<th>custId:</th>
<td><input type="text" name="custId" value="<%=cust.getCustId() %>" readonly="readonly"></td>
</tr>
<tr>
<th>custName:</th>
<td><input type="text" name="custName" value="<%=cust.getCustName()%>"></td>

</tr>
<tr>
<th>Address:</th>
<td><input type="text"name="address" value="<%=cust.getAddress() %>"></td>
</tr>
<tr>
<th>emailId:</th>
<td><input type="text"name="emailId" value="<%=cust.getEmailId() %>"></td>
</tr>
<tr>
<th>phone number:</th>
<td><input type="text"name="phoneNumber" value="<%=cust.getPhoneNumber() %>"></td>
</tr>
</table>
<input type="submit"value="update" class="submit">
<input type="reset"value="clear" class="submit">
</div>
</form>
</fieldset>
</div>
</body>
</html>