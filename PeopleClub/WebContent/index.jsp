<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

	<center>
	<h1>Welcome to PeopleClub</h1>
	<br>
	<br>
	
<%
String message=request.getParameter("message");
%>


	<form action="http://localhost:9090/PeoplClub/LoginController" method="Post">
	<h1>Login Here</h1>
	<br><br>
	<%
	if(message==null)
	{
		
	}
	else
	{
	%>
	<b><font color="red">Invalid credentials</font></b>
	<br><br>
	<%
	}
	%>
	Enter your Phone Number:<input type="text" name="id" width="100px"/>
	<br><br>
	Password:<input type="password" name="password" width="100px"/>
	<br><br>
	<input type="submit" value="Login" width="100px" style="background-color:#002147;color:white"/>
	<br><br>
	</form>

<h4><a href="Register.jsp">Want to be a new Member?</a></h4>
		
	</center>

</body>
</html>