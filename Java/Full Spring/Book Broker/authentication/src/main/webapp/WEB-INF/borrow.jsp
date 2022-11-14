<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Book Lender Dashboard</title>
</head>
<body>
	<header>
		<div>
			<p>Hello, ${thisUser1.userName}.Welcome to</p>
			<h2>The Book Broker!</h2>			
		</div>		
		<div>
			<a href="/books">back to the shelves</a>
		</div>
	</header>
	<main>
		<p>Available Books to Borrow</p>
		<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.authorName}</td>
			<td>${book.user.userName}</td>
			<td>
				<c:choose>				
					<c:when test="${book.user.id == thisUser1.id }">
						<a href="/delete/${book.id}">delete</a>
						<a href="/books/${book.id}/edit">edit</a>
					</c:when>
					<c:otherwise>
						<a href="/bookmarket/${book.id}">borrow</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<p>Books I'm Borrowing..</p>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${borrow}">
		<tr>
			<td>${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.authorName}</td>
			<td>${book.user.userName}</td>
			<td><a href="/bookmarket/return/${book.id}">return</a></td>
		</tr>
		</c:forEach>
	</table>				
	</main>
</body>
</html>