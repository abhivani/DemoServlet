<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="detailsServlet" method="post">
<input name="task" value ="signup" type="hidden">

<p>
FirstName: <input name="firstName" type="text">
</p>

<p>
LastName: <input name="lastName" type="text">
</p>

<p>
Email: <input name="email" type="text">
</p>


<p>
password :<input name="password" type="password">
</p>

<input type="submit" value ="submit" name="submit">
<input type="reset" name="reset" value ="Reset">
</form>
</body>
</html>