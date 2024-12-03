<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- directive to import package -->
 <%@page import="java.util.Scanner,java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<%!
		//not scriptlet
		//declaration tag, allowed to declare calss or instace variable or method
		int coef = 3;
		Scanner sc = new Scanner(System.in);
	%>
	<%
		//scriptlet -- variable isnisde it are local variable inside service method
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i+j;
	%>
	<!-- Expression to print something-->
	<p>Output is <%= k %></p>
	<p>Coefficient is <%= coef %></p>
</body>
</html>