<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="/css/home.css">
</head>
<body>
	<header>
		<div>
			<h2>Welcome, ${thisUser1.userName}</h2>
			<p>Books from everyone's shelves.</p>
		</div>		
		<div>
			<a href="/logout" class="logout" >logout</a><br>
			<a href="/books/new">+ Add a to my shelf!</a>
		</div>
	</header>
	<main>
		<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.authorName}</td>
			<td>${book.user.userName}</td>
		</tr>
		</c:forEach>
	</table>				
	</main>
</body>
</html>