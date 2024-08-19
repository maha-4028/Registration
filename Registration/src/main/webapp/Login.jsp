<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>Login</h1>
<form action="LoginServlet" method="post">
<lable for="name">Username:</lable>
<input type="text" id="name" name="name" required><br><br>
<label for="password">Password:</label>
<input type="password" id="password" name="pass" required><br><br>
<button type="submit">Login</button>

</form>
<p><a href="index.html">Back to Home</a></p>

<% String error = request.getParameter("error");
if(error != null && error.equals("1")) { %>
<p style="color: red;">Invalid username or password.Please try again.
<% } %>
</div>
</body>
</html>