<%@page import="com.amstech.inc.demo.DTO.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		UserDTO userDTO = (UserDTO) request.getAttribute("userDTO");
		if (userDTO != null) {
	%>

	<h3>Welcome</h3>


	<h3 style="color: green;">
	
		<h3 style="color: green;">
			<%=userDTO.getFirstName()%></h3>

		<h3 style="color: blue;">
			<%=userDTO.getEmail()%></h3>
	</h3>

	

	<%
		}
	%>


</body>
</html>