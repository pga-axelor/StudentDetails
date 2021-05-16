<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.student.db.StudentDetails"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Conrtol"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Exipres" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search StudentDetailss</title>
<link rel="icon" type="image/x-icon"
	href="../assets/images/Address-Book-icon.ico">
<link rel="stylesheet" href="assets/css/main.css">
<style type="text/css">
body {
	font-family: 'Nunito', sans-serif;
	color: #384047;
}

table {
	max-width: 960px;
	margin: 10px auto;
}

caption {
	font-size: 1.6em;
	font-weight: 400;
	padding: 10px 0;
}

thead th {
	font-weight: 400;
	background: #8a97a0;
	color: #FFF;
}

tr {
	background: #f4f7f8;
	border-bottom: 1px solid #FFF;
	margin-bottom: 5px;
}

tr:nth-child(even) {
	background: #e8eeef;
}

th, td {
	text-align: left;
	padding: 20px;
	font-weight: 300;
}

tfoot tr {
	background: none;
}

tfoot td {
	padding: 10px 2px;
	font-size: 0.8em;
	font-style: italic;
	color: #8a97a0;
}

img {
	width: 25px;
	height: 25px;
}

button {
	width: 250px;
	height: 30px;
	font-size: 15px;
	background-color: #e7e7e7;
	color: black;
	transition-duration: 0.4s;
	border-radius: 5px;
}

button:hover {
	background-color: #CACACA;
}

.all {
	margin-left: 50%
}
</style>
</head>
<body>
	<center>
		<form action="<%=request.getContextPath()%>/StudentDetails/search"
			method="POST">

			<h2>Search Student Details</h2>

			<table>
				<tr>
					<th colspan="2">Search StudentDetails:</th>
					<td colspan="3"><input type="text" name="findusn"
						placeholder="Enter USN of Student" required="required"></td>
	</td>
						<td><label class="radio-inline"> 
						 <input type="radio" id="usn" name="opt" value="usn" checked>By USN
					</label> <label class="radio-inline"> 
					<input type="radio" id="name" name="opt" value="name">By Name
					</label></td>
					<td colspan="2"><input type="submit" value="Search"
						style="width: 200px"></td>
				</tr>
			</table>
			<br> <br>
			<table>
				<%
				if (request.getAttribute("allStudentDetails") != null) {
					List<StudentDetails> S = (ArrayList<StudentDetails>)request.getAttribute("allStudentDetails");
				%>
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>MobileNo</th>
					<th>Email-Id</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<%
				for (StudentDetails s : S) {

					out.print("<tr>");

					out.print("<td>");
					out.print(s.getUsn());
					out.print("</td>");

					out.print("<td>");
					out.print(s.getSname());
					out.print("</td>");

					out.print("<td>");
					out.print(s.getBranch());
					out.print("</td>");

					out.print("<td>");
					out.print(s.getSem());
					out.print("</td>");

					out.print("<td>");
					out.print(s.getYear());
					out.print("</td>");

					out.print("<td>");
				%>
				<a href="fetch/<%=s.getUsn()%>">Update</a>
				<%
				out.print("</td>");

				out.print("<td>");
				%>
				<a href="delete/<%=s.getUsn()%>">Delete</a>
				<%
				out.print("</td>");

				out.print("</tr>");
				}
				S= null;
				}
				%>
			</table>
			<br> <br>
			<button onclick="goBack()">Back</button>
			<script>
				function goBack() {
					window.history.back();
				}
			</script>
		</form>
	</center>
</body>
</html>
