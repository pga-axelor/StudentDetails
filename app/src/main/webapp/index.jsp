<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.student.db.StudentDetails"%><% 
    String contextpath=request.getContextPath();
    String path="/StudentDetails/show";
    response.sendRedirect(contextpath+path);
%>

<html>
<head>
<title>Index Page</title>
</head>

<body>
	<center>

		<h2>Show Student Details</h2>
		<form action="<%=request.getContextPath()%>/StudentDetails/show"
			method="POST">
			<input type="submit" value="Show">
		</form>

	</center>
</body>

</html>