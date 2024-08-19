<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Welcome,<%=request.getParameter("name")%>!</h1>
<p>We're delighted to have you on my profile</p><br>
<iframe src="Mahalakshmi_2023_BE(CSE)_Java (2).pdf" width="800px" height="500px" /><br><br>
<a href="downloadResume">Download Resume</a><br><br>
you can <a href="logout.jsp">LOGOUT</a> Securely

</div>
</body>
</html>