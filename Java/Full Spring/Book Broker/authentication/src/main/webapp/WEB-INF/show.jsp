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
</head>
<body>
	<header>
		<h2>${book.title}</h2>
		<a href="/books">back to the shelves</a>
	</header>
	<main>
		<p>${book.user.userName} read ${book.title} by ${book.authorName}</p>
		<p>Here are ${book.user.userName}'s thoughts:</p><hr>
		<p>${book.description }</p><hr>
		<c:choose>
			<c:when test="${book.user.id == thisUser1.id }">
				<a href="/delete/${book.id}">delete</a>
				<a href="/books/${book.id}/edit">edit</a>
			</c:when>
			<c:otherwise>
				<p></p>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>