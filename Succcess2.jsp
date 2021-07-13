<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result page</title>
</head>
<body>
<div>
<%
String status=(String)request.getAttribute("addBookSuccess");
if(status!=null)
	out.println(status); 
String status1=(String)request.getAttribute("addBookFailure");
if(status1!=null)
	out.println(status1); 

String flag=(String)request.getAttribute("flag");
if(flag!=null)
	out.println(flag);

String cust=(String)request.getAttribute("customer");
if(cust!=null)
	out.println(cust);




%>

 </div>
</div>
</body>
</html>