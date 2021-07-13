<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password page</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<style>
label.error{color:red;}
</style>
</head>
<body>
<!--main div start -->
	<div id="main">
		<!--header -->
		<div id="footer">
			<jsp:include page="Header.jsp"></jsp:include>
		</div>

<%
String Admin=(String) session.getAttribute("Admin");
String Customer=(String) session.getAttribute("Customer");
String userName=(String) session.getAttribute("userName");
String status=(String)request.getAttribute("status");
if(status!=null)
	out.println(status);

%>
<fieldset>
<Legend style="color:purple">Change password</Legend>
<div align="center">
<form id="1" method="post" action="LoginServlet" onsubmit="return validate()">
<input type="hidden" name="operation" value="forgetPassword">
<table>
<tr>
<%
if(Admin!=null && Customer==null){
%>
<td><input type="radio" name="type" value="Admin" checked="checked">Admin</td>
<%
}
if((Customer!=null && Admin==null)){
%>
<td><input type="radio" name="type" value="Customer" checked="checked">Customer</td>
<%
}
%>
<%
if((Customer==null && Admin==null)){
%>
<td><input type="radio" name="type" value="Admin">Admin</td>
<td><input type="radio" name="type" value="Customer">Customer</td>
<td><span id="typeError" style="color:red;">*</span></td>
<%
}
%>
</tr>

<tr>
<%
if((Customer==null && Admin==null)){
%>
<th align="Left">Username:</th>
<td><input type="text" name="userName" id="userName" ></td>
<td><span id="UsernameError" style="color:red;">*</span></td>
<%
}
%>
<%
if((Customer!=null && Admin==null)){
%>
<th align="Left">Username:</th>
<td><input type="text" name="userName" id="userName" value="<%=userName%>" readonly="readonly"></td>
<td><span id="UsernameError" style="color:red;">*</span></td>
<%
}
%>
<% 
if((Customer==null && Admin!=null)){
%>
<th align="Left">Username:</th>
<td><input type="text" name="userName" id="userName" ></td>
<td><span id="UsernameError" style="color:red;">*</span></td>
<%
}
%>
</tr>
<tr>
<th align="Left"> New Password:</th>
<td><input type="password" name="newPassword" ></td>
<td><span id="newPasswordError" style="color:red;">*</span></td>
</tr>
<tr>
<th align="Left"> Confirm Password:</th>
<td><input type="password" name="newPassword" ></td>
<td><span id="confirmPasswordError" style="color:red;">*</span></td>
</tr>
</table>
<input type="submit" value="change"class="submit"/>
<input type="reset" value="cancel" class="submit"/>
</form>
</div>
</fieldset>
</div>
</body>
</html>