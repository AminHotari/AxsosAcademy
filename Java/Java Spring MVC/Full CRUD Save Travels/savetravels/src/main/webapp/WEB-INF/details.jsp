<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Show Expense</title>
</head>
<body>
	<h2>Expense Details</h2>
	<a href="">Go back</a>
	<table>
		<tr>
			<td>Expense Name:</td>
			<td>${details.name1}</td>
		</tr>
		<tr>
			<td>Expense Description:</td>
			<td>${details.description}</td>
		</tr>
		<tr>
			<td>Vendor:</td>
			<td>${details.vendor}</td>
		</tr>
		<tr>
			<td>Amount Spent:</td>
			<td>${details.amount}</td>
		</tr>
	</table>
</body>
</html>