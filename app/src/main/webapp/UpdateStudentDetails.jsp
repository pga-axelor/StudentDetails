<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Conrtol"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Exipres" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Portal</title>
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
	width: 125px;
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
		<h1>Student Details Update</h1>
		<br> <br>
		<form name="StduentList"
			action="<%=request.getContextPath()%>/StudentDetails/update/<%=request.getAttribute("usn")%>"
			method="POST">
			<table>
				<tr>
					<th colspan="2"><h2 style="margin-left: 29%;">Update data</h2></th>
				</tr>
				<tr>
					<td><label>USN: </label></td>
					<td><input type="text" id="usn_u" name="usn_u"
						placeholder='<%=request.getAttribute("usn")%>' readonly></td>
				</tr>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" id="name_u" name="name_u"
						value='<%=request.getAttribute("name")%>' required></td>
				</tr>
				<tr>
					<td><label>Branch: </label></td>
					<td><input type="text" id="branch_u" name="branch_u"
						value='<%=request.getAttribute("branch")%>' required></td>
				</tr>
				<tr>
					<td><label>Semester: </label></td>
					<td><input type="text" id="sem_u" name="sem_u"
						value='<%=request.getAttribute("sem")%>' required></td>
				</tr>
				<tr>
					<td><label>Year: </label></td>
					<td><input type="text" id="year_u" name="year_u"
						value='<%=request.getAttribute("year")%>' required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="Reset" value="Reset"></td>
			</table>
		</form>
		<br> <br> <a href="SearchStudentDetails.jsp"><button>Search
				Student</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="goBack()">Back</button>
		<script>
			function goBack() {
				window.history.back();
			}
		</script>
	</center>
</body>
</html>
