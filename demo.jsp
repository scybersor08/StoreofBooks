<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Welcome to Library</title>
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
			<h2>Welcome to Library</h2>

			<p class="weltxt">Library Management is a web-based, integrated library system for
				managing library resources, including traditional and digital
				collections, and automating daily library operations. It provides
				the tools necessary to meet the rapidly changing requirements of the
				digital library. Library Management streamlines and facilitates the
				day-to-day operations of a corporate, government, or organizational
				library. Comprised of a set of modules, it provides: Patron and
				self-service Cataloging and maintenance of library materials
				Circulation processing Receiving and routing of serial publications
				Management of the purchasing process for published materials
				Flexible policy administration</p>
			<br class="spacer" />
			<br class="spacer" />
			
			<h3>Books</h3>
			<div class="menu">
				<ul class="brown">
					<li><a href="/getbookbyname/java"> Java
					</a></li>
					<li><a href="/getbookbyname/python"> Python
					</a></li>
					<li><a href="/getbookbyname/django">Django
					</a></li>
					<li><a href="/getbookbyname/maths">Maths
					</a></li>
				</ul>
				<ul class="brown">
					<li><a href="#" title="Reprehenderit">Reprehenderit </a></li>
					<li><a href="#" title="Commodo">Commodo</a></li>
					<li><a href="#" title="Excepteur">Excepteur </a></li>
					<li><a href="#" title="Magna">Magna </a></li>
				</ul>
				<ul class="brown">
					<li><a href="#" title="Adipisicing">Adipisicing </a></li>
					<li><a href="#" title="Deserunt">Deserunt </a></li>
					<li><a href="#" title="Consectetur">Consectetur </a></li>
					<li><a href="#" title="Voluptate">Voluptate </a></li>
				</ul>
				<ul class="brown">
					<li><a href="#" title="Excepteur">Excepteur </a></li>
					<li><a href="#" title="Magna">Magna</a></li>
					<li><a href="#" title="Commodo">Commodo </a></li>
					<li><a href="#" title="Excepteur">Excepteur </a></li>
				</ul>
				<ul class="brown">
					<li><a href="#" title="Mollit anim">Mollit anim </a></li>
					<li><a href="#" title="Sint occaecat">Sint occaecat</a></li>
					<li><a href="#" title="Duis aute">Duis aute </a></li>
					<li><a href="#" title="Cupidatat">Cupidatat </a></li>
				</ul>
				<br class="spacer" />
			</div>
			<h3>Issue Book</h3>
			<ul class="image">
				<li><img src="{%static '/images/java.jpg'%}" width="95" height="91" /><br />
				<span>Java</span><br /><br /> 
				<a href="/getbookbyname/java">Issue Now</a></li>
				<li><img src="{%static '/images/java.jpg'%}" width="95" height="91" /><br />
				<span>Maths</span><br /><br />
				<a href="/getbookbyname/maths">Issue Now</a></li>
				<li><img src="{%static '/images/java.jpg'%}" width="95" height="91" /><br />
				<span>Sherlock Holmes</span><br /><br />
				<a href="/getbookbyname/Sherlock">Issue Now</a></li>
				<li><img src="{%static '/images/java.jpg'%}" width="95" height="91" /><br />
				<span>Python</span><br /><br />
				<a href="/getbookbyname/python">Issue Now</a></li>
				<li><img src="{%static '/images/java.jpg'%}" width="95" height="91" /><br />
				<span>Django</span><br /><br />
				<a href="/getbookbyname/django">Issue Now</a></li>
			</ul>
			<br class="spacer" /> <br class="spacer" /> <br class="spacer" />
		</div>
		<!--right start -->
		<div id="right">
			<h3 >Book Category</h3>
			<br/>
				<ul class="cat">

				<li><a href="/getbookbycategory/edu">Educational</a></li><br/>
				<li><a href="/getbookbycategory/fiction">Fiction</a></li><br/>
				<li><a href="/getbookbycategory/gk">General Knowledge</a></li><br/>
				<li><a href="/getbookbycategory/novel">Novel</a></li><br/>
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
