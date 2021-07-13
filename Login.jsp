<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content Type" content="text/html; charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<script type="text/javascript">
function validate(){
	
	var Username=document.getElementById("Username");
	var password=document.getElementById("password");
	var user=document.getElementById("type");
	if(user[0].checked==false && user[1].checked==false)
		{
		document.getElementById("typeError").innerHTML="select user!!!";
		return false;
		}
	else
		{
		document.getElementById("typeError").innerHTML="";
		}
	if(Username=="")
		{
		document.getElementById("UsernameError").innerHTML="Username cannot be empty";
		return false;
		}
	else
		{
		document.getElementById("UsernameError").innerHTML="";
		}
	if(password=="")
	{
	document.getElementById("passwordError").innerHTML="password cannot be empty";
	return false;
	}
else
	{
	document.getElementById("passwordError").innerHTML="";
	}
	if(password.length<5 || password.length>8)
		{
		document.getElementById("passwordError").innerHTML="password must be 5 to 8 characters Long";
		return false;
		}
	else
		{
		document.getElementById("passwordError").innerHTML="";
		}
	return true;
}
</script>
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

<div align="center">
<%
String status=(String)request.getAttribute("status");
if(status!=null)
	out.println(status);
%>
</div>
<%
String Admin=(String) session.getAttribute("Admin");
String Customer=(String) session.getAttribute("Customer");
String userName=(String) session.getAttribute("userName");

%>
<div align="center">
<h1>Log In</h1>
<form id="1" onsubmit="return validate()" action="LoginServlet" method="post">
<input type="hidden" name="operation" value="Login">
<table>
<tr>
<td><input type="radio" name="type" value="Admin">Admin</td>
<td><input type="radio" name="type" value="Customer">Customer</td>
<td><span id="typeError" style="color:red;">*</span></td>
</tr>
<tr>
<th align="Left">Username:</th>
<td><input type="text" name="userName" id="userName"></td>
<td><span id="UsernameError" style="color:red;">*</span></td>
</tr>
<tr>
<th align="Left">Password:</th>
<td><input type="password" name="password" ></td>
<td><span id="passwordError" style="color:red;">*</span></td>
</tr>
</table>
<input type="submit" value="Log In" class="submit"/>
<input type="reset" value="clear" class="submit"/>
</form>
<a href="ChangePassword.jsp">forgot password</a>
</div>
</div>
</body>
</html>