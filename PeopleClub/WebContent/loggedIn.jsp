<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.lti.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	User u=(User)session.getAttribute("user");
%>

<center>
<br><br>
		
		
		<a href="http://localhost:9090/PeopleCLub/FetchAllUsers">Show Members</a>
		
		<br><br>
		
		<h2>Your Profile</h2>
		
		First Name: <%= u.getFname()%>
		<br><br>
		Last Name: <%= u.getLname()%>
		<br><br>
		Phone Number: <%= u.getId()%>
		<br><br>
		Date of Birth: <%= u.getDob()%>
		<br><br>
		City: <%= u.getCity()%>

<br><br>


		<a href="http://localhost:9090/PeopleCLub/UDUserControl">Want To Delete your Membership Account?</a>
		<a href="logout.jsp">Logout</a>
		
</center>
</body>
</html>