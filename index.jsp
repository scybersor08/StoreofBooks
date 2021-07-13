<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Welcome to Library</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<script type="text/javascript" src="js/jquery.min.js" >
</script>

<script type="text/javascript" src="js/jquery-3.3.1" >
</script>

</head>
<body>

	<!--main div start -->
	<div id="main">
		<!--header -->
		
		<div id="footer">
			<jsp:include page="Header.jsp"></jsp:include>
		</div>
		<div align="left">
			<form id="form" action="BookServlet" method="get">
				<input type="text" class="submit" name="bookName" placeholder="Search book here"/>
				<input type="hidden" name="operation" value="searchByName"/>		
				<input type="submit" class="submit"/>
				<span id="span" style="color: red;"></span> 
			</form>
			<script>
				$("form").submit(function(event) 
				{
					if ( $("input:first").val() == "") 
					{
						$("#span").text("Please Enter Book Name!!!").show().fadeOut(2000);
						event.preventDefault();
					}	 
				});
			</script>
		</div>
		<br/><br/>
		<div id="header">
			<img  src="images/header.jpg" width="780px;" height="380px;" style="background-repeat: no-repeat;" /> 
		</div>
		<div align="center" id="main">
			<br />
			<p>
			
			</p>
			<br />
		</div>

		<!--body start -->
		<div id="left">
			<h2>Welcome to Online BookStore</h2>

			<p class="weltxt">Bookstore is about picking your books of interest.Each kind ofBook might be available 
			in the upcoming updates.so we will be glad if you choose our website for
			 ordering and showing some curiosity in our website.we would love to deal  with you.  
			 Give us one chance and we will try to be your everytime  first choice whenever you feel like buying books.</p>
			<br class="spacer" />
			<br class="spacer" />
			
			<h3>Books</h3>
			<div class="menu">
				<ul class="brown">
					<li><a href="BookServlet?operation=searchByName&bookName=Java programming"> Java </a></li>
					<li><a href="BookServlet?operation=searchByName&bookName=python" > python</a></li>
					<li><a href="BookServlet?operation=searchByName&bookName=django">Django </a></li>
					<li><a href="BookServlet?operation=searchByName&bookName=Maths">Maths </a></li>
				</ul>
				
				<ul class="brown" >
					<li><a href="#BookServlet?operation=searchByAuthor&authorName=james">james</a></li>
					<li><a href="BookServlet?operation=searchByAuthor&authorName=Ganesh">Ganesh</a></li>
					<li><a href="BookServlet?operation=searchByAuthor&authorName=Ganesh">Ganesh </a></li>
					<li><a href="BookServlet?operation=searchByAuthor&authorName=Ganesh">Ganesh </a></li>
				</ul>
				<ul class="brown">
					<li><a href="BookServlet?operation=searchByPublisher&bookPublisher=pune"></a>Pune</li>
					<li><a href="BookServlet?operation=searchByPublisher&bookPublisher=pune"></a>Pune</li>
					<li><a href="BookServlet?operation=searchByPublisher&bookPublisher=pune"></a>Pune</li>
					<li><a href="BookServlet?operation=searchByPublisher&bookPublisher=Mumbai Publication">Mumbai </a></li>
				</ul>
					<br class="spacer" />
			</div>
			
			<h3>Issue Book</h3>
			<ul class="image">
			
				<li><img src="images/javaBook.jpg" width="95"
					height="91" /><br /> <span>Java Programming</span><br /><br />
				<br /> <a href="BookServlet?operation=searchByName&bookName=Java programming">Issue Now</a></li>
				<li><img src="images/MathsBook.jpgit" width="95"
					height="91" /><br /> <span>Maths</span><br /><br />
				<br /> <a href="BookServlet?operation=searchByName&bookName=Maths">Issue Now</a></li>
				<li><img src="images/java.jpg" width="95"
					height="91" /><br /> <span>Java</span><br /><br />
				<br /> <a href="BookServlet?operation=searchByName&bookName=Java programming">Issue Now</a></li>
				<li><img src="images/PythonBook.jpg" width="95"
					height="91" /><br /> <span>Python</span><br /><br />
				<br /> <a href="BookServlet?operation=searchByName&bookName=python">Issue Now</a></li>
				<li><img src="images/DjangoBook.jpg" width="95"
					height="91" /><br /> <span>Django</span><br /><br />
				<br /> <a href="BookServlet?operation=searchByName&bookName=django">Issue Now</a></li>
			</ul>

			<br class="spacer" /> <br class="spacer" /> <br class="spacer" />
		</div>
		<!--right start -->
		<div id="right">
			<h3 >Book Category</h3>
			<br/>
				<ul class="cat">

				<li><a href="BookServlet?operation=searchByCategory&bookCategory=Educational">Educational</a></li>
				<br />
				<li><a href="BookServlet?operation=searchByCategory&bookCategory=Educational">Fiction</a></li>
				<br />
				<li><a href="BookServlet?operation=searchByCategory&bookCategory=edu">General Knowledge</a></li>
				<br />
				<li><a href="BookServlet?operation=searchByCategory&bookCategory=edu">Novel</a></li>
				<br />
			</ul>
				
			
			<p class="border"></p>
			<p class="ourtxt">
				<strong>Phone Numbers:</strong><br /> 
				<span>+55(0)7778748200/+00400</span><br /> 	
				<strong>e-mail to:</strong><br /> 
				<a href="https://accounts.google.com/ServiceLogin/signinchooser">info@modernlibrary.com</a>
			</p>
		</div>
	
	</div>
</body>
</html>
