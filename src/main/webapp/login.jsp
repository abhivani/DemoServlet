<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form name="loginForm" method="post" action="detailsServlet">
<input type="hidden" name="task" value="login">

<label>Email:</label>
<input type="text" placeholder="Enter your email" name="email" required>
</br>
</br>

<label>Password:</label>
<input  placeholder="Enter your password" name="password" type="password" required>
</br>
</br>

<button type = "submit" value="submit" name="submit">Login</button>
<button type = "submit">Reset</button>


</body>
</html>