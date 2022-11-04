<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>All Books</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Language</th>
			<th>Number of pages</th>
		</tr>
		<c:forEach var= "theBook" items="${books1}" >
		<tr>
			<td>${theBook.id }</td>
			<td>${theBook.title }</td>
			<td>${theBook.description }</td>
			<td>${theBook.language }</td>
			<td>${theBook.numberOfPages }</td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>