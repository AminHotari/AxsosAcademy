<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Project Details</title>
</head>
<body>
	<header>
		<h2>Project Details</h2>
		<a href="/dashboard">Back to Dashboard</a>
	</header>
	<main>
		<table>
			<tr>
				<td>Project:</td>
				<td>${project.title}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td>Due Date:</td>
				<td>${project.dueDate}</td>
			</tr>
		</table>
	</main>
	<footer>
		<a href="#">see taskes</a>
		<c:if test="${project.userCreate.id == thisUser.id }">
		<form action="/projects/${project.id}" method="post">
			<input type="hidden" name="_method" value="delete"><input type="submit" value="Delete Project">
		</form>
		</c:if>
	</footer>
</body>
</html>